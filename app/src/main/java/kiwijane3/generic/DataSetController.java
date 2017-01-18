package kiwijane3.generic;

/**
 * Created by janef on 18/01/17.
 */

import android.content.Context;

/**
 * A view controller where the contents is a collection of data. Contents cannot be empty.
 */
public abstract class DataSetController<A> extends ViewController<A> {

    protected int position;

    public DataSetController(Context context){
        super(context);
    }

    /**
     * Sets position to the specified position.
     * @param inPosition
     */
    public void setPosition(int inPosition){
        position = inPosition;
        onBindView();
    }

}
