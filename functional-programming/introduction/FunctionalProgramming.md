# Introduction to Functional Programming

Functional programming in Java is a programming style that emphasizes the use of
pure functions and immutable data structures to transform data.

* **Pure Function**: Its return value is the same for the same argument
  (no reading of shared mutable state).
  Its evaluation has **no side effects** (no writing to shared mutable state)

* **Higher-Order Functions**: They refer to **functions that operate on
  other functions**, either by taking them as arguments, returning them as
  results, or both.
  In a higher-order function, **functions are treated as inputs or outputs**,
  similar to how other data types like integers or strings can be inputs or
  outputs to functions.

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

## References
* Venkat Subramaniam. **Functional Programming in Java**. The Pragmatic Bookshelf, 2015

*Egon Teiniker, 2016-2023, GPL v3.0*
