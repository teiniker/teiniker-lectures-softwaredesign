# Pattern Matching with switch Expression

Pattern Matching in Java 21 is a feature that enhances the expressiveness and readability
of code that involves **type checks** and **data extraction**.


_Example:_ Classic implementation 
```Java
public abstract class FileSystemVisitor
{
	public void visit(Node node)
	{
		if(node instanceof File)
		{
			File f = (File)node;
			visit(f);
		}
		else if(node instanceof Directory)
		{
			visit((Directory)node);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	
	public abstract void visit(File file);
	public abstract void visit(Directory dir);
}
```


_Example:_ Using pattern matching
```Java
public abstract class FileSystemVisitor
{
    public void visit(Node node)
    {
        switch (node)
        {
            case File f     -> visit(f);
            case Directory d-> visit(d);
            default         -> throw new IllegalArgumentException("Unknown node type");
        }
    }	
	public abstract void visit(File file);
	public abstract void visit(Directory dir);
}
```


## References

* [ORACLE: Pattern Matching for switch Expressions and Statements](https://docs.oracle.com/en/java/javase/21/language/pattern-matching-switch.html#GUID-E69EEA63-E204-41B4-AA7F-D58B26A3B232)
* [Baeldung: Pattern Matching for Switch](https://www.baeldung.com/java-switch-pattern-matching)


*Egon Teiniker, 2016-2025, GPL v3.0*
