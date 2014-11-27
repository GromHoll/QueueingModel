package edu.queueing.model.generator;

import java.util.Random;

/**
 * @author GromHoll
 */
public class DeviantGenerator implements Generator {

    private final int medianTick;
    private final int deviant;

    private Random random = new Random();

    public DeviantGenerator(int medianTick, int deviant) {
        this.medianTick = medianTick;
        this.deviant = deviant;
    }

    @Override
    public int generate() {
        return medianTick + random.nextInt(2*deviant) - deviant;
    }

}
