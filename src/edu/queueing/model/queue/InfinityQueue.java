package edu.queueing.model.queue;

import edu.queueing.model.customer.Customer;

import java.util.ArrayDeque;

/**
 * @author GromHoll
 */
public class InfinityQueue extends Queue {

    private java.util.Queue<Customer> queue = new ArrayDeque<>();

    @Override
    public Customer getCustomer() {
        return queue.poll();
    }

    @Override
    public int getSize() {
        return queue.size();
    }

    @Override
    protected void addToQueue(Customer customer) {
        queue.add(customer);
    }
}
