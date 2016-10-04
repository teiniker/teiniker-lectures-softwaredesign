package org.se.lab;

/**
 * Replace Constructors with CreationMethods
 * 
 * Replace the constructors with intension-revealing creation methods
 * that return object instances.
 * 
 * One advantage of static creation methods is that, unlike constructors, 
 * they have names.
 * 
 * A second advantage of static creation methods is that, unlike constructors,
 * they are not required to create a new object each time they are invoked.
 * 
 * A third advantage of static creation methods is that, unlike constructors, 
 * they can return an object of any sub-type of their return type.
 */

public class ComplexNumber
{
    /* 
     * Constructor (private)
     */  
    private ComplexNumber(double re, double im)
    {
        setRe(re);
        setIm(im);
    }
    
    
    /*
     * Creation methods
     */
    public static ComplexNumber createFromCartesian(double re, double im)
    {
        return new ComplexNumber(re, im);
    }
    
    public static ComplexNumber createFromPolar(double abs, double angle)
    {
        return new ComplexNumber(abs*Math.cos(angle), 
        		abs*Math.sin(angle));
    }

    
    
    /** Getters and Setters */
    
    
    /*
     * Property: im:double
     */
    private double im;    
    public final double getIm()
    {
        return im;
    }
    protected final void setIm(final double im)
    {
        this.im = im;
    }

    
    /*
     * Property: re:double
     */
    private double re;
    public final double getRe()
    {
        return re;
    }
    protected final void setRe(final double re)
    {
        this.re = re;
    }
    

    
    /*
     * Calculation methods 
     */
    
    public void add(ComplexNumber z)
    {
        this.re += z.getRe();
        this.im += z.getIm();
    }
    
    // ...
    
    public String toString()
    {
        return getRe() + "+ " + getIm() + "i";
    }
}
