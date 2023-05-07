# Replace Constructor with Creation Method

Using the **new** operator together with the **constructor** implies some 
restrictions:
* Since the constructor always bears the name of the class, the instantiation 
  is always linked to the specific implementation class. The implementation 
  class can only be exchanged by changing the instantiation.
* Constructor overloading only works with different parameter lists.
* Constructors are part of the implementation class and are not inherited. 
  It is also not possible to define a constructor in an interface.

_Example: Complex number class_

```Java
public class ComplexNumber
{
    public ComplexNumber(double re, double im) 
    {
        setRe(re);
        setIm(im);
    }

    public ComplexNumber(double abs, double angle)  //!!!!! will not compile
    {
        setRe(abs*Math.cos(angle));
        setIm(abs*Math.sin(angle));
    }  
    //...
}
```

To work around some of these limitations, the following refactoring steps can 
be applied:
* We make the **constructor private** so that the new operator can no longer be used.
* We define one or more **static creation methods** in which the instantiation is 
  encapsulated and the created object is returned as a result.
* Since these creation methods have their own names, they can on the one hand communicate 
  the type of instantiation and on the other hand they can use the same parameter lists.
* The static creation methods can also instantiate a subtype of the class and return the 
  result without changing the method signature.

_Refactoring: Replace constructor with creation method_
```Java
public class ComplexNumber 
{
    private ComplexNumber(double re, double im) 
    {
        setRe(re);
        setIm(im);
    }
    
    public static ComplexNumber createFromCartesian(double re, double im) 
    {
        return new ComplexNumber(re, im);
    }

    public static ComplexNumber createFromPolar(double abs, double angle) 
    {
        return new ComplexNumber(abs * Math.cos(angle), abs * Math.sin(angle));
    }
    //...
}
```

In order to instantiate the given class `ComplexNumber` one has to use one of the 
static creation methods.

## References
* Kerievsky Joshua. **Refactoring to Patterns**. Addison-Wesley, 2004
  * Chapter 6. Creation


*Egon Teiniker, 2016-2023, GPL v3.0*