# Reducing a Collection to a Single Value

All techniques to manipulate collections so far have one thing in common: 
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

