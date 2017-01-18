package kiwijane3.generic;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janef on 13/01/17.
 */

public class Conversion {

    public static List<String> jsonArrayToStringList(JSONArray json) throws JSONException{
        List<String> out = new ArrayList<>();
        for (int i = 0; i < json.length(); ++i){
            out.add(json.getString(i));
        }
        return out;
    }

}
