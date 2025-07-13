# Finding Elements
 
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


# Picking an Element 

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

