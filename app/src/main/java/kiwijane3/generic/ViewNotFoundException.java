package kiwijane3.generic;

/**
 * Created by janef on 13/01/17.
 */

public class ViewNotFoundException extends RuntimeException {

    public ViewNotFoundException(){
        super();
    }

    public ViewNotFoundException(String message){
        super(message);
    }

    public ViewNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
