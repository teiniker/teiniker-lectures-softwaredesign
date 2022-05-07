Singleton Implementation Variants
-------------------------------------------------------------------------------

Example 1: Classic Implementation
---------------------------------
The example uses the classic implementation described in the GoF book.


Example 2: Sub-Classing
-----------------------
This example demonstrates how a sub-class can be used to change the implementation
of an existing Singleton class - without breaking the client code.


Example 3: Singleton Registry
-----------------------------
The given example demonstrates how different Singleton sub-classes can be
organized by a registry to configure a particular Singleton implementation.


Example 4: static final Field
-----------------------------
Here, a private static final field is used to hold the reference to the Singleton
instance.


Example 5: Enum
---------------
A enum can be used to specify a single instance of itself.
Note that a Java enum is very similar to a class and its elements are represented
by instances of that type.