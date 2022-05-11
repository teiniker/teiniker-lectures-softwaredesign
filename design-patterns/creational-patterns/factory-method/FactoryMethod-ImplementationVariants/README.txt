Factory Method: Implementation Variants
-------------------------------------------------------------------------------

Since Java 8 we can use new concepts in Java interfaces.

Example 1: Static creation method 
---------------------------------
We can implement static methods within interfaces. In the given
example we use a static interface method to create instances of the class
"Person".

Note that ths is not a Factory Method pattern since there is no way to change
the implementation of the Factory Method by subclassing.


Example 2: Default implementations 
----------------------------------
We can also provide default implementations for interface methods.
Because default implementations can be overridden, we can change the
implementation of the Factory Method in one of the interface's implementation
classes.
