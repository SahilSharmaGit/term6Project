package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDao;
import com.model.Admin;
import com.model.AdminLogin;
import com.model.Customer;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	public CustomerDao dao;
	
	public Admin validateAdmin(AdminLogin login) {
		return dao.validateAdmin(login);
	}
	@Override
	public List<Customer> getAllEmployee() {
	
		return dao.getAllCustomer();
	}
}
