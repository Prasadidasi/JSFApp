package com.jsfapp.login;

import java.sql.*;

public class DBLogin {
	public static boolean validate(String name, String pass){
		Boolean status=false;
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Webapp", "root", "");
			PreparedStatement ps = conn.prepareStatement("Select * from login where name like ('" + name +"') and password like ('" + pass +"')");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				status = true;
		} catch (SQLException ex){
		  ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		 } finally {
		 try {
		      conn.close(); 
		    } catch (Exception e) {
		     /*Stuff No one Cares about*/
		    }
		 }
		return status;
	}
}
