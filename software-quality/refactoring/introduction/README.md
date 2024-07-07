# Introduction to Refactoring

> Refactoring refers to the process of restructuring existing computer code 
> without changing its external behavior.

Its goal is to improve the nonfunctional attributes of the software:
* **Code Readability**: Making the code easier to read and understand.
* **Maintainability**: Simplifying the structure of the code to make future modifications easier.
* **Reusability**: Making code components more reusable by other parts of 
  the application or different projects.

## Common Refactoring Techniques

Many refactoring operations are known in practice and can be carried out 
with the **support of IDEs**.
The following list is an introduction and by no means complete.

Focus on methods:

* **Rename Method**: Changes the name of a method to better reflect its 
  purpose, improving code readability and understanding. This involves 
  updating the method name in its definition and all references throughout 
  the codebase.

* **Move Method**: Relocates a method from one class to another class where
  it is more relevant, enhancing cohesion and reducing coupling. This involves identifying the method's dependencies and moving it to the class that uses 
  or owns those dependencies. 

* **Extract Method**: Breaks down a complex method into smaller, more 
  manageable methods to improve readability and reuse. This involves 
  moving a segment of code into a new method and replacing the original 
  code with a call to the new method.

* **Pull Up Method**: Moves a method that is common to multiple subclasses 
  to a common superclass to reduce code duplication. This involves 
  identifying the common method in subclasses and relocating it to the 
  superclass.

* **Remove Parameter**: Eliminates an unused or redundant parameter from 
  a method to simplify the method signature. This involves updating the 
  method definition and all calls to this method to no longer include 
  the parameter.

* **Decompose Conditional**: Simplifies complex conditional statements by 
  breaking them into separate methods or using clearer logic structures. 
  This involves extracting each condition and the corresponding action 
  into distinct methods or using polymorphism to handle different cases.


Focus on objects: 

* **Introduce Null Object**: Replaces null values with an object representing 
  a neutral or default behavior to simplify code and avoid null checks. 
  This involves creating a new class that implements the expected interface 
  or superclass with default behavior.

* **Introduce Parameter Object**: Combines multiple parameters that are 
  frequently passed together into a single parameter object to simplify 
  method signatures. This involves creating a new class to encapsulate 
  the parameters and using this class in method signatures.

* **Replace Data Value with Object**: Converts a primitive data value into 
  an object to provide additional behavior and improve code clarity. 
  This involves creating a new class to encapsulate the data value and 
  provide related methods.

* **Replace Method with Method Object**: Converts a complex method into 
  its own object to allow for more flexible handling and decomposition 
  of logic. This involves creating a new class where the method becomes 
  an instance method, enabling the breaking down of the method's logic 
  into smaller methods within the class.

Focus on classes:

* **Extract Subclass**: Creates a new subclass to encapsulate behavior 
  and properties that are only relevant to certain instances, thereby 
  simplifying the original class. This involves moving specific fields 
  and methods from the original class to the new subclass.

* **Extract Interface**: Defines a new interface to outline common behavior 
  across different classes, enhancing flexibility and promoting polymorphism. 
  This involves creating an interface with method signatures and having 
  the relevant classes implement this interface.

* **Replace Type Code with Subclasses**: Eliminates type codes by creating
  subclasses for each type, enhancing code clarity and enabling polymorphism. 
  This involves replacing conditional logic based on the type code with 
  subclasses that each implement specific behavior.

* **Replace Conditional with Polymorphism**: Replaces complex conditional
  statements with polymorphic methods to simplify code and improve 
  maintainability. This involves creating a class hierarchy where each 
  subclass implements the behavior specific to a particular condition.

* **Collapse Hierarchy**: Merges a subclass into its parent class when 
  the subclass does not provide enough unique functionality, simplifying 
  the class hierarchy. This involves moving all members of the subclass 
  to the parent class and removing the subclass.

* **Inline Class**: Merges a class into another class when it is no longer 
  useful on its own, reducing unnecessary complexity. This involves moving 
  the features of the class into another class and then deleting the original 
  class.


## References

* [Martin Fowler: Catalog of refactorings](https://refactoring.com/catalog/)
* Martin Fowler. **Refactoring: Improving the Design of Existing Code**. Addison Wesley, 2. Edition, 2019

*Egon Teiniker, 2016-2024, GPL v3.0*


