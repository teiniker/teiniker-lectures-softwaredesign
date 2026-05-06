# Liskov Substitution Principle (LSP)

> **Subtypes must be substitutable** for their base types.

A class, viewed in isolation, cannot be meaningfully validated. The validity of 
a class can only be expressed in terms of its clients.

The LSP makes it clear that in OOD, the **is a** relationship applies to **behavior** 
that can be reasonably assumed and that clients depend on. 

The true definition of a subtype is **substitutable**, where substitutability 
is **defined by a contract**.

_Example:_ Design by Contract (DbC)\
    The contract is specified by declaring pre- and post-conditions for each operation 
    as well as invariants for a class.

* The **precondition (pre)** states the properties that must hold whenever the 
    operation is called.
* The **postcondition (post)** states the properties that the operation guarantees 
    when it returns.
* An **invariant (inv)** for a class C is a set of assertions that every instance 
    of C will satisfy at all “stable” times (on instance creation, before and after 
    every operation call). 
```
    {inv AND pre} op {inv AND post}
```

In the context of **inheritance**, subcontracting must be handled in a proper way: 
* For a **precondition**, all parents expressions are combined in a logical **OR** 
    relationship. A subclass operation’s precondition can only weaken the original.
* For a **postcondition**, all parent expressions are combined in a logical **AND** 
    relationship. A subclass operation’s postcondition can only be strengthen the original.
* **Invariants** accumulate down an inheritance structure. The invariants of all 
    parents apply to the subclass itself in a logical **AND** combination.


_Examples:_ GoF Patterns 

* **Template Method Pattern**: The parent class defines the skeleton of an algorithm. 
    Subclasses override specific steps but must preserve the overall structure. 
    This ensures that any subclass can be used where the abstract class is expected 
    without surprising the caller.

* **Composite Pattern**: Clients treat individual objects and compositions of objects 
    uniformly. Whether you are dealing with a single `File` or a `Directory` 
    (the composite), the interface remains the same, ensuring the composite "substitutes" 
    for the component perfectly.

## References

* E. Gamma, R. Helm, R. Johnson, J. Vlissides. **Design Patterns, Elements of Reusable Object-Oriented Software**. Addison-Wesley, 1995

* Robert C. Martin. **Agile Software Development – Principles, Patterns, and Practices**. Prentice Hall, 2003

*Egon Teiniker, 2016-2026, GPL v3.0*
