# Structural Patterns

Structural patterns are design patterns that deal with **class and object 
composition** or the relationships between entities to form larger structures. 

These patterns focus on **how classes and objects are composed to form 
larger structures** while keeping these structures flexible and efficient.


Overview of some key structural patterns described by the GoF:

* [**Proxy**](proxy/README.md): 
  This pattern provides a surrogate or placeholder for another object 
  to control access to it. It is used to create a representative object that 
  controls access to another, possibly more complex, object.

* [**Decorator**](decorator/README.md):
  This pattern adds additional responsibilities to an object dynamically.
  Decorators provide a flexible alternative to subclassing for extending
  functionality.

* [**Adapter**](adapter/README.md):
  This pattern allows incompatible interfaces to work together. It acts 
  as a bridge between two incompatible interfaces by converting one interface 
  to another that a client expects.

* **Bridge**: 
  This pattern decouples an abstraction from its implementation so that 
  the two can vary independently. It involves an interface, and the implementation 
  of this interface is selected at runtime.

* [**Facade**](facade/README.md): 
  This pattern provides a simplified interface to a complex subsystem, making 
  it easier to use. It defines a higher-level interface that makes the subsystem
  easier to use.

* [**Composite**](composite/README.md): 
  This pattern allows you to compose objects into tree structures to represent
  part-whole hierarchies. It lets clients treat individual objects and compositions
  of objects uniformly.

* **Flyweight**: 
  This pattern reduces the cost of creating and manipulating a large number 
  of similar objects. It involves sharing objects to support large numbers 
  of fine-grained objects efficiently.

Each of these structural patterns addresses different aspects of composing 
objects and classes. By leveraging these patterns, developers can create 
flexible and reusable object-oriented designs. 

They help manage dependencies and can **improve the overall structure** and 
maintainability of the system.





## References
* [Structural Patterns in Core Java](https://www.baeldung.com/java-core-structural-patterns)
* E. Gamma, R. Helm, R. Johnson, J. Vlissides. **Design Patterns, Elements of Reusable Object-Oriented Software**. Addison-Wesley, 1995
  * Chapter 4: Structural Patterns 
* Joshua Kerievsky. **Refactoring to Patterns**. Addison-Wesley, 2005

*Egon Teiniker, 2016-2024, GPL v3.0*
