# Stream API

Java Streams, introduced in Java 8, provide a modern, functional approach to 
processing sequences of elements. They offer a high-level, declarative way to 
handle data transformations and computations, allowing for more readable and 
concise code. 

## Introduction 

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
    * `collect()`: Collects elements into a collection.
    * `reduce()`: Reduces elements to a single value using an accumulator function.    

* **Source**:
    The data source for a stream can be a collection, array, I/O channel, or generator 
    function.


## Using the Stream API

* [Iterating Through a Collection](iterating/)

* [Transforming Elements](transforming/)

* [Filtering Elements](filtering/)

* [Reducing a Collection to a Single Value](reducing/)

* [Joining Elements](joining/)


## References
* [YouTube (Venkat Subramaniam): Functional Programming with Java 8](https://youtu.be/15X0qFtBqiQ)
* [The Java 8 Stream API Tutorial](https://www.baeldung.com/java-8-streams)
* [Guide To Java 8 Optional](https://www.baeldung.com/java-optional)

*Egon Teiniker, 2016-2025, GPL v3.0*