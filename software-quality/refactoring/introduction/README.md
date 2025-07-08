# Refactoring

> Refactoring refers to the process of restructuring existing computer code 
> without changing its external behavior.

Its goal is to improve the nonfunctional attributes of the software:
* **Code Readability**: Making the code easier to read and understand.
* **Maintainability**: Simplifying the structure of the code to make future modifications easier.
* **Reusability**: Making code components more reusable by other parts of 
  the application or different projects.


## Refactoring Techniques

Many refactoring operations are known in practice and can be carried out 
with the **support of IDEs**.


### Composing Methods
Excessively long methods are the root of all evil. The vagaries of code inside 
these methods conceal the execution logic and make the method extremely hard 
to understand, and even harder to change.

The refactoring techniques in this group streamline methods, remove code 
duplication, and pave the way for future improvements.

*	**Extract Method**: Move a fragment of code into its own method and replace the original 
	code with a call to that method to improve readability and reuse.

* **Inline Method**: Replace a method call with the method’s body when the method’s name 
	no longer adds clarity.

* **Extract Variable**: Introduce a temporary variable to hold the result of a complex 
	expression to make the code easier to understand.

*	**Inline Temp**: Replace a temporary variable with the expression it stores when the 
	variable adds no clarity.

*	**Replace Temp with Query**: Replace a temporary variable that holds the result of a simple 
	expression with a method call so the expression’s logic is always up-to-date.

* **Split Temporary Variable**: When a variable is assigned more than once for different 
	purposes, split it into multiple variables to clarify its roles.

*	**Remove Assignments to Parameters**: Avoid reassigning method parameters by using local 
	variables instead, to prevent side effects and improve clarity.

* **Replace Method with Method Object**: Turn a long method into a separate class where local 
	variables become fields, enabling more decomposition and reuse.

*	**Substitute Algorithm**: Replace a complex or unclear algorithm with a simpler, clearer 
	one that produces the same result.


### Moving Features between Objects
These refactoring techniques show how to safely move functionality between classes, 
create new classes, and hide implementation details from public access.

*	**Move Method**: Move a method to the class where it is more relevant or where most 
	of the data it uses resides.

*	**Move Field**: Move a field to the class that uses or owns it more, to reduce coupling 
	and improve cohesion.

*	**Extract Class**: Create a new class and move related fields and methods into it when 
	one class is doing too much.

*	**Inline Class**: Move all features of a class into another class and delete the 
	original when the former no longer justifies its existence.

*	**Hide Delegate**: Add methods to a class to hide the fact that it delegates behavior 
	to another class, reducing coupling.

*	**Remove Middle Man**: Eliminate unnecessary delegation methods and let clients call 
	the target class directly when the delegating class adds no value.

*	**Introduce Foreign Method**: Add a method to a client class that operates on another 
	class’s instance when you can’t modify that other class.

*	**Introduce Local Extension**: Create a subclass or wrapper to add methods to a class 
	that you can’t modify directly, making needed functionality available.


### Organizing Data

These refactoring techniques help with data handling, replacing primitives with 
rich class functionality. Another important result is untangling of class 
associations, which makes classes more portable and reusable.

* **Change Value to Reference**: Convert a value object to a reference object when 
	multiple users should share and modify the same instance.

* **Change Reference to Value**: Convert a reference object to a value object when 
	shared references are no longer needed and independent copies are preferable.

* **Duplicate Observed Data**: Keep a local copy of data in a GUI object that mirrors 
	a domain object’s state to allow independent editing before committing changes.

* **Self Encapsulate Field**: Use getter and setter methods even within the class 
	itself to access a field, preparing for future enhancements or constraints.

* **Replace Data Value with Object**: Replace a simple data item with an object to 
	group related behavior and data together.

* **Replace Array with Object**: Replace an array with a class that has named fields 
	to clarify the meaning of array elements and allow for richer behavior.

* **Change Unidirectional Association to Bidirectional**: Add a back-reference in a 
	one-way association when two objects need to communicate with each other.

* **Change Bidirectional Association to Unidirectional**: Remove one direction of an 
	association when only one object needs to know about the other, simplifying the 
	design.

* **Encapsulate Field**: Replace direct access to a field with getter and setter 
	methods to control and protect how the field is accessed or modified.

* **Encapsulate Collection**: Provide methods to modify a collection rather than 
	exposing it directly, allowing better control and encapsulation.

* **Replace Magic Number with Symbolic Constant**: Replace a hard-coded number with 
	a named constant to give it meaning and make the code easier to understand and 
	maintain.

* **Replace Type Code with Class**: Replace a numeric or string type code with a 
	class when the code has behavior or needs to be more robust.

* **Replace Type Code with Subclasses**: Replace a type code with subclasses when 
	different values imply different behavior.

* **Replace Type Code with State/Strategy**: Replace a type code with state or 
	strategy objects when behavior associated with the code changes at runtime.

* **Replace Subclass with Fields**: Replace subclasses with fields when the variation 
	between them can be represented as data rather than behavior.


### Simplifying Conditional Expressions

Conditionals tend to get more and more complicated in their logic over time, 
and there are yet more techniques to combat this as well.

* **Consolidate Conditional Expression**: Combine multiple conditional checks that lead 
	to the same result into a single expression to simplify and clarify logic.

* **Consolidate Duplicate Conditional Fragments**: Move repeated code in all branches 
	of a conditional outside the conditional to reduce duplication.

* **Decompose Conditional**: Extract conditionals and their branches into separate methods 
	to make complex decision logic more readable and testable.

* **Replace Conditional with Polymorphism**: Use polymorphism to handle variant behavior 
	instead of using conditionals that check object types or states.

* **Remove Control Flag**: Eliminate control flags used to manage flow by using break, 
	return, or continue instead, to make the logic clearer.

* **Replace Nested Conditional with Guard Clauses**: Use guard clauses for handling 
	exceptional or boundary conditions early, reducing nesting and improving clarity.

* **Introduce Null Object**: Replace null values with an object that exhibits default 
	benign behavior to eliminate null checks.

* **Introduce Assertion**: Add assertions to document and enforce assumptions in the 
	code that must always be true at certain points.


### Simplifying Method Calls

These techniques make method calls simpler and easier to understand. This, in turn, 
simplifies the interfaces for interaction between classes.

* **Add Parameter**: Add a new parameter to a method to provide additional input 
	needed for its logic.

* **Remove Parameter**: Eliminate a parameter from a method when it is no longer 
	used or necessary.

* **Rename Method**: Change the name of a method to better reflect its purpose and 
	improve readability.

* **Separate Query from Modifier**: Split a method that both returns information and 
	changes state into two methods—one for querying and one for modifying—to clarify 
	intent.

* **Parameterize Method**: Replace similar methods that perform nearly identical actions 
	with one method that takes a parameter to specify the variation.

* **Introduce Parameter Object**: Replace a group of related parameters with a single 
	object to simplify method signatures and reveal structure.

* **Preserve Whole Object**: Pass an entire object to a method instead of individual values 
	that can be obtained from that object, maintaining cohesion and reducing duplication.

* **Remove Setting Method**: Make a field immutable by removing its setter method when 
	its value should not change after initialization.

* **Replace Parameter with Explicit Methods**: Replace a method that uses a parameter to 
	determine behavior with multiple methods for each behavior to clarify intent.

* **Replace Parameter with Method Call**: Remove a parameter that can be derived from 
	other accessible data and replace it with a direct method call.

* **Hide Method**: Make a method private (or less visible) when it’s only used internally 
	to reduce the class’s public interface.

* **Replace Constructor with Factory Method**: Replace direct object construction with 
	a factory method to better control and abstract the instantiation process.

* **Replace Error Code with Exception**: Throw an exception instead of returning an 
	error code to clearly separate normal flow from error handling.

* **Replace Exception with Test**: Use a conditional test to avoid throwing an 
	exception in expected situations, reserving exceptions for truly exceptional 
	cases.


### Dealing with Generalization

Abstraction has its own group of refactoring techniques, primarily associated with moving 
functionality along the class inheritance hierarchy, creating new classes and interfaces, 
and replacing inheritance with delegation and vice versa.

* **Pull Up Field**: Move a field from subclasses to the superclass when it is duplicated 
	across them to eliminate redundancy.

* **Pull Up Method**: Move a common method from multiple subclasses to the superclass when 
	they share identical or similar behavior.

* **Pull Up Constructor Body**: Move duplicate code from subclass constructors into the 
	superclass constructor to centralize initialization logic.

* **Push Down Field**: Move a field from a superclass to the subclasses that actually 
	use it when it is not relevant to the superclass.

* **Push Down Method**: Move a method from the superclass to the appropriate subclass(es) 
	when it only applies to those subclasses.

* **Extract Subclass**: Create a new subclass and move specific behavior or fields from 
	the parent class to model specialization.

* **Extract Superclass**: Create a new superclass and move shared behavior and data from 
	two or more classes into it to generalize common features.

* **Extract Interface**: Define an interface that declares a common set of methods used 
	by multiple classes to decouple usage from implementation.

* **Collapse Hierarchy**: Merge a subclass and superclass when inheritance is no longer 
	needed and the distinction adds unnecessary complexity.

* **Form Template Method**: Move identical code from subclasses into a superclass and 
	replace varying parts with abstract methods to define a consistent algorithm 
	structure.

* **Replace Inheritance with Delegation**: Remove an inheritance relationship and use 
	delegation instead when subclassing is inappropriate or leads to tight coupling.

* **Replace Delegation with Inheritance**: Use inheritance instead of delegation when 
	the subclass can naturally reuse and extend the behavior of the superclass.



## References

* [Martin Fowler: Catalog of refactorings](https://refactoring.com/catalog/)
* Martin Fowler. **Refactoring: Improving the Design of Existing Code**. Addison Wesley, 2. Edition, 2019
* [Refactoring Guru: Refactoring](https://refactoring.guru/refactoring)

*Egon Teiniker, 2016-2025, GPL v3.0*


