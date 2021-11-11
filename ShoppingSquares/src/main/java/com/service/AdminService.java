package com.service;

import java.util.List;

import com.model.Admin;
import com.model.AdminLogin;
import com.model.Customer;

public interface AdminService {
	public Admin validateAdmin(AdminLogin lg);
	List<Customer> getAllEmployee();
	
}
