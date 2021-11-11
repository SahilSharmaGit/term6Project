package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Product;
import com.model.Shipping;
import com.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cartService;
	
	@RequestMapping(value = "/cartCount.htm", method = RequestMethod.POST)
	public ModelAndView addToCart(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		String name = (String)session.getAttribute("username");
		if(name != null) {
		try {
				String sid = request.getParameter("sid");
				System.out.println("Cart Controller : "+name+" "+sid);
				int count = cartService.insertCart(sid,name);
				if(count > 0) {
					String cartCount =""+cartService.getCartCount(name);
					session.setAttribute("count", cartCount);
					response.sendRedirect("home.htm");
				}
				else {
					return new ModelAndView("welcome","msg","Please try again later");
				}
				} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				return new ModelAndView("welcome","msg","Please try again later, something went wrong");
			}
		}
		return new ModelAndView("welcome","msg","Please login first to add to cart");
	}
	
	
	@RequestMapping(value="/mycart.htm",method=RequestMethod.GET)
	public String showMyCart(HttpServletRequest req, ModelMap m)
	{
		String msg = "Please login to see your cart";
		HttpSession session  = req.getSession(false);
		String name   = (String)session.getAttribute("username");
		if(name == null)
		{
			m.addAttribute("msg", msg);
			return "welcome";
		}
		List<Product> list = cartService.getUserProducts(name);
		if(list.isEmpty()  || list == null)
		{
			m.addAttribute("msg","Empty cart!!!");
			return "welcome";
		}
		else
		{
			System.out.println(list);
			m.addAttribute("list",list);
			return "mycart";
		}
	}

	@RequestMapping(value="/shipping.htm", method= RequestMethod.GET)
	public String shippingAddress(ModelMap m,HttpServletRequest req)
	{
		HttpSession session  = req.getSession(false);
		String name   = (String)session.getAttribute("username");
		if(name != null)
		{
			int amt = cartService.getTotalAmount(name);
			int productsCount = cartService.getCount(name);
			m.addAttribute("amount",amt);
			m.addAttribute("productsCount",productsCount);
			m.addAttribute("shipping",new Shipping());
			return "shipping";
		}
		m.addAttribute("msg","login is required!!!");
		return "welcome";
	}
	
	
	@RequestMapping(value="/saveAddress.htm", method = RequestMethod.POST)
	public String saveCustomerAddress(ModelMap m, HttpServletRequest req,
			HttpServletResponse res,
			@ModelAttribute("shipping")Shipping shipping)
	{
		HttpSession session  = req.getSession(false);
		String name   = (String)session.getAttribute("username");
		if(name != null)
		{
			int updateCount = cartService.save(name, shipping);
			if(updateCount == -1)
			{
				m.addAttribute("msg","your cart is empty!!!");
				return "mycart";
			}
			if(updateCount > 0)
			{
				return "thanks";
			}
		}
	
		return "home";
	}


@RequestMapping(value="/remove.htm", method = RequestMethod.GET)
public String removeItem(HttpServletRequest req,ModelMap m)
{
	String sid = req.getParameter("sid");
	int count = cartService.remove(sid);
	if(count > 0)
	{
		HttpSession session  = req.getSession(false);
		String name   = (String)session.getAttribute("username");
		
		String cartCount =""+cartService.getCount(name);
		session.setAttribute("count", cartCount);
		showMyCart(req, m);
	}
	return "mycart";
}


}


