package org.se.lab;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    JUnit4Test.class, 
    TestSuite.class
})
public class AllTests
{
    @BeforeClass
    public static void setUpSuite()
    {
        System.out.println("AllTests.setUpSuite()");
        // TODO
    }
    

    @AfterClass
    public static void tearDownSuite()
    {
        System.out.println("AllTests.tearDownSuite()");
        // TODO
    }
}
