package kiwijane3.generic;

import android.app.Activity;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by janef on 14/01/17.
 */

public class ActivityViewCache {

    private Activity activity;

    private Map<Integer, WeakReference<View>> cache;

    public ActivityViewCache(Activity inActivity){
        activity = inActivity;
        cache = new HashMap<>();
    }

    public View findView(int id){
        // // Try and find the view in the cache.
        WeakReference<View> viewReference = cache.get(id);
        if (viewReference != null){
            View cachedView = viewReference.get();
            return cachedView;
        }
        // Cache lookup has failed, use findViewById.
        // Due to the preconditions for running this method, this will not return null.
        View target = activity.findViewById(id);
        //If we cannot find the view, this is a fundamental programming flaw, so crash.
        if (target == null){
            throw new ViewNotFoundException("Cannot find view with id: " + id);
        }
        //We have the view, add it to the cache.
        cache.put(id, new WeakReference<>(target));
        return target;
    }

}
