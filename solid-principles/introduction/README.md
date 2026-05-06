# Introduction

The **UML diagrams** representing the source code are additive to the design 
but are not the design itself. We should not see UML diagrams separate from the code.

The **design of a software system** is an abstract concept.
It has to do with the overall shape and structure of the program as well 
as the detailed shape and structure of each module, class, and method.

> **In the end, the source code is the design!**


A principle of reusable object-oriented design that reduces implementation 
dependencies between subsystems significantly is:

> **Program to an interface, not an implementation!**

Don’t declare variables to be instances of particular concrete classes. 
Instead, commit only to an interface.


**Class inheritance** is defined statically at compile-time and is supported 
directly by the programming languages.

Disadvantages of class inheritance:
* We can’t change the implementations inherited from parent classes at run-time.
* The implementation of a subclass becomes so bound up with the implementation 
    of its parent class that any change in the parent’s implementation will force 
    the subclass to change. 
    Therefore, it’s often said that **inheritance breaks encapsulation**.

**Object composition** is defined dynamically at run-time through objects acquiring 
references to other objects.

Advantages of object composition:
* Because objects are accessed solely through their interfaces, we don’t break 
    encapsulation.
* Because object’s implementation will be written in terms of object interfaces, 
    there are substantially fewer implementation dependencies.

> **Favor object composition over class inheritance!**


## References

* E. Gamma, R. Helm, R. Johnson, J. Vlissides. **Design Patterns, Elements of Reusable Object-Oriented Software**. Addison-Wesley, 1995

* Robert C. Martin. **Agile Software Development – Principles, Patterns, and Practices**. Prentice Hall, 2003

*Egon Teiniker, 2016-2026, GPL v3.0*