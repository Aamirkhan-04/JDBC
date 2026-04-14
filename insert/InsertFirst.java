package com.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertFirst {
	public static void main(String[] args) throws Exception {
		
		String name1="Aamir";
		String email1="aamirkhan@12678gmail.com";
		String password1="khanaamir@1";
		String gender="Male";
		String city="Up";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "root");
		
		//PreparedStatement ps=con.prepareStatement("insert into register values('Aamir','aamirkhan@134gmail.com','Khanaamir','Male','Mumbai')");
		
		PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
	     
		ps.setString(1, name1);
	     ps.setString(2, email1);
	     ps.setString(3, password1);
	     ps.setString(4, gender);
	     ps.setString(5, city);
		int i=ps.executeUpdate();
		 if(i>0) {
			 System.out.println("success");
		 }
		 else {
			System.out.println("fail");
		}
	
	}

}
