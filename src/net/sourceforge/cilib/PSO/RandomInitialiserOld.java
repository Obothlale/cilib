/*
 * RandomInitialiser.java
 *
 * Created on September 14, 2003, 4:11 PM
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

package net.sourceforge.cilib.PSO;

import java.util.Random;

import net.sourceforge.cilib.Problem.OptimisationProblem;
import net.sourceforge.cilib.Random.MersenneTwister;
import net.sourceforge.cilib.Type.DomainParser;
import net.sourceforge.cilib.Type.Types.MixedVector;
import net.sourceforge.cilib.Type.Types.Real;
import net.sourceforge.cilib.Type.Types.Vector;

/**
 *
 * @author  espeer
 */
public class RandomInitialiserOld implements Initialiser {
    
    public RandomInitialiserOld() {
        randomiser = new MersenneTwister();
    }
        
    //public double[] getInitialPosition(OptimisationProblem problem) {
    public Vector getInitialPosition(OptimisationProblem problem) {
        //DomainComponent dom = problem.getDomain();
        //return (double[])dom.getRandom(randomiser);
    	
    	//Domain domain = Domain.getInstance();
    	
    	//return new double[0];
    	//return new MixedVector();
    	return (Vector) DomainParser.getInstance().getInitialisedRepresenation();
    }

    //public double[] getInitialVelocity(OptimisationProblem problem) {
    public Vector getInitialVelocity(OptimisationProblem problem) {
        /*double[] velocity = new double[problem.getDomain().getDimension()];
        for (int i = 0; i < problem.getDomain().getDimension(); ++i) {
            velocity[i] = 0;
        }
        return velocity;*/
    	
    	//return new double[0];
    	//return new MixedVector();
    	
    	MixedVector velocity = new MixedVector(DomainParser.getInstance().getDimension(), new Real(0.0));
    	//for (int i = 0; i < DomainParser.getInstance().getDimension(); i++) {
    	//	velocity.setReal(i, 0.0);
    	//}
    	
    	return velocity;
    }

    public void setRandomiser(Random generator) {
        this.randomiser = generator;
    }

	public Random getRandomiser() {
		return randomiser;
	}
    
    private Random randomiser;
}
