## ResultVerification with Hamcrest

Hamcrest is a well-known framework used for JUnit test assertions. 
It is based on predicates - called **matcher classes**. 
In this example you will find applications for Hamcrest matchers.

### Hamcrest Setup

Add the following dependency to the *pom.xml*:
```xml
    <dependency>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest-all</artifactId>
        <version>1.3</version>
    </dependency>
```

A test class should use the following Hamcrest import statements:

```java
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
```

Instead of using JUnit's *assert()* methods, we only use the Hamcrest API's single
**assertThat()** operation with appropriate matchers. So we can take advantage of 
it to write more intuitive unit tests. 

### Matching Numbers

In the context of Numbers, the following matchers can be used:

* **greaterThan(T value)**: matches when the examined object is greater than the specified value.

* **greaterThanOrEqualTo(T value)**: matches when the examined object is greater 
    than or equal to the specified value.
    
* **lessThan(T value)**: matches when the examined object is less than the specified 
    value.
    
* **lessThanOrEqualTo(T value)**: matches when the examined object is less than or 
    equal to the specified value.

* **closeTo(double operand, double error)**: matches when an examined double is equal to the 
    specified *operand*, within a range of +/- *error*.       


### Matching Strings

In the context of Strings, the following matchers can be used:

* **isEmptyString()**: matches when the examined string has zero length.

* **isEmptyOrNullString()**: matches when the examined string is *null*, 
    or has zero length.

* **equalToIgnoringWhiteSpace(String expectedString)**: matches when the examined string is equal to
    the specified expectedString, when whitespace differences are (mostly) ignored:
      (i) all leading and trailing whitespace of both the expectedString and the 
      examined string are ignored.
      (ii) any remaining whitespace, appearing within either string, is collapsed to 
      a single space before comparison.
                                       
* **equalToIgnoringCase(String expectedString)**: matches when the examined string is equal to
    the specified expectedString, ignoring case. 
    
* **containsString(String substring)**: matches if the examined String contains the 
    specified String anywhere.                         

* **stringContainsInOrder(Iterable<String> substrings)**: matches when the examined string contains all of
    the specified substrings.

* **startsWith(String prefix)**: matches if the examined String starts with the 
    specified String.

* **endsWith(String suffix)**: matches if the examined {@link String} ends with 
    the specified String.
    
* **not(Matcher<T> matcher)**: wraps an existing matcher, but inverts the logic 
    by which it will match.    
     
* **anyOf(Matcher<T> first, Matcher<? super T> second)**: matches if the examined object matches 
    *ANY* of the specified matchers (logical OR).     

* **allOf(Matcher<? super T> first, Matcher<? super T> second)**: matches if the examined 
    object matches *ALL* of the specified matchers (logical AND).


### Matching Arrays

In the context of Arrays, the following matchers can be used:

* **arrayWithSize(int size)**: matches when the *length* of the array
    equals the specified size.

* **arrayContaining(E... items)**: matches when each item in the examined array is
    logically equal to the corresponding item in the specified items.  
    For a positive match,  the examined array must be of the same length as the 
    number of specified items.

* **arrayContainingInAnyOrder(E... items)**: matches when each item in the
    examined array is logically equal to one item anywhere in the specified items.
    For a positive match, the examined array must be of the same length as the 
    number of specified items.

* **hasItemInArray(T element)**: matches when the examined array contains at least one 
    item that is specified by the element.

* **isIn(T[] param)**: matches when the examined object is found within the
    specified array.


### Matching Lists
In the context of Lists, the following matchers can be used:

* **empty()**: matching examined collections whose *isEmpty()*
    method returns true.

* **hasSize(int size)**: matches when the *size()* method returns
    a value equal to the specified size.

* **contains(E... items)**: matches when a single pass over the examined List 
    yields a series of items, each logically equal to the corresponding item in the 
    specified items.  For a positive match, the examined List must be of the same 
    length as the number of specified items.
 
* **containsInAnyOrder(T... items)**: order agnostic matcher for Lists that matches 
    when a single pass over the examined List yields a series of items, each 
    logically equal to one item anywhere in the specified items. 
    For a positive match, the examined iterable must be of the same length as 
    the number of specified items. 
 
* **hasItem(T item)**: only matches when a single pass over the examined List 
    yields at least one item that is equal to the specified item.  
    Whilst matching, the traversal of the examined List will stop as soon as 
    a matching item is found. 
 
* **isIn(Collection<T> collection)**: matches when the examined object is found 
    within the specified collection. 
 
 
### Matching Maps
In the context of Maps, the following matchers can be used:

* **hasKey(K key)**: matches when the examined Map contains
    at least one key that is equal to the specified key.

* **hasValue(V value)**: matches when the examined Map contains
    at least one value that is equal to the specified value.

* **hasEntry(K key, V value)**: matching when the examined Map contains
    at least one entry whose key equals the specified key and whose value 
    equals the specified value.


### Matching Java Beans

In the context of Java Beans, the following matchers can be used:

* **equalTo((T operand))**: matches when the examined object is logically equal to 
    the specified operand, as determined by calling the *equals()* method on the 
    examined object.

* **hasToString(String expectedToString)**: matches any examined object whose 
    *toString()* method returns a value equalTo the specified string. 

* **hasProperty(String propertyName, Matcher<?> valueMatcher)**: matches when the 
    examined object has a JavaBean property  with the specified name whose value 
    satisfies the specified matcher.

* **samePropertyValuesAs(T expectedBean)**: matches when the examined object has 
    values for all of its JavaBean properties that are equal to the corresponding 
    values of the specified bean. 

* **instanceOf(Class<?> type)**: matches when the examined object is an instance 
    of the specified type,  as determined by calling the *Class.isInstance(Object)*
     method on that type, passing the the examined object.

* **sameInstance(T target)**: matches only when the examined object is the same 
    instance as the specified target object.

## References

[Hamcrest Web Page](http://hamcrest.org/JavaHamcrest/javadoc/)

*Egon Teiniker, 2019, GPL v3.0*