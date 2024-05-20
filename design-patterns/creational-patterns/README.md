# Creational Patterns

The **classic way of object instantiation** has some disadvantages:

* [**Overcome limitations of the class constructor**](ReplaceConstructorWithCreationMethod)


Creational patterns are design patterns that focus on the process of 
object creation. They **abstract the instantiation process** and help 
make a system independent of how its objects are created, composed, 
and represented. 

The main goal of creational patterns is to ensure that an application 
is flexible in terms of the types of objects it creates, how they are 
created, and how they are configured.

Overview of the key creational patterns described by the GoF:

* [**Singleton**](singleton/README.md): 
  This pattern ensures that a class has only one instance and provides a global 
  point of access to it. It is useful when exactly one object is needed to 
  coordinate actions across a system.

* [**Builder**](builder/README.md): 
  This pattern separates the construction of a complex object from its 
  representation, allowing the same construction process to create different
  representations. 
  It is particularly useful for creating objects with many optional parameters 
  or parts.

* [**Factory Method**](factory-method/README.md): 
  This pattern defines an interface for creating an object but lets subclasses 
  alter the type of objects that will be created. It encapsulates the object 
  creation process and delegates it to subclasses.

* [**Abstract Factory**](abstract-factory/README.md): 
  This pattern provides an interface for creating families of related or dependent 
  objects without specifying their concrete classes. It allows a system to use 
  multiple factories interchangeably, each producing objects of a different family.

* **Prototype**: 
  This pattern involves creating new objects by copying an existing object, 
  known as the prototype. It is used when the cost of creating a new instance 
  of a class is prohibitively expensive or complex.

Each of these creational patterns addresses a specific problem related to 
object creation, providing flexibility and control over the instantiation 
process. 

By using these patterns, developers can create systems that are easier to extend, 
modify, and maintain, ensuring that object creation is centralized and managed 
in a consistent manner.

## References
* [Introduction to Creational Design Patterns](https://www.baeldung.com/creational-design-patterns)

* E. Gamma, R. Helm, R. Johnson, J. Vlissides. **Design Patterns, Elements of Reusable Object-Oriented Software**. Addison-Wesley, 1995
  * Chapter 3: Creational Patterns 

* Joshua Kerievsky. **Refactoring to Patterns**. Addison-Wesley, 2005

*Egon Teiniker, 2016-2024, GPL v3.0*
