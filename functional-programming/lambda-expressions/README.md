# Lambda Expressions

Lambda expressions in Java were introduced in Java 8 and provide a way to express 
**instances of single-method interfaces** (known as functional interfaces) more 
compactly. 

They allow for more concise and readable code, especially when used in conjunction 
with **functional programming concepts such as the Stream API**.


Lambdas technically don't let us do anything that we couldn't do prior Java 8.
But we no longer have to write clumsy code using anonymous classes to benefit
from behavioral parameterization.

## Using Anonymous Classes 

An anonymous class in Java is **a class that does not have a name and is declared 
and instantiated all at once**. 

Anonymous classes enable us to make our code more concise by defining and creating 
an instance of a class in a single expression. 
They are often used to override the methods of a class or interface without the 
need to create a separate named class.

_Example:_ Anonymous class
```Java
    Comparator<Integer> c = new Comparator<Integer>()
    {
        public int compare(Integer a, Integer b)
        {
            return b-a;
        }
    };
```

## Using Lambda Expressions

A **lambda expression** doesn't have a name, but consists of three parts:
* A comma-separated list of **parameters enclosed in parentheses**.
* The arrow token `->`.
* A **body**, which can be a single expression or a block of statements.

_Example:_ Lambda expresion: `(parameters) -> body`
```Java
	Comparator<Integer> comp = (a,b) -> b-a;
```

The compiler can often infer the types of the parameters of a lambda 
expression, so we don't need to specify them.

Lambda expressions in Java can only be used with interfaces that have 
a single abstract method. These interfaces are known as **functional interfaces**. 

Java provides several built-in functional interfaces like `Runnable`, `Callable`, 
`Comparator`, and those in the `java.util.function` package.

**Lambda expressions let us provide the implementation of the abstract method of a
functional interface directly inline** and treat the whole expression as an instance
of a functional interface (exactly: an instance of a concrete implementation of the
functional interface).

**The signature of the abstract method of the functional interface essentially 
describes the signature of the lambda expression**. We call this abstract method a 
function description.

A lambda expression can be assigned to a variable or passed to a method expecting
a functional interface as argument, provided the lambda expression has the same 
signature as the abstract method of the functional interface.


## Anonymous Classes vs. Lambda Expressions

If we compare anonymous classes with lambda expressions, we get the following 
advantages and disadvantages:

**Anonymous Classes**:
* Can implement multiple methods if extending a class.
* Can have instance variables and initializers.
* Suitable for more complex cases where more functionality is required.

**Lambda Expressions**:
* Only used with functional interfaces (interfaces with a single abstract method).
* More concise and readable for single-method implementations.
* Preferred for simple, brief implementations like callbacks or listeners.

Anonymous classes in Java provide a way to create quick, one-off implementations 
of interfaces or extensions of classes, useful for simple tasks like event handling 
or small, isolated pieces of functionality. 
However, for more complex scenarios, named classes or lambda expressions might be 
more appropriate.


## Method References

Method references in Java provide a shorthand, compact syntax to refer to methods 
or constructors without having to invoke them explicitly. They are part of Java's 
functional programming capabilities introduced in Java 8, and they work with functional 
interfaces. 

**A method reference allows you to create a lambda expression by referring to a method directly**, thereby making the code more readable and concise.

There are four main types of method references in Java:

* **Static Method Reference**:
    A static method reference refers to a static method of a class.

    _Example:_ `ClassName::staticMethodName`
    ```Java
    Function<String, Integer> lambda = s -> Integer.parseInt(s);    // Using a lambda expression

    Function<String, Integer> methodRef = Integer::parseInt;        // Using a method reference
    ```

* **Instance Method Reference of a Particular Object**: 
    An instance method reference refers to an instance method of a particular object.
    
    _Example:_ `instance::instanceMethodName`
    ```Java
    Supplier<Integer> lambda = () -> str.length();  // Using a lambda expression

    Supplier<Integer> methodRef = str::length;      // Using a method reference
    ```

* **Instance Method Reference of an Arbitrary Object of a Particular Type**: 
    An instance method reference refers to an instance method of an arbitrary object 
    of a particular type.
    
    _Example:_ `ClassName::instanceMethodName`
    ```Java
    strings.forEach(s -> System.out.println(s));  // Using a lambda expression

    strings.forEach(System.out::println);         // Using a method reference
    ```

* **Constructor Reference**:
    A constructor reference refers to a constructor of a class.
    
    _Example:_  `ClassName::new`
    ```Java
    Function<String, StringBuilder> lambda = str -> new StringBuilder(str);  // Using a lambda expression

    Function<String, StringBuilder> methodRef = StringBuilder::new;          // Using a method reference
    ```

Method references in Java provide a way to make code more concise and readable by referring 
to existing methods or constructors without invoking them directly. 


## Implementation of Lambda Expressions in Bytecode

In Java versions since Java 8, lambda expressions are implemented using a combination 
of compile-time and runtime mechanisms that leverage **invokedynamic** and 
**LambdaMetafactory**. This approach provides efficient, flexible, and high-performance 
lambda expressions that are integrated seamlessly into the Java language and runtime.

* **Compile-Time Representation**:
    When a lambda expression is compiled, the compiler generates a `private static` 
    method in the containing class that contains the code for the lambda body. 
    This method takes the lambda's parameters and returns its result.

* **Invokedynamic Bytecode Instruction**:
    The compiler inserts an `invokedynamic` instruction in the place of the lambda 
    expression. This instruction is used to dynamically link the lambda expression 
    at runtime.

* **Bootstrap Method**:
    The `invokedynamic` instruction references a bootstrap method, which is 
    `LambdaMetafactory.metafactory` by default. This method is responsible for 
    creating a `CallSite` that points to the lambda implementation.

* **LambdaMetafactory**:
    The `LambdaMetafactory` generates a `CallSite` that creates an instance of a 
    functional interface implementation. This is typically done using `MethodHandles` 
    and dynamically generated classes that implement the functional interface.

Using `invokedynamic` and `LambdaMetafactory` allows for high-performance lambdas 
that can be optimized by the JVM.


## References
* [YouTube: Lambda Expressions in Java](https://youtu.be/tj5sLSFjVj4?si=RFvUQJ57jLEFJwlX)
* [YouTube: Java Anonymous Inner Classes](https://youtu.be/DwtPWZn6T1A?si=rRHno75wECXib-gy)
* [YouTube (Venkat Subramaniam): Functional Programming with Java](https://youtu.be/15X0qFtBqiQ)

* Raoul-Gabriel Urma, Mario Fusco, Alan Mycroft. **Java 8 in Action: Lambdas, Streams, and Functional-Style Programming**. Manning Publishing, 2014
    * Chapter 3: Lambda Expressions
  
*Egon Teiniker, 2016-2024, GPL v3.0*