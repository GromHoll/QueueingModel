package edu.queueing.model.generator;

/**
 * @author GromHoll
 */
public class GuassInput extends DeviantGenerator {

    public GuassInput(int medianTick, int deviant) {
        super(medianTick, deviant);
    }

    @Override
    public int generate() {
        return (int) getRandom().nextGaussian()*getDeviant();
    }
}
