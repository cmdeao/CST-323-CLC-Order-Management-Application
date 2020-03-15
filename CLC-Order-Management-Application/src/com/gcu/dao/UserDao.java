package com.gcu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Model.Order;
import Model.User;


public class UserDao
{
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template)
    {
        this.template = template;
    }

    public int save(User user)
    {
        String sql = "INSERT INTO CST323.users(first_name, last_name, email, phone_number, username, password) values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmailAddress()+"','"+user.getPhoneNumber()+"','"+user.getUsername()+"','"+user.getPassword()+"');";
        return template.update(sql);
    }

    public User getUserByID(int id)
    {
        String sql = "SELECT * FROM CST323.users WHERE id='"+id+"'";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
    }

    public List<User> authenticateUser()
    {
    	String sql = "SELECT * FROM CST323.users";
    	return template.query(sql,  new RowMapper<User>() {
    		@Override
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
