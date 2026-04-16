package com.jdbcsession;

import java.sql.*;

public class TransactionHandling {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/bank_account";
		String user = "root";
		String password = "root";

		Connection con = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);

		con.setAutoCommit(false);

		Statement stmt = con.createStatement();
		try {
			stmt.executeUpdate("INSERT IGNORE INTO account VALUES (1, 'Aamir', 2000)");
			stmt.executeUpdate("INSERT IGNORE INTO account VALUES (2, 'Rahul', 1000)");

			String debitQuery = "UPDATE account SET balance = balance - ? WHERE id=?";

			String creditQuery = "UPDATE account SET balance = balance - ? WHERE id=?";

			PreparedStatement debit = con.prepareStatement(debitQuery);
			debit.setDouble(1, 500);
			debit.setInt(2, 1);

			PreparedStatement credit = con.prepareStatement(creditQuery);
			credit.setDouble(1, 500);
			credit.setInt(2, 2);

			debit.executeUpdate();
			credit.executeUpdate();

			con.commit();
			System.out.println("Transaction Successful");

		} catch (Exception e) {
			con.rollback();
			System.out.println("Transaction Failed");

		}

	}
}