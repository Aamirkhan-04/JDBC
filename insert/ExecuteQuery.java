package com.insert;

import java.sql.*;

public class ExecuteQuery{
public static void main(String[] args) throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");	
	Statement st=con.createStatement();
	int row =st.executeUpdate("insert into employee values(1,'Aamir')");
//	ResultSet r s=st.executeQuery("select * from employee");
//	while(rs.next()) {
//		System.out.println(rs.getInt("emp_is")+"\t"+rs.getString("emp_name"));
//	} 
	System.out.println(row + " Row inserted");
	con.close();
}
}