# Functional Programming in Java 

Functional programming in Java is a programming style that emphasizes the use of 
pure functions and immutable data structures to transform data. 

* **Pure Function**: Its return value is the same for the same argument 
   (no reading of shared mutable state).
   Its evaluation has **no side effects** (no writing to shared mutable state)

* **Immutable Data Structures**: Data structures that **cannot be modified** once 
  they are created. 
  Any operation on an immutable data structure returns a new data structure, 
  leaving the original data structure intact.

In functional programming, **functions are treated as first-class citizens**, which 
means that they can be treated **like any other object** in the program. 
This enables Java programmers to write code that is more concise, easier to read, 
and less error-prone. 

**Functional programming is supported in Java** by the introduction of features like 
lambda expressions, method references, and the Stream API in Java 8 and later versions:

* **Lambda Expressions** and **Method References** allow developers to create and 
  use **functions as objects**, which can be passed as arguments to other functions, stored 
  in variables, and returned as values.

* The **Stream API** allows developers to perform operations on collections of data using 
  functional-style operations like **map**, **filter**, and **reduce**, which can be 
  **chained together** to create complex transformations.


## Collections and Streams

We often use collections of numbers, strings, and objects.









## References
* [YouTube (Dave Farley):GOTO 2021: Object Oriented Programming vs Functional Programming](https://youtu.be/-VADIcicpcg)
* [YouTube (Venkat Subramaniam): Functional Programming with Java 8](https://youtu.be/15X0qFtBqiQ)

* Venkat Subramaniam. **Functional Programming in Java**. The Pragmatic Bookshelf, 2015

* [The Java 8 Stream API Tutorial](https://www.baeldung.com/java-8-streams)


*Egon Teiniker, 2016-2023, GPL v3.0*

