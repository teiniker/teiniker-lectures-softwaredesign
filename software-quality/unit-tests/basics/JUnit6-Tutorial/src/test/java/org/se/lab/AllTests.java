package org.se.lab;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({
    JUnit6Test.class,
    ExceptionTest.class,
    TimeoutTest.class
})
public class AllTests
{
}
