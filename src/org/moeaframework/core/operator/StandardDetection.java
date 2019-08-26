package org.moeaframework.core.operator;

import org.moeaframework.core.Detection;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class StandardDetection implements Detection {
    @Override
    public double getProportionOfExperimentalSolutions() {
        // Static 10%
        return 0.1d;
    }

    @Override
    public boolean isEnvironmentChanged(Problem problem, Solution[] solutions) {
        int[] indexes = ThreadLocalRandom.current().ints(0, solutions.length).distinct().limit((int)(solutions.length*0.1d)).toArray();
        for(int index : indexes) {
            double[] objectives = solutions[index].getObjectives().clone();
            problem.evaluate(solutions[index]);
            if (!Arrays.equals(objectives, solutions[index].getObjectives())) {
                return true;
            }
        }
        return false;
    }
}
