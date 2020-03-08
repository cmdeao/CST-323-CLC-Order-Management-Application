package com.gcu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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

}
