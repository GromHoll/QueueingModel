package edu.queueing.model.customer;

/**
 * @author GromHoll
 */
public class CustomerFactory implements CustomerProducer {
    private long nextId = 1;

    public Customer getCustomer() {
        return new Customer(nextId++);
    }

}
