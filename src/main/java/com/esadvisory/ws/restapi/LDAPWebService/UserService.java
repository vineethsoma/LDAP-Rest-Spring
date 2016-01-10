package com.esadvisory.ws.restapi.LDAPWebService;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.esadvisory.ws.dao.UserDaoImpl;
import com.esadvisory.ws.domain.User;

@Path("users")
public class UserService {

	ApplicationContext context = new ClassPathXmlApplicationContext("/resources/applicationContext.xml") ; 
	@Autowired
	UserDaoImpl userDao = (UserDaoImpl)context.getBean("userDao"); 
	
	@GET
	@Produces("text/plain")
	public String getAllUsers(){
		
		
		
		
		return "All Users" ; 
	}
	
	
	@GET
	@Path("{emplid}")
	@Produces("text/plain")
	public String getSpecificUser(@PathParam("emplid") String emplid){
		
		User user = userDao.findByPrimaryKey(emplid) ; 
		
		
		
	//	return "User with employeeID: " +emplid ; 
		return user.toString() ; 
		
		
	}
	
	
}
