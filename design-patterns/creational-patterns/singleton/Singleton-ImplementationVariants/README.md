## Singleton Implementation Variants

Different Java features can be used to implement the Singleton pattern.
In this example, we will explore some of these variants.

_Example 0:_ INSTANCE Constant within an Interface
```java
public interface PersonFactory
{
    PersonFactory INSTANCE  = new PersonFactoryImpl();

    Person createPerson(int id, String firstName, String lastName, String mail);
}
```

In this minimal implementation of the Singleton pattern, the interface `PersonFactory` defines a constant `INSTANCE` that holds a reference 
to an instance of `PersonFactoryImpl`.


_Example 1:_ Classic Implementation (GoF book)
```java
public class Singleton
{
    private static Singleton instance;    

    private Singleton() {} 
    
    public static Singleton getInstance()
    {
        if(instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
    //...    
}
```

This is the classic implementation of the Singleton pattern as described 
in the Gang of Four (GoF) book. It uses a private static field to hold 
the instance and a public static method to provide access to it.


_Example 2:_ Singleton Sub-Classing
```java
public class Singleton
{
    private static Singleton instance;
    
    protected Singleton() {}
     
    public static Singleton getInstance()
    {
        if(instance == null)
        {
        	// create an instance of a subclass
            instance = new SingletonSubclass();
        }
        return instance;
    }
    // ...
}
```

```Java
public class SingletonSubclass
    extends Singleton
{    
    protected SingletonSubclass()
    {
        super();
    }
    
    public String getVersionNumber()
    {
        final String VERSION = "2.0.0";
        out.println("getVersion()");
        return VERSION;
    }   
}
```

This example illustrates how a subclass can **modify the behavior 
of an existing Singleton class** while maintaining compatibility 
with client code.


_Example 3:_ static final Field

```java
public class Singleton
{    
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance()
    {
        return INSTANCE;
    }
    // ...
}
```

Here, a private static final field is used to hold the reference to 
the Singleton instance.
The instance is created when the class is loaded, ensuring that it is
only created once and is thread-safe without requiring synchronization. 

_Example 3:_ Enum Implementation

```java
public enum Singleton
{
    INSTANCE;  // Ensure a unique instance
    
    public String getVersionNumber()
    {
        return "1.0.0";
    }
}
```

A `enum` can be used to specify a single instance of itself.

Note that a Java enum is very similar to a class and its elements are 
represented by instances of that type (see Effective Java, Second Edition 
- Item 3).

*Egon Teiniker, 2016-2025, GPL v3.0*