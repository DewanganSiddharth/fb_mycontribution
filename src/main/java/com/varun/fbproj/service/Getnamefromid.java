package com.varun.fbproj.service;

import java.sql.*;

import com.varun.fbproj.model.FriendClass;
import com.varun.fbproj.model.User;

public class Getnamefromid {

	public static User getnameService(int  uid)
	{
		User u1 = new User();
		
		try {

      	  DBAccess connect = new DBAccess();
            boolean check=false;
            while(check==false)
            {
            	check=connect.start();
            	System.out.println("trying connection for login");
            }
            
			PreparedStatement prepStatement = connect.con.prepareStatement("select fname,userID from User where userID = ? ");
			prepStatement.setInt(1,uid);
			
			System.out.println();

			ResultSet result = prepStatement.executeQuery();
			if (result != null) {
				while (result.next()) {
					
						/*System.out.println("Name Found");
						System.out.println("friend name is: "+result.getString("fname"));
						*///con.close();
						u1.setFname(result.getString("fname"));
						u1.setUserID(result.getInt("userID"));
						return u1;
						//System.out.println("cacacacacac"+u1.getFname());
						
						//System.out.println("YES");
					}
					
				
				}
			
		} catch (Exception e) {
System.out.println("exception "+e);		}
		
		
        return null;
    }//method ends here
	
}
