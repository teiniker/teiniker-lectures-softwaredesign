# Behavioral Patterns

Behavioral patterns are concerned with algorithms and the assignment 
of responsibilities between objects. These patterns focus on 
**how objects communicate with each other and how the flow of control is managed in 
complex systems**. 

Behavioral patterns help to define how objects interact and distribute 
responsibilities, making the system more flexible and easier to understand, 
modify, and maintain.

Overview of the behavioral patterns described by the GoF:

* [**Strategy**](strategy/): 
    This pattern defines a family of algorithms, encapsulates each one, and makes 
    them interchangeable. It lets the algorithm vary independently from the clients 
    that use it.

* [**Template Method**](template-method/): 
    This pattern defines the skeleton of an algorithm in an operation, deferring 
    some steps to subclasses. It lets subclasses redefine certain steps of an 
    algorithm without changing its structure.

* [**Command**](command/): 
    This pattern encapsulates a request as an object, thereby allowing for
    parameterization of clients with queues, requests, and operations. 
    It supports undoable operations.

* [**Iterator**](iterator/): 
    This pattern provides a way to access the elements of an aggregate object 
    sequentially without exposing its underlying representation.

* [**Visitor**](visitor/): 
    This pattern lets you define a new operation without changing the classes 
    of the elements on which it operates. It separates an algorithm from the 
    object structure it operates on.

* [**Chain of Responsibility**](chain-of-responsibility/): This pattern allows a 
    request to pass through a chain of handlers. Each handler decides either 
    to process the request or to pass it to the next handler in the chain.

* [**Observer**](observer/): 
    This pattern defines a one-to-many dependency between objects so that when 
    one object changes state, all its dependents are notified and updated 
    automatically.

* **Mediator**: This pattern defines an object that encapsulates how a set 
    of objects interact. It promotes loose coupling by keeping objects from 
    referring to each other explicitly and allows their interaction to be 
    varied independently.

* **Memento**: This pattern provides the ability to restore an object to its 
    previous state without violating encapsulation. It captures and externalizes 
    an object's internal state. 

* [**State**](state/):
    This pattern allows an object to alter its behavior when its internal 
    state changes. The object will appear to change its class.

* **Interpreter**: This pattern defines a representation for a grammar of a 
    given language along with an interpreter that uses the representation 
    to interpret sentences in the language.


Each of these behavioral patterns addresses different aspects of how objects 
interact and communicate within a system. 

By using these patterns, developers can create more modular and decoupled systems, 
where changes in one part of the system have minimal impact on other parts, 
enhancing flexibility and maintainability.


## References

* E. Gamma, R. Helm, R. Johnson, J. Vlissides. **Design Patterns, Elements of Reusable Object-Oriented Software**. Addison-Wesley, 1995
  * Chapter 5: Behavioral Patterns 

* Joshua Kerievsky. **Refactoring to Patterns**. Addison-Wesley, 2005

*Egon Teiniker, 2016-2024, GPL v3.0*