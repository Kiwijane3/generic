package kiwijane3.generic.functionalinterfaces;

/**
 * Created by janef on 13/01/17.
 */
@FunctionalInterface
public interface Consumer<A> {
    public void invoke(A in);
}
