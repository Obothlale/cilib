/*
 * ParticipantingAlgorithm.java
 *
 * Created on January 24, 2003, 11:35 AM
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

package net.sourceforge.cilib.Algorithm;

import net.sourceforge.cilib.Problem.Fitness;
import net.sourceforge.cilib.Type.Types.Vector;


/**
 * Any algorithm that implements this interface can be used as a participant in a {@link CoOperativeOptimisationAlgorithm}.
 * 
 * <p />
 * 
 * <b>Note:</b> Currently this interface only supports continuous domained problems.
 * 
 * @author  espeer
 */
public interface ParticipatingAlgorithm {
    /**
    * Returns contribution to the solution for the co-operative optimisation algorithm.
    *
    * @return The algorithm's solution contribution.
    */
    public Vector getContribution();

    /**
     * Returns the fitness of contribution to the solution.
     *
     * @return The fitness of the solution contribution.
     */
    public Fitness getContributionFitness();
    
    /**
     * Updates the new fitness for the solution contribution.
     *
     * @param fitness The new fitness of the contribution.
     */
    public void updateContributionFitness(Fitness fitness);
}
