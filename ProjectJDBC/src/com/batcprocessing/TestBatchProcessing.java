package com.batcprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBatchProcessing {

	public static void main(String[] args) throws  SQLException,ClassNotFoundException {
		Connection con=null;
		Statement stmt=null,stmt1=null;
		ResultSet rs=null;

	     Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/j30group","root","Komal123@");
		
		System.out.println(DriverManager.getDriver("jdbc:mysql://localhost/j30group"));
		if(con==null)
			System.out.println("connection not established");
		else
			System.out.println("connection  established");
	/*	
		stmt=con.createStatement();
		String s1="insert into employee3(ename,salary)values('jay',7000)";
		stmt.addBatch(s1);
		
		String s2="insert into employee3(ename,salary)values('sanjay',8000)";
		stmt.addBatch(s2);
		
		String s3="insert into employee3(ename,salary)values('vijay',9000)";
		stmt.addBatch(s3);
		
		stmt.executeBatch();
*/
		
		con.setAutoCommit(false);
		Statement stmt2=con.createStatement();
		stmt2.executeUpdate("insert into employee3 values(8,'shahil',4000)");
		stmt2.executeUpdate("insert into employee3 values(9,'sayali',5000)");
		
		con.commit();
	}
}
