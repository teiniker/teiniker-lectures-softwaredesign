# Factory Method: Implementation Variants

Since Java 8 we can use **new concepts in Java interfaces**.

## Static Creation Method 

Static methods can be defined within interfaces. In the provided 
`example1`, a static method in the interface is utilized to create 
objects of the "Person" class.

```Java
public interface PersonFactory
{
    static Person createPerson(int id, String firstName, String lastName, String mail)
    {
        Person p = new Person();
        p.setId(id);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setMail(mail);
        return p;
    }
}
```

Note that this is **not a real Factory Method pattern** since there 
is **no way to change the implementation of the Factory Method** 
by subclassing.


## Default implementations 

Default implementations for interface methods can also be provided. 
In the provided `example2`, a default method in the interface is
used to create objects of the "Person" class.

```Java
public interface PersonFactory
{
    default Person createPerson(int id, String firstName, String lastName, String mail)
    {
        Person p = new Person();
        p.setId(id);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setMail(mail);
        return p;
    }
}
```

These implementations are flexible, as they **can be overridden 
in the implementing classes of the interface**. This allows the 
Factory Method's behavior to be customized in specific implementations.


## Refereces

* [Baeldung: Java Interfaces](https://www.baeldung.com/java-interfaces)
* [The Java™ Tutorials: Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)

*Egon Teiniker, 2016-2025, GPL v3.0*