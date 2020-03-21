package com.gcu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import Model.User;

public class DataAccessObject 
{	
	JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template)
	{
		System.out.println("SETTING THE TEMPLATE");
		this.template = template;
		if(this.template == null)
		{
			System.out.print("IT'S NULL");
		}
	}
	
	public int save(User user)
	{
		setTemplate(template);
		if(template == null)
		{
			System.out.println("FALSE");
		}
		else
		{
			System.out.println("TRUE");
		}
		String sql = "INSERT INTO cst-323.users(first_name, last_name, email, phone_number, username, passsword) "
				+ "values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmailAddress()+"','"+user.getPhoneNumber()+"','"
						+ ""+user.getUsername()+"','"+user.getPassword()+"');";
		System.out.println("TESTING SQL INJECTION:" + sql);
		return template.update(sql);
	}
	
	public void StoreUser(User user)
	{
		String url = "clc-order.commclm1m94c.us-east-2.rds.amazonaws.com";
		String uName = "admin";
		String password = "adminpassword";
		
		try 
		{
			Connection conn = DriverManager.getConnection(url, uName, password);
			
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String emailAddress = user.getEmailAddress();
			int phoneNumber = user.getPhoneNumber();
			String userName = user.getUsername();
			String userPass = user.getPassword();
			
			String query = "INSERT INTO app.users (first_name, last_name, email, phone_number, username, password)"
					+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement prepState = null;
			prepState = conn.prepareStatement(query);
			prepState.setString(1, firstName);
			prepState.setString(2, lastName);
			prepState.setString(3, emailAddress);
			prepState.setInt(4, phoneNumber);
			prepState.setString(5, userName);
			prepState.setString(6, userPass);
			prepState.executeUpdate();
			conn.close();
			System.out.println("Added to DB");
		} 
		catch (SQLException e) 
		{
			System.out.println("Failed to insert user into the database.");
			e.printStackTrace();
		}
	}
	
	
}
