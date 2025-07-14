# Integration Tests 

Integration testing is a critical phase in the software development lifecycle that focuses on verifying the proper functioning of individual software components when integrated together. It aims to uncover defects or issues that may arise due to interactions between these components. Integration testing plays a vital role in ensuring the overall quality, reliability, and performance of a software system.

The main objective of integration testing is to detect defects early on, preventing them from escalating into more significant issues during subsequent phases, such as system testing or production deployment. By testing the integration points between different modules, the testing team can validate that the software components work seamlessly together, accurately exchange data, and deliver the desired functionality as a unified system.

## Implementation of Integration Tests 
From a technical point of view, we can use the **same testing framework** (and the **same xUnit patterns**) for integration tests as for unit tests.

Particular attention must be paid to the **setup** and **teardown** phase when implementing integration tests. Very often we deal with **Persistent Test Fixtures**. For performance reasons, we are often forced to work with **Shared Fixtures**.

Components that frequently appear in integration tests are:

* **Filesystem**: Data is stored and passed on in various file formats.

* **Databases**: Databases are a particularly useful form of data storage. They allow not only the storage but also the simple evaluation of data via query languages.

## Test Case Design 
The design of the test cases for integration tests is **based on the requirements**.
In this context, we also speak of **black-box tests**, since the focus is on the requirements and not the implementation of the system under test (SUT).

* **Blach-Box Test Techniques**: We apply techniques like **Equivalence Partitioning** 
and **Boundary Value Analysis** to minimize the number of test cases.


## References
* Glenford J. Myers, Corey Sandler, Tom Badgett. **The Art of Software Testing**. Wiley, 3rd Edition 2012
* Lisa Crispin, Janet Gregory. **Agile Testing**. Addison Wesley, 2009

*Egon Teiniker, 2019-2024, GPL v3.0*