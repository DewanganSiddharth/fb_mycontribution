package com.varun.fbproj.resource;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.POST;
import javax.xml.bind.DatatypeConverter;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import java.security.Key;
import java.util.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.*;
import com.varun.fbproj.model.FriendClass;
import com.varun.fbproj.model.User;
import com.varun.fbproj.service.Confirmfriendservice;
import com.varun.fbproj.service.Getnamefromid;
import com.varun.fbproj.service.GetuseridService;
import com.varun.fbproj.service.LoginService;
import com.varun.fbproj.service.LogoutService;
import com.varun.fbproj.service.PutFriendService;
import com.varun.fbproj.service.RetriveService;
import com.varun.fbproj.service.ShowfriendService;
import com.varun.fbproj.service.SignUpService;
import com.varun.fbproj.service.TokenService;
import com.varun.fbproj.service.UpdateService;
import com.varun.fbproj.service.svGetNameService;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
@WebService()
@Path("/getFriend")
public class sidvishufriendresource {
	
	
	
	@GET
    @Path("/getName/{name}")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
    public User userLogin(@PathParam ("name") String fname) throws JsonParseException, JsonMappingException, IOException{
	
		
		System.out.println("sakcndlkckds   "+fname);
		
		
		return svGetNameService.getNameService(fname);

	}//loginuser method ends here
	
	
	@POST
    @Path("/getuserid")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.TEXT_PLAIN})
    public int userID(String jwt) throws JsonParseException, JsonMappingException, IOException{
	
		
		System.out.println("Inside get userid resource");
		Claims claims = Jwts.parser().setSigningKey("secret".getBytes("UTF-8")).parseClaimsJws(jwt).getBody();
			    System.out.println("Subject: " + claims.getSubject());
			    System.out.println("Expiration: " + claims.getExpiration());
			  String emailID=claims.getSubject();
		
		
		return GetuseridService.getidService(emailID);

	}//loginuser method ends here
	
	
	@POST
    @Path("/putFriend")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
    public String userLogin(FriendClass obj) throws JsonParseException, JsonMappingException, IOException{
	
		if(PutFriendService.friendService(obj))
		{
			
	           return "success";
		}
		
		return "failure";

	}//log
	
	
	@POST
    @Path("/showrequest")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
    public User showRequest(String uid) throws JsonParseException, JsonMappingException, IOException{
	
		System.out.println("inside showrequest");
		
		FriendClass obj = ShowfriendService.showService(uid);
		System.out.println("after showfriendservice");
		if(obj!=null)
		{
			
			User u1 = Getnamefromid.getnameService(obj.getUserid());
			System.out.println("after getname service");
			System.out.println(u1.getFname());
			System.out.println(u1.getUserID());
	           return u1;
		}
		
		return null;

	}//log
	
	
	@POST
    @Path("/confirmrequest")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
    public String showRequest(FriendClass u1) throws JsonParseException, JsonMappingException, IOException{
	
		System.out.println("inside showrequest");
		
		boolean s = Confirmfriendservice.confirmService(u1);
		System.out.println("after showfriendservice");
		if(s == true)
		{
			
			   return "success";
		}
		
		return "failure";

	}//log
	
	
 


}//class ends here
