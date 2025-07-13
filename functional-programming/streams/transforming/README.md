# Transforming Elements

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

