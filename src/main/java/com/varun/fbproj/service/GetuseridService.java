package com.varun.fbproj.service;

import java.sql.*;

import com.varun.fbproj.model.User;

public class GetuseridService {

	public static int getidService(String emailID)
	{
		
		
		try {

      	  DBAccess connect = new DBAccess();
            boolean check=false;
            while(check==false)
            {
            	check=connect.start();
            	System.out.println("trying connection for login");
            }
            
			PreparedStatement prepStatement = connect.con.prepareStatement("select userID from User where emailID = ? ");
			prepStatement.setString(1,emailID);
			

			ResultSet result = prepStatement.executeQuery();
			if (result != null) {
				while (result.next()) {
					
					return result.getInt("userID");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return 0;
        
    }//method ends here
	
}
