# JUnit 5 Tutorial

JUnit Tests classes are annotated Java classes without special base classes.
Test cases are implemented as annotated methods.

## Annotations
JUnit 5 introduces several annotations to facilitate testing. These annotations 
help in setting up and tearing down tests, specifying test methods, handling 
exceptions, and more. 

Here are some of the most common annotations used in JUnit 5:

* **@Test**: Marks a method as a test method.

* **@BeforeAll**: Indicates that the annotated method should be executed once before 
all `@Test` methods in the current class. The method must be static.

* **@BeforeEach**: Indicates that the annotated method should be executed before 
each `@Test` method in the current class.

* **@AfterEach**: Indicates that the annotated method should be executed after each 
`@Test` method in the current class.

* **@AfterAll**:  Indicates that the annotated method should be executed once after 
all `@Test` methods in the current class. The method must be static.

* **@Ignore("Some test")**: Disables the annotated test method or test class. 
It will not be executed. 

* **@Timeout(t)**: Specifies that the annotated test method must complete within 
the given time period (`t` seconds); otherwise, it will fail.

* **@RepeatedTest(n)**: Marks a method to be executed repeatedly (`n` times) with 
the specified number of repetitions.


## Assert Methods
JUnit 5 provides a variety of assertions to validate the behavior and state of 
the code being tested. These assertions help verify that the code produces the 
expected results. 

Here are some of the most common assert statements used in JUnit 5:

* **Assertions.assertTrue(boolean condition)**:
    Asserts that a condition is true.

* **Assertions.assertFalse(boolean condition)**:
     Asserts that a condition is false.

* **Assertions.fail(String message)**:
     Fails a test with the given message.
     
* **Assertions.assertNull(Object object)**: 
      Asserts that an object is null.

* **Assertions.assertNotNull(Object object)**:
    Asserts that an object isn't null.

* **Assertions.assertEquals(Object expected, Object actual)**:
     Asserts that two objects are equal.

* **Assertions.assertSame(Object expected, Object actual)**:
    Asserts that two objects refer to the same object. 

* **Assertions.assertArrayEquals(Object[] expected, Object[] actual)**:
    Asserts that two object arrays are equal.
    
* **Assertions.assertThrows(Class<T> expectedType, Executable executable)**:
Asserts that an executable throws a specified exception.
    
    _Example:_ 
    ```Java
    assertThrows(IllegalArgumentException.class, () -> {
        throw new IllegalArgumentException("Invalid argument");
    });
    ```

* **Assertions.assertTimeout(Duration timeout, Executable executable)**:
  Asserts that a piece of code executes within a given timeout.

  _Example:_
    ```Java
    assertTimeout(Duration.ofMillis(100), () -> {
    // Code that should complete within 100 milliseconds
    }); 
    ```

* **Assertions.assertAll(String heading, Executable... executables)**:
  Groups multiple assertions, allowing them to be executed and reported together.
  When using separate assert statements, the test stops at the first failure. 

  _Example:_
    ```Java
    assertAll("Person",
        () -> assertEquals("John", person.getFirstName()),
        () -> assertEquals("Doe", person.getLastName())
    );  
    ```

  Note that `assertAll()` continues to execute all assertions and reports 
  all failures at once.

## References

* [Baeldung: A Guide to JUnit 5](https://www.baeldung.com/junit-5)

* [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
* [JUnit5 JavaDoc](https://junit.org/junit5/docs/5.10.1/api/index.html)


*Egon Teiniker, 2016-2024, GPL v3.0*