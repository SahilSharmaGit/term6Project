package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.Cart;
import com.model.Product;
import com.model.Shipping;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int insertCart(String supplier_id, String username) {
	
		System.out.println(jt +supplier_id+"   "+username);
		final String sql = "insert into cart(supplier_id,username) values(?,?)";
		return jt.update(sql, supplier_id,username);
	}
	
	
	public int getCartCount(String username) {
		
		final String sql = "select count(username) from cart where username = '"+username+"' and isdelivered is null";
		int count = jt.queryForObject(sql,Integer.class);
		System.out.println("Count************: "+count);
		return count;
	}

	@Override
	public int cartCount(String username) {
	
		final String sql = "select count(username) from cart where username = '"+username+"' and isdelivered = 'yes'";
	
		
		int count = jt.queryForObject(sql,Integer.class);
		System.out.println("Count************: "+count);
		return count;
	}


	@Override
	public List<Product> getUserCartInfo(String username) {
		
		final String sql1 = "select supplier_id from cart where username = '"+username+"'";// and isdelivered is null";
		RowMapper<Cart> rm = (rs, c)->
		{
			Cart cart = new Cart();
			cart.setSupplier_id(rs.getString(1));
			return cart;
		};
		List<Cart> list = jt.query(sql1,rm);
		String sql ="select * from products where supplier_id in (";
		String param = "";
		for(Cart c : list)
		{
			param = "'"+c.getSupplier_id()+"',"+param;
		}
		sql = sql+param+"'0')";
		
		RowMapper<Product> rm2 = (rs,count) ->
		{
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setpTitle(rs.getString(2));
			p.setpDesc(rs.getString(3));
			p.setPrice(rs.getDouble(4));
			p.setDiscount(rs.getDouble(5));
			p.setQuantity(rs.getInt(6));
			p.setCategory(rs.getString(7));
			p.setSupplier_id(rs.getString(8));
			return p;
		};
		List<Product> proList = jt.query(sql, rm2);
		for(Product p : proList)
		{
			customerCompleteCart(p.getSupplier_id());
		}
		return proList;
	}
	
	@Override
	public int getTotalAmount(String username) {
		final String sql = "select round(price - (price * discount  / 100)) from products where supplier_id in (select supplier_id from cart  where username = '"+username+"')";
		RowMapper<Shipping> rm = (rs, c)->
		{
			Shipping ship = new Shipping();
			ship.setTotalAmount(rs.getInt(1));
			return ship;
		};
		
		List<Shipping> list = jt.query(sql, rm);
		int total_amount = 0;
		for(Shipping s : list)
		{
			total_amount = s.getTotalAmount()+total_amount;
		}
		return total_amount;
	}

	@Override
	public int saveCustomerAddress(String username, Shipping s) {
		final String sql = "insert into shipping values(?,?,?,?,?,?)";
		final String sql2 = "select count(*) from cart where username = '"+username+"'";
		if(jt.queryForObject(sql2, Integer.class) == 0)
		{
			return -1;
		}
		return jt.update(sql,username,s.getFullname(),s.getAddress(),s.getCity(),s.getTotalProducts(),s.getTotalAmount());
	}
	
	public void customerCompleteCart(String sid)
	{
		final String sql = "update cart set isdelivered = 'yes' where supplier_id = ?";
		jt.update(sql,sid);
	}
	
	@Override
	public int removeItem(String supplier_id) {
	final String sql = "delete from cart where supplier_id = ?";
	
		return jt.update(sql, supplier_id);
	}
}
