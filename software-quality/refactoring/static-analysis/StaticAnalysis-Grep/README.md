# Static Analysis Using grep

The grep filter **searches a file for a particular pattern of characters**, and displays all lines 
that contain that pattern. The pattern that is searched in the file is referred to as the 
**regular expression** (grep stands for **global search for regular expression and print out**).


## Search for Known-Bad Operations and Types

We can use grep to **quickly search for problematic operations or types** (eg: gets(), printf(),
System.out.println(), etc.) in source directories.

We can try grep in our target project:
```
$ cd StaticAnalysis-Target/
```

First we look for **print statements**. This is usually an indicator of very poor code quality.
```
$ grep -i -n -r "System.out.println(" .
./src/main/java/org/se/lab/BadPractice.java:34:     System.out.println("Strings are equal!");
./src/main/java/org/se/lab/Security.java:15:        System.out.println("File exist!");
```

In **error handling**, we can see the use of **generic exception types** (or even the excessive use of checked exceptions such as `SQLException`).
```
$ egrep -i -n -r " Exception|RuntimeException" .
./src/main/java/org/se/lab/ErrorHandling.java:59:   throw new RuntimeException("Some bad things happened!");
```

```
$ egrep -i -n -r ".printStackTrace()" .
./src/main/java/org/se/lab/ErrorHandling.java:44: e.printStackTrace();
```

## References

* [grep command in Unix/Linux](https://www.geeksforgeeks.org/grep-command-in-unixlinux/)

*Egon Teiniker, 2016-2024, GPL v3.0*


