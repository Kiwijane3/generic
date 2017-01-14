package kiwijane3.generic.functionalinterfaces;

/**
 * Created by janef on 13/01/17.
 */
@FunctionalInterface
public interface Function<A, B> {
    public B invoke(A in);
}
