package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public ModelAndView LogoutCustomer(HttpServletRequest req, HttpServletResponse res)
	{
		HttpSession session = req.getSession(false);
		Cookie[] cks = req.getCookies();
		
		if(null != session && null!=cks)
		{
			for(Cookie ck : cks)
			{
				if(ck.getName().equals("username"))
					System.out.println("Logout data: "+ck.getValue());
				if(ck.getName().equals("JSESSIONID"))
					System.out.println("Id: "+ck.getValue());
				ck.setMaxAge(0);
			}
			session.setAttribute("count", 0);
			session.invalidate();
		//	req.setAttribute("count", 0);
			session = null;
			cks = null;
			return new ModelAndView("welcome");
		}
		return new ModelAndView("welcome");
	}
}
