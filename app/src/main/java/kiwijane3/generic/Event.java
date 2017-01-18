package kiwijane3.generic;

import java.util.ArrayList;
import java.util.List;

import kiwijane3.generic.functionalinterfaces.Action;

/**
 * Created by janef on 13/01/17.
 */

public class Event implements Action {

    private List<Action> listeners;

    public Event(){
        listeners = new ArrayList<>();
    }

    public void addListeners(Action listener){
        listeners.add(listener);
    }

    @Override
    public void invoke() {
        for (Action listener : listeners){
            listener.invoke();
        }
    }

    // Removes all items.
    public void clear(){
        listeners.removeAll(listeners);
    }

}
