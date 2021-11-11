package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CustomerDao;
import com.model.Category;

@Controller
public class CategoryController {

	@Autowired
	public CustomerDao dao;

	
	  @RequestMapping(value = "insertCategory.htm", method = RequestMethod.GET)
	  public ModelAndView displayCategories(/*ModelAndView mav*/) {
		  
		  System.out.println("insertCATEGORY is called get");
		    List<Category> list =   dao.listCategory();
	//	    mav = new ModelAndView("insertCategory");
			System.out.println("add category getting get req...");
			
		    int id =  dao.nextCate_id();
//		  	mav.addObject("id", id);

	    return new ModelAndView("insertCategory","id", id);
	  }
	
  @RequestMapping(value = "savecat.htm", method = RequestMethod.POST)
	public ModelAndView addCate(@RequestParam("cate_id")int cate_id,
			  			@RequestParam("category")String category)
	  {
	  
		  ModelAndView mav = new ModelAndView("insertCategory");
			System.out.println("add category getting post req...");
			int count  = dao.addNewCategory(cate_id, category);
			if(count == 0)
			{
				return new ModelAndView("insertCategory","cateF","Category not added");
			}
		  return new ModelAndView("insertCategory","cateS","Category added successfully");
	  }
	
	
}
