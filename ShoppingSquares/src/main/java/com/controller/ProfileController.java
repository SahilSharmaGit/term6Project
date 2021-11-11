package com.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Login;
import com.model.Profile;
import com.service.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	@Qualifier("profileService")
	public ProfileService profileService;
	
	
	@RequestMapping(value = "/profile.htm", method = RequestMethod.GET)
	public ModelAndView displayProfile(HttpServletRequest req)
	{
		String msg = "Please login first to check profile";
		HttpSession hs = req.getSession(false);
		String name = ""+hs.getAttribute("username");
		if(hs != null && name != null)
		{
			Profile  p  = profileService.getCustomerDetails(name);
			if(null != p)
			{
				ModelAndView mav = new ModelAndView("profile");
			System.out.println(p);
			Map<String,String> m = new LinkedHashMap<String, String>();
			m.put("name",p.getUsername().toUpperCase());
			m.put("phone",p.getPhone());
			m.put("email",p.getEmail());
			mav.addAllObjects(m);
			
			//	return "profile";
			return mav;
			}
		}
		//return new ModelAndView("login","login",new Login());
		return new ModelAndView("welcome","msg",msg);	
		
	}
	/*@RequestMapping(value = "/profile.htm", method = RequestMethod.POST)
	public ModelAndView displayCustProfile(HttpServletRequest req)
	{
		HttpSession hs = req.getSession(false);
		String name = ""+hs.getAttribute("username");
		if(hs != null && name != null)
		{
			Profile  p  = profileService.getCustomerDetails(name);
			if(null != p)
			{
				ModelAndView m = new ModelAndView();
			System.out.println(p);
				m.addObject("name",p.getUsername());
				m.addObject("phone",p.getPhone());
				m.addObject("email",p.getEmail());
			//	return "profile";
			return new ModelAndView("profile");
			}
		}
		return new ModelAndView("login","login",new Login());
	
//		return new ModelAndView("home");
	}
	*/
}
