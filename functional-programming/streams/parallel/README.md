# Parallel Streams

## Overview

A **parallel stream** splits its source data into multiple chunks, processes
each chunk in a separate thread using the **Fork/Join Framework**, and then
combines the results. The only code change required is replacing `.stream()`
with `.parallelStream()` (or calling `.parallel()` on an existing stream).

**Benefits:**
* Leverages all available CPU cores transparently: no manual thread management.
* The same pipeline code works for both sequential and parallel execution.
* Significant speedup for CPU-bound operations on large data sets.


## Example: Book List

The `Book` class has three properties `isbn`, `author`, `title`.

In the corresponding test cases, `filter`, `map`, `sorted`, and `toList` 
stream operations will be used.


### Sequential vs. Parallel

```java
// Sequential
List<String> titles = books.stream()
        .map(Book::getTitle)
        .sorted()
        .toList();

// Parallel — identical pipeline, different source
List<String> titles = books.parallelStream()
        .map(Book::getTitle)
        .sorted()
        .toList();
```

### `findAny()` Instead of `findFirst()`

With parallel streams, `findAny()` is preferred over `findFirst()` because
`findFirst()` must enforce encounter order even in parallel, which adds
synchronisation overhead. When any match is acceptable, use `findAny()`:

```java
Optional<Book> result = books.parallelStream()
        .filter(b -> b.getIsbn().equals(ISBN))
        .findAny();
```

### `assertAll` for Grouped Verification

JUnit 6's `assertAll` groups multiple assertions so that all failures are
reported in one test run. This is useful when verifying several fields of 
a found object:

```java
assertAll("found book",
    () -> assertTrue(result.isPresent()),
    () -> assertEquals("Robert C. Martin", result.get().getAuthor()),
    () -> assertEquals("Clean Code", result.get().getTitle())
);
```

## When to Use Parallel Streams

**Good candidates:**
* Large collections (typically > 10 000 elements) where processing is CPU-bound.
* Stateless, side-effect-free operations (`map`, `filter`, `reduce`).
* Operations that can run independently on each element.

**Avoid parallel streams when:**
* The data source is small because thread coordination overhead outweighs the gain.
* Operations have side effects or shared mutable state (e.g. writing to a list).
* The source has poor splittability (e.g. `LinkedList`, `Iterator`-backed streams).
* Order matters and the pipeline uses `findFirst()`, `forEachOrdered()`, or `limit()`,
  since maintaining encounter order in parallel requires extra synchronisation.
* The task is I/O-bound where threads will mostly block, so parallelism adds nothing.

**Rule of thumb:** profile first. Use `parallelStream()` only after confirming that
a bottleneck exists and that parallelism actually improves throughput on the target
hardware.


## Fork/Join Framework 

The thread pool operates on two fundamental operations:

* **Fork**: If a task is too large, it is split (forked) into smaller, 
        independent sub-tasks. This happens recursively until the sub-task 
        is small enough to be executed sequentially without further splitting.

* **Join**: Once the sub-tasks finish executing, their results are combined 
        (joined) back together to form the final result.


### Number of Threads Used

From the JVM runtime we get the number of CPU cores:

```Java
// Print the number of available processors
int cpus = Runtime.getRuntime().availableProcessors();
```

We can also check the parallelism level of the common pool using the 
**ForkJoinPool API**:

```Java
// Get the target parallelism level
int parallelism = ForkJoinPool.getCommonPoolParallelism();
        
// Get the actual number of worker threads currently running
int poolSize = ForkJoinPool.commonPool().getPoolSize();
```

By default, `ForkJoinPool.getCommonPoolParallelism()` returns one less than 
the number of logical CPU cores (CPUs - 1). This is because the main thread 
calling the stream also participates in the execution, bringing the total 
thread count up to equal your total CPU cores.

We can set a JVM-wide flag to configure the common pool's parallelism. 
This must be done before any parallel stream is invoked, ideally as 
a JVM argument.

```Java 
System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");
```

```bash
$ java -Djava.util.concurrent.ForkJoinPool.common.parallelism=4 -jar your-app.jar        
```


## References

* Brian Goetz et al. **Java Concurrency in Practice**. Addison-Wesley, 2006.
* Venkat Subramaniam. **Functional Programming in Java**. Pragmatic Bookshelf, 2014.
* [Java Parallel Streams (Baeldung)](https://www.baeldung.com/java-when-to-use-parallel-stream)
* [Fork/Join Framework (Oracle)](https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html)

*Egon Teiniker, 2016-2026, GPL v3.0*
