package com.yammizzaa.fooddelivery.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Driver")
public class Driver 
{
  @Id
  @GenericGenerator(name="generator", strategy="increment")
  @GeneratedValue(generator="generator")
  @Column(name="driver_id")
  private Integer id;
  
  @Column(name="name")
  private String name;
  
  @Column(name="phone",unique=true)
  private long phone;
  
  @Column(name="Orderstatus")
  private String orderstatus;
  
  public String getOrderstatus() {
	return orderstatus;
}

public void setOrderstatus(String orderstatus) {
	this.orderstatus = orderstatus;
}

@Column(name="email",unique=true)
  private String email;
  
  @Column(name="password")
  private String password;
  
  @Column(name="VehicleNumber")
  private Integer vehiclenumber;
  
  @Column(name="LicenseNumber")
  private Integer licensenumber;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public long getPhone() {
	return phone;
}

public void setPhone(long phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}



public Integer getLicensenumber() {
	return licensenumber;
}

public void setLicensenumber(Integer licensenumber) {
	this.licensenumber = licensenumber;
}


public Integer getVehiclenumber() {
	return vehiclenumber;
}

public void setVehiclenumber(Integer vehiclenumber) {
	this.vehiclenumber = vehiclenumber;
}



public Driver(Integer id, String name, long phone, String orderstatus, String email, String password,
		Integer vehiclenumber, Integer licensenumber) {
	super();
	this.id = id;
	this.name = name;
	this.phone = phone;
	this.orderstatus = orderstatus;
	this.email = email;
	this.password = password;
	this.vehiclenumber = vehiclenumber;
	this.licensenumber = licensenumber;
}

public Driver() {
	super();
	
}
  
  
  
}
