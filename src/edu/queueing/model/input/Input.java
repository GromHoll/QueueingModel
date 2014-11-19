package edu.queueing.model.input;

import edu.queueing.model.common.HierarchyTickable;
import edu.queueing.model.common.TickEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GromHoll
 */
public abstract class Input extends HierarchyTickable {

    private List<InputListener> inputListeners = new ArrayList<>();

    public void notifyListeners(TickEvent event) {
        inputListeners.stream().forEach(listener -> listener.input(event));
    }

    public void addListener(InputListener listener) {
        inputListeners.add(listener);
    }

    public void removeListener(InputListener listener) {
        inputListeners.remove(listener);
    }

}
