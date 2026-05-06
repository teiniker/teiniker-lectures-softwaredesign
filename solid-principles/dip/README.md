# Dependency-Inversion Principle (DIP)

> **High-level modules should not depend on low-level modules**. 
> Both should depend on abstractions.

> **Abstractions should not depend on (implementation) details**. 
> Details should depend on abstractions.

The dependency structure is **inverted** with respect to the dependency structure 
that normally results from traditional procedural methods (service interfaces are 
often owned by their clients).

Since the abstractions and details are all isolated from each other, the code is 
much easier to maintain.

_Example:_ Layering

![Layering](figures/Layering.png)

A naive implementation of this architectural pattern might lead to a structure 
where the high-level **Policy Layer** uses a lower-level **Mechanism Layer**, 
which uses a detailed-level **Utility Layer**. 

_Example_: Dependency Inversion

![Layering](figures/DIP.png)

In a more appropriate design, the upper-level layer declares abstract interfaces 
for the service that it needs. The lower-level layer is then realized from these 
abstract interfaces.

The lower-layers depend on abstract service interfaces declared in the upper layers.

This principle is sometimes known as the **Hollywood principle**: 
„Don‘t call us, we‘ll call you“


## References

* E. Gamma, R. Helm, R. Johnson, J. Vlissides. **Design Patterns, Elements of Reusable Object-Oriented Software**. Addison-Wesley, 1995

* Robert C. Martin. **Agile Software Development – Principles, Patterns, and Practices**. Prentice Hall, 2003

*Egon Teiniker, 2016-2026, GPL v3.0*