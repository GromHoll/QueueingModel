package edu.queueing.model.service;

import edu.queueing.model.common.HierarchyTickable;
import edu.queueing.model.queue.Queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author GromHoll
 */
public abstract class Service extends HierarchyTickable {

    private List<Queue> queues = new ArrayList<>();

    public void addQueue(Queue queue) {
        this.queues.add(queue);
        addChild(queue);
    }

    public void addQueues(Collection<Queue> queues) {
        this.queues.addAll(queues);
        addChildren(queues);
    }

    public boolean next() {
        for (Queue queue : queues) {
             if (queue.next()) {
                return true;
             }
        }
        return false;
    }
}
