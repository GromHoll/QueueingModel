package edu.queueing.model.input;

import edu.queueing.model.common.TickEvent;

import java.util.Random;

import static edu.queueing.model.utils.CheckUtils.checkArgument;

/**
 * @author GromHoll
 */
public class DeviantInput extends Input {

    private final int medianTick;
    private final int deviant;

    private Random random = new Random();
    private int currentTick = 0;
    private int nextInputTick = 0;

    public DeviantInput(int medianTick, int deviant) {
        checkArgument(medianTick > 0, "Median Tick should be positive");
        checkArgument(medianTick > Math.abs(deviant), "Deviant should be less than Median Tick");
        this.medianTick = medianTick;
        this.deviant = deviant;
        generateNextInputTick();
    }

    @Override
    public void tickLogic(TickEvent event) {
        currentTick++;
        if (currentTick > nextInputTick) {
            notifyListeners(event);
            generateNextInputTick();
        }
    }

    private void generateNextInputTick() {
        currentTick = 0;
        nextInputTick = medianTick + random.nextInt(2*deviant) - deviant;
    }
}
