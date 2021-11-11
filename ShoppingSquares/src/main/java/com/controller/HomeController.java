package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CustomerDao;
import com.model.Category;
import com.model.Product;
import com.service.CartService;

@Controller
public class HomeController {

	@Autowired
	CustomerDao dao;
	
	
	 @RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	  public ModelAndView displayAllCustomer(ModelAndView mav,HttpServletRequest req) {

		 mav = new ModelAndView("home");
	    System.out.println("getting request for home2");
	    List<Product> list1 =    dao.getAllProducts();
	    mav.addObject("productsList",list1);
	    List<Category> list2 =   dao.listCategory();
	    mav.addObject("categoryList",list2);
	    HttpSession s = req.getSession(false);
	    String name = (String)s.getAttribute("username");
		if(name != null) {
			String count = ""+dao.getCartCount(name);
			s.setAttribute("count", count);
		}
	    //	    mav = new ModelAndView("insertCategory");
//				System.out.println("add category getting get req...");
				
//			  	mav.addObject("id", id);

	    return mav;
	  }
	 
}
