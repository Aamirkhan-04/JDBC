package com.updatedelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Update1 {
public static void main(String[] args) throws Exception{
	//String city1="Uran";
	//String password="Arman13@";
	String email1="armamkh@gmail.com";
	String name="Arman";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
	PreparedStatement ps=con.prepareStatement("update register set email=? where name=?");
	
	ps.setString(1, email1);
	ps.setString(2, name);
	
	int count=ps.executeUpdate();
	if(count >0) {
		System.out.println("Updated Succcessfully");
	}
	else {
		System.out.println("Updation Failed");
	}
	
}
}
