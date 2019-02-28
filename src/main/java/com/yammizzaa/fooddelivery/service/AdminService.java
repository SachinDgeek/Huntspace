package com.yammizzaa.fooddelivery.service;

import java.util.List;

import com.yammizzaa.fooddelivery.model.Admin;

//Service class used by the clients to interact with the functionality of the application
//Interface is used just to show the functionality not the implementation to the clients
public interface AdminService
{
  //abstract methods called from the Admin controller class
  public void adminadd(Admin admin);
  
  public List<Admin> adminList();
  
  public String checkAdminCredentials(Admin admin);
}
