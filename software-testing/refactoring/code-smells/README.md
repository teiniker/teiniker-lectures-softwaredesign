# Code Smells 

Improving the design of existing code requires that we know what code 
needs improvement. It is therefore necessary to learn common design 
problems so we can recognize them in our code.

The most common design problems result from code that is:
**duplicated**, **unclear**, **complicated**.

> Code smells are examples which provide additional guidance 
> for identifying design problems.


* **Duplicated Code**: If we see the same code structure in more than 
    one place, we can be sure that your program will be better if we 
    find a way to unify them.
    * **Explicit duplication** exists in identical code.
    * **Subtle duplication** exists in structures or processing steps 
        that are outwardly different yet essentially the same.
    
    _Refactorings_: Extract Method, Extract Class, Pull Up Method, 
        Substitute Algorithm

* **Long Method**: The classes that live best and longest are 
    those with short methods. The longer a method is, the more difficult 
    it is to understand.
    
    A key point in handling small methods is **good naming**. If we 
    have a good name for a method we don’t need to look at the 
    implementation body.

    _Refactorings_: Extract Method, Replace Temp with Query, 
        Introduce Parameter Object, Preserve Whole Object, 
        Replace Method with Method Object, Decompose Conditional

* **Large Class**: When a class is trying to do too much, it often shows 
    up as too many instance variables. When a class has **too many instance 
    variables**, duplicated code can’t be far behind.
    
    A class with **too much code** is prime breeding ground for duplicated code 
    and chaos.

    _Refactorings_: Extract Class, Extract Subclass, Extract Interface,
    Duplicate Observed Data


* **Long Parameter List**: Long parameter lists are **hard to understand**, because 
    they become inconsistent and difficult to use. In object-oriented programs 
    we don’t pass in everything the method needs, instead we **pass enough** so 
    that the method can get to everything it needs.

    _Refactorings_: Replace Parameter with Method, Preserve Whole Object,
        Introduce Parameter Object  


* **Divergent Change**: We structure software to make change easier (software 
    is meant to be soft). 
    
    When we make a change, we want to be able to jump to a **single clear point** 
    in the system and make the change.
    
    Divergent change occurs when one class is commonly changed in different 
    ways for different reasons.

    _Refactorings_: Extract Class


* **Feature Envy**: A classic smell is a method that seems more interested in a 
    class other than the one it actually is in. This is a method  that invokes 
    half-a-dozen getting methods on another object to calculate some value. 
    Often a method uses features of several classes.
    
    A heuristic we can use is to **determine which class has most of the data** 
    and put the method with that data.

    _Refactorings_: Move Method, Extract Method
 

* **Data Clumps**: Often, we can see **the same three or four data items together** 
    in lots of places: fields in a couple of classes, parameters in many method signatures.
    
    Bunches of data that hang around together really should be **put into their own object**.

    Reducing field lists and parameter lists will certainly remove a few bad smells.

    _Refactorings_: Extract Class, Introduce Parameter Object, Preserve Whole Object


* **Primitive Obsession**: People new to objects usually are conservative to use 
    small objects for small tasks (e.g. money classes, ranges with an upper and a 
    lower bound, special strings like telephone numbers).

    _Refactorings_: Replace Data Value with Object, Replace Type Code with Class / Subclasses,
    Extract Class, Introduce Parameter Object, Replace Array with Object

* **Switch Statements**: The problem with switch statements is essentially that of 
    duplication. Often we can find **the same switch statement scattered about a program** 
    in different places. 
    
    The object-oriented notation of **polymorphism** gives us an elegant way to deal 
    with this problem. 

    _Refactorings_: Extract Method, Move Method, Replace Type Code with Subclasses,
    Replace Conditional with Polymorphism, Replace Parameter with Explicit Methods,
    Introduce Null Object
 

* **Lazy Class**: A class that isn’t doing enough to pay for itself should be eliminated.

    Often this might be a class that has been downsized with refactoring, or it might be 
    a class that was added because of changes that were planned but not made. 

    _Refactorings_: Collapse Hierarchy, Inline Class

* **Speculative Generality** We get this smell when people say, "Oh, I think we need 
    the ability to this kind of thing someday". Such Code often is harder to understand 
    and maintain.
    
    Speculative generality can be spotted when **the only users of a method or class 
    are test cases**. If we find such a method or class, we can **delete it**.

    _Refactorings_: Collapse Hierarchy, Inline Class, Remove Parameter, Rename Method


## References

* [Martin Fowler: Catalog of refactorings](https://refactoring.com/catalog/)

* Martin Fowler. **Refactoring: Improving the Design of Existing Code**. Addison Wesley, 2. Edition, 2019

*Egon Teiniker, 2016-2024, GPL v3.0*