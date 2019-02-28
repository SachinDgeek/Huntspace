  package com.yammizzaa.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yammizzaa.fooddelivery.model.Admin;
import com.yammizzaa.fooddelivery.service.AdminService;

//controller Admin class which gathers the input and execute the request related action method

@RestController
@RequestMapping(value="/admin")
public class AdminController 
{
	//@Autowired used to automatic class dependency injection through spring bean configuration file
	@Autowired
	AdminService adminservice;
	
	
	//request method to add the Admin details into the Admin table in database
	@RequestMapping(value = "/adminadd",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void adminadd(@RequestBody Admin admin){
		adminservice.adminadd(admin);
	}
	
	//request method to view Admin details from the Admin table in database
	@RequestMapping(value ="/adminget",method = RequestMethod.GET)
	public List<Admin> adminList(){
		return adminservice.adminList();
	}

	//request method to check Admin credentials entered are correct or not to login into application
	@RequestMapping(value = "/admincheck", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String admincheck(@RequestBody Admin admin) {
		return adminservice.checkAdminCredentials(admin);
	}
	
	
	
		  
}

