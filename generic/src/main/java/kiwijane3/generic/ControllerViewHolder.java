package kiwijane3.generic;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import kiwijane3.generic.controller.ViewController;

/**
 * Created by janef on 14/01/17.
 */

public class ControllerViewHolder<A> extends RecyclerView.ViewHolder {

    private ViewController<A> controller;

    protected ControllerViewHolder(View itemView, ViewController inController) {
        super(itemView);
        controller = inController;
        controller.setView(itemView);
    }

    public void setContents(A contents){
        controller.setContents(contents);
    }

}
