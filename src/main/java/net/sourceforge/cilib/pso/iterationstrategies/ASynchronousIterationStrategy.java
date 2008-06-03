/*
 * Copyright (C) 2003 - 2008
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
 */
package net.sourceforge.cilib.pso.iterationstrategies;

import java.util.Iterator;

import net.sourceforge.cilib.algorithm.population.AbstractIterationStrategy;
import net.sourceforge.cilib.entity.Particle;
import net.sourceforge.cilib.entity.Topology;
import net.sourceforge.cilib.pso.PSO;

/**
 * @author Gary Pampara
 */
public class ASynchronousIterationStrategy extends AbstractIterationStrategy<PSO> {
	private static final long serialVersionUID = -3511991873784185698L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ASynchronousIterationStrategy getClone() {
		return this;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.cilib.PSO.IterationStrategy#performIteration()
	 * 
	 * This is an ASynchronous strategy:
	 * 1. For all particles:
	 *    1.1 Update the particle velocity
	 *    1.2 Update the particle position
	 *    1.3 Calculate the particle fitness
	 *    1.4 For all paritcles in the current particle's neighbourhood
	 *        1.4.1 Update the nieghbourhooh best  
	 */
	public void performIteration(PSO algorithm) {
		Topology<Particle> topology = algorithm.getTopology();
		for (Iterator<? extends Particle> i = topology.iterator(); i.hasNext();) {
			Particle current = i.next();
			current.updateVelocity();       // TODO: replace with visitor (will simplify particle interface)
			current.updatePosition();       // TODO: replace with visitor (will simplify particle interface)
	           
			boundaryConstraint.enforce(current);
	           
			current.calculateFitness();
            
            for (Iterator<? extends Particle> j = topology.neighbourhood(i); j.hasNext();) {
                Particle other = j.next();
                if (current.getSocialBestFitness().compareTo(other.getNeighbourhoodBest().getSocialBestFitness()) > 0) {
                    other.setNeighbourhoodBest(current); // TODO: neighbourhood visitor?
                }
            }
		}
	}

}
