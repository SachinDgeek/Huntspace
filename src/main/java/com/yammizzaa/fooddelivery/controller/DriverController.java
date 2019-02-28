package com.yammizzaa.fooddelivery.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yammizzaa.fooddelivery.model.Driver;
import com.yammizzaa.fooddelivery.model.OrederFood;
import com.yammizzaa.fooddelivery.service.DriverService;


//controller Driver class which gathers the input and execute the request related action method

@RestController
@RequestMapping(value="/driver")
public class DriverController
{
	//@Autowired used to automatic class dependency injection through spring bean configuration file
	@Autowired
	DriverService driverservice;
	
	//request method to add the Driver details into the Driver table in database
	@RequestMapping(value = "/driveradd",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void driverAdd(@RequestBody Driver driver){
		driverservice.adddriver(driver);
	}
	
	//request method to view Driver details from the Driver table in database
	@RequestMapping(value ="/driverget",method = RequestMethod.GET)
	public List<Driver> driverList(){
		return driverservice.driverlist();
	}
	
	//request method to check Driver credentials entered are correct or not to login into application	
	@RequestMapping(value = "/drivercheck", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public String drivercheck(@RequestBody Driver driver)
	{
		return driverservice.checkdriverCredentials(driver);
	}
		  
	//request method to get particular Driver details by providing email
	@RequestMapping(value="/drivergetbyemail",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Driver drivergetbyemail(@RequestParam("email") String email) {
		return driverservice.getDriverByemail(email);
	}
		
	// request method to delete the Driver details into the Driver table in database
	@RequestMapping(value = "/driverdelete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteDriver(@RequestBody Driver driver) {
		return driverservice.driverdelete(driver.getId());
	}
	
	// request method to get available Drivers details from the Driver table in database
	 @RequestMapping(value = "/driverAvailabileGet", method = RequestMethod.GET)
	public List<Driver> Availabledriver() {
		return driverservice.Availabledriverlist();
	}
	 
	//request method to get the Driver details into the Driver table in database
	@RequestMapping(value = "/assigneddriverget", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<OrederFood> assigneddriverget(@RequestBody Driver driver) {
		return driverservice.assigneddriverget(driver.getPhone());
	}
  
}
