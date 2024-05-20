## JUnit4 Result Verification

In this example, different variants are shown how to verify result objects:

### Equals vs. Same

The most obvious way to compare objects would be to use the *assertEquals()* method. 
This only works in part because the equals() method of Objects usually does not include 
all the properties of an object in the comparison.

```java
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }
```

The comparison with *assertSame()* corresponds to the == operator and returns true only if both object references point to the same object.

```java
    @Test
    public void testSame()
    {
        User u1 = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        User u2 = u1;

    	// verify
        User expected = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        Assert.assertEquals(expected, u1);
        Assert.assertEquals(expected, u2);

        Assert.assertNotSame(expected,u2);
        Assert.assertSame(u1,u2);
    }
```


### Property Verification
Two objects are compared by comparing their properties individually.

```java
    @Test
    public void testEachAttribute()
    {
        User u = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");

        Assert.assertEquals(7, u.getId());
        Assert.assertEquals("homer", u.getUsername());
        Assert.assertEquals("Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=", u.getPassword());
    }        
```

This code is difficult to read, especially when the object structures are 
getting more complex.

If such comparisons occur in many tests, *redundant code* is created.


### Expected Objects and Custom Asserts

An alternative approach uses *Expected Objects* together with *Custom Asserts*. 
First, reference objects are created, which are then compared with actual objects 
using custom asserts.

```java
    @Test
    public void testEachAttribute()
    {
        User u = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");

        // verify
        User expected = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        CustomAssert.assertEquals(expected, u);
    }
```
Remember, custom asserts are homemade assert methods that can compare whole 
objects with each other.

```java
    public static void assertEquals(User u1, User u2)
    {
        Assert.assertNotNull(u1);
        Assert.assertNotNull(u2);
        Assert.assertEquals(u1.getId(), u2.getId());
        Assert.assertEquals(u1.getUsername(), u2.getUsername());
        Assert.assertEquals(u1.getPassword(), u2.getPassword());
    }
```

Because these custom assert methods are implemented in one place, they 
prevent redundant code.


### Fluent Interface via Builder

The creation of expected objects can be done either in a *creation method* 
or with the help of the *builder pattern*.
The builder pattern allows the implementation of a *fluent interface* with 
which expected objects can be constructed step by step.

```java
    @Test
    public void testExpectedObject()
    {
        User u = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        
        // verify
        User expected = new UserBuilder()
            .id(7)
            .username("homer")
            .password("Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=")
            .build();
    
        CustomAssert.assertEquals(expected, u);
    }
```

The builder pattern allows the implementation of a *fluent interface* with 
which expected objects can be constructed step by step.
In addition, the builder pattern allows the definition of *default values* 
that can be overridden if necessary.

*Egon Teiniker, 2016-2023, GPL v3.0*