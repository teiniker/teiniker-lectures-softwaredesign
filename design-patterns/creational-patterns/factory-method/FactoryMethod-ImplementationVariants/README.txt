Factory Method: Implementation Variants
-------------------------------------------------------------------------------

Example 1: Minimal Singleton (Interface)
----------------------------------------
We can implement a minimal Singleton as a constant field in the giben Interface.

    PersonFactory INSTANCE  = new PersonFactoryImpl();

The constant field INSTANCE is pointing to a single instance of the class
"PersonFactoryImpl".


Example 2: Static creation method (Interface)
---------------------------------------------
Since Java 8 we can implement static methods within interfaces. In the given
example we use a static interface method to create instances of the class
"Person".

Note that ths is not a Factory Method pattern since there is no way to change
the implementation of the Factory Method by subclassing.


Example 3: Java 8 Interface Features
------------------------------------
In Java 8 we can also provide default implementations for interface methods.
Because default implementations can be overridden, we can change the
implementation of the Factory Method in one of the interface's implementation
classes.