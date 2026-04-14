package com.crudoperation;

import java.io.*;
import java.sql.*;

public class Crud {
  static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
  static String url="jdbc:mysql://localhost:3306/college";
  static String username="root";
  static String password="root";
  static String driver="com.mysql.cj.jdbc.Driver";
  static Connection con;
  static PreparedStatement ps;
  
  public static void insertRecord() throws Exception{
	 
	  try {
		  
		  Class.forName(driver);
		  con=DriverManager.getConnection(url, username, password);
		  String q="insert into student (std_id,name,age) values(?,?,?)";
		  ps=con.prepareStatement(q);
		  System.out.println("Enter student id: ");
		  ps.setString(1, br.readLine());
		  System.out.println("Enter student name: ");
		  ps.setString(2, br.readLine() );
		  System.out.println("Enter student age: ");
		  ps.setString(3,br.readLine());
		  ps.executeUpdate();
		  System.out.println("Record inserted SuccessFully");  
	  }
	  finally {
		con.close();
	}
  }
    public static void updateRecord() throws Exception{
    	try {
    	  Class.forName(driver);
   		  con=DriverManager.getConnection(url, username, password);
   		  String q="update student set name=? where std_id=?";
   		  ps=con.prepareStatement(q);
   		  System.out.println("Enter new Name: ");
   		  ps.setString(1,br.readLine());
   		  System.out.println("Enter student id: ");
   		  ps.setString(2, br.readLine());
   		  ps.executeUpdate();
   		  System.out.println("Record update SuccessFully");
    	}
    	finally {
			con.close();
		}
    }
    public static void  deleteRecord() throws Exception{
    	try {
    	Class.forName(driver);
     	con=DriverManager.getConnection(url, username, password);
     	System.out.println("Delete by(std_id/name/age): ");
     	String choice=br.readLine();
     	if(choice.equalsIgnoreCase("std_id")) {
     		ps=con.prepareStatement("delete from student where std_id=?");
     		System.out.println("Enter id: ");
     		ps.setString(1,br.readLine());
     	}
     	else if (choice.equalsIgnoreCase("name")) {
			ps=con.prepareStatement("delete from student where name=?");
			System.out.println("Enter name: ");
			ps.setString(1,br.readLine());
		}
     	else if (choice.equalsIgnoreCase("age")) {
			ps=con.prepareStatement("delete from student where age=?");
			System.out.println("Enter age: ");
			ps.setString(1,br.readLine());
		}
     	else {
			System.out.println("Invalid Option");
			return;
		}
     	ps.executeUpdate();
     	System.out.println("Record Deleted SuccessFully");
    	}
    	finally {
			con.close();
		}
	}
    public static void fetchRecord() throws Exception{
    	try {
    	Class.forName(driver);
        con=DriverManager.getConnection(url, username, password);
    		ps=con.prepareStatement("select * from student");
    		ResultSet rs =ps.executeQuery();
    		System.out.println("\nID\tNAME\tAGE");
    		System.out.println("----------------------");
    		while(rs.next()) {
    			System.out.println(rs.getString("std_id")+ "\t" +rs.getString("name") + "\t"+rs.getString("age"));
    		}
    	}
    	finally {
			con.close();
		}
    }
    public static void getAllRecord() throws Exception{
    	while(true) {
    	System.out.println("Choose option: insert / update / delete / fetch / exit");
    	String op =br.readLine();
    	
    	switch(op.toLowerCase()) {
    	case "insert" :
    		insertRecord();
    		break;
    	case "update" :
    		updateRecord();
    		break;
    	case "delete" :
    		deleteRecord();
    		break;
    	case "fetch" :
    		fetchRecord();
    		break;
    	case "exit" :
    		System.out.println("Thanks.....");
    		break;
    	default :
    			System.out.println("Invalid Option ");
    		
    	}
    }
}
    public static void main(String[] args) throws Exception {
		getAllRecord();
	}
}
