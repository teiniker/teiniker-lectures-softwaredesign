package org.se.lab;

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
