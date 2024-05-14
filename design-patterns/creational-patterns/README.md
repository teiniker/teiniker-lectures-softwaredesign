# Creational Patterns

Here's an example showing the **limitations of the class constructor**:
* [ReplaceConstructorWithCreationMethod](ReplaceConstructorWithCreationMethod)

Creational design patterns **abstract the instantiation process**.
They help make a system independent of how its objects are created, composed, 
and represented.

Creational patterns help to **separate business logic from creational logic**,
therefore, they **reduce the number of dependencies between classes**.

* Singleton
    * [Logger](singleton/Singleton-Logger)
    * [Implementation Variants](singleton/Singleton-ImplementationVariants)
    * _Exercise_: [Registry](singleton/Singleton-Registry-Exercise) - ([Model solution](singleton/Singleton-Registry))

* Builder 
    * [StringBuilder](builder/Builder-StringBuilder)
    * [BookReference](builder/Builder-BookReference)
    * _Exercise_: [ListBuilder](builder/Builder-ListBuilder-Exercise) - ([Model solution](builder/Builder-ListBuilder))
    * _Exercise_: [URLBuilder](builder/Builder-URLBuilder-Exercise) - ([Model solution](builder/Builder-URLBuilder))
    
* Factory Method
    * [FactoryMethod-ListFactory](factory-method/FactoryMethod-ListFactory)
    * [FactoryMethod-ImplementationVariants](factory-method/FactoryMethod-ImplementationVariants)
    * _Exercise_: [TableFactory](factory-method/FactoryMethod-TableFactory-Exercise) - ([Model solution](factory-method/FactoryMethod-TableFactory)) 
    
* Abstract Factory
    * [TableFamily](abstract-factory/AbstractFactory-TableFamily)
    * _Exercise_: [SerializerFamily](abstract-factory/AbstractFactory-SerializerFamily-Exercise) - ([Model solution](AbstractFactory-SerializerFamily))

The following examples combine the usage of **several creational patterns**:

* _Exercise_: [IOFactory](../../patterns-in-practice/CreationalPatterns-IOFactory-Exercise) - ([Model solution](../../patterns-in-practice/CreationalPatterns-IOFactory))



## References
* [Introduction to Creational Design Patterns](https://www.baeldung.com/creational-design-patterns)
* E. Gamma, R. Helm, R. Johnson, J. Vlissides. **Design Patterns, Elements of Reusable Object-Oriented Software**. Addison-Wesley, 1995
  * Chapter 3: Creational Patterns 
* Joshua Kerievsky. **Refactoring to Patterns**. Addison-Wesley, 2005

*Egon Teiniker, 2016-2024, GPL v3.0*
