package com.insert;

import java.sql.*;

public class BatchProcessing {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
		Statement st=con.createStatement();
		st.addBatch("insert into employee values(2,'Altamash')");
		st.addBatch("insert into employee values(3,'Moiez')");
		st.addBatch("insert into employee values(4,'Aftab')");
		st.addBatch("insert into employee values(5,'Umair')");
		st.executeBatch();
		System.out.println("Batch executed");
		con.close();
}
}