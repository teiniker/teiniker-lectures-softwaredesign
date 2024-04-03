# Test Automation Difficulty

The following common kinds of tests are listed in order of difficulty, 
from easiest to most difficult:

1. **Simple entity objects**
    * Simple classes with no dependencies.
    * Complex classes with dependencies.

2. **Service objects**
    * Individual components. 
    * The entire business logic layer.
    * Customer tests via Service Facade.

3. **So called "Hard-to-test" code**
    * User interface logic.
    * Database logic.
    * Multi-threaded software.

4. **Object-oriented legacy software** 

    Software built without any tests.

5. **Non-object-oriented legacy software**


The irony is that many teams start automatic testing by trying to implement 
tests onto an existing application...




## References

* Gerard Meszaros. **xUnit Test Patterns**. Addison-Wesley, 2007 
* [xUnit Test Patterns Web Page](http://xunitpatterns.com/)

*Egon Teiniker, 2024, GPL v3.0*