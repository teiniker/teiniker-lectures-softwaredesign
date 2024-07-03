package org.se.lab;


public class UserService
{
	/*
	 * Constructor
	 */
	public UserService(UserDAO userDAO)
	{
		setUserDAO(userDAO);
	}

	
	/*
	 * Dependency: userDao:UserDAO
	 */
	private UserDAO userDAO;
    public void setUserDAO(UserDAO userDAO) 
    {
		this.userDAO = userDAO;
	}

    
    /*
     * Business Methods
     */


    public void addUser(User p)
    {
        try
        {
            userDAO.insert(p);
        }
        catch(DAOException e)
        {
            throw new ServiceException("Can't insert user!", e);
        }
    }

	public String toXml(int id)
    {
        try
        {
            User user = userDAO.findById(id);
            return convertUser2Xml(user);
        }
        catch(DAOException e)
        {
            throw new ServiceException("Can't generate XML string!", e);
        }
    }

    private String convertUser2Xml(User user)
    {
        if(user == null)
            return "";
        StringBuilder xml = new StringBuilder();
        xml.append("<user>");
        xml.append("<id>").append(user.getId()).append("</id>");
        xml.append("<name>").append(user.getUsername()).append("</name>");
        xml.append("<password>").append(user.getPassword()).append("</password>");
        xml.append("</user>");
        return xml.toString();
    }
}
