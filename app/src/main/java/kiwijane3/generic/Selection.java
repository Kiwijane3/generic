package kiwijane3.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janef on 13/01/17.
 */

public class Selection {

    private List<String> contents;

    public String get(int i){
        return contents.get(i);
    }

    public int size(){
        return contents.size();
    }

    private boolean[] selection;

    public Event onSelectionChanged;

    public Selection(List<String> inContents){
        contents = inContents;
        selection = new boolean[contents.size()];
        // Select all.
        for (int i = 0; i < contents.size(); ++i){
            selection[i] = true;
        }
        onSelectionChanged = new Event();
    }

    public void select(int index){
        selection[index] = true;
        onSelectionChanged.invoke();
    }

    public void deselect(int index){
        selection[index] = false;
        onSelectionChanged.invoke();
    }

    public void toggle(int index){
        selection[index] = !selection[index];
        onSelectionChanged.invoke();
    }

    public void selectOnly(int index){
        for (int i = 0; i < contents.size(); ++i){
            selection[i] = false;
        }
        selection[index] = true;
        onSelectionChanged.invoke();
    }

    public boolean isSelected(int index){
        return selection[index];
    }


    public List<String> getSelected(){
        List<String> out = new ArrayList<>();
        for (int i = 0; i < contents.size(); ++i){
            if (selection[i]){
                out.add(contents.get(i));
            }
        }
        return out;
    }

    public String getSelectedAsCompactString(){
        String out = "";
        List<String> selected = getSelected();
        for (int i = 0; i < selected.size(); ++i){
            out += selected.get(i);
            // Don't add a comma at the end.
            if (i < (selected.size() - 1)){
                out += ",";
            }
        }
        return out;
    }

}
