Internal Iterator
-------------------------------------------------------------------------------
The iterator controls the iteration. The client hands an internal iterator an 
operation to perform, and the iterator applies that operation to every element 
in the aggregate.


Java 8 Streams
-------------------------------------------------------------------------------

A stream represents a sequence of elements and supports different kind of 
operations to perform computations upon those elements

Stream operations are either intermediate or terminal:
 
	- Intermediate operations return a stream so we can chain multiple 
	  intermediate operations without using semicolons. 
	  Example: map()
	  
	- Terminal operations are either void or return a non-stream result. 
	  Example: collect()


Stream API
-------------------------------------------------------------------------------

<R> Stream<R> map(Function<? super T, ? extends R> mapper);
	Returns a stream consisting of the results of applying the given function 
	to the elements of this stream.
	
	@FunctionalInterface
	public interface Function<T, R> {
	    R apply(T t);
	}	
	

Stream<T> filter(Predicate<? super T> predicate);
	Returns a stream consisting of the elements of this stream that match
    the given predicate.	
    
    @FunctionalInterface
	public interface Predicate<T> {
	    boolean test(T t);
	}
	

<R, A> R collect(Collector<? super T, A, R> collector);
	Performs a reduction operation on the elements of this stream using a
    Collector. A Collector encapsulates the functions used as arguments to
    collect, allowing for reuse of collection strategies and composition 
    of collect operations such as multiple-level grouping or partitioning.	
	
	
	