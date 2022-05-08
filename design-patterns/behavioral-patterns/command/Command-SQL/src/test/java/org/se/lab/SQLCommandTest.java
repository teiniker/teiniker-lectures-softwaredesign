package org.se.lab;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class SQLCommandTest
{
    private List<SQLCommand> commandList = new ArrayList<SQLCommand>();
    
    /*
     * Setup a list of commands which can be executed later on.
     */
    @Before
    public void setup()
    {
        commandList.add(new InsertCommand(new User(3, "homer", "**********")));
        commandList.add(new InsertCommand(new User(7, "marge", "**********")));
        commandList.add(new InsertCommand(new User(11,"bart", "**********")));
        commandList.add(new DeleteCommand(3));
    }
    
    
    /*
     * Execute commands which are stored in a task list. 
     */
    
    @Test
    public void test()
    {
        for(SQLCommand cmd : commandList)
        {
            cmd.execute();
        }
    }
}
