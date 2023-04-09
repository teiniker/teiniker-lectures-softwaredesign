Internal Iterator in Java 8
-------------------------------------------------------------------------------

Iterable Interface
------------------

public interface Iterable<T> {
    Iterator<T> iterator();

    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }

    //...
}


Consumer Interface
------------------
Performs the given action for each element of the Iterable until all elements
have been processed or the action throws an exception.  Actions are performed
in the order of iteration, if that order is specified.  Exceptions thrown by
the action are relayed to the caller.

The behavior of this method is unspecified if the action performs side-effects
that modify the underlying source of elements, unless an overriding class has
specified a concurrent modification policy.

@FunctionalInterface
public interface Consumer<T>
{
   void accept(T t);
}

