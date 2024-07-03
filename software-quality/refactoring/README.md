# Refactoring

> Refactoring is a controlled technique for **improving the design 
> of an existing code base**. 
> Its essence is applying a series of **small behavior-preserving 
> transformations**. 

However the cumulative effect of each of these transformations is quite
significant. By doing them in small steps we reduce the risk of introducing
errors. 

We also avoid having the system broken while we are carrying out the restructuring,
which allows us to gradually refactor a system over an extended period of time.


Refactoring is crucial for eliminating [Code Smells](code-smells/README.md) in source 
code, as it involves restructuring existing code without changing its external behavior.

[Static Code Analysis and Software Metrics](static-analysis/README.md) are 
essential tools for **identifying code smells in source code**. 
By using static code analysis, developers can automatically examine code without 
executing it, which helps in detecting potential issues early in the development 
process. 
This proactive approach ensures that code quality is maintained and reduces 
the likelihood of bugs and vulnerabilities.

Software metrics, on the other hand, provide quantitative measures of various 
aspects of the code, such as complexity, maintainability, and readability. These 
metrics help in pinpointing areas of the code that may be problematic or prone 
to errors. 


## References

* [Martin Fowler: Refactoring](https://martinfowler.com/books/refactoring.html)

* Martin Fowler. **Refactoring: Improving the Design of Existing Code**. Addison Wesley, 2. Edition, 2019


*Egon Teiniker, 2016-2024, GPL v3.0*