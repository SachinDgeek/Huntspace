package com.yammizzaa.fooddelivery.dao;

import java.util.List;
import java.util.Map;

import com.yammizzaa.fooddelivery.model.Driver;
import com.yammizzaa.fooddelivery.model.OrederFood;

public interface DriverDAO
{
	public void adddriver(Driver driver);

	public List<Driver> driverlist();

	public String checkDriverCredentials(Driver driver);

	public Driver getdriverbyemail(String email);

	public String deletedriver(Integer id);

	public List<Driver> Availabledrivers();

	public List<OrederFood> assigneddriverget(long phone);

}
