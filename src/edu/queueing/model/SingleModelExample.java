package edu.queueing.model;

import edu.queueing.model.customer.Customer;
import edu.queueing.model.generator.GaussianGenerator;
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

import java.util.List;

/**
 * @author  GromHoll
 */
public class SingleModelExample {

    public static void main(String[] args) {
        ModelSystem system = new TimedModelSystem(8*60);

        Generator inputGenerator = new GaussianGenerator(18, 6);
        Input input = new GeneratedInput(inputGenerator);
        Queue queue = new InfinityQueue();
        queue.addChild(input);
        input.addListener(queue);

        Generator serviceGenerator = new GaussianGenerator(16, 4);
        Service service = new GeneratedService(serviceGenerator);
        service.addQueue(queue);

        Storage storage = new Storage();
        storage.addChild(service);
        service.setConsumer(storage);

        system.addChild(storage);
        system.autoTick();

        storage.getCustomers().stream().forEach(System.out::println);

        analysis(storage.getCustomers());
    }

    public static void analysis(List<Customer> customers) {
        double timeInQueue = customers.stream().map(Customer::getMessages)
                .mapToInt(mes -> mes.get(1).getTick() - mes.get(0).getTick())
                .average().orElse(-1);

        double timeInService = customers.stream().map(Customer::getMessages)
                .mapToInt(mes -> mes.get(2).getTick() - mes.get(1).getTick())
                .average().orElse(-1);

        System.out.println("=======");
        System.out.println("Average time in queue = " + timeInQueue);
        System.out.println("Average time in service = " + timeInService);
    }

}
