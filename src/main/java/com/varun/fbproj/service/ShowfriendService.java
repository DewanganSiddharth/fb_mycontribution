package com.varun.fbproj.service;

import java.sql.*;

import com.varun.fbproj.model.FriendClass;
import com.varun.fbproj.model.User;

public class ShowfriendService {

	public static FriendClass showService(String  uid)
	{
		FriendClass u1 = new FriendClass();
		
		try {

      	  DBAccess connect = new DBAccess();
            boolean check=false;
            while(check==false)
            {
            	check=connect.start();
            	System.out.println("trying connection for login");
            }
            
			PreparedStatement prepStatement = connect.con.prepareStatement("select myID,friendID,status from userFriends where friendID = ? ");
			prepStatement.setString(1,uid);
			
			System.out.println();

			ResultSet result = prepStatement.executeQuery();
			if (result != null) {
				while (result.next()) {
					
						/*System.out.println("Name Found");
						System.out.println("friend name is: "+result.getString("fname"));
						*///con.close();
						
						u1.setUserid(result.getInt("myID"));
						u1.setFriendid(result.getInt("friendID"));
						u1.setStatus(result.getString("status"));
						
						if(u1.getStatus().equals("pending"))
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
