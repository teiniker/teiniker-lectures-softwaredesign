# Working with ChatGPT

From the practical perspective, we have to integrate ChatGPT into the **Software Development Cycle (SDL)**.
We have to analyze every phase in the SDL cycle and develop practices to integrate machine learning.

A promising approach is to **use ChatGPT as a programming pair**:

As part of **Extreme Programming (XP)**, **Pair Programming** is a software development technique in which two programmers work together on the same computer to complete a task. It involves two roles: the **driver** and the **navigator**.
The driver is responsible for writing the code, while the navigator reviews each line of code, provides feedback, and thinks strategically about the overall direction of the program.

In pair programming, the two programmers **collaborate in real time**, discussing and solving problems together. They **switch roles frequently**, allowing both individuals to actively participate in the coding process. The driver focuses on the implementation details, typing the code, and executing the immediate tasks, while the navigator takes a broader view, identifying potential issues, suggesting improvements, and conducting research when needed.



## Use Cases in Software Development

The possible areas of application of ChatGPT in software development are very diverse.
Here are some examples...

### Explain Terms and Concepts

_Example: Explain the concept of a record in the context of Java._

**ChatGPT:**\
In Java, a record is a new language feature that was introduced in Java 16. 
It is a compact and immutable class-like construct that is designed to represent a data container 
with a fixed set of fields. It is essentially a combination of a class and a tuple, allowing you 
to define a type that represents a specific set of data fields.

A record is defined using the `record` keyword followed by the name of the record and its fields. 
For example, the following code defines a record called Person with two fields, name and age:
```Java
public record Person(String name, int age) {}
```
   Once a record is defined, it automatically generates the following features:
1. A constructor that takes the values of all the fields as arguments and assigns
them to the corresponding fields.
2. Getter methods for all the fields.
3. An `equals` method that compares two instances of the record based on the values of their fields.
4. A `hashCode` method that generates a hash code for an instance of the record based on the values of its fields.
5. A `toString` method that generates a string representation of an instance of the record based on the values of its fields.

Records are often used to represent data that is read-only and that does not require behavior
beyond the built-in features provided by the record.  
They can also be used to replace traditional Java beans and DTOs (Data Transfer Objects)
that only contain state and no behavior.


### Explain the Given Source Code

_Example: Explain the following code out of the Java List interface._
```Java
 static <E> List<E> of(E... elements) {
      switch (elements.length) { // implicit null check of elements
          case 0:
              @SuppressWarnings("unchecked")
              var list = (List<E>) ImmutableCollections.EMPTY_LIST;
              return list;
          case 1:
              return new ImmutableCollections.List12<>(elements[0]);
          case 2:
              return new ImmutableCollections.List12<>(elements[0], elements[1]);
          default:
              return ImmutableCollections.listFromArray(elements);
      }
  }
```
**ChatGPT:**\
The code you provided is a static method in the List interface called `of`.
This method allows you to create an immutable list with the specified elements.

Let's break down the code step by step:
1. The method takes a variable number of arguments of type `E` using the ellipsis `(...)` syntax.
   This means that you can pass in any number of elements of type `E`.

2. The switch statement checks the length of the elements array.
   If the length is `0`, it returns an empty immutable list.
   If the length is `1` or `2`, it returns a new immutable list containing the specified elements.
   If the length is greater than `2`, it delegates to another method called `listFromArray` to create the immutable list.

3. In the case where the length is `0`, the method returns a pre-existing instance of an empty immutable list.
   The `@SuppressWarnings("unchecked")` annotation is used to suppress a warning that would otherwise be raised
   because of the unchecked cast to `List<E>`. This is safe because the `EMPTY_LIST` instance is guaranteed to
   be an empty list of any type.

4. In the case where the length is `1` or `2`, a new instance of an immutable list is created
   using the `ImmutableCollections.List12` class, which is a private nested class of
   `ImmutableCollections`. This class is designed to efficiently represent a list with `1` or `2` elements.

5. In the default case where the length is greater than `2`, the method delegates to the
   `listFromArray` method to create an immutable list from the elements array. This method creates
   a new instance of an immutable list using the `ImmutableCollections.ListN` class, which is another
   private nested class of `ImmutableCollections`. This class is designed to efficiently represent a list
   with more than `2` elements.

Overall, the `of` method provides a convenient and efficient way to create immutable
lists with a small number of elements. It is part of Java's effort to provide more
concise and functional programming constructs in the language.



### Refactor Existing Source Code

_Example: Given the following Java code. Can you refactor the code towards Java17?._
```Java
public class Subject
{
    private List<Observer> observers = new ArrayList<Observer>();
    
    public List<Observer> getObservers()
    {
        return Collections.unmodifiableList(observers);
    }
    
    public void attachObserver(Observer o)
    {
        observers.add(o);
    }
       
    public void notifyObservers()
    {
        for(Observer o : observers)
        {
            o.update();
        }
    }
}
```

**ChatGPT:**\

Sure, here's the refactored code using Java 17 features:
```Java
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public List<Observer> getObservers() {
        return List.copyOf(observers);
    }

    public void attachObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
```
Here are the changes that were made:
1. The generic type argument of the `ArrayList` constructor was removed as it can be inferred from the variable declaration.
2. The `Collections.unmodifiableList` method was replaced with the `List.copyOf` method.
   The `copyOf` method returns an unmodifiable list that is a copy of the original list,
   which is safer than returning the original list directly.
3. The for loop in the `notifyObservers` method was replaced with a `forEach` method call.
   The `forEach` method takes a lambda expression as an argument and applies it to each element of the list.
   In this case, it calls the update method on each Observer object.
   This is a more concise and functional way of iterating over a list.

These changes make the code more concise and use newer Java features while retaining the same functionality.


### Analyze Source Code for Errors and Security Vulnerabilities

_Example: Given the following Java code. Can you find security problems?_
```Java
public class FileManager
{
	private static final String BASE_DIRECTORY = "./doc";
	
	public String readFile(final String name) 
	{
		if(name == null)
			throw new IllegalArgumentException();

		File file = new File(BASE_DIRECTORY, name);

		try(BufferedReader in = new BufferedReader(new FileReader(file)))
		{
			StringBuilder buffer = new StringBuilder();
			String line;
			while ((line = in.readLine()) != null)
			{
				buffer.append(line).append("\n");
			}
			return buffer.toString();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
```
**ChatGPT:**\
Yes, there are potential security problems with this code. Here are some issues to consider:

1. Directory traversal attack: The readFile method takes a `name` parameter,
   which is used to construct a File object.
   However, the name parameter is not validated, which means that an attacker could potentially
   provide a malicious input that contains path traversal characters (e.g., `../`) and access
   files outside the expected directory.
   To prevent this type of attack, you should validate the `name` parameter and ensure that it only
   contains expected characters.

2. File disclosure vulnerability: If an attacker can control the `name` parameter, they could potentially
   access sensitive files on the server. For example, if the attacker provides a name of `"passwords.txt"`,
   the `readFile` method would return the contents of that file.
   To prevent this type of attack, you should restrict access to sensitive files and ensure that the `name`
   parameter only accesses files that are meant to be publicly accessible.

3. Exception handling: The `readFile` method catches an `IOException` and prints the stack trace.
   This could potentially leak sensitive information or provide useful debugging information to an attacker.
   Instead, you should handle exceptions in a way that does not reveal sensitive information.

To address these issues, you could implement additional security measures such as input validation, access control,
and exception handling best practices. For example, you could validate the name parameter using a regular expression
or a whitelist of allowed characters, restrict access to sensitive files using file system permissions or a security
framework, and handle exceptions in a way that does not reveal sensitive information.


### Generate Source Code From Text-Based Requirements

_Example: Implement two classes in Java:_
* The class "User" has the attributes id:int, username:String, and password:string.
  "User" also has a directed association of multiplicity * to the class Mail.
* The second class "Mail" has the attributes id:int, and address:String.
* To reduce the code redundency, implement a base class called "Entity" which implements the common id:int
  attribute together with the getter and setter methods, hashCode and equals.
  
**ChatGPT:**\
Here's an implementation of the Entity class:
```Java
public abstract class Entity {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        Entity entity = (Entity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
```
This class defines an `id` attribute with corresponding getter and setter methods,
as well as `equals` and `hashCode` methods for comparing objects based on their `id` attribute.
It is defined as abstract so that it can't be instantiated directly.

Here's an implementation of the `User` and `Mail` classes that extend the `Entity` class:
```Java
public class User extends Entity {
    private String username;
    private String password;
    private List<Mail> mails = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Mail> getMails() {
        return mails;
    }

    public void addMail(Mail mail) {
        mails.add(mail);
    }
}
```
```Java
public class Mail extends Entity {
    private String address;

    public Mail(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
```
The `User` class has a list of `Mail` objects, which represents the directed
association of multiplicity `*` from `User` to `Mail`.
The `addMail` method allows adding new mails to the list.

By extending the `Entity` class, the `User` and `Mail` classes inherit the `id` attribute
and its associated getter and setter methods, as well as `equals` and `hashCode` methods
for comparing objects based on their `id` attribute.
This helps to reduce code redundancy and promote code reuse.


_Example: Can you extend the constructor or User and Mail to pass in the id values as well?_

**ChatGPT:**\
Sure, here's an updated implementation of the `User` and `Mail` classes that includes constructors
to set the `id` attribute along with the `username`, `password`, and `address` attributes, respectively:
```Java
	//...
    public User(int id, String username, String password) {
        super.setId(id);
        this.username = username;
        this.password = password;
    }
	//...
```

```Java
	//...
	    public Mail(int id, String address) {
        super.setId(id);
        this.address = address;
    }
	//...
```

In these updated implementations, the constructors of `User` and `Mail` take an
additional `id` parameter and pass it to the `setId` method of the `Entity` class.
This sets the `id` attribute of the object to the specified value.

By providing constructors that set the `id` attribute, we can create instances of
`User` and `Mail` with a specified `id` value. This can be useful in cases where we
need to create objects with specific identifiers, such as when loading data from a
database or other external source.


### Generate Source Code From Given Test Cases


_Example: Given the following test case, implement the missing "Base16" class and its "toBase16String" method to make the test work._
```Java
public class Base16Test:
{
	@Test
	public void test3Bytes()
	{
		byte[] binaryData = 
		{ 
			(byte)0x1a,(byte)0xcf,(byte)0xd2
		};
		
		String base16String = Base16.toBase16String(binaryData);
		
		Assert.assertEquals("1ACFD2", base16String);
	}
}
```

**ChatGPT:**\
Sure, here's an implementation of the missing `Base16` class with a
`toBase16String` method that converts a byte array to a base16 string:
```Java
public class Base16 {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String toBase16String(byte[] data) {
        char[] hexChars = new char[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            int v = data[i] & 0xFF;
            hexChars[i * 2] = HEX_ARRAY[v >>> 4];
            hexChars[i * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
```

In this implementation, the `toBase16String` method takes a `byte[]`
parameter and returns a `String` that represents the hexadecimal representation
of the input data.

The method works by iterating over each byte in the input data and converting it to
its hexadecimal representation. The `HEX_ARRAY` constant is a lookup table that
contains the characters for each possible hexadecimal value.
The resulting hexadecimal characters are then concatenated into a `char[]` array
and converted to a `String` using the `String(char[])` constructor.

With this implementation of the `Base16` class, the `test3Bytes` method in the
`Base16Test` class should pass as expected.


## ChatGPT in Education

In the same way that pair programming is a great way for novice programmers to get started, ChatGPT can be used as a **personal learning coach**.

A possible didactic approach is to use the **inverted class room model**. The acquisition of knowledge is transferred to the home through **self-directed learning**, while the students can then **apply their knowledge in the laboratory** using practical tasks.

The **assessment must be made in the class** through concrete problems. Homework is not a suitable tool for assessing students (not only since ChatGPT).


## References

* Pair Programming
    * Kent Beck. Extreme Programming Explained. Addison-Wesley, 2000
    * [YouTube (Continuous Delivery): You Must Be CRAZY To Do Pair Programming](https://youtu.be/aItVJprLYkg)

* ChatGPT
    * [ChatGPT](https://chat.openai.com/)
    * Nathan Hunter. The Art of Prompt Engineering with ChatGPT. ChatGPT Trainings, 2023
    * Stephen Wolfram. What is ChatGPT Doing... and Why Does It Work?. Wolfram Media, 2023

* Education
    * [YouTube (Douglas Schmidt): Applying ChatGPT to Computer Science Courses at Vanderbilt University](https://youtu.be/rXUnGaYGTt4)
    * Egon Teiniker, Gerhard Seuchter. Improving the Flipped Classroom Model by the Use of Inductive Learning. 2020 IEEE Global Engineering Education Conference (EDUCON)

*Egon Teiniker, 2016-2023, GPL v3.0*