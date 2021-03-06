/**           __  __
 *    _____ _/ /_/ /_    Computational Intelligence Library (CIlib)
 *   / ___/ / / / __ \   (c) CIRG @ UP
 *  / /__/ / / / /_/ /   http://cilib.net
 *  \___/_/_/_/_.___/
 */
package net.sourceforge.cilib.pso.positionprovider.binary;

import net.sourceforge.cilib.controlparameter.ControlParameter;
import net.sourceforge.cilib.controlparameter.LinearlyVaryingControlParameter;
import net.sourceforge.cilib.pso.particle.Particle;
import net.sourceforge.cilib.pso.positionprovider.PositionProvider;
import net.sourceforge.cilib.type.types.container.Vector;

/**
 * Implementation of Modified particle swarm optimisation algorithm for variable
 * selection in MLR and PLS modeling.
 *
 * Position of the particle is updated using a varying probability
 * <p>
 * References:
 * </p>
 * <ul><li>
 * Qi Shen, Jian-Hui Jiang, Chen-Xu Jiao, Guo-li Shen, Ru-Qin Yu.,
 * "Modified particle swarm optimization algorithm for variable
 * selection in MLR and PLS modeling: QSAR studies of antagonism of
 * angiotensin II antagonists" (2004). European Journal of Pharmaceutical
 * Sciences 22, 145-152
 * </li></ul>
 */
public class BinaryStaticProbPositionProvider implements PositionProvider {

    private ControlParameter staticProb;

    /**
     * Create an instance of {@linkplain BinaryStaticProbPositionProvider}.
     */
    public BinaryStaticProbPositionProvider() {
        this.staticProb = new LinearlyVaryingControlParameter(0.5, 0.33);
    }

    /**
     * Create a copy of the provided instance.
     * @param copy The instance to copy.
     */
    public BinaryStaticProbPositionProvider(BinaryStaticProbPositionProvider copy) {
        this.staticProb = copy.staticProb;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BinaryStaticProbPositionProvider getClone() {
        return new BinaryStaticProbPositionProvider(this);
    }

    /**
     * BinaryPSO particle position update using static probability
     */
    @Override
    public Vector get(Particle particle) {
        Vector velocity = (Vector) particle.getVelocity();
        Vector position = (Vector) particle.getPosition();
        Vector.Builder builder = Vector.newBuilder();

        double a = staticProb.getParameter();
        double limit = 0.5 * (1 + a);

        Vector pbest = (Vector) particle.getLocalGuide();
        Vector gbest = (Vector) particle.getGlobalGuide();

        for (int i = 0; i < particle.getDimension(); i++) {
            double vi = velocity.doubleValueOf(i);
            double newPosition = position.doubleValueOf(i);

            if ((vi > a) && (vi <= limit)) {
                newPosition = pbest.doubleValueOf(i);
            } else if ((vi > limit) && (vi <= 1)) {
                newPosition = gbest.doubleValueOf(i);
            }

            builder.addWithin(newPosition, position.boundsOf(i));
        }
        return builder.build();
    }


    /**
    * Get the static probability control parameter used within the update strategy
    * @return the {@linkplain ControlParameter} used.
    */
    public ControlParameter getStaticProb() {
        return this.staticProb;
    }

    /**
    * Set the static probability control parameter to use.
    * @param staticProb The control parameter to set.
    */
    public void setStaticProb(ControlParameter staticProb) {
        this.staticProb = staticProb;
    }
}
