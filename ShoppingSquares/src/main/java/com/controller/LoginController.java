package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Customer;
import com.model.Login;
import com.service.CustomerService;

@Controller
public class LoginController {

	 @Autowired
	  CustomerService service;

	  @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	  public ModelAndView showLogin(ModelAndView mav,HttpServletRequest request) {
	  
		 
		  HttpSession hs = request.getSession(false);
		  	String name = (String)hs.getAttribute("username");
			  
		  if(hs != null && name != null) {
		   
//		    	mav.addObject("username",name);
	//	    	mav.addObject("home");
		    	System.out.println("User trying to login again"+name);
		    	return new ModelAndView("welcome","username",name);
		    }
		  mav = new ModelAndView("login");
		  mav.addObject("login", new Login());

		    return mav;
			
	  }

	  @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") Login login) {
	    ModelAndView mav = null;
	    	
	    
		    System.out.println("loging is recieving requ to save data....");
		    Customer customer = service.validateCustomer(login);
		    if (null != customer) {
		    	HttpSession session = request.getSession();
		    	session.setAttribute("username", customer.getUsername());
		    	session.setMaxInactiveInterval(60 * 60);
		    	mav = new ModelAndView("welcome");
		    mav.addObject("username", customer.getUsername());
		    } else {
		    mav = new ModelAndView("login");
		    mav.addObject("message", "Username or Password is wrong!!");
		    }
		    return mav;
	      
	  }
}
