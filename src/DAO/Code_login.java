package DAO;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java .sql.ResultSet;
import java.sql.DriverManager;
public class Code_login {

	public static Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public static  Connection getConnection() throws ClassNotFoundException{
		  try {
			  
			  System.out.println("conn");
	            Class.forName("com.mysql.cj.jdbc.Driver");
	             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionbancaire", "root", "ameni123");

	          } 
		  catch ( SQLException e) {
	        	System.out.println("s"+e);
	        } return con;
	
	     }
}