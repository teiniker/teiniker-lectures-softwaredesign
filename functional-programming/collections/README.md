# Collections and Streams

Collections of numbers, strings, and objects are often used in Java applications.
In the following section, we explore the use of lambda expressions to manipulate
collections.

## Iterating Through a List

In classic Java external iterators are used to process every element of a collection:
```Java
    List<String> result = new ArrayList<>();
    for(String s : list)
    {
        System.out.println("s");
    }
```
Under the hood this **forEach loop** uses the `Iterator` interface and calls its
`hasNext()` and `next()` methods.

This is an **imperative style** which implies a serious disadvantage:
The **for loops are inherently sequential** and are quite difficult to parallelize.

The `Iterable` interface has been enhanced in JDK8 with a special method named
`forEach()`, which accepts a parameter of type `Consumer` and implements an
**internal iterator**.

```Java
@FunctionalInterface
public interface Consumer<T>
{
   void accept(T t);
}
```

The `forEach()` is a higher-order function that accepts a lambda expression
to execute it the context of each element in the list.

A combination of the `forEach()` method and a lambda expression turns the
example into a **declarative style**:

```Java
    list.forEach(s -> System.out.println(s));
```

This version has also a limitation.
Once the `forEach()` method starts, we can not break out of the iteration.

Let's take one last step to improve the example:

```Java
    list.forEach(System.out::println);
```

In the preceding code we use a **method reference**.
Java lets us simply replace the body of a lambda expression with the name
of a method of our choice.


## Transforming a List

We take a `List` of strings and transform it into a new `List`
that has elements in all caps.

Again we start with an **external iterator** using the `forEach()` loop:

```Java
    List<String> list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
    List<String> result = new ArrayList<>();
    for(String s : list)
    {
        result.add(s.toUpperCase());
    }
```
We create an empty `List` then populate it with all-uppercase strings,
one element at a time, while iterating through the original `List`.

Let's refactor that example into a **functional programming style**.

First, we turn the `Collection` into a `Stream`.
A `Stream` is much like an iterator on a `Collection` of objects and provides
some nice **fluent functions**.

Using the methods of the `Stream` interface, we can compose a sequence of calls
so that the code can be read in the same way we would describe the solution.

The **map()** method can transform a sequence of input to a sequence of output.
`map()` takes a functional interface called `Function<T, R>` as a parameter.

```Java
@FunctionalInterface
public interface Function<T, R>
{
    R apply(T t);
}
```
The `apply()` method accepts one argument and produces a result.

```Java
  List<String> result = list.stream()
    .map(s -> s.toUpperCase())
    .toList();
```
The method `stream()` is available on all collections and it wraps the collection
into an instance of `Stream`.

The `map()` method is quite useful to map or transform an input collection
into a new output collection.
Ths method will ensure tat the same number of elements exist in the input
and the output sequence.
Element types in the input don't have to match the element types in the
output collection.

Again, we can use a **method reference** to make the code more concise:

```Java
  List<String> result = list.stream()
    .map(String::toUpperCase)
    .toList();
```

In this example, the method reference was used for an instance method.
Method references can also refer to static methods and methods that take parameters.

## References
* [YouTube (Venkat Subramaniam): Functional Programming with Java 8](https://youtu.be/15X0qFtBqiQ)
* [The Java 8 Stream API Tutorial](https://www.baeldung.com/java-8-streams)

*Egon Teiniker, 2016-2023, GPL v3.0*