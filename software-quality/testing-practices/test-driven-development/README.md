# Test-Driven Development

Test-Driven Development (TDD) is a software development process where tests 
are written before the actual code is implemented. This approach emphasizes 
writing the minimum amount of code necessary to pass the tests. The TDD cycle 
typically follows a sequence of steps often referred to as **Red-Green-Refactor**. 

## The TDD Cycle

![Test-Driven Development](figures/fowler-tdd.png)

_Figure: Test-Driven Development steps (Fowler, 2005)_

1. **Red**: Write a Test
    * Begin by writing a unit test for the new functionality you are about to 
        implement. The test should be written based on the requirements and 
        should cover both happy-path and alternative cases.

    * Run the test, and it should fail since the functionality is not yet 
        implemented. This failing test is called "red" because it indicates that 
        the test did not pass.

2. **Green**: Write the Code
    * Write the minimal amount of code required to make the test pass. The focus 
        here is on implementing just enough functionality to pass the test.
    * Run the test again, and if it passes, the test turns "green," indicating success.

3. **Refactor**: Improve the Code
    * Once the test passes, review the code and the test to see if there 
        are any improvements or optimizations that can be made. This could 
        involve refactoring the code to improve readability, performance, 
        or maintainability without changing its behavior.
    * Ensure that all tests still pass after refactoring.

## Benefits of TDD

* **Improved Code Quality**: 
    Writing tests first ensures that the code meets the requirements from the outset.
    Tests help identify edge cases and potential issues early in the development process.

* **Better Design**:
    TDD encourages a modular and decoupled design since it requires thinking about 
    how to test each part of the code independently.
    It promotes writing only the necessary code to pass the test, avoiding over-engineering.

* **Documentation**:
    The tests serve as documentation for the code, providing clear examples of how the 
    code is intended to be used and what its expected behavior is.

* **Regression Prevention**: 
    The test suite created during TDD acts as a safety net, catching regressions 
    and ensuring that new changes do not break existing functionality.
    Developers can make changes and refactor the code with confidence, knowing that 
    the tests will catch any errors introduced by the changes.

Test-Driven Development is a powerful methodology that helps ensure code quality, 
robustness, and maintainability. By writing tests before code, TDD encourages 
thoughtful design, thorough testing, and cleaner code, ultimately leading to more 
reliable software. Although it requires discipline and practice to master, 
the long-term benefits make it a valuable approach in modern software development.


## References

* [Martin Fowler: Test Driven Development](https://martinfowler.com/bliki/TestDrivenDevelopment.html)

* Kent Beck. **Test Driven Development: By Example**. Addison-Wesley Professional, 2002
* Lisa Crispin, Janet Gregory. **Agile Testing**. Addison Wesley, 2009


*Egon Teiniker, 2016-2024, GPL v3.0*