package com.yammizzaa.fooddelivery.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Restaurant")
public class Restaurant 
{
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "restaurant_id")
	private Integer R_id;

	
	@Column(name = "name",unique=true)
	private String name;


	@Column(name = "phone")
	private long phone;

	public List<Product> getProductList() {
		return productList;
	}

	public Restaurant(Integer r_id, String name, long phone, String address, Integer price, String image,
			List<Product> productList) {
		super();
		this.R_id = r_id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.price = price;
		this.image = image;
		this.productList = productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Column(name = "address")
	private String address;

	@Column(name = "price")
	private Integer price;

	@Column(name = "image")
	private String image;

	@OneToMany(mappedBy = "restaurant")
	private static List<Product> productList;

	public Restaurant() {
		super();

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
	// private List<Product> productList;

	public Integer getR_id() {
		return R_id;
	}

	public void setR_id(Integer r_id) {
		this.R_id = r_id;
	}

	

}
