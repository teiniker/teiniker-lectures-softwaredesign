# Internal Iterator in Java 8

The internal iterator is a programming concept used in Java and other 
programming languages to **process elements of a collection or stream**. 
In Java, the `forEach()` method is a **built-in internal iterator** method 
that is used to traverse and process each element of a collection in a 
sequential order.

## Iterable Interface

The `Iterable<T>` interface in Java is a fundamental interface that 
represents a sequence of elements that can be iterated over. 

It is part of the **Java Collections Framework** and is implemented by 
all collection classes in Java, such as `List`, `Set`, and `Map`.

```Java
public interface Iterable<T>
{
    Iterator<T> iterator();

    default void forEach(Consumer<? super T> action)
    {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }
    //...
}
```

Note that the `forEach()` method is defined as part of the
`Iterable<T>` interface.


## ForEach Method

The `forEach()` method performs the given action for each element of the
`Iterable<T>` until all elements have been processed or the action throws an
exception.  

Actions are performed in the order of iteration, if that order is specified.  
Exceptions thrown by the action are relayed to the caller.

The behavior of this method is unspecified if the action performs
side-effects that modify the underlying source of elements, unless an
overriding class has specified a concurrent modification policy.

As parameter, `forEach()` takes a `Consumer<T>` functional interface. 

```Java
@FunctionalInterface
public interface Consumer<T>
{
   void accept(T t);
}
```

This interface defines an `accept()` operation that accepts a 
**single input argument and returns no result**. 

Unlike most other functional interfaces, `Consumer<T>` is expected
to **operate via side-effects**.


## References

* [YouTube (Venkat Subramaniam): Get a Taste of Lambdas and Get Addicted to Streams by Venkat Subramaniam](https://youtu.be/1OpAgZvYXLQ)

* Raoul-Gabriel Urma, Mario Fusco, Alan Mycroft. **Java 8 in Action: Lambdas, Streams, and Functional-Style Programming**. Manning Publishing, 2014
    

*Egon Teiniker, 2016-2023, GPL v3.0*
