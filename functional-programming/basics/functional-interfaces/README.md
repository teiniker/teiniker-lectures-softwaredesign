# Functional Interfaces

A functional interface is an **interface that specifies exactly one abstract method**.

Note that functional interfaces can have default methods (that is a method with a body 
that provides some default implementation for a method in case it isn't implemented by 
a class).

The `@FunctionalInterface` annotation is used to indicate that the interface is
intended to be a functional interface, but this annotation is **not mandatory**. 
It is good practice to use it when an interface is designed for that purpose.
        
An interface is still a functional interface if it has many default methods as long 
as it specifies only one abstract method.        


## `java.util.function` Package

The `java.util.function` package defines numerous functional interfaces that are 
important for functional programming in Java.

### Consumer
A `Consumer` is an in-build functional interface in the java.util.function package. 
We use consumers when we need to consume objects, the consumer takes an input value 
and returns nothing. 

* **void accept(T value);**\
    Performs this operation on the given argument.

* `default Consumer<T> andThen(Consumer<? super T> after);`\
    Returns a composed Consumer that performs, in sequence, this operation followed 
    by the `after` operation.


### Predicate
A `Predicate` is a functional interface, which accepts an argument and returns 
a boolean. Usually, it is used to apply in a filter for a collection of objects.

* **boolean test(T value);**\
    Evaluates this predicate on the given argument.

* `default Predicate<T> and(Predicate<? super T> other);`\
    Returns a composed predicate that represents a short-circuiting logical AND 
    of this predicate and another.

* `default Predicate<T> negate();`\
    Returns a predicate that represents the logical negation of this predicate.

* `default Predicate<T> or(Predicate<? super T> other);`\
    Returns a composed predicate that represents a short-circuiting logical OR 
    of this predicate and another.

* `static <T> Predicate<T> isEqual(Object targetRef);`\
    Returns a predicate that tests if two arguments are equal according to 
    Objects.equals(Object, Object).

* `static <T> Predicate<T> not(Predicate<? super T> target);`\
    Returns a predicate that is the negation of the supplied predicate.


### Function
A Function is another in-build functional interface in `java.util.function` 
package, the function takes an input value and returns a value. The function 
interface has four methods, mostly function used in map feature of stream APIs.

* **R apply(T var1);**\
    Applies this function to the given argument.

* `default <V> Function<V, R> compose(Function<V, T> before);`\
    Returns a composed function that first applies the before function to its 
    input, and then applies this function to the result.

* `default <V> Function<T, V> andThen(Function<R, V> after);`\
    Returns a composed function that first applies this function to its input, 
    and then applies the after function to the result.

* `static <T> Function<T, T> identity();`\
    Returns a function that always returns its input argument.


### Supplier
The Supplier Interface is a part of the `java.util.function package`. It 
represents a function that does not take in any argument but produces 
a value of type `T`. It contains only one method.

* **T get();**\
    Gets a result.



## References

* [YouTube (Venkat Subramaniam): Functional Programming with Java](https://youtu.be/15X0qFtBqiQ)

* [Baeldung: Functional Interfaces in Java 8](https://www.baeldung.com/java-8-functional-interfaces)

* [Java 8's — Consumer, Predicate, Supplier, and Function](https://medium.com/javarevisited/java-8s-consumer-predicate-supplier-and-function-bbc609a29ff9)


*Egon Teiniker, 2016-2024, GPL v3.0*