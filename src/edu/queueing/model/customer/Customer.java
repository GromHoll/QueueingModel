package edu.queueing.model.customer;

import edu.queueing.model.common.TickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GromHoll
 */
public class Customer {

    private long id;
    private List<Message> log = new ArrayList<>();

    Customer(long id) {
        this.id = id;
    }

    public void addMessage(String message, TickEvent event) {
        log.add(new Message(message,event));
    }

    @Override
    public String toString() {
        return "Customer #" + id + ":\n" + log.stream().map(Message::toString).collect(Collectors.joining("\n"));
    }
}
