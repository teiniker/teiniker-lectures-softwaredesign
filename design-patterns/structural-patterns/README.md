# Structural Patterns

Structural design patterns are those that **simplify the design** of large object 
structures by identifying relationships between them. 

They describe **common ways of composing classes and objects** so that they become 
repeatable as solutions.

* **Proxy**
    * _Demo_: [Protection Proxy: ReadOnlySet](proxy/Proxy-Protection-ReadOnlySet)
    * _Exercise_: [Validation Proxy: Service](proxy/Proxy-Validation-Service-Exercise) - ([Model solution](proxy/Proxy-Validation-Service))
    * _Exercise_: [Virtual Proxy: TextFile](proxy/Proxy-Virtual-TextFile-Exercise) - ([Model solution](Proxy-Virtual-TextFile))

* **Decorator**
  * _Demo_: [TableMonitor](decorator/Decorator-TableMonitor)
  * _Exercise_: [FileName](decorator/Decorator-FileName-Exercise) - ([Model solution](decorator/Decorator-FileName))

* **Composite**
  * _Demo_: [FileSystem](composite/Composite-FileSystem)
  * _Demo_: [FileSystem-HiddenFile](composite/Composite-FileSystem-HiddenFile)
  * _Exercise_: [AppleTree](composite/Composite-AppleTree-Exercise) - ([Model solution](composite/Composite-AppleTree))
  * _Exercise_: [Xml](composite/Composite-Xml-Exercise) - ([Model solution](Composite-Xml))

* **Facade**
  * _Demo_: [CalculatorService](facade/Facade-CalculatorService)
  * _Exercise_: [DigestService](facade/Facade-DigestService-Exercise) - ([Model solution](facade/Facade-DigestService))
  
* **Adapter**
  * _Demo_: [Object Adapter: CustomLogger](adapter/Adapter-CustomLogger)
  * _Demo_: [Class Adapter: ArticleDAO]()
  * _Exercise_: [ArticleDAO](adapter/Adapter-ArticleDAO-Exercise) - ([Model solution](adapter/Adapter-ArticleDAO))
  * _Exercise_: [DigestService](adapter/Adapter-DigestService-Exercise) - ([Model solution](adapter/Adapter-DigestService))
  
The following examples combine the usage of **several creational and structural patterns**:

* _Demo_: [TestFramework](../../patterns-in-practice/StructuralPatterns-TestFramework)

## References
* [Structural Patterns in Core Java](https://www.baeldung.com/java-core-structural-patterns)
* E. Gamma, R. Helm, R. Johnson, J. Vlissides. **Design Patterns, Elements of Reusable Object-Oriented Software**. Addison-Wesley, 1995
  * Chapter 4: Structural Patterns 
* Joshua Kerievsky. **Refactoring to Patterns**. Addison-Wesley, 2005

*Egon Teiniker, 2016-2024, GPL v3.0*
