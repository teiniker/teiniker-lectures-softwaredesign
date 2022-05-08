Internal Iterator
-------------------------------------------------------------------------------
The iterator controls the iteration. The client hands an internal iterator an 
operation to perform, and the iterator applies that operation to every element 
in the aggregate.


Java 8 Lambda Expressions
-------------------------------------------------------------------------------

We can think of lambda expressions as anonymous functions, basically methods 
without declared names, but which can also be passed as arguments to a method
(as we can with an anonymous class).

A lambda expression doesn't have a name, but it has a list of parameters, a
body, a return type, and also possibly a list of exceptions that can be thrown.

Example: (parameters) -> body

	(a,b) -> b-a;
	
	
Example: (parameters) -> { statements; }
	
	(a,b) -> {
		if(a < b)
			return 1;
		else if(a > b)
			return -1;
		else
			return 0;
	};

Lambdas technically don't let you do anything that we couldn't do prior Java 8.
But we no longer have to write clumsy code using anonymous classes to benefit
from behavioral parameterization.

Example: Anonymous class

		Comparator<Integer> c = new Comparator<Integer>()
        {
		    public int compare(Integer a, Integer b)
		    {
		        return a-b;
		    }
        };


Functional Interfaces
-------------------------------------------------------------------------------        
We can use a lambda expression in the context of a functional interface.

A functional interface is an interface that specifies exactly one abstract method.

Examples in the Java API: Comparator<T>, Runnable 

	@FunctionalInterface
	public interface Comparator<T> {
	   int compare(T o1, T o2);
	}

	@FunctionalInterface
	public interface Runnable {
	    public abstract void run();
	}
      
Note that interfaces can have default methods (that is a method with a body that 
provides some default implementation for a method in case it isn't implemented by 
a class).

The @FunctionalInterface annotation is used to indicate that the interface is
intended to be a functional interface. Note that the @FunctionalInterface annotation
is not mandatory, but it is good practice to use it when an interface is designed
for that purpose.
        
An interface is still a functional interface if it has many default methods as long 
as it specifies only one abstract method.        

Lambda expressions let you provide the implementation of the abstract method of a
functional interface directly inline and treat the whole expression as an instance
of a functional interface (exactly: an instance of a concrete implementation of the
functional interface).

The signature of the abstract method of the functional interface essentially 
describes the signature of the lambda expression. We call this abstract method a 
function description.

A lambda expression can be assigned to a variable or passed to a method expecting
a functional interface as argument, provided the lambda expression has the same 
signature as the abstract method of the functional interface.
