package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestRestaurant {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		 Connection con=null;
		 PreparedStatement ptmt=null;
		 ResultSet rs=null;
		 Class.forName("com.mysql.jdbc.Driver");
		 
		   con=DriverManager.getConnection("jdbc:mysql://localhost/j30group","root","Komal123@");
		   
		   if(con==null)
			   System.out.println("Connection not establish");
		   else
			   System.out.println("Connection  establish");
		   
		  String s="create table restaurant(id int primary key auto_increment,name varchar(20),foodtype varchar(30),foodcost int)";
		   ptmt=con.prepareStatement(s);
		  //ptmt.executeUpdate();
		   //System.out.println("Table created");
		   
		   String s1="insert into restaurant values(?,?,?,?)";
			ptmt=con.prepareStatement(s1);
			
			System.out.println("Enter id,name,foodtype,foodcost");
			int id=new Scanner(System.in).nextInt();
			String name=new Scanner(System.in).next();
			String foodtype=new Scanner(System.in).next();
			int foodcost=new Scanner(System.in).nextInt();
			
			ptmt.setInt(1,id);
			ptmt.setString(2,name);
			ptmt.setString(3,foodtype);
			ptmt.setInt(4,foodcost);
			
			ptmt.executeUpdate();
			System.out.println("values insert");
			
			rs=ptmt.executeQuery("select * from restaurant");
			
			System.out.println("Second Higest:");
			rs=ptmt.executeQuery("select id,name,foodtype,foodcost from restaurant where foodcost=(select MAX(foodcost)from restaurant where(foodcost<(select MAX(foodcost)from restaurant)));");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			
		 }
	
	}


