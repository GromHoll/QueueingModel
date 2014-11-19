package edu.queueing.model.service;

import edu.queueing.model.common.TickEvent;
import edu.queueing.model.customer.Customer;

import java.util.Random;

import static edu.queueing.model.utils.CheckUtils.checkArgument;

/**
 * @author GromHoll
 */
public class DeviantService extends Service {

    private final int medianTick;
    private final int deviant;

    private Random random = new Random();
    private int currentTick = 0;
    private int nextServiceTick = 0;
    private Customer currentCustomer = null;

    public DeviantService(int medianTick, int deviant) {
        checkArgument(medianTick > 0, "Median Tick should be positive");
        checkArgument(medianTick > Math.abs(deviant), "Deviant should be less than Median Tick");
        this.medianTick = medianTick;
        this.deviant = deviant;
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
            currentCustomer.addMessage("Customer service started", event);
            releaseCustomer(currentCustomer);
            currentCustomer = null;
        }
    }

    private void generateServiceTick() {
        currentTick = 0;
        nextServiceTick = medianTick + random.nextInt(2*deviant) - deviant;
    }

}
