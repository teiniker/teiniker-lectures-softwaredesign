# Log4j2

Log4j2 is a popular logging framework for Java, developed by the Apache Software
Foundation. It is a successor to the original Log4j and provides significant 
improvements in performance, flexibility, and ease of configuration. Logging is 
a critical aspect of application development, enabling developers to record, track, 
and analyze the flow and behavior of their applications.

## Components of Log4j2

* **Logger**: The main interface used for logging messages. It provides methods 
    for different logging levels such as `TRACE`, `DEBUG`, `INFO`, `WARN`, 
    `ERROR`, and `FATAL`.

* **Appender**: Responsible for outputting log messages to various destinations 
    such as the console, files, databases, or remote servers.

* **Layout**: Defines the format in which log messages are presented. Common 
    layouts include PatternLayout, XMLLayout, and JSONLayout.

* **Configuration**: Log4j2 configurations can be specified in XML, JSON, YAML, 
    or properties files. These configurations define the logging behavior, 
    including log levels, appenders, and loggers.

* **Filter**: Provides a mechanism to control which log events are processed by 
    the loggers and appenders based on criteria such as log level or specific 
    message content.

## Features of Log4j2

* **Asynchronous Logging**: Improves performance by allowing log messages to 
    be processed asynchronously, reducing the impact on application performance.

* **Support for Multiple Output Destinations**: Can log messages to various 
    destinations simultaneously, such as the console, files, databases, and 
    remote logging servers.


## Essential Log4j2 Configuration

To configure Log4j2, we create a Log4j2 configuration file, such as `log4j2.xml`, 
in the `src/main/resources` directory.

_Example:_ Simple Log4j2 Configuration
```XML
<Configuration status="warn">
    <Appenders>
        <!-- Console appender configuration -->
        <Console name="console" target="SYSTEM_OUT">
            <PatternLayout
                    pattern="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n" />
        </Console>
    </Appenders>

    <Loggers>
        <!-- Root logger referring to console appender -->
        <Root level="all" additivity="false">
            <AppenderRef ref="console" />
        </Root>
    </Loggers>
</Configuration>
```

* `<Configuration>`: 
    * `status="warn"`: This attribute sets the **internal logging level for Log4j2 
        itself**. Messages with a severity level of WARN or higher will be printed 
        to the console during the initialization of the logging system. 
        This is useful for debugging the logging configuration itself.

* `<Appenders>`: This section defines where log messages will be sent. In this 
    case, there is one appender defined for the console.
    * `Console` Appender: Named "console" and targeted at SYSTEM_OUT (standard output).
        * `PatternLayout`: Specifies the format of the log messages.

* `<Loggers>`: This section defines the loggers that will be used in the application.
    * `Root` Logger: The root logger is the default logger that will catch all 
        log messages that are not captured by more specific loggers.
        * `level="all"`: This sets the logging level to ALL, which means all log 
            messages (from the lowest level `TRACE` to the highest level `FATAL`) 
            will be logged.
        * `additivity="false"`: If set to false, log messages will not be passed 
            to the parent logger. This can be used to prevent log messages from 
            being logged multiple times.
        * `AppenderRef`: This refers to the "console" appender defined earlier, 
            meaning that all log messages for the root logger will be sent to the 
            console.

This configuration sets up a simple logging system that outputs all log messages 
to the console with a specific format. The root logger is configured to log all 
messages of all levels, and the messages are formatted to include the timestamp, 
log level, logger name, line number, and the log message itself. This is a common 
setup for development environments where you need to see detailed log information
directly in the console.

## References

* [Log4j2 Configuration](https://logging.apache.org/log4j/2.x/manual/configuration.html)

*Egon Teiniker, 2016-2024, GPL v3.0*