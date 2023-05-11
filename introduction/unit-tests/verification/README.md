# Result Verification

JUnit comes with a collection of build-in **Assertion Methods**.

Assertions are usually called from within the test method body right after 
the SUT has been exercised.

A key challenge in coding the assertions is getting access to the information 
we want to compare with the expected results.


## State Verification
We **inspect the state of the SUT** after it has been exercised 
and compare it to the expected state.

State verification consists of the following steps:

1. We exercise the SUT by invoking the methods of interest.

2. We interact with the SUT to retrieve its post-exercise state and compare 
it with the expected end state by calling assert methods.

We can access the state of the SUT simply by calling methods that return 
its state.


## Behavior Verification

We capture the **indirect output** of the SUT as they occur and compare 
them to the expected behavior.

Behavior verification includes of the following steps:

1. Each test specifies not only how the client of the SUT interacts with it 
during the exercise phase of the test, but also how the SUT interacts with 
the components on which it should depend.

2. Behavior verification almost always involves interacting with or replacing 
a depended-on component (DOC) with which the SUT interacts at runtime.

Behavior verification usually requires the help of test doubles such as
*Test Spy* or *Mock Object*.


## Reducing Code Duplication

In result verification, test code duplication usually shows up as a set of 
repeated assertions.

Several techniques are available to reduce the number of assertions in such 
cases:
* **Expected Objects**: Use a single equality assertion to compare two whole 
objects to each other rather than using many equality assertion calls to 
compare them field by field.

* **Custom Assertions**: A custom assertion is a domain-specific assertion 
we write ourselves. Custom assertions hide the procedure for verifying the 
results behind a declarative name, making our result verification logic 
more intent-revealing.

* **Verification Methods**: The major difference between a verification 
method and a custom assertion is that latter only makes assertions, while the 
former also interacts with the SUT (for the purpose of exercising it).  

* **Parameterized Test**: If the logic to set up the test fixture is the 
same but uses different data, we can extract the common fixture setup, 
exercise SUT, and verify phases of the test into a new *parameterized test 
method*. We define very simple test methods for each test, which then call 
the parameterized test and pass in the data required to make this test unique. 

* **Data-Driven Tests**: The test case is completely generic. 
It reads the arguments from a *test data file* as it executes. 


## References

* Gerard Meszaros. **xUnit Test Patterns**. Addison-Wesley, 2007 
* [xUnit Test Patterns Web Page](http://xunitpatterns.com/)

*Egon Teiniker, 2016-2023, GPL v3.0*