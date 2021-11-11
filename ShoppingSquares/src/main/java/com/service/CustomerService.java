package com.service;

import com.model.Customer;
import com.model.Login;

public interface CustomerService {

	String register(Customer c);
	Customer validateCustomer(Login login);
}
