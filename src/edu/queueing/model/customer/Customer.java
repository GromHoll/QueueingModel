package edu.queueing.model.customer;

import edu.queueing.model.common.TickEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GromHoll
 */
public class Customer {

    private @Getter long id;
    private @Getter List<Message> messages = new ArrayList<>();

    Customer(long id) {
        this.id = id;
    }

    public void addMessage(String message, TickEvent event) {
        messages.add(new Message(message, event));
    }

    @Override
    public String toString() {
        return "Customer #" + id + ":\n" + messages.stream().map(Message::toString).collect(Collectors.joining("\n"));
    }
}
