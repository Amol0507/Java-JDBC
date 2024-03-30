package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class testPreparedStatement {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		 Connection con=null;
		 PreparedStatement ptmt=null;
		 ResultSet rs=null;
		 Class.forName("com.mysql.jdbc.Driver");
		 try {
		   con=DriverManager.getConnection("jdbc:mysql://localhost/j30group","root","Komal123@");
		   
		   if(con==null)
			   System.out.println("Connection not establish");
		   else
			   System.out.println("Connection  establish");
		   
		  String s="create table Customers1(id int primary key auto_increment,name varchar(20),amount int)";
		   //ptmt=con.prepareStatement(s);
		 //  ptmt.executeUpdate();
		  // System.out.println("Table created");
		   
		   String s1="insert into Customers1 values(?,?,?)";
			ptmt=con.prepareStatement(s1);
			
			System.out.println("Enter id,name,amount");
			int id=new Scanner(System.in).nextInt();
			String name=new Scanner(System.in).next();
			int amount=new Scanner(System.in).nextInt();
			
			ptmt.setInt(1,id);
			ptmt.setString(2,name);
			ptmt.setInt(3,amount);
			
			ptmt.executeUpdate();
		 /*
		  *  
		  String s2="update Customers1 set name=? where id=?";
		  ptmt=con.prepareStatement(s2);
		  
		  ptmt.setString(1,"Mayank");
		  ptmt.setInt(2,101);
		  
		  ptmt.executeUpdate();
		  System.out.println("update name and id");
		  
		  */
		  /*
		  String s3="delete from Customers1 where id=?";
		  ptmt=con.prepareStatement(s3);
		  
		  ptmt.setInt(1,101);
		  ptmt.executeUpdate();
		  System.out.println("record delete");
			*/
		  ptmt=con.prepareStatement("select * from Customers1");
		  rs=ptmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
					
		  
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 finally {
			 con.close();
		 }

	}

}
