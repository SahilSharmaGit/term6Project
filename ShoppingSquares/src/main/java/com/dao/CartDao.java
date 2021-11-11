package com.dao;

import java.util.List;

import com.model.Product;
import com.model.Shipping;

public interface CartDao {

	int insertCart(String supplier_id, String username);
	int cartCount(String username);
	List<Product> getUserCartInfo(String username);
	int getTotalAmount(String username);
	int saveCustomerAddress(String username, Shipping shipping);
	int removeItem(String supplier_id);
	public int getCartCount(String username);
}
