# JUnit 4 Tutorial

JUnit Tests classes are annotated Java classes without special base classes.
Test cases are implemented as annotated methods.

## Annotations
Since JUnit4, Java annotations are used to mark test, setup and tear down methods.

* **@Before**: Annotating a public void method with @Before causes that method 
to be run before the Test method. 
The @Before methods of superclasses will be run before those of the current class, 
unless they are overridden in the current class. 
No other ordering is defined.

* **@BeforeClass**: Annotating a public static void no-arg method with @BeforeClass 
causes it to be run once before any of the test methods in the class. 
The @BeforeClass methods of superclasses will be run before those of the current 
class, unless they are shadowed in the current class.


* **@After**: If you allocate external resources in a Before method you need to 
release them after the test runs. Annotating a public void method with @After causes 
that method to be run after the Test method. 
All @After methods are guaranteed to run even if a Before or Test method throws an 
exception. 
The @After methods declared in superclasses will be run after those of the current 
class, unless they are overridden in the current class.

* **@AfterClass**: If you allocate expensive external resources in a BeforeClass 
method you need to release them after all the tests in the class have run. 
Annotating a public static void method with @AfterClass causes that method to be 
run after all the tests in the class have been run. 
All @AfterClass methods are guaranteed to run even if a BeforeClass method throws 
an exception. 
The @AfterClass methods declared in superclasses will be run after those of the 
current class, unless they are shadowed in the current class.


* **@Test**: The Test annotation tells JUnit that the public void method to 
which it is attached can be run as a test case. 
To run the method, JUnit first constructs a fresh instance of the class then 
invokes the annotated method. 
Any exceptions thrown by the test will be reported by JUnit as a failure. 
If no exceptions are thrown, the test is assumed to have succeeded.

  
* **@Test(expected = Exception.class)**: The optional annotation parameter **expected** declares 
that a test method should throw an exception.
If it doesn't throw an exception or if it throws a different exception than the one 
declared, the test fails.

* **@Test(timeout = 1000)**: The optional annotation parameter **timeout** causes 
a test to fail if it takes longer than a specified amount of clock time (measured in 
milliseconds).


* **@Ignore**: Sometimes you want to temporarily disable a test or a group of tests. 
Methods annotated with Test that are also annotated with @Ignore will not be executed 
as tests. 
Also, you can annotate a class containing test methods with @Ignore and none of the 
containing tests will be executed.


* **@RunWith(Suite.class)**: When a class is annotated with @RunWith or extends a class 
annotated with @RunWith, JUnit will invoke the class it references to run the tests 
in that class instead of the runner built into JUnit.
Suites in JUnit 4 are built using RunWith, and a custom runner named Suite

* **@Suite**: Using Suite as a runner allows you to manually build a suite containing 
tests from many classes. 


## Assert Methods
JUnit assert methods are helper methods which determine whether a method under test is 
performing correctly or not. 
They let us assert that some condition is true.  Only failed assertions are recorded.

* **Assert.assertTrue(boolean condition)**:
    Asserts that a condition is true.

* **Assert.assertFalse(boolean condition)**:
     Asserts that a condition is false.

* **Assert.fail(String message)**:
     Fails a test with the given message.
     
* **Assert.assertNull(Object object)**: 
      Asserts that an object is null.

* **Assert.assertNotNull(Object object)**:
    Asserts that an object isn't null.

* **Assert.assertEquals(Object expected, Object actual)**:
     Asserts that two objects are equal.

* **Assert.assertSame(Object expected, Object actual)**:
    Asserts that two objects refer to the same object. 

* **Assert.assertArrayEquals(Object[] exp, Object[] act)**:
    Asserts that two object arrays are equal.
    

## References

[JUnit4 JavaDoc](https://junit.org/junit4/javadoc/latest/index.html)


*Egon Teiniker, 2016-2023, GPL v3.0*