package edu.queueing.model.input;

import edu.queueing.model.common.TickEvent;

/**
 * @author GromHoll
 */
public interface InputListener {
    public void input(TickEvent event);
}
