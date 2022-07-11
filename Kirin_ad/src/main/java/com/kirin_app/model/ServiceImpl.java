package com.kirin_app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceImpl implements Service {
private Statement s;
	public void connectionDB() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kirin","root","Admysql*100");
	 s = c.createStatement();
		
	} catch (Exception e) {
				e.printStackTrace();
	}

	}

	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
			s.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = s.executeQuery("Select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return false;
	}
	public ResultSet listAllReg() {
		
		try {
			ResultSet result = s.executeQuery("Select * from registration ");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}
	public void deleteRegistration(String email) {
		
		try {
		s.executeUpdate("Delete from registration where email='"+email+"'");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
