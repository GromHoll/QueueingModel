package edu.queueing.model.storage;

import edu.queueing.model.common.HierarchyTickable;
import edu.queueing.model.customer.Customer;
import edu.queueing.model.customer.CustomerConsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GromHoll
 */
public class Storage extends HierarchyTickable implements CustomerConsumer {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public void sendCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
