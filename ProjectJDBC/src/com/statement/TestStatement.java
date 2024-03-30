package com.statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TestStatement {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
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
		
		String s="create table employee3(id int primary key auto_increment,ename varchar(20),salary int)";
		stmt=con.createStatement();
		//stmt.executeUpdate(s);
		//System.out.println("Table created");
		
		String s1="insert into employee3(ename,salary)values('Sajay',600)";
		//stmt.executeUpdate(s1);
		//System.out.println("Record inserted");
		
		String s2="update employee3 set ename='sita' where id=1";
		//stmt.executeUpdate(s2);
		//System.out.println("Record updated");
		
		/*
		String s3="alter table employee3 drop column salary";
		stmt.executeUpdate(s3);
		System.out.println("Record delete");
		*/
		
		rs=stmt.executeQuery("select * from employee3");
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		
		
		stmt1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs=stmt1.executeQuery("select * from employee3");
		System.out.println("Reverse-----");
		rs.afterLast();
		while(rs.previous())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		System.out.println("-------");
		rs.absolute(2);
		System.out.println(rs.getInt(1)+" "+rs.getString(2));
	}

}
