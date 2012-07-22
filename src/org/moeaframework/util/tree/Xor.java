/* Copyright 2009-2012 David Hadka
 * 
 * This file is part of the MOEA Framework.
 * 
 * The MOEA Framework is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or (at your 
 * option) any later version.
 * 
 * The MOEA Framework is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public 
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License 
 * along with the MOEA Framework.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.moeaframework.util.tree;

public class Xor extends Node {
	
	public Xor() {
		super(Boolean.class, Boolean.class, Boolean.class);
	}

	@Override
	public Xor copyNode() {
		return new Xor();
	}

	@Override
	public Boolean evaluate(Environment environment) {
		return (Boolean)getArgument(0).evaluate(environment) ^
				(Boolean)getArgument(1).evaluate(environment);
	}

}