package edu.queueing.model.service;

import edu.queueing.model.common.TickEvent;
import edu.queueing.model.customer.Customer;
import edu.queueing.model.generator.Generator;

import static edu.queueing.model.utils.CheckUtils.notNull;

/**
 * @author GromHoll
 */
public class GeneratedService extends Service {

    private Generator generator;

    private int currentTick = 0;
    private int nextServiceTick = 0;
    private Customer currentCustomer = null;

    public GeneratedService(Generator generator) {
        notNull(generator, "Generator can't be null");
        this.generator = generator;
    }

    @Override
    public void tickLogic(TickEvent event) {
        if (currentCustomer == null) {
            serviceNext(event);
        } else {
            serviceExist(event);
        }
    }

    private void serviceNext(TickEvent event) {
        Customer customer = next();
        if (customer != null) {
            currentCustomer = customer;
            currentCustomer.addMessage("Customer service started", event);
            generateServiceTick();
            serviceExist(event);
        }
    }

    private void serviceExist(TickEvent event) {
        currentTick++;
        if (currentTick > nextServiceTick) {
            currentCustomer.addMessage("Customer service finished", event);
            releaseCustomer(currentCustomer);
            currentCustomer = null;
        }
    }

    private void generateServiceTick() {
        currentTick = 0;
        nextServiceTick = generator.generate();
    }

}
