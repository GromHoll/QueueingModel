package edu.queueing.model.customer;

import edu.queueing.model.common.TickEvent;
import lombok.Getter;

/**
 * @author GromHoll
 */
public class Message {
    private final @Getter String message;
    private final @Getter TickEvent event;

    public Message(String message, TickEvent event) {
        this.message = message;
        this.event = event;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", event.getTick(), message);
    }
}
