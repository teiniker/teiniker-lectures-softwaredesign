## Iterating Through a Collection

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
    list.stream().forEach(s -> System.out.println(s));
```

This version has also a limitation.
Once the `forEach()` method starts, we can not break out of the iteration.

Let's take one last step to improve the example:

```Java
    list.stream().forEach(System.out::println);
```

In the preceding code we use a **method reference**.
Java lets us simply replace the body of a lambda expression with the name
of a method of our choice.

