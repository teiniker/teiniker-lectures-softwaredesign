# Roadmap to Test Automation

Here is an practical order in which a team can learn about the techniques of 
test automation:

1. **Exercise the happy path code**
    * Set up a simple pre-test state of the SUT.
	
	* Exercise the SUT by calling the method being tested.
	
	Before exercising the SUT, we need to set up the test fixture by 
	initializing the SUT to the pre-test state.
	 
	As long as the SUT executes without raising any errors, we consider the 
	test as having passed.
	Here, we don't check the actual results against the expected results.

2. **Verify direct outputs of the happy path**
    * Call assertion methods on the SUT's responses.
    
    * Call assert methods on the post-test state.
   	
   	Once the happy path is executing successfully, we can add result 
   	verification logic.
   	This involves adding calls to assert methods to compare the expected 
   	results with what actually occurred.	
   	We can easily do that for any object or values returned to the 
   	test by the SUT.
   	We can also call other methods on the SUT or public fields to access the 
   	post-test state of the SUT.
 
3. **Verify alternative paths**
    * Vary the SUT method arguments.

    * Vary the pre-test state of the SUT.

    * Control indirect inputs of the SUT.
	
	Until now, the alternative paths through the code are still untested code.
	The next step is to write tests for these paths.

    *How to exercise alternative paths?*
    * Different values passed in be the client as arguments.
    * Different prior state of the SUT itself.
    * Different results of invoking methods on components on which       	the SUT depends.

    *How to control indirect inputs?*   
    * We can do this by using a **Test Stub** that returns the value that should 
    drive the SUT into the desired code path.
     * As part of the fixture setup, we must force the SUT to use the stub 
    instead of the real component.
    * By using a test stub, we replace a possible nondeterministic component 
    with one that is completely deterministic and under test control.

4. **Verify indirect output behavior**
   	
    Use Mock Objects or Test Spies to intercept and verify outgoing method 
   	calls.
   	
    Sometimes, we cannot confirm that the SUT has behaved correctly simply by 
    looking at the post-test state. In that case, we need a behavior 
    verification:
    * **Test Spy**: remembers how it was called so that the test can later retrieve the usage information.
    * **Mock Object**: can be loaded with expectations during fixture setup, which it subsequently compares with the actual calls.

5. **Optimize test implementation**
	
    * Make the tests run faster
	
	* Make the tests easy to understand and maintain
	
	* Design the SUT for testability
	
	* Reduce the risk of missed bugs
	
	At this point we should have automated tests for all the paths through 
	our code. But we may have less than optimal tests:
    * We may have slow tests.
	* The tests may contain test code duplication.
	* We may have obscure tests.

    *How to make the tests run faster?*
    
	We can use some form of **Shared Fixture**. 
	A better solution is to replace a DOC with a **Fake Object**.

	*How to make the tests easy to understand and maintain?*
	
	We can make obscure tests easier to understand and remove a lot of 
	test code duplication by refactoring our test methods to call 
	**Test Utility Methods** that contain any frequently used logic instead 
	of doing everything on an in-line basis (**Creation Methods**, 
	**Custom Assertions**, **Finder Methods**, **Parameterized Tests**).


## References

* Gerard Meszaros. **xUnit Test Patterns**. Addison-Wesley, 2007 
* [xUnit Test Patterns Web Page](http://xunitpatterns.com/)

*Egon Teiniker, 2016-2023, GPL v3.0*