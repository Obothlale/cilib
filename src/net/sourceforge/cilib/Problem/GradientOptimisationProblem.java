/*
 * GradientOptimisationProblem.java
 *
 * Created on June 4, 2003, 4:53 PM
 *
 * 
 * Copyright (C) 2003, 2004 - CIRG@UP 
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science 
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA 
 *   
 */

package net.sourceforge.cilib.Problem;

import net.sourceforge.cilib.Type.Types.Vector;

/**
 * Optimisation problems that are able to provide gradient information should implement this
 * interface. Some optimisation algorithms are able to exploit this information. 
 * <p />
 * 
 * This interface only applies to continuous valued problems.
 *
 * @author  espeer
 */
public interface GradientOptimisationProblem {
    
	/**
	 * Returns the gradient of the optimisation problem at the given position.
	 * 
	 * @param position the position.
	 * @return the gradient at position.
	 */
    public abstract Vector getGradient(Vector position);
    
}
