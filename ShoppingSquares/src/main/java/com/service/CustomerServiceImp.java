package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDao;
import com.model.Customer;
import com.model.Login;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerDao dao;
	
	public String register(Customer c)
	{
		int count = dao.register(c);
		String msg = null;
		if(count == 0)
		{
			msg = "failure";
		}
		else {
			msg = "success";
		}
		return msg;
	}
	@Override
	public Customer validateCustomer(Login login) {
		return dao.validateCustomer(login);
	}
}
