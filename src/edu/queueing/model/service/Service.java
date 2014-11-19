package edu.queueing.model.service;

import edu.queueing.model.common.HierarchyTickable;
import edu.queueing.model.customer.Customer;
import edu.queueing.model.customer.CustomerConsumer;
import edu.queueing.model.customer.CustomerProducer;
import edu.queueing.model.queue.Queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author GromHoll
 */
public abstract class Service extends HierarchyTickable {

    private List<CustomerProducer> producers = new ArrayList<>();
    private CustomerConsumer consumer = null;

    public void addQueue(Queue queue) {
        this.producers.add(queue);
        addChild(queue);
    }

    public void addQueues(Collection<Queue> queues) {
        this.producers.addAll(queues);
        addChildren(queues);
    }

    public Customer next() {
        for (CustomerProducer queue : producers) {
            Customer customer = queue.getCustomer();
            if (customer != null) {
                return customer;
            }
        }
        return null;
    }

    public void setConsumer(CustomerConsumer consumer) {
        this.consumer = consumer;
    }

    protected void releaseCustomer(Customer customer) {
        if (consumer != null) {
            consumer.sendCustomer(customer);
        }
    }
}
