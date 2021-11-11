package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CustomerDao;
import com.model.Category;
import com.model.Customer;
import com.model.Product;

@Controller
public class ProductController {

	@Autowired
	public CustomerDao dao;

	  @RequestMapping(value = "/insertProducts.htm", method = RequestMethod.GET)
	  public ModelAndView displayCategories(ModelAndView mav) {
	 System.out.println("insertProducts is called get");
	    List<Category> list =   dao.listCategory();
	    mav = new ModelAndView("insertProducts");
		mav.addObject("cateList",list);
		return mav;
	  }
	  
	@RequestMapping(value = "/insertProducts.htm", method = RequestMethod.POST)
	public ModelAndView addProducts(
	          @RequestParam("pTitle")String pTitle,
	         @RequestParam("pDesc")String pDesc,
	        @RequestParam("price")Double price,
	          @RequestParam("discount")Double discount,
	          @RequestParam("quantity")Integer quantity,
	          @RequestParam("category")String category,
	          @RequestParam("supplier_id")String supplier_id,
	          @RequestParam("photo")MultipartFile photo
		        
			) {
		 
		 System.out.println("saveProducts is called post");
		
			System.out.println( pTitle+" "+ pDesc+" "+ price+" "+discount+" "+ quantity+" "+ category);
					
			System.out.println("starting insertion.......");
		
			int count  = 0;
			String s1 = category.trim(); 
				String[] s2 = s1.split("\\s");
				
				int pid = Integer.parseInt(s2[0]);
				System.out.println("starting insertion....... 2");
				
				String categoryS = s2[s2.length-1];
				System.out.println(pid+" " +pTitle+" "+ pDesc+" "+ price+" "+discount+" "+ quantity+" "+ categoryS);
		
				count = dao.insertProducts(supplier_id,pid, pTitle, pDesc, price, discount, quantity, categoryS,photo,null);
			if(count != 0 ) {
			return new ModelAndView("insertProducts", "msg", "Products succesfully inserted");
			}
			return new ModelAndView("insertProducts", "msg", "Products insertion failed");
			
	}		
	

	 @RequestMapping(value = "/productsList.htm", method = RequestMethod.GET)
	  public ModelAndView displayAllCustomer(ModelAndView mav) {
	    mav = new ModelAndView("productsList");
	    
	    List<Product> list =    dao.getAllProducts();
	    mav.addObject("productsList",list);

	    return mav;
	  }

}
