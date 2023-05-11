# Test Fixtures

In xUnit, we call everything we need in place to exercise the **System Under 
Test (SUT)** the test fixture. 

Depending on the type of implementation, we distinguish between:

* **Front door setup**: We call the appropriate methods on the SUT to put 
it into the starting state. This may require constructing other objects and 
passing them to the SUT as arguments of method calls.

* **Back door setup**: We insert the necessary data directly into the 
    component (database or Mock Object) on which the behavior of the SUT 
    depends.


## Transient Fixtures

When our fixture is an in-memory fixture referenced only by local 
variables or instance variables, we call it a transient fixture.

When creating a fixture, then we can choose one of the following variants:

* **In-line fixture setup**: The test handles all of the fixture setup 
within the body of the test method. This is like a do-it-yourself approach to 
fixture creation.
This setup method tends to lead to test *code duplication*, because each test 
method needs to construct the SUT.

* **Delegated fixture setup**: We move a sequence of statements used in 
several test methods into a test utility method (*creation method*) 
that we can call from test methods. 

* **Implicit fixture setup**: Most members of the xUnit family provide a 
convenient hook for calling code that needs to be run before every 
test method (@Before in JUnit). 

As long as our references to the fixture are held in variables that go 
out of scope, we can count on garbage-collected teardown.



## Persistent Fixtures

A persistent fixture most often occurs when the System Under Test (SUT) 
includes file or a database, but it can occur simply because the SUT uses class 
variables to hold some of its data.

When fixtures are persistent, we may find that subsequent runs of the same 
test method try to recreate a fixture that already exists.
A way to avoid unrepeatable tests is to tear down the fixture at the end 
of each test. 
Unfortunately, we cannot take advantage of garbage-collected teardown.

In order to teardown a persistent test fixture we can choose one of the 
following strategies:

* **In-line teardown**: To ensure that the fixture is destroyed after we 
are done with it we include test-specific teardown code within our test 
methods. 
This hand-coded teardown will tear down the fixture when the test passes 
– but it won’t tear down the fixture if the test fails or ends with an error.

* **Implicit teardown**:
The test automation framework calls a special teardown method 
(@After in JUnit4) after each test method regardless of whether the test 
passed or failed.

* **Database teardown**:
We can take advantage of certain features of the database to implement the 
teardown.
    * Table truncation teardown. 
    This is a brute-force way to blow away the entire contents of a table 
    with a single database command (make sure that you have your own database 
    sandbox).

    * Transaction rollback teardown. 
    We can invoke the business logic from the test without having the SUT 
    commit the transaction automatically. 

* **Avoiding the need for teardown**: We can replace the persistence 
    mechanism with a test double (e.g. Mock Object).

## References

* Gerard Meszaros. **xUnit Test Patterns**. Addison-Wesley, 2007
* [xUnit Test Patterns Web Page](http://xunitpatterns.com/)


*Egon Teiniker, 2016-2023, GPL v3.0*