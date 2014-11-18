package edu.queueing.model;

import edu.queueing.model.input.DeviantInput;
import edu.queueing.model.input.Input;
import edu.queueing.model.queue.InfinityQueue;
import edu.queueing.model.queue.Queue;
import edu.queueing.model.system.ModelSystem;
import edu.queueing.model.system.TimedModelSystem;

/**
 * @author  GromHoll
 */
public class SingleModelExample {

    public static void main(String[] args) {
        ModelSystem system = new TimedModelSystem(8*60);

        Input input = new DeviantInput(18, 6);
        Queue queue = new InfinityQueue();
        queue.addChild(input);
        input.addListener(queue);

        system.addChild(input);
        system.autoTick();
    }

}
