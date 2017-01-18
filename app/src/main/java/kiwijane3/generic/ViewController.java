package kiwijane3.generic;

import android.content.Context;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by janef on 13/01/17.
 */

public abstract class ViewController<A> {

    private WeakReference<View>  view;

    private Map<Integer, WeakReference<View>> cache;

    protected A contents;

    protected final Context context;

    public ViewController(Context inContext){
        context = inContext;
        cache = new HashMap<>();
    }

    public void setContents(A inContents){
        contents = inContents;
        bindView();
    }

    public void setView(View inView){
        view = new WeakReference<>(inView);
        bindView();
    }

    // Binds the contents to the view.
    protected final void bindView(){
        if (contents != null && view != null && view.get() != null){
            onBindView();
        }
    }

    /**
     * Implement logic for binding the contents to the view here.
     */
    protected abstract void onBindView();

    protected View findView(int id) throws ViewNotFoundException{
        // Try and find the view in the cache.
        WeakReference<View> viewReference = cache.get(id);
        if (viewReference != null){
            View cachedView = viewReference.get();
            return cachedView;
        }
        // Cache lookup has failed, use findViewById.
        View rootView = view.get();
        if (rootView != null) {
            View target = rootView.findViewById(id);
            //If we cannot find the view, this is a fundamental programming flaw, so crash.
            if (target == null) {
                throw new ViewNotFoundException("Cannot find view with id: " + id);
            }
            //We have the view, add it to the cache.
            cache.put(id, new WeakReference<View>(target));
            return target;
        } else return null;
    }

}
