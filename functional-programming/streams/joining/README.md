# Joining Elements

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

