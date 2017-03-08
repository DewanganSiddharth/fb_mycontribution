package com.varun.fbproj.service;

import java.sql.*;

import com.varun.fbproj.model.FriendClass;
import com.varun.fbproj.model.User;

public class Confirmfriendservice {

	public static boolean confirmService(FriendClass obj)
	{
		
		
		try {

      	  DBAccess connect = new DBAccess();
            boolean check=false;
            while(check==false)
            {
            	check=connect.start();
            	System.out.println("trying connection for login");
            }
            
            
            String query = "UPDATE userFriends SET "
            		+ "status='approved' where myID = ? and friendID = ?";
            
            
            PreparedStatement ps = connect.con.prepareStatement(query);
           
			ps.setInt(1,obj.getUserid());
			ps.setInt(2,obj.getFriendid());
            ps.executeUpdate();
            
            
          
            check=connect.stop();
            return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return false;
        
    }//method ends here
	
}
