package edu.queueing.model.queue;

import edu.queueing.model.common.HierarchyTickable;
import edu.queueing.model.input.InputListener;

/**
 * @author GromHoll
 */
public abstract class Queue extends HierarchyTickable implements InputListener {

    public abstract void next();

}
