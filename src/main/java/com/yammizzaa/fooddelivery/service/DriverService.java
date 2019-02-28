package com.yammizzaa.fooddelivery.service;

import java.util.List;

import com.yammizzaa.fooddelivery.model.Driver;
import com.yammizzaa.fooddelivery.model.OrederFood;


//Service class used by the clients to interact with the functionality of the application
//Interface is used just to show the functionality not the implementation to the clients
public interface DriverService 
{
	//abstract methods called from the Driver controller class
	public void adddriver(Driver driver);

	public List<Driver> driverlist();

	public String checkdriverCredentials(Driver driver);

	public Driver getDriverByemail(String email);

	public String driverdelete(Integer id);

	public List<Driver> Availabledriverlist();

	public List<OrederFood> assigneddriverget(long phone);

}
