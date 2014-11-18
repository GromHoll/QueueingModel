package edu.queueing.model.system;

import edu.queueing.model.common.Tickable;

import java.util.Collection;

import static edu.queueing.model.utils.CheckUtils.checkArgument;

/**
 * @author GromHoll
 */
public class TimedModelSystem extends ModelSystem {

    private int modelingPeriod;

    public TimedModelSystem(int modelingPeriod) {
        setModelingPeriod(modelingPeriod);
    }

    public TimedModelSystem(int modelingPeriod, Collection<Tickable> elements) {
        setModelingPeriod(modelingPeriod);
        addChildren(elements);
    }

    public void setModelingPeriod(int modelingPeriod) {
        checkArgument(modelingPeriod > 0, "ModelingPeriod should be positive");
        this.modelingPeriod = modelingPeriod;
    }

    @Override
    public void autoTick() {
        for (int t = 0; t < modelingPeriod; t++) {
            System.out.println("==== " + t + " tick ===="); // TODO delete log
            tick();
        }
    }

}
