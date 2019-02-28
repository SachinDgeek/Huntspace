package com.yammizzaa.fooddelivery.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yammizzaa.fooddelivery.dao.DriverDAO;
import com.yammizzaa.fooddelivery.model.Driver;
import com.yammizzaa.fooddelivery.model.OrederFood;

//Driver Service implementation class which will not be given to the clients
//@Service used for automatic bean detection using class path
@Service
public class DriverServiceImpl implements DriverService
{
	// @Autowired used to automatic class dependency injection through spring bean configuration file
	@Autowired
	DriverDAO driverDAO;

	// @Transactional helps to interact with the database
	@Transactional
	public void adddriver(Driver driver) {
		driverDAO.adddriver(driver);

	}

	@Transactional
	public List<Driver> driverlist() {

		return driverDAO.driverlist();
	}

	public String checkdriverCredentials(Driver driver) {
		return driverDAO.checkDriverCredentials(driver);
	}

	public Driver getDriverByemail(String email)
	{
		return driverDAO.getdriverbyemail(email) ;
	}

	public String driverdelete(Integer id) {
		return driverDAO.deletedriver(id);
		
	}

	public List<Driver> Availabledriverlist() {
		return driverDAO.Availabledrivers();
	}

	public List<OrederFood> assigneddriverget(long phone) {
		 return driverDAO.assigneddriverget(phone);
		
	}

	
	
	
}
