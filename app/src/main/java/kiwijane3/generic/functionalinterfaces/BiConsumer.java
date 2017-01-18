package kiwijane3.generic.functionalinterfaces;

/**
 * Created by janef on 18/01/17.
 */
@FunctionalInterface
public interface BiConsumer<A, B> {
    void invoke(A a, B b);
}
