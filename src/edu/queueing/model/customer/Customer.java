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
    private List<String> log = new ArrayList<>();

    Customer(long id) {
        this.id = id;
    }

    public void addMessage(String message, TickEvent event) {
        String formattedMessage = String.format("[%d] %s", event.getTick(), message);
        log.add(formattedMessage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer #")
            .append(id)
            .append(":\n");
            sb.append(log.stream().collect(Collectors.joining("\n")));
            return sb.toString();
        }
    }
