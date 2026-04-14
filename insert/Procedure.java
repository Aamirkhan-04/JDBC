package com.insert;
import java.sql.*;

public class Procedure {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");	
		CallableStatement cs=con.prepareCall("{call getEmployee()}");
		ResultSet rs= cs.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
		} 
		System.out.println("Success");
   con.close();
}
}