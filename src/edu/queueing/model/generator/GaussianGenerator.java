package edu.queueing.model.generator;

/**
 * @author GromHoll
 */
public class GaussianGenerator extends DeviantGenerator {

    public GaussianGenerator(int medianTick, int deviant) {
        super(medianTick, deviant);
    }

    @Override
    public int getNextDeviant() {
        return (int) getRandom().nextGaussian()*getDeviant();
    }
}
