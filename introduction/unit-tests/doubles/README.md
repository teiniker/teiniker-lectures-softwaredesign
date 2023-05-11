# Test Doubles

*Depended-on components (DOC)* may return values or throw exceptions that 
affect the behavior of the SUT, but it can be difficult or impossible to 
cause certain cases to occur.

The testing challenge is to somehow cause the DOC to throw an exception so 
that the error path can be tested (**Indirect Input**).

Not all outputs of the SUT are directly visible to the test. Some outputs 
are sent to other components in the form of method calls or messages. 
(**Indirect Output**). 


## Control Indirect Inputs

To test the SUT with indirect inputs, we must be able to control the DOC 
well enough to cause it to return every possible kind of return value. 

The test could interact with the DOC to set up how it will respond to 
requests (**Back Door Setup**).

In many cases this approach is not practical because:

* The real component cannot be manipulated to produce the desired indirect 
    input.

* Manipulating the real component is either not cost-effective or has 
    unacceptable side effects.

* The real component is not yet available for use.

Therefore, we have to replace the real DOC with one that we can control. 
The most common approach is the **Test Stub**.
During execution of the SUT, the test stub receives the calls and returns 
previously configured response.
Before exercising the SUT, we tell the test stub what it should return to 
the SUT when it is called. 
This strategy allows us to force the SUT through all its code paths.


## Verify Indirect Outputs

To test the indirect outputs, we must be able to observe the calls that the 
SUT makes to the API of the DOC. We also need to be able to control the 
values returned.

Using real components as observation points is not practical:

* We cannot query calls to the internal state of the DOC.

* Querying real components is costly and may have unacceptable side effects.

* Real components are not yet available for use.

So we have to replace the real components with a test-specific alternative.

Two basic styles of indirect output verification are available:

* **Procedural Behavior Verification**: captures the calls to a DOC during 
SUT execution and then compares them with the expected calls after the SUT 
has finished executing (**Test Spy**).

* **Expected Behavior Verification**: involves building a "behavior specification" 
during the fixture setup phase of the test and then comparing the actual 
behavior with this expected behavior (**Mock Object**).


## Types of Test Doubles

A Test Double is any object or component that we install in place of the 
real component for the purpose of running a test.

Test Doubles can behave in one of the following ways:

* A **Dummy Object** is a placeholder object that is passed to the SUT as an 
argument but is never actually used.

* A **Test Stub** is an object that replaces a real component on which the 
SUT depends so that the test can control the indirect inputs of the SUT. 
It allows the test to force the SUT down paths it might not otherwise exercise.

* A **Test Spy** can be used to verify the indirect output of the SUT by 
giving the test a way to inspect them after exercising the SUT.

* A **Mock Object** is an object that replaces a real component on which 
the SUT depends so that the test can verify its indirect outputs.

* A **Fake Object** is an object that replaces the functionality of the 
real DOC with an alternative implementation of the same functionality.


## References

* Gerard Meszaros. **xUnit Test Patterns**. Addison-Wesley, 2007 
* [xUnit Test Patterns Web Page](http://xunitpatterns.com/)

*Egon Teiniker, 2016-2023, GPL v3.0*