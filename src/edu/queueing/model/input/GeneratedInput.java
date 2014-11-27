package edu.queueing.model.input;

import edu.queueing.model.common.TickEvent;
import edu.queueing.model.generator.Generator;

import static edu.queueing.model.utils.CheckUtils.notNull;

/**
 * @author GromHoll
 */
public class GeneratedInput extends Input {

    private Generator generator;

    private int currentTick = 0;
    private int nextInputTick = 0;

    public GeneratedInput(Generator generator) {
        notNull(generator, "Generator can't be null");
        this.generator = generator;
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
        nextInputTick = generator.generate();
    }
}
