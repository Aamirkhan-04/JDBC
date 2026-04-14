package com.updatedelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete1 {
public static void main(String[] args) throws Exception{
	String email="aamirkhan@134gmail.com";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
	PreparedStatement ps=con.prepareStatement("delete from register where email=?");
	ps.setString(1, email);
	int count =ps.executeUpdate();
	
	if(count>0) {
	 System.out.println("Deleted Successfully");
	}
	else {
		System.out.println("Deletion Failed");
	}
}
}
