# Functional Programming


## Programming Paradigms

Programming paradigms refer to a **fundamental style or approach to programming** 
that defines how the code is structured, how it runs, and how it interacts with data. 

Programming paradigms provide a framework for developers to organize and structure 
their code to solve problems in different ways.

There are several programming paradigms, including:

* **Imperative**
    * Procedural 
    * Object-Oriented 

* **Declarative**
    * Functional 
    * Logic 

In this context, **Modern Java (since 1.8) is a hybrid that combines 
OOP and FP paradigms**.

### Imperative Programming
Imperative programming is a programming style where the programmer gives explicit
instructions on how the program should run.

In other words, it is a step-by-step approach to programming where the programmer
specifies the exact sequence of operations that the computer should perform to
achieve a desired outcome.

Imperative programming languages use statements and commands to change the state
of the program and the underlying system.

#### Procedural Programming
Procedural programming is a programming style where the program is structured
around procedures or functions that perform specific tasks.

In other words, it is a step-by-step approach to programming where the program
is organized into a series of functions or procedures that manipulate data.

Procedural programming languages use functions or procedures to group code that
performs a specific task, and these functions can be called from other parts of the program.

Some examples of procedural programming languages include **C**, **Pascal**, and **Fortran**.

#### Object-Oriented Programming
Object-oriented programming is a programming style where the program is organized
around objects that represent real-world entities or concepts.

In other words, it is a high-level approach to programming where the program is
organized into a series of objects that contain data and methods.

Object-oriented programming languages use objects to group data and methods that
are related to a specific entity or concept.

Examples of object-oriented programming languages include **C++**, **Java**, and **Python**.

### Declarative programming
Declarative programming is a programming style where the programmer specifies
what the program should do, rather than how it should do it.
  
In other words, it is a high-level approach to programming where the programmer
specifies the desired outcome, and the computer works out the details of how to
achieve that outcome.

Declarative programming languages describe the desired outcome or properties of
a program without specifying how to achieve them.

#### Functional programming
Functional programming is a programming style where the program is structured
around functions that take input and produce output, without changing the state
of the program or the underlying system.

In other words, it is a programming style that emphasizes the use of pure functions
and immutable data structures.

Functional programming languages use functions to transform data, and these functions
can be combined to build complex operations.

Some examples of functional programming languages include **Haskell**, **Lisp**, and **ML**.

#### Logic Programming
Logic programming is a programming style where the program is structured around
logical relations and rules that are used to infer new knowledge from existing facts.

In other words, it is a programming style that emphasizes the use of logical inference
and deduction to solve problems.

Logic programming languages use relations and rules to describe the problem domain,
and the program is executed by the interpreter that uses logical inference to deduce
new facts from the existing ones.

Examples of logic programming languages include **Prolog** and **Mercury**.


## Introduction to Functional Programming

Functional programming a programming style that emphasizes the use of
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
* [YouTube (Douglas Schmidt): Java Supported Programming Paradigms: Overview](https://youtu.be/mjWsvnzB2ss)

* Venkat Subramaniam. **Functional Programming in Java**. The Pragmatic Bookshelf, 2015

*Egon Teiniker, 2016-2024, GPL v3.0*