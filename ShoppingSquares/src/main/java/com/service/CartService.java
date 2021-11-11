package com.service;

import java.util.List;

import com.model.Product;
import com.model.Shipping;

public interface CartService {

	int insertCart(String supplier_id,String username);
	int getCount(String username);
	List<Product> getUserProducts(String username);
	int getTotalAmount(String username);
	int save(String username, Shipping shipping);
	int remove(String sid);
	public int getCartCount(String username);
}
