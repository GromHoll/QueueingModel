package edu.queueing.model.service;

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
    private boolean isFree = true;

    public DeviantService(int medianTick, int deviant) {
        checkArgument(medianTick > 0, "Median Tick should be positive");
        checkArgument(medianTick > Math.abs(deviant), "Deviant should be less than Median Tick");
        this.medianTick = medianTick;
        this.deviant = deviant;
    }

    @Override
    public void tickLogic() {
        if (isFree) {
            serviceNext();
        } else {
            serviceExist();
        }
    }

    private void serviceNext() {
        if (next()) {
            isFree = false;
            generateServiceTick();
            serviceExist();
        }
    }

    private void serviceExist() {
        currentTick++;
        if (currentTick > nextServiceTick) {
            System.out.println("Somebody was served");
            // TODO good
            isFree = true;
        }
    }

    private void generateServiceTick() {
        currentTick = 0;
        nextServiceTick = medianTick + random.nextInt(2*deviant) - deviant;
    }

}
