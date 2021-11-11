package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartDao;
import com.model.Product;
import com.model.Shipping;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	public  CartDao cartDao;
	@Override
	public int insertCart(String supplier_id, String username) {
		// TODO Auto-generated method stub
		return cartDao.insertCart(supplier_id, username);
	}
	@Override
	public int getCount(String username) {
		
		return cartDao.cartCount(username);
	}
	@Override
	public List<Product> getUserProducts(String username) {
		return cartDao.getUserCartInfo(username);
	}

	@Override
	public int getTotalAmount(String username) {
		// TODO Auto-generated method stub
		return cartDao.getTotalAmount(username);
	}
	
	@Override
	public int save(String username, Shipping shipping) {
		// TODO Auto-generated method stub
		return cartDao.saveCustomerAddress(username, shipping);
	}
	
	@Override
	public int remove(String sid) {
		// TODO Auto-generated method stub
		return cartDao.removeItem(sid);
	}
	public int getCartCount(String username)
	{
		return cartDao.getCartCount(username);
	}
}
