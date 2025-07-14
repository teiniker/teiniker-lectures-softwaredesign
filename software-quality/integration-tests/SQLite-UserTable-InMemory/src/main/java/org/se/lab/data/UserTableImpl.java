package org.se.lab.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class UserTableImpl 
	implements UserTable
{
	private final Logger logger = Logger.getLogger(UserTableImpl.class);

	// Constructor
	public UserTableImpl(Connection connection)
	{
		logger.debug("UserDAOImpl(" + connection + ")");
		setConnection(connection);
	}

	// Dependency: ---[1]-> connection:Connection
	private Connection connection;
	protected final Connection getConnection()
	{
		return connection;
	}
	public final void setConnection(final Connection connection)
	{
		if (connection == null)
			throw new IllegalArgumentException("connection");
		this.connection = connection;
	}

	// DAO operations

	public void insert(User user)
	{
		logger.debug("insert(" + user + ")");
		
		if (user == null)
			throw new IllegalArgumentException();

		final String SQL = "INSERT INTO user (firstname, lastname, username, password) VALUES (?,?,?,?)";
		logger.debug("SQL> " + SQL);

		try (PreparedStatement pstmt = getConnection().prepareStatement(SQL))
		{
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			throw new TableException("insert failure", e);
		} 
	}

	public void update(User user)
	{
		logger.debug("update(" + user + ")");
		
		if (user == null)
			throw new IllegalArgumentException();

		final String SQL = "UPDATE user SET firstname=?, lastname=?, "
				+ "username=?, password=? WHERE id=?";
		logger.debug("SQL> " + SQL);

		try (PreparedStatement pstmt = getConnection().prepareStatement(SQL))
		{
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.setLong(5, user.getId());
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			throw new TableException("Can't update User!", e);
		} 
	}

	
	public void delete(User user) 
	{
		logger.debug("delete(" + user + ")");
		
		final String SQL = "DELETE FROM user WHERE ID = ?";
		logger.debug("SQL> " + SQL);

		try (PreparedStatement pstmt = getConnection().prepareStatement(SQL))
		{
			pstmt.setLong(1, user.getId());
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			throw new TableException("Can't delete User!", e);
		} 
	}

	public User findById(int id) 
	{
		logger.debug("findById(" + id + ")");
		
		final String SQL = "SELECT * FROM user WHERE id=? ";
		logger.debug("SQL> " + SQL);

		// When a Statement object is closed, its current ResultSet object,
		// if one exists, is also closed.
		try (PreparedStatement pstmt = getConnection().prepareStatement(SQL))
		{
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		}
		catch (SQLException e)
		{
			throw new TableException("Can't find User", e);
		} 
	}

	
	public List<User> findAll()
	{
		logger.debug("findAll()");
		
		final String SQL = "SELECT * FROM user";
		logger.debug("SQL> " + SQL);

		try (Statement stmt = getConnection().createStatement())
		{
			ResultSet rs = stmt.executeQuery(SQL);
			List<User> users = new ArrayList<>();
			while (rs.next())
			{
				int id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String username = rs.getString("username");
				String password = rs.getString("password");
				User user = new User();
				user.setId(id);
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setUsername(username);
				user.setPassword(password);
				users.add(user);
			}
			return users;
		} 
		catch (SQLException e)
		{
			throw new TableException("Can't find any User!", e);
		}
	}

	public User createUser(String firstName, String lastName, String username, String password)
	{
		User u = new User();
		u.setFirstname(firstName);
		u.setLastname(lastName);
		u.setUsername(username);
		u.setPassword(password);		
		insert(u);
		// TODO: Read created id from database.
		return u;
	}
}
