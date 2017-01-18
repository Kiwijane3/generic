package kiwijane3.generic;

import android.content.Context;
import android.view.View;

/**
 * Created by janef on 18/01/17.
 */

public class DataSetControllerViewHolder<A> extends ControllerViewHolder<A> {

    /**
     * Based off this signature, we can ensure that the controller is a DataSetController.
     * @param view
     * @param inController
     */
    protected DataSetControllerViewHolder(View view, DataSetController<A> inController){
        super(view, inController);
    }

    public void setPosition(int position){
        ((DataSetController<A>) controller).setPosition(position);
    }

}
