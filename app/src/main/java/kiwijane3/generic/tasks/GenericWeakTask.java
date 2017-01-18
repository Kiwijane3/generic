package kiwijane3.generic.tasks;

import android.support.v7.widget.LinearLayoutCompat;

import kiwijane3.generic.functionalinterfaces.BiConsumer;
import kiwijane3.generic.functionalinterfaces.Consumer;
import kiwijane3.generic.functionalinterfaces.Function;

/**
 * Created by janef on 18/01/17.
 */

public class GenericWeakTask<A, B, C> extends WeakTask<A, B, C> {

    private Function<A, B> background;

    /**
     * (Target, Result) -> {...}
     */
    private BiConsumer<C, B> foreground;

    public GenericWeakTask(C target, Function<A, B> inBackground, BiConsumer<C, B> inForeground){
        super(target);
        background = inBackground;
        foreground = inForeground;
    }

    @Override
    protected B doInBackground(A... params) {
        if (params.length > 0) {
            return background.invoke(params[0]);
        } else {
            return background.invoke(null);
        }
    }

    @Override
    protected void onFinish(C target, B result){
        foreground.invoke(target, result);
    }

}
