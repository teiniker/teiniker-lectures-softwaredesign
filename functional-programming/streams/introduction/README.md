# Introduction to Java Streams API


## Pipes & Filters Pattern

The Pipes and Filters architectural pattern is a classic, highly decoupled 
structural pattern used to process a stream of data.

### Core Components

Pipes and Filters is a pattern that decomposes a complex processing task 
into a sequence of separate, independent reusable steps (**Filters**) that 
communicate exclusively through standard interfaces (**Pipes**).

* **Filters (The Processors)**: 
    A filter is an independent, encapsulated data processing unit. 
    It transforms, enriches, refines, or validates data.

    Filters are completely ignorant of their neighbors. A filter only 
    knows its input interface and its output interface. It does not 
    know which filter preceded it or which one follows.

    Filters can run synchronously, but they are most powerful when 
    running asynchronously as separate threads, processes, or microservices, 
    processing data as soon as it arrives.

* **Pipes (The Conduits)**:
    A pipe is the directional communication channel that transports data 
    from one filter's output to the next filter's input.

    Pipes handle data buffering and synchronization. If a upstream filter 
    produces data faster than a downstream filter can consume it, the pipe 
    acts as a queue.

At an advanced level, filters are categorized by how they interact with 
the data stream:

* **Producer (Source)**: A starting point that injects data into the pipeline 
    (e.g., reading from a database, listening to an IoT MQTT broker).

* **Transformer (Pure Filter)**: Consumes data, modifies it, and outputs it.

* **Consumer (Sink)**: An endpoint that collects the final processed data 
    and writes it to a file, database, or UI, without forwarding it further.

### Advantages

* **Extreme Decoupling and Reusability**: Because filters share no state and 
    rely only on standard interfaces, we can rearrange, swap, or reuse them 
    across different pipelines. 
    
* **Concurrence and Parallelism**: Since filters can run independently, a 
    pipeline naturally leverages multi-core processors or distributed 
    infrastructure. 
    While Filter B is processing item `N`, Filter A can simultaneously 
    process item `N+1`. 
    
* **Scalability**: If a specific filter is computationally expensive (e.g., 
    an image compression filter), we can easily scale that specific filter 
    horizontally by running multiple instances of it in parallel, fed by a 
    load-balancing pipe.
    
* **Flexibility and Extensibility**: New requirements simply mean creating 
    a new filter and dropping it into the sequence, requiring zero 
    modifications to existing filters.


### Real-World Implementation

A classic examples of using the Pipes & Filters pattern is  the 
**UNIX Command Line Interface (CLI)**.

_Example_: UNIX Pipes

```bash
$ cat names.txt | grep "Smith" | sort
```

Another example is the Java Streams API.


## Java Streams API 

Java Streams, introduced in Java 8, provide a modern, functional approach to 
processing sequences of elements. They offer a high-level, declarative way to 
handle data transformations and computations, allowing for more readable and 
concise code. 

Streams can be used to perform operations such as filtering, mapping, and reducing 
collections of data.

* **Stream Definition**:
    A stream is a sequence of elements supporting sequential and parallel aggregate 
    operations. Unlike collections, streams do not store elements; they carry elements 
    from a source (like a collection, array, or I/O channel) through a pipeline of 
    computational operations.

* **Pipeline of Operations**:
    Streams operate in a pipeline pattern, where multiple operations are chained 
    together. The operations in the pipeline are classified into intermediate 
    operations and terminal operations.

* **Intermediate Operations**:
    Intermediate operations transform a stream into another stream. These operations 
    are lazy, meaning they are not executed until a terminal operation is invoked. 

    _Examples:_
    * `filter()`: Filters elements based on a predicate.
    * `map()`: Transforms elements using a function.
    * `sorted()`: Sorts the elements.

* **Terminal Operations**:
    Terminal operations produce a result or a side-effect and mark the end of the 
    stream pipeline. 
    
    _Examples:_
    * `forEach()`: Performs an action for each element.
    * `toList()`: Collects elements into a collection.
    * `reduce()`: Reduces elements to a single value using an accumulator function.    

* **Source**:
    The data source for a stream can be a collection, array, I/O channel, or generator 
    function.

## References
* [YouTube (Venkat Subramaniam): Functional Programming with Java 8](https://youtu.be/15X0qFtBqiQ)
* [The Java 8 Stream API Tutorial](https://www.baeldung.com/java-8-streams)
* [Guide To Java 8 Optional](https://www.baeldung.com/java-optional)

*Egon Teiniker, 2016-2026, GPL v3.0*