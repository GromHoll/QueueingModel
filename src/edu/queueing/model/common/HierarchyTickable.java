package edu.queueing.model.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author GromHoll
 */
public abstract class HierarchyTickable implements Tickable {

    private List<Tickable> children = new ArrayList<>();

    public void addChild(Tickable child) {
        this.children.add(child);
    }

    public void addChildren(Collection<? extends Tickable> children) {
        this.children.addAll(children);
    }

    @Override
    public void tick() {
        children.stream().forEach(Tickable::tick);
        tickLogic();
    }

    public void tickLogic() {};

}
