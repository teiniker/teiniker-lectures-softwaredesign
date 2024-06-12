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

* Unit Testing Basics
  * [Introduction](basics/README.md)
  * [JUnit Tutorial](basics/JUnit4-Tutorial)
  * [Test Automation Difficulty](../introduction/TestDifficulties.md)
  * [Roadmap to Test Automation](../introduction/RoadmapToTest.md)
  
* Fixtures 
  * [Introduction](fixtures/README.md)
  * [Fixture Setup](fixtures/JUnit4-Fixture-Setup)
  * Exercise: [Builder Book](fixtures/JUnit4-Fixture-Builder-Book-Exercise/) - 
    ([Model Solution](fixtures/JUnit4-Fixture-Builder-Book/))

* Verification
  * [Introduction](verification/README.md)
  * [Result Verification](verification/JUnit4-ResultVerification)
  * Exercise: [Result Verification Book](verification/JUnit4-ResultVerification-Book-Exercise/) - 
    ([Model Solution](verification/JUnit4-ResultVerification-Book/))

* Test Doubles 
  * [Introduction](doubles/)

  * [Test Stub](doubles/JUnit4-TestDouble-Stub/)
  * Exercise: [Stub - Article Service](doubles/JUnit4-TestDouble-Stub-ArticleService-Exercise/) - 
    ([Model Solution](doubles/JUnit4-TestDouble-Stub-ArticleService/))

  * [Test Spy](doubles/JUnit4-TestDouble-Spy/)
  * Exercise: [Spy - Article Service](doubles/JUnit4-TestDouble-Spy-ArticleService-Exercise/) - 
    ([Model Solution](doubles/JUnit4-TestDouble-Spy-ArticleService/))

  * [Mockito](doubles/JUnit4-TestDouble-Mockito/)
  * [Easy Mock](doubles/JUnit4-TestDouble-EasyMock/)

* Test Case Design
  * Introduction
  * [Code Coverage Analysis](testcase-design/JUnit4-CodeCoverage/)
  * Exercise: [Code Coverage - Blog](testcase-design/JUnit4-CodeCoverage-Blog-Exercise/) - 
    ([Model Solution](testcase-design/JUnit4-CodeCoverage-Blog/)


## References
* Lisa Crispin. **Agile Testing: A Practical Guide for Testers and Agile Teams**. Addison-Wesley, 2008
* Gerard Meszaros. **xUnit Test Patterns**. Addison-Wesley, 2007
* [xUnit Test Patterns Web Page](http://xunitpatterns.com/)
* Catalin Tudose. **JUnit in Action**. Manning, 3rd Edition, 2020.

*Egon Teiniker, 2016-2024, GPL v3.0*
