package com.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCallable {

	public static void main(String[] args)throws SQLException, ClassNotFoundException {
		Connection con=null;
		CallableStatement cst=null,cst1=null;
		ResultSet rs=null;

	     Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/j30group","root","Komal123@");
		
		System.out.println(DriverManager.getDriver("jdbc:mysql://localhost/j30group"));
		if(con==null)
			System.out.println("connection not established");
		else
			System.out.println("connection  established");
		/*
		String s="create table Book(Bid int primary key auto_increment,Bname varchar(20),Bcost int)";
		stmt=con.createStatement();
		//stmt.executeUpdate(s);
		//System.out.println("Table created");
		
		String s1="insert into Book(Bid,Bname,Bcost)values(3,'Garudpuran',40000)";
		//stmt.executeUpdate(s1);
		//System.out.println("Record inserted");

		rs=stmt.executeQuery("select Bid,Bname,Bcost from Book where Bcost=rs.getString(2)(select MAX(Bcost)from Book)");
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		rs=stmt.executeQuery("select * from Book");
		while(rs.next())
		{
			System.out.println(rs.getString(2));
	    }
*/
 
		cst=con.prepareCall("{call insertData(?,?,?)}");
		cst.setInt(1,8);
		cst.setString(2,"black book");
		cst.setInt(3,600);
		
		cst.executeUpdate();
	}

}
