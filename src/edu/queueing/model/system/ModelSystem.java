package edu.queueing.model.system;

import edu.queueing.model.common.HierarchyTickable;

/**
 * @author GromHoll
 */
public abstract class ModelSystem extends HierarchyTickable {

    public abstract void autoTick();

}
