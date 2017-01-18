package kiwijane3.generic.tasks;

/**
 * Created by janef on 18/01/17.
 */

import android.os.AsyncTask;

import java.lang.ref.WeakReference;

/**
 * An AsyncTask that stores a target in a WeakReference.
 * @param <A> The input type.
 * @param <B> The result type.
 * @param <C> The target type.
 */
public abstract class WeakTask<A, B, C> extends AsyncTask<A, Void, B> {

    private WeakReference<C> targetReference;

    /**
     * Create a WeakTask targetting target.
     * @param target
     */
    public WeakTask(C target){
        targetReference = new WeakReference<C>(target);
    }

    @Override
    protected final void onPostExecute(B result) {
        C target = targetReference.get();
        if (result != null && target != null){
            onFinish(target, result);
        }
    }

    /**
     * Called after onPostExecute if onPostExecute returned a result, and the target is still live.
     * @param target
     * @param result
     */
    protected abstract void onFinish(C target, B result);

}
