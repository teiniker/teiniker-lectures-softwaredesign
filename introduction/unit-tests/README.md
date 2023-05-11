# Unit Tests

A unit test is a type of software testing that focuses on **verifying the functionality 
of individual units, components, or modules** of a software application. 
The purpose of unit testing is to ensure that each unit of code, such as a function or 
a method, performs as expected and produces the correct output for a given input.

Unit tests are typically **written by software developers themselves** as part of the 
development process. They are written in a programming language and closely resemble 
the structure of the code being tested. 
The tests are designed to target small, isolated portions of code, rather than the 
entire application. 
By **isolating the units of code**, it becomes easier to identify and fix any bugs or 
issues, as the scope of the problem is limited.

Unit tests are usually **automated**, meaning they can be executed automatically 
without manual intervention. Developers use **testing frameworks** or libraries specific 
to their programming language or platform to write and run unit tests. 
These frameworks provide tools and utilities for setting up test scenarios, 
executing the code being tested, and comparing the actual results against the 
expected results.

*  Unit Testing Basics
  * [Introduction](basics/README.md)
  * [JUnit Tutorial](basics/JUnit4-Tutorial)
  * [Roadmap to Test Automation](basics/RoadmapToTest.md)
  * [Test Automation Difficulty](basics/TestDifficulties.md)
  
* Fixtures 
  * [Introduction](fixtures/)
  * [JUnit Fixture Setup](fixtures/JUnit4-Fixture-Setup)
  
* Verification
  * [Introduction](verification/)
  * [JUnit Result Verification](verification/JUnit4-ResultVerification)

* Test Doubles 
  * [Introduction](doubles/)
  * [Test Stub](doubles/JUnit4-TestDouble-Stub/)
  * [Test Spy](doubles/JUnit4-TestDouble-Spy/)

* Test Case Design
  * Introduction
  * [Code Coverage Analysis](testcase-design/JUnit4-CodeCoverage-Blog)


## References
* Gerard Meszaros. **xUnit Test Patterns**. Addison-Wesley, 2007
* [xUnit Test Patterns Web Page](http://xunitpatterns.com/)

*Egon Teiniker, 2016-2023, GPL v3.0*
