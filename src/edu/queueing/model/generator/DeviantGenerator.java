package edu.queueing.model.generator;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Random;

/**
 * @author GromHoll
 */
public class DeviantGenerator implements Generator {

    private @Getter final int medianTick;
    private @Getter final int deviant;

    private @Getter(AccessLevel.PROTECTED) Random random = new Random();

    public DeviantGenerator(int medianTick, int deviant) {
        this.medianTick = medianTick;
        this.deviant = deviant;
    }

    @Override
    public int generate() {
        return getMedianTick() + getNextDeviant();
    }

    protected int getNextDeviant() {
        return getRandom().nextInt(2 * getDeviant()) - getDeviant();
    }

}
