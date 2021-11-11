package com.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Admin;
import com.model.AdminLogin;
import com.model.Customer;
import com.model.Login;
import com.service.AdminService;

@Controller
public class AdminController {

	 @Autowired
	 @Qualifier("adminService")
	  public AdminService adminService;

	  @RequestMapping(value = "/admin.htm", method = RequestMethod.GET)
	  public ModelAndView showLogin(ModelAndView mav,HttpServletRequest request) {
	  

		  HttpSession hs = request.getSession(false);
		  	String name = (String)hs.getAttribute("aname");
			  
		  if(hs != null && name != null) {
		    	return new ModelAndView("adminHome");
		    }
		  
		  
		mav = new ModelAndView("admin");
	    mav.addObject("admin", new AdminLogin());

	    return mav;
	  }
	  		
	  @RequestMapping(value = "/admin.htm", method = RequestMethod.POST)
	  public ModelAndView aloginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("admin") AdminLogin login) {
	    Admin a  = adminService.validateAdmin(login);
	    if (null != a) {
	    	HttpSession session = request.getSession();

	    	session.setAttribute("aname", a.getAname());
	    	session.setMaxInactiveInterval(60 * 5);
	    
	    return new ModelAndView("adminHome");
	    
	    } else {
	 	   
	    return new ModelAndView("admin","message", "Admin name or Password is wrong!!");
	    }
	  }
	  
	  
	  @RequestMapping(value = "/customerList.htm", method = RequestMethod.GET)
	  public ModelAndView displayAllCustomer(ModelAndView mav) {
	    mav = new ModelAndView("customerList");
	    
	    List<Customer> list =    adminService.getAllEmployee();
	    mav.addObject("custList",list);

	    return mav;
	  }

	  
	  @RequestMapping(value = "/adminLogout.htm", method = RequestMethod.GET)
		public String LogoutCustomer(HttpServletRequest req, HttpServletResponse res)
		{
			HttpSession session = req.getSession(false);
			Cookie[] cks = req.getCookies();
			
			if(null != session && null!=cks)
			{
				for(Cookie ck : cks)
				{
					if(ck.getName().equals("aname"))
					if(ck.getName().equals("JSESSIONID"))
					ck.setMaxAge(0);
				}
				session.setAttribute("count", 0);
				session.invalidate();
				session = null;
				cks = null;
				return "welcome";
			}
			return "welcome";
		}
}
