package edu.queueing.model.input;

import edu.queueing.model.common.HierarchyTickable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GromHoll
 */
public abstract class Input extends HierarchyTickable {

    private List<InputListener> inputListeners = new ArrayList<>();

    public void notifyListeners() {
        inputListeners.stream().forEach(InputListener::input);
    }

    public void addListener(InputListener listener) {
        inputListeners.add(listener);
    }

    public void removeListener(InputListener listener) {
        inputListeners.remove(listener);
    }

}
