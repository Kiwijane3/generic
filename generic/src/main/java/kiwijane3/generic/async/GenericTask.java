package kiwijane3.generic.async;

import android.os.AsyncTask;

import kiwijane3.generic.functionalinterfaces.Consumer;
import kiwijane3.generic.functionalinterfaces.Function;

/**
 * Created by janef on 14/01/17.
 */

// A generic AsyncTask with no progress.
public class GenericTask<A, B> extends AsyncTask<A, Void, B> {

    private Function<A, B> background;

    private Consumer<B> foreground;

    public GenericTask(Function<A, B> inBackground, Consumer<B> inForeground){
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
    protected void onPostExecute(B result) {
        foreground.invoke(result);
    }
}
