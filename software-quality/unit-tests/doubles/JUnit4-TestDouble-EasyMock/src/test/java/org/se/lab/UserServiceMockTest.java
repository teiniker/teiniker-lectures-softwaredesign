package org.se.lab;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


/*
 * These test cases use the PersonService object as an Object Under Test.
 * 
 * Note that the PersonService implementation uses the faked UserDAO
 * implementation, thus, only the UserService code is tested.
 */
public class UserServiceMockTest 
{   
    @Test
    public void testAddPerson()
    {
    	// Configure mock object
    	UserDAO mock = createMock(UserDAO.class);
        User p = new User(7, "Egon");        
        mock.insert(p);
        replay(mock);
        UserService service = new UserService(mock);     	

        // Run test case
    	User user = new User(7, "Egon");
        service.addUser(user);
        
        // Verify mock interactions 
        verify(mock);        
    }

    @Test
    public void testToCsv()
    {
    	// Configure mock object
    	UserDAO mock = createMock(UserDAO.class);
        User p = new User(7, "Egon");        
        expect(mock.findById(7)).andReturn(p);
        replay(mock);
        UserService service = new UserService(mock);     	
        
        // Run test case
        String csv = service.toCSV(7);
        assertEquals("7,Egon", csv);
        
        // Verify mock interactions
        verify(mock);
    }    
}
