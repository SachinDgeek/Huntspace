package com.yammizzaa.fooddelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="OrederFood")
public class OrederFood
{
	 @Id
     @GenericGenerator(name="generator", strategy="increment")
     @GeneratedValue(generator="generator")
     @Column(name="order_id")
     private Integer id;
	 
	 @Column(name="CustomerName")
	 private String customerName;
	 
	 @Column(name="CustomerAddress")
	 private String customerAddress;
	 
	 @Column(name="DriverId")
	 private Integer driverid;
	 
	@Column(name="phone")
	private long phone;


	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public OrederFood(Integer id, String customerName, String customerAddress, Integer driverid, long phone,
			String restaurantName, String restaurantAddress, Integer price, String status) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.driverid = driverid;
		this.phone = phone;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.price = price;
		this.status = status;
	}

	public Integer getDriverid() {
		return driverid;
	}

	public void setDriverid(Integer driverid) {
		this.driverid = driverid;
	}

	

	@Column(name="RestaurantName")
	 private String restaurantName;
	 
	 @Column(name="RestaurantAddress")
	 private String restaurantAddress;
	 
	 public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="price")
	 private Integer price;
	 
	 @Column(name="status")
	 private String status;

	public OrederFood() {
		super();
	}

	
}
