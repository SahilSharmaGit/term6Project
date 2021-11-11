package com.dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.model.Admin;
import com.model.AdminLogin;
import com.model.Category;
import com.model.Customer;
import com.model.Login;
import com.model.Product;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public int register(Customer c) {
		final String sql = "INSERT INTO customer_registration VALUES(?,?,?,?)";
		System.out.println(c.getUsername() + " " + c.getPhone());
		int count = 0;
		try {

			count = jt.update(sql, new Object[] { c.getEmail(), c.getPhone(), c.getUsername(), c.getPassword() });
		} catch (Exception e) {
			count = 0;
			System.out.println(e);
			return count;
		}

		System.out.println("Count values is : " + count);
		return count;
	}

	@Override
	public Customer validateCustomer(Login l) {

		final String sql = "SELECT * FROM customer_registration	where username = '" + l.getUsername()
				+ "' and password = '" + l.getPassword() + "'";

		RowMapper<Customer> rm = (rs, count) -> {
			Customer c = new Customer();
			c.setEmail(rs.getString(1));
			c.setPhone(rs.getString(2));
			c.setUsername(rs.getString(3));
			c.setPassword(rs.getString(4));
			return c;
		};
		System.out.println("Template is : " + jt);
		Customer c = null;
		try {
			c = jt.queryForObject(sql, rm);

		} catch (Exception e) {
			return null;
		}
		if (null == c.getPassword() || null == c.getUsername()) {
			return null;
		}

		return c;

	}

	public Admin validateAdmin(AdminLogin login) {
		final String sql = "SELECT * FROM admin_login where a_name = '" + login.getAname() + "' and a_pwd = '"
				+ login.getApassword() + "'";
		System.out.println(login.getAname() + "  " + login.getApassword());
		RowMapper<Admin> rm = (rs, count) -> {
			Admin admin = new Admin();
			admin.setAname(rs.getString(1));
			admin.setApassword(rs.getString(2));
			System.out.println(admin.getAname() + "  " + admin.getApassword());

			return admin;
		};
		System.out.println("Template is : " + jt);
		System.out.println("Admin validate method 1");

		Admin ad = null;
		try {
			System.out.println("Admin validate method 2");
			ad = jt.queryForObject(sql, rm);
			System.out.println("Admin validate method 3");
			System.out.println(ad);
		} catch (Exception e) {
			return null;
		}
		if (null == ad.getAname() || null == ad.getApassword()) {
			return null;
		}

		return ad;
	}

	public List<Customer> getAllCustomer() {
		RowMapper<Customer> rm = (rs, count) -> {
			Customer c = new Customer();
			c.setEmail(rs.getString(1));
			c.setPhone(rs.getString(2));
			c.setUsername(rs.getString(3));
			c.setPassword(rs.getString(4));
			return c;
		};
		final String sql = "select * from customer_registration";
		List<Customer> list = jt.query(sql, rm);
		return list;
	}

	@Override
	public List<Category> listCategory() {
		RowMapper<Category> rm = (rs, count) -> {
			Category c = new Category();
			c.setCate_id(rs.getInt(1));
			c.setCategory(rs.getString(2));
			return c;
		};
		final String sql = "select cate_id, category from category";
		List<Category> list = jt.query(sql, rm);
		return list;
	}

	@Override
	public int insertProducts(String supplier_id, int pid, String pTitle, String pDesc, double price, double discount,
			double quantity, String category, MultipartFile photo, String photo_name) {
		photo.getOriginalFilename();

		// File f = new File("D:\\Ashok
		// IT\\SPRING\\AshokSpring\\ShoppingSquares\\src\\main\\webapp\\css");
		final String sql = "INSERT INTO Products values(?,?,?,?,?,?,?,?,?)";
String name = supplier_id+photo.getOriginalFilename();
String path= "D:\\Ashok IT\\SPRING\\AshokSpring\\ShoppingSquares\\src\\main\\webapp\\css\\";
System.out.println(name);
System.out.println(path+name);
//byte[] b = null;
		InputStream fis = null;
		try {
			//b = photo.getBytes();
			 fis =  photo.getInputStream();
			 FileOutputStream fos = new FileOutputStream(path+name);
			 byte[] buffer = new byte[2048];
				while(fis.read(buffer)>0)
				{
					fos.write(buffer);
				}
				fos.flush();
				fos.close();
		} catch (Exception e) {
		}
		
		return jt.update(sql, pid, pTitle, pDesc, price, discount, quantity, category, supplier_id, name);

	}

	@Override
	public int addNewCategory(int cate_id, String category) {
		// TODO Auto-generated method stub
		final String sql = "INSERT INTO category VALUES(?,?)";
		return jt.update(sql, cate_id, category);
	}

	@Override
	public int nextCate_id() {
		final String sql = "select max(cate_id) from category";
		RowMapper<Category> rm = (rs, count) -> {
			Category c = new Category();
			c.setCate_id(rs.getInt(1));
			return c;
		};
		Category cat = jt.queryForObject(sql, rm);

		if (null != cat) {
			int next_Cate_Id = 0;
			next_Cate_Id = cat.getCate_id() + 111;
			System.out.println("New id should be: " + next_Cate_Id);
			return next_Cate_Id;
		}
		return 0;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		RowMapper<Product> rm = (rs, count) -> {
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setpTitle(rs.getString(2));
			p.setpDesc(rs.getString(3));
			p.setPrice(rs.getDouble(4));
			p.setDiscount(rs.getDouble(5));
			p.setQuantity(rs.getInt(6));
			p.setCategory(rs.getString(7));
			p.setSupplier_id(rs.getString(8));
			p.setPhoto_name(rs.getString(9));
			System.out.println(p.getPid() + " " + p.getpTitle() + " " + p.getCategory());
			return p;
		};
		
		System.out.println("Get All Products.......");
		final String sql = "select * from products";
		List<Product> list = jt.query(sql, rm);
		return list;

	}

	public int getCartCount(String username) {

		final String sql = "select count(username) from cart where username = '" + username
				+ "' and isdelivered is null";
		int count = jt.queryForObject(sql, Integer.class);
		System.out.println("Count************: " + count);
		return count;
	}
}
