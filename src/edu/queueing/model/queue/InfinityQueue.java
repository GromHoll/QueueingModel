package edu.queueing.model.queue;

import edu.queueing.model.input.InputListener;

/**
 * @author GromHoll
 */
public class InfinityQueue extends Queue {

    private int queueSize = 0;

    @Override
    public void next() {
        if (queueSize != 0) queueSize--;
    }

    @Override
    public void input() {
        queueSize++;
        System.out.println("Somebody added to queue");  // TODO delete log
    }
}
