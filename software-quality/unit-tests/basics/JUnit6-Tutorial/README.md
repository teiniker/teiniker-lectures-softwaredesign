# JUnit 6 Tutorial

JUnit Tests classes are annotated Java classes without special base classes.
Test cases are implemented as annotated methods.

JUnit 6 (released September 2025) is the current major version of JUnit Jupiter.
Key changes over JUnit 5: **Java 17 baseline**, a single unified version number
for Platform/Jupiter/Vintage, JSpecify nullability annotations, and removal of
all previously deprecated APIs.

## Annotations

JUnit 6 uses Java annotations to mark test, setup, and tear-down methods.
The table below maps the equivalent JUnit 4 annotations to their JUnit 6 counterparts.

| JUnit 4 | JUnit 6 | Description |
|---------|---------|-------------|
| `@Before` | `@BeforeEach` | Run before each test method |
| `@After` | `@AfterEach` | Run after each test method |
| `@BeforeClass` | `@BeforeAll` | Run once before all tests in the class (must be `static`) |
| `@AfterClass` | `@AfterAll` | Run once after all tests in the class (must be `static`) |
| `@Test` | `@Test` | Marks a method as a test case |
| `@Ignore` | `@Disabled` | Disables a test method or class |
| `@Test(expected=…)` | `assertThrows(…)` | Verifies that an exception is thrown |
| `@Test(timeout=…)` | `@Timeout(…)` | Fails the test if it exceeds the given time |
| `@RunWith(Suite.class)` | `@Suite` | Runs a collection of test classes |
| `@Suite.SuiteClasses` | `@SelectClasses` | Specifies which classes belong to the suite |

### @BeforeEach / @AfterEach

Annotating a method with `@BeforeEach` causes it to be run before each `@Test` method.
Annotating a method with `@AfterEach` causes it to be run after each `@Test` method —
even if the test or setup throws an exception.

### @BeforeAll / @AfterAll

Annotating a `static` method with `@BeforeAll` causes it to run once before any test
method in the class.
Annotating a `static` method with `@AfterAll` causes it to run once after all test
methods in the class have finished.

### @Test

Marks a `void` method as a test case. JUnit creates a fresh instance of the class for
each test, then invokes the annotated method. Any uncaught exception is reported as a
failure; if no exception is thrown the test is considered to have passed.

### @Disabled

Temporarily disables a test method or an entire test class. The disabled test is
reported as skipped rather than ignored silently.

```java
@Disabled("Until bug #666 is fixed!")
@Test
public void anotherMethod() { … }
```

### @Timeout

Causes a test to fail if it takes longer than the specified number of seconds.

```java
@Test
@Timeout(1)   // fail after 1 second
public void aMethodWithTimeout() throws InterruptedException { … }
```

### @Suite / @SelectClasses

Allows combining multiple test classes into a single suite using the JUnit Platform
Suite engine.

```java
@Suite
@SelectClasses({ FooTest.class, BarTest.class })
public class AllTests {}
```

> Requires the `junit-platform-suite` dependency on the classpath.


## Assert Methods

All assertion methods live in `org.junit.jupiter.api.Assertions`.

| Method | Description |
|--------|-------------|
| `assertTrue(condition)` | Asserts that `condition` is `true` |
| `assertFalse(condition)` | Asserts that `condition` is `false` |
| `fail(message)` | Fails the test immediately |
| `assertNull(object)` | Asserts that `object` is `null` |
| `assertNotNull(object)` | Asserts that `object` is not `null` |
| `assertEquals(expected, actual)` | Asserts that two values are equal |
| `assertSame(expected, actual)` | Asserts that two references point to the same object |
| `assertArrayEquals(expected, actual)` | Asserts that two arrays are equal |
| `assertThrows(type, executable)` | Asserts that `executable` throws an exception of `type` |
| `assertTimeout(duration, executable)` | Asserts that `executable` finishes within the given duration |
| `assertAll(heading, executables…)` | Runs all assertions and reports all failures at once |

### assertThrows

```java
NullPointerException ex = assertThrows(NullPointerException.class, () -> setName(null));
assertEquals("Parameter name is null!", ex.getMessage());
```

### assertAll

```java
assertAll("Book properties",
    () -> assertEquals("9780132350884", book.getIsbn()),
    () -> assertEquals("Robert C. Martin", book.getAuthor()),
    () -> assertEquals("Clean Code", book.getTitle())
);
```

Unlike separate `assertEquals` calls, `assertAll` continues executing every lambda and
reports all failures in a single run.


## References

* [JUnit 6 User Guide](https://junit.org/junit5/docs/6.0.3/user-guide/)
* [JUnit 6 JavaDoc](https://junit.org/junit5/docs/6.0.3/api/index.html)
* Catalin Tudose. **JUnit in Action**. Manning, 3rd Edition, 2020.

*Egon Teiniker, 2016-2025, GPL v3.0*
