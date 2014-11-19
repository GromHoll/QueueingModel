package edu.queueing.model.queue;

import edu.queueing.model.common.HierarchyTickable;
import edu.queueing.model.common.TickEvent;
import edu.queueing.model.customer.Customer;
import edu.queueing.model.customer.CustomerFactory;
import edu.queueing.model.customer.CustomerProducer;
import edu.queueing.model.input.InputListener;

/**
 * @author GromHoll
 */
public abstract class Queue extends HierarchyTickable implements InputListener, CustomerProducer {

    private CustomerProducer customerFactory = new CustomerFactory();

    @Override
    public void input(TickEvent event) {
        Customer customer = customerFactory.getCustomer();
        addToQueue(customer);
        customer.addMessage("Customer was added to queue as " + getSize(), event);
    }

    public abstract int getSize();

    protected abstract void addToQueue(Customer customer);

}
