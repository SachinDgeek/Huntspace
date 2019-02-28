package com.yammizzaa.fooddelivery.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yammizzaa.fooddelivery.dao.AdminDAO;
import com.yammizzaa.fooddelivery.model.Admin;

//Admin Service implementation class which will not be given to the clients
//@Service used for automatic bean detection using class path
@Service
public class AdminServiceImpl implements AdminService
{
	//@Autowired used to automatic class dependency injection through spring bean configuration file
	@Autowired
	  AdminDAO adminDAO;
	
	//@Transactional helps to interact with the database
	@Transactional
	public void adminadd(Admin admin) {
	 adminDAO.addadmin(admin);	
		
	}

	
	@Transactional
	public List<Admin> adminList() {
		
		return adminDAO.adminlist();
	}

	
	public String checkAdminCredentials(Admin admin) 
	{
		 return adminDAO.checkAdminCredentials(admin);
	
	}
}
