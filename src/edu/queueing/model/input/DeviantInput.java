package edu.queueing.model.input;

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
    public void tickLogic() {
        currentTick++;
        if (currentTick == nextInputTick) {
            notifyListeners();
            nextInputTick = generateNextInputTick();
            System.out.println("Input generated");  // TODO remove log
        }
    }

    private int generateNextInputTick() {
        return medianTick + random.nextInt(2*deviant) - deviant;
    }
}
