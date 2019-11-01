Java 8 Interfaces
-------------------------------------------------------------------------------

Traditionally, a Java interface groups related methods together into a contract.
Any class that implements an interface must provide an implementation for each
method defined by the interface or inherit the implementation from a superclass.

But this causes a problem when library designers need to update an interface to
add new methods...

Interfaces in Java 8 can now declare methods with implementation code:
	- Java 8 allows static methods inside interfaces
	- Java 8 introduces a new feature called default methods that allows us to
		provide a default implementation for methods in an interface.
		
Impacts on Design Patterns

o) Move creational methods into the interface (static create methods)

o) Factory Method: Provide default implementations for factory methods within interfaces.

o) Abstract Factory: Interface mit default Product-Family
 
o) Composite: Abstract Base Class könnte als Interface ausgeführt werden.



Nested Classes in Interfaces (schon vor Java 8 möglich)
-------------------------------------------------------------------------------

o) Proxy: siehe Collections Class

o) Decorator: Abstract Base Class im Interface implementiert.

