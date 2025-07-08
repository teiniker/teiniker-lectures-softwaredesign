# Code Smells 

> A code smell is a **surface indication** that usually **corresponds to a deeper problem** in the system. 
> A smell is by definition something that's **quick to spot**.

A smells aren't inherently bad on their own - they are often an indicator of a problem rather than 
the problem themselves.


## Bloaters

Bloaters are code, methods and classes that have increased to such gargantuan 
proportions that they are hard to work with. Usually these smells do not crop 
up right away, rather they accumulate over time as the program evolves 
(and especially when nobody makes an effort to eradicate them).

* **Long Method**: A method that is too long becomes hard to understand, maintain, 
and reuse due to doing too much.

* **Large Class**: A class that has too many responsibilities becomes difficult 
to manage and violates the Single Responsibility Principle.

* **Primitive Obsession**: Overuse of primitive types (like strings, integers, or 
arrays) instead of small objects for domain concepts leads to less expressive, 
less flexible code.

* **Long Parameter List**: A method that takes too many parameters is harder to 
understand and use, often signaling that some parameters should be grouped 
or encapsulated.

* **Data Clumps**: Groups of variables that tend to appear together suggest that 
they should be encapsulated in their own class or object.



## Object-Orientation Abusers

All these smells are incomplete or incorrect application of object-oriented 
programming principles.

* **Alternative Classes with Different Interfaces**: Two classes perform similar 
	functions but have different method names, making it hard to use them 
	interchangeably or understand their commonality.

* **Refused Bequest**: A subclass inherits methods or fields from its superclass 
	that it does not use or want, indicating that inheritance may be inappropriate.

* **Switch Statements**: Frequent use of switch (or if-else) statements based 
	on type or state suggests that polymorphism could better organize the 
	behavior.

* **Temporary Field**: A field that is only set or used in certain situations 
	adds confusion and clutter to the object’s structure.


## Change Preventers

These smells mean that if you need to change something in one place in 
your code, you have to make many changes in other places too. Program 
development becomes much more complicated and expensive as a result.

* **Divergent Change**: A class suffers from frequent changes for different 
	reasons, indicating it has too many responsibilities and should be split.

* **Parallel Inheritance Hierarchies**: Every time you create a subclass 
	in one hierarchy, you must create a corresponding subclass in another, 
	suggesting tight and unnecessary coupling between class structures.

* **Shotgun Surgery**: A small change requires many small edits scattered 
	across multiple classes or methods, making the system harder to 
	maintain and more error-prone.


## Dispensables

A dispensable is something pointless and unneeded whose absence would 
make the code cleaner, more efficient and easier to understand.

* **Comments**: Excessive or outdated comments may indicate that the 
	code isn't clear enough on its own and would benefit more from 
	refactoring than annotation.

* **Duplicate Code**: Identical or very similar code appearing in multiple 
	places increases maintenance effort and risk of inconsistencies.

* **Data Class**: A class that contains only fields and no meaningful 
	behavior tends to be overly passive and overly dependent on other 
	classes.

* **Dead Code**: Code that is never used or no longer serves a purpose 
	clutters the codebase and should be removed.

* **Lazy Class**: A class that does too little to justify its existence 
	adds unnecessary complexity and can often be eliminated or merged.

* **Speculative Generality**: Code designed for anticipated future needs 
	that never materialize adds unnecessary complexity and should be 
	removed.


## Couplers

All the smells in this group contribute to excessive coupling between 
classes or show what happens if coupling is replaced by excessive delegation.

* **Feature Envy**: A method that uses data or methods from another class 
	more than from its own suggests it belongs in the other class.

* **Inappropriate Intimacy**: Two classes are too tightly coupled, often 
	accessing each other’s internals, making changes risky and violating 
	encapsulation.

* **Incomplete Library Class**: A library or external class lacks needed 
	functionality, leading to awkward workarounds or subclassing when a 
	better abstraction is needed.

* **Message Chains**: A sequence of method calls like 
	a.getB().getC().doSomething() creates tight coupling to navigation 
	paths and makes code brittle.

* **Middle Man**: A class that delegates most of its work to another class 
	adds little value and can often be removed to simplify the design.



## References

* [Martin Fowler: Catalog of refactorings](https://refactoring.com/catalog/)

* Martin Fowler. **Refactoring: Improving the Design of Existing Code**. Addison Wesley, 2. Edition, 2019

* [Refactoring GURU: Code Smells](https://refactoring.guru/refactoring/smells)

*Egon Teiniker, 2016-2025, GPL v3.0*