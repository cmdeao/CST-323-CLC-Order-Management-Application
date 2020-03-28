package com.gcu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * UserDao class.
 * @author Cameron Deao & John Harrison
 *
 */
public class UserDao
{
	//Global variables to be used within this Java Class.
    JdbcTemplate template;
    Logger logger = LoggerFactory.getLogger(UserDao.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	/**
	 * setTemplate() - Establishing the template variable.
	 * @param template
	 */
    public void setTemplate(JdbcTemplate template)
    {
        this.template = template;
    }

    //Methods to insert, update, delete, and retrieve data from the database.
    //Methods utilize SQL statements to insert and retrieve updated information.
    /**
     * save() - stores data within the database.
     * @param user
     * @return
     */
    public int save(User user)
    {
    	logger.debug("Successfully registered and stored " + user.getUsername() + " Timestamp: " + sdf.format(timestamp));
        String sql = "INSERT INTO CST323.users(first_name, last_name, email, phone_number, username, password) values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmailAddress()+"','"+user.getPhoneNumber()+"','"+user.getUsername()+"','"+user.getPassword()+"');";
        return template.update(sql);
    }

    /**
     * getUserByID() - retrieves user by specific ID.
     * @param id
     * @return
     */
    public User getUserByID(int id)
    {
        String sql = "SELECT * FROM CST323.users WHERE id='"+id+"'";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
    }

    /**
     * authenticateUser() - retrieves entire table of user data.
     * @return
     */
    public List<User> authenticateUser()
    {
    	String sql = "SELECT * FROM CST323.users";
    	return template.query(sql,  new RowMapper<User>() {
    		public User mapRow(ResultSet resultSet, int i) throws SQLException{
    			User user = new User();
    			user.setId(resultSet.getInt(1));
    			user.setFirstName(resultSet.getString(2));
    			user.setLastName(resultSet.getString(3));
    			user.setEmailAddress(resultSet.getString(4));
    			user.setPhoneNumber(resultSet.getInt(5));
    			user.setUsername(resultSet.getString(6));
    			user.setPassword(resultSet.getString(7));
    			return user;
    		}
    	});
    }
}
