package edu.queueing.model.queue;

/**
 * @author GromHoll
 */
public class InfinityQueue extends Queue {

    private int queueSize = 0;

    @Override
    public boolean next() {
        if (queueSize > 0) {
            queueSize--;
            return true;
        }
        return false;
    }

    @Override
    public void input() {
        queueSize++;
        System.out.println("Somebody added to queue. Current size = " + queueSize);  // TODO delete log
    }
}
