package com.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.model.Admin;
import com.model.AdminLogin;
import com.model.Category;
import com.model.Customer;
import com.model.Login;
import com.model.Product;

public interface CustomerDao {

	int register(Customer c);
	
	Customer validateCustomer(Login l);
	
	public Admin validateAdmin(AdminLogin login);
	
	List<Customer> getAllCustomer();
	
	int insertProducts(String supplier_id,int pid,String pTitle, String pDesc
	, double price 
	, double discount
	, double quantity 
	, String category
	,MultipartFile photo,
	String photo_name); 

	List<Category> listCategory();
	
	int addNewCategory(int cate_id, String category);
	
	int nextCate_id();

	List<Product> getAllProducts();

public int getCartCount(String username);

}
