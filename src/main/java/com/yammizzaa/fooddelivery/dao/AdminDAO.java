package com.yammizzaa.fooddelivery.dao;

import java.util.List;

import com.yammizzaa.fooddelivery.model.Admin;


public interface AdminDAO {
	public void addadmin(Admin admin);

	public List<Admin> adminlist();

	public String checkAdminCredentials(Admin admin);
}
