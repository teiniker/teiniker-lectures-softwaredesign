# Logging

The simplest way of **observing facts about a program run** is to have the program 
output the facts as desired, by inserting appropriate logging statements in the code.

The `System.out.println()` debugging is a widespread debugging technique, 
but has several drawbacks:

* **Cluttered code**: Because logging statements serve no other purpose than debugging,
    they do not help us in understanding the code. Programmers frequently remove logging
    statements once the observation is done.

* **Cluttered output**: Logging statements can produce a great deal of output, depending
    on the number of events and variables traced.    

* **Slowdown**: A huge amount of logging can slow down the program.

* **Loss of data**: For performance reasons, output is typically buffered before actually
    being written to the output device. In the event of a program crash, this buffered
    output is lost.


Therefore, it is better to use dedicated logging frameworks:
* **Use standard formats**: Standard formats make it easy to search and filter logs for 
    code locations, events and data.

* **Make logging optional**: For performance reasons, logging is typically turned off 
    in production code.

* **Allow for variable granularity**: It can be helpful to focus on specific levels 
    of detail. Focusing only on specific events also improve performance.


## References

* [Log4j2 Configuration](https://logging.apache.org/log4j/2.x/manual/configuration.html)

*Egon Teiniker, 2016-2024, GPL v3.0*