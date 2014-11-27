package edu.queueing.model;

import edu.queueing.model.generator.DeviantGenerator;
import edu.queueing.model.generator.Generator;
import edu.queueing.model.input.GeneratedInput;
import edu.queueing.model.input.Input;
import edu.queueing.model.queue.InfinityQueue;
import edu.queueing.model.queue.Queue;
import edu.queueing.model.service.GeneratedService;
import edu.queueing.model.service.Service;
import edu.queueing.model.storage.Storage;
import edu.queueing.model.system.ModelSystem;
import edu.queueing.model.system.TimedModelSystem;

/**
 * @author  GromHoll
 */
public class SingleModelExample {

    public static void main(String[] args) {
        ModelSystem system = new TimedModelSystem(8*60);

        Generator inputGenerator = new DeviantGenerator(18, 6);
        Input input = new GeneratedInput(inputGenerator);
        Queue queue = new InfinityQueue();
        queue.addChild(input);
        input.addListener(queue);

        Generator serviceGenerator = new DeviantGenerator(16, 4);
        Service service = new GeneratedService(serviceGenerator);
        service.addQueue(queue);

        Storage storage = new Storage();
        storage.addChild(service);
        service.setConsumer(storage);

        system.addChild(storage);
        system.autoTick();

        storage.getCustomers().stream().forEach(System.out::println);


    }

}
