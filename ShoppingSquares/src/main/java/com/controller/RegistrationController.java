package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Customer;
import com.service.CustomerService;

@Controller
public class RegistrationController {

	
	@Autowired
	public CustomerService service;
	
	@RequestMapping(value = "/register.htm", method = RequestMethod.GET)
	  public ModelAndView showRegister(ModelAndView mav) {
	    mav = new ModelAndView("register");
	    mav.addObject("customer", new Customer());

	    return mav;
	  }

	  @RequestMapping(value = "/register.htm", method = RequestMethod.POST)
	  public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("customer") Customer customer) {

		  System.out.println("Registration is recieving request to save data");
	  String msg = service.register(customer);
	  if(msg.equals("failure"))
	  {
		  return new ModelAndView("register","msg","Registration failed pls try again");
	  }
	  	
	  return new ModelAndView("welcome", "username", customer.getUsername());
	  }
}
