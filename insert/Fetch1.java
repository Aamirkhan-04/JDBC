package com.insert;

import java.sql.*;

public class Fetch1 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
	PreparedStatement ps=con.prepareStatement("select * from register");
	ResultSet rs=ps.executeQuery();
	
	System.out.println("----------------------------------");
	
	while(rs.next()) {
		
		String name=rs.getString("name");
		System.out.println("Name: "+ name);
		
		String email=rs.getString("email");
		System.out.println("Email: "+email);
		
		String password=rs.getString("password");
		System.out.println("Password: "+password);
		
		String gender=rs.getString("gender");
		System.out.println("Gender: "+gender);
		
		String city=rs.getString("city");
		System.out.println("City: "+city);
		
		System.out.println("--------------------------------------");
	}
	con.close();
   }
 }
