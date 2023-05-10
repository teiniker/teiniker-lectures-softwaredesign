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

## Finding Elements 
The `filter()` method is designed to pick elements from a collection.

From a list of strings, let's pick the ones which end with the charachter `i`.

First, we code in classic Java:
```Java
List<String> list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
List<String> result = new ArrayList<>();

for(String s : list)
{
    if(s.endsWith("i"))
        result.add(s);
}
```
In a loop we test every element from the list and add the matching elements 
to the result list.

We can refactor that code using the filter method which expects a
`Predicate<T>` type containing the `boolean test(T t)` method, which
represents a predicate (boolean-valued function) of one argument.

```Java
@FunctionalInterface
public interface Predicate<T> 
{
    boolean test(T t);
}
```

The `filter()` method expects a lambda expression that returns a boolean result.
If the lambda expression returns a `true`, the element is added to a result
collection, otherwise it is skipped.

```Java
    List<String> result = list.stream()
        .filter(s -> s.endsWith("i"))
        .toList();
```
Finally, the method returns a `Stream` with only elements for which the lambda 
expression yields a `true`.
In the end we transform the result into a `List` using the `toList()` method.

The elements in the result collection that `filter()` returned are a **subset of the 
elements in the input collection**.

To reduce redundancy, we can **assign lambda expressions to variables** and reuse 
them, just like with objects.


## Picking an Element 

One would think that picking one element from a collection would be simpler than 
picking multiple elements. But there are a few complications.

Let's try to pick the first matching element and safely deal with the absence 
of such an element.

Here the code in classic Java:
```Java
List<String> list = = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
String result = null;
for(String s : list)
{
    if(s.startsWith("Z"))
    {
        result = s;
        break;
    }
} 
```
Note that the result here can be either a string or `null`.

In the new implementation we also want to pick the first matching element
but safely deal with the absence of such an element.
```Java
    Optional<String> result = list.stream()
        .filter(s -> s.startsWith("Z"))
        .findFirst();

    String finalResult = result.orElse("");
```
We use the `filter()` method to grap all the elements matching the desired pattern.
Then the `findFirst()` method of the Stream class to pick the first element from 
that collection.
This method returns an `Optional` object, which is useful whenever the result may be 
absent.

`Optional` protects us from getting a `NullPointerException` by accident and makes it quite 
explicit to the reader that "no result found" is a possible outcome.

We can inquire if an object is present by using the `isPresent()` method, and we can obtain 
the current value using its `get()` method.

Alternatively, we can suggest a substitute value for the missing instance,
using the method `orElse()`.

Rather than providing an alternative value for the absent instance, we can ask 
`Optional` to run a lambda expression only if a value is present using the `ifPresent()`
method.

## Reducing a Collection to a Single Value
All techniques to manipulate collections so far have one thin in common: 
they all work independently on individual elements in the collection.

Now we look at how to compare elements and carry over a computational state across 
a collection.

As the first example, we calculate the **total number of characters** over all
strings in the list:
```Java
List<String> list = Arrays.asList("00001111", "0011", "0000011111", "01");
int sum = list.stream()
    .mapToInt(s -> s.length())
    .sum();
```
To find the total of the characters, we need the length of each string.
We can easily compute that using the `mapToInt()` method.

Once we transform from the strings to their length, the final step is to total them
using the `sum()` method.

There are more mapping methods like: `mapToDouble()` and `mapToLong()`. 

Instead of using the `sum()` method, we could use a variety of methods like
`max()` to find the longest length, `min()` to find the shortest length,
`sorted()` to sort the lengths, `average()` to find the average of the length, and so on.

We can use the `reduce()` method to compare two elements against each other and
pass along the result for further comparison with the remaining elements in the 
collection.

The `reduce()` method iterates over the collection and carries forward the result of the
computation that the lambda expression returned.
```Java
List<String> list = Arrays.asList("00001111", "0011", "0000011111", "01");
Optional<String> longString = list.stream()
        .reduce((s1,s2) -> s1.length() > s2.length() ? s1 : s2);
longString.ifPresent(s -> System.out.printf("The longest string is '%s'\n", s));
```

`reduce()` takes a `BinaryOperator<T>` argument which inherits the method  `T apply(T t, T u)`
from `BiFunction<T, T, T>`. 
```Java
@FunctionalInterface
public interface BiFunction<T, U, R> 
{
    R apply(T t, U u);
}

@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T> 
{
}
```

The result of the `reduce()` method is an Optional because the list on which
`reduce()` is called may be empty.


## Joining Elements

We can use the `join()` method of the `String` class to 
concatenate a collection.

```Java
List<String> list = List.of("00001111", "0011", "0000011111", "01");
String result = String.join(",", list);
```

There is also an alternative way, we can use the `collect()` method which 
does the reduction of a collection but delegates the target to a 
collector.
```Java
List<String> list = List.of("00001111", "0011", "0000011111", "01");
String result = list.stream()
        .collect(Collectors.joining(","));
```


## References
* [YouTube (Venkat Subramaniam): Functional Programming with Java 8](https://youtu.be/15X0qFtBqiQ)
* [The Java 8 Stream API Tutorial](https://www.baeldung.com/java-8-streams)
* [Guide To Java 8 Optional](https://www.baeldung.com/java-optional)

*Egon Teiniker, 2016-2023, GPL v3.0*