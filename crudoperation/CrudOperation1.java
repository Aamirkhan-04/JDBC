package com.crudoperation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class CrudOperation1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String url = "jdbc:mysql://localhost:3306/college";
    static String username = "root";
    static String password = "root";
    static String driver = "com.mysql.cj.jdbc.Driver";

    static Connection con;
    static PreparedStatement ps;

    
    public static void insertRecord() throws Exception {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);

            String q = "insert into student(std_id, name, age) values(?,?,?)";
            ps = con.prepareStatement(q);

            System.out.print("Enter student id: ");
            ps.setString(1, br.readLine());

            System.out.print("Enter student name: ");
            ps.setString(2, br.readLine());

            System.out.print("Enter student age: ");
            ps.setString(3, br.readLine());

            ps.executeUpdate();
            System.out.println("Record Inserted Successfully");
        } finally {
            con.close();
        }
    }

    public static void updateRecord() throws Exception {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);

            String q = "update student set name=IFNULL(?, name), age=IFNULL(?, a	ge) where std_id=?";
            ps = con.prepareStatement(q);

            System.out.println("Do you want to update name? (yes/no): ");
            String op=br.readLine();
            
            if(op.equalsIgnoreCase("yes")) {
            System.out.print("Enter new name: ");
            ps.setString(1, br.readLine());
            }
            else {
            	ps.setNull(1, java.sql.Types.VARCHAR);
            }
            System.out.println("Do you want to update age? (yes/no): ");
            String choose=br.readLine();
            
            if(choose.equalsIgnoreCase("yes")) {
            	System.out.println("Enter new age: ");
            	ps.setInt(2, Integer.parseInt(br.readLine()));
            }
            else {
            	ps.setNull(2, java.sql.Types.INTEGER);
			}
            
            System.out.print("Enter student id: ");
            ps.setInt(3, Integer.parseInt(br.readLine()));

            ps.executeUpdate();
            System.out.println("Record Updated Successfully");
        } finally {
            if(con !=null)
            	con.close();
        }
    }

    public static void deleteRecord() throws Exception {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);

            System.out.print("Delete by (std_id/name/age): ");
            String choice = br.readLine();

            if (choice.equalsIgnoreCase("std_id")) {
                ps = con.prepareStatement("delete from student where std_id=?");
                System.out.print("Enter id: ");
                ps.setString(1, br.readLine());
            }
            else if (choice.equalsIgnoreCase("name")) {
                ps = con.prepareStatement("delete from student where name=?");
                System.out.print("Enter name: ");
                ps.setString(1, br.readLine());
            }
            else if (choice.equalsIgnoreCase("age")) {
                ps = con.prepareStatement("delete from student where age=?");
                System.out.print("Enter age: ");
                ps.setString(1, br.readLine());
            }
            else {
                System.out.println("Invalid option");
                return;
            }

            ps.executeUpdate();
            System.out.println("Record Deleted Successfully");
        } finally {
            con.close();
        }
    }

    public static void fetchRecords() throws Exception {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);

            ps = con.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();

            System.out.println("\nID\tNAME\tAGE");
            System.out.println("----------------------");

            while (rs.next()) {
           System.out.println(rs.getString("std_id") + "\t" + rs.getString("name") + "\t" + rs.getString("age"));
            }
        } finally {
            con.close();
        }
    }

   
    public static void autoRun() throws Exception {
            System.out.println("Choose option: insert / update / delete / fetch / exit");
            String op = br.readLine();

            
            switch (op.toLowerCase()) {
                case "insert": 
                	CrudOperation1.insertRecord(); 
                	break;
                case "update": 
                	CrudOperation1.updateRecord();
                    break;
                case "delete": 
                	CrudOperation1.deleteRecord(); 
                	break;
                case "fetch":  
                	CrudOperation1.fetchRecords(); 
                	break;
                case "exit":   
                	System.out.println("Thanks"); 
                	return;
                default: 
                	System.out.println(" Invalid option");
            }
           System.out.println("Would you like to continue with this operation? (Yes / No):");
           String st=br.readLine(); 
           if(st.equalsIgnoreCase("yes") | st.equalsIgnoreCase("y")) {
        	   CrudOperation1.autoRun();
           }
           else if (st.equalsIgnoreCase("no") | st.equalsIgnoreCase("n")) {
        	   System.out.println("Thank....");
		}
        }
    
    public static void main(String[] args) throws Exception {
    	CrudOperation1.autoRun();
    }
}