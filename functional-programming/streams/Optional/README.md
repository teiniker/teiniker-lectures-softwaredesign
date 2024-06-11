# Optional

The `Optional` class in Java, introduced in Java 8, is a container object which may 
or may not contain a non-null value. It provides a way to **handle null values more
gracefully**, reducing the likelihood of `NullPointerExceptions`.


## Creating Optional Objects

* **Optional.of(T value)**: Creates an `Optional` containing the given non-null value.
* **Optional.ofNullable(T value)**: Creates an `Optional` containing the given value,
     which can be null.
* **Optional.empty()**: Creates an empty `Optional`.


## Checking Presence

* **isPresent()**: Returns `true` if there is a value present, otherwise `false`.
* **isEmpty()**: Returns `true` if there is no value present, otherwise `false`.

* **ifPresent(Consumer<? super T> action)**: If a value is present, performs the 
    given action with the value, otherwise does nothing.
* **ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)**: If a value 
    is present, performs the given action with the value, otherwise performs the 
    given empty-based action.

## Accessing Values

* **get()**: Returns the value if present, otherwise throws `NoSuchElementException`.
* **orElse(T other)**: Returns the value if present, otherwise returns other.
* **orElseGet(Supplier<? extends T> other)**: Returns the value if present, 
    otherwise returns the result produced by the supplying function.
* **orElseThrow()**: Returns the value if present, otherwise throws 
    `NoSuchElementException`.
* **orElseThrow(Supplier<? extends X> exceptionSupplier)**: Returns the value 
    if present, otherwise throws an exception produced by the exception 
    supplying function.


## Transforming Values

* **map(Function<? super T, ? extends U> mapper)**: If a value is present, applies 
    the provided mapping function to it, and if the result is non-null, returns 
    an Optional describing the result.
* **flatMap(Function<? super T, Optional<U>> mapper)**: Similar to map, but the 
    mapping function returns an Optional instead of a plain value.
* **filter(Predicate<? super T> predicate)**: If a value is present, and the value
    matches the given predicate, returns an Optional describing the value, 
    otherwise returns an empty Optional.

## References

* [Guide To Java 8 Optional](https://www.baeldung.com/java-optional)

*Egon Teiniker, 2016-2024, GPL v3.0*