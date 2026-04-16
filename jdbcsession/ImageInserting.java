package com.jdbcsession;

import java.io.*;
import java.sql.*;

public class ImageInserting {
public static void main ( String [ ] args) throws ClassNotFoundException, SQLException, IOException {
	String username="root";
	String password="root";
	String url="jdbc:mysql://localhost:3306/bank_account";
	String query="insert into account_image (Image) values(?)";
	String driver="com.mysql.cj.jdbc.Driver";
	String image_path="C:\\Users\\DELL\\Pictures\\Camera Roll\\Aamir.jpeg";
	
	Class.forName(driver);
	Connection con=DriverManager.getConnection(url, username, password);
	
	FileInputStream stream=new FileInputStream(image_path);
	byte[] imagedata=new byte[stream.available()];
	stream.read(imagedata);
	
	PreparedStatement ps=con.prepareStatement(query);
	ps.setBytes(1, imagedata);
	ps.executeUpdate();
	System.out.println("Image Inserted");
	
	con.close();
	stream.close();
	
   }
 }
