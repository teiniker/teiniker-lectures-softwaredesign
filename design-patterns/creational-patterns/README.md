# Creational Patterns

Creational design patterns **abstract the instantiation process**.
They help make a system independent of how its objects are created, composed, 
and represented.

Creational patterns also help to **separate business logic and creational logic**.
Which reduces the number of dependencies between classes.

* **Singleton**
    * _Demo_: [Logger](singleton/Singleton-Logger)
    * _Demo_: [Implementation Variants](singleton/Singleton-ImplementationVariants)
    * _Exercise_: [Registry](singleton/Singleton-Registry-Exercise) - ([Model solution](singleton/Singleton-Registry))

* **Builder** 
    * _Demo_: [StringBuilder](builder/Builder-StringBuilder)
    * _Demo_: [BookReference](builder/Builder-BookReference)
    * _Exercise_: [ListBuilder](builder/Builder-ListBuilder-Exercise) - ([Model solution](builder/Builder-ListBuilder))
    * _Exercise_: [URLBuilder](builder/Builder-URLBuilder-Exercise) - ([Model solution](builder/Builder-URLBuilder))
    
* **Factory Method**
    * _Demo_: [FactoryMethod-ListFactory](factory-method/FactoryMethod-ListFactory)
    * _Demo_: [FactoryMethod-ImplementationVariants](factory-method/FactoryMethod-ImplementationVariants)
    * _Exercise_: [TableFactory](factory-method/FactoryMethod-TableFactory-Exercise) - ([Model solution](factory-method/FactoryMethod-TableFactory)) 
    * _Exercise_: [IOFactory](factory-method/CreationalPatterns-IOFactory-Exercise) - ([Model solution](factory-method/CreationalPatterns-IOFactory))
    
* **Abstract Factory**
    * _Demo_: [TableFamily](abstract-factory/AbstractFactory-TableFamily))
    * _Exercise_: [SerializerFamily](abstract-factory/AbstractFactory-SerializerFamily-Exercise) - ([Model solution](AbstractFactory-SerializerFamily))

## References
* E. Gamma, R. Helm, R. Johnson, J. Vlissides. **Design Patterns, Elements of Reusable Object-Oriented Software**. Addison-Wesley, 1995
* Joshua Kerievsky. **Refactoring to Patterns**. Addison-Wesley, 2005


*Egon Teiniker, 2016-2022, GPL v3.0*
