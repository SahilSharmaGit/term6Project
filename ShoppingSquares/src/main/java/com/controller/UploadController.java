package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.FileUploadDAO;
import com.model.Image;
import com.model.UploadFile;

@Controller
public class UploadController {

	@Autowired
	FileUploadDAO filedao;
	/*@RequestMapping(value="/upload.htm", method = RequestMethod.GET)
	public String uploadGet()
		{
			return "uploadPhoto";
		}
	*/
	@RequestMapping(value="/upload.htm", method = RequestMethod.GET)
	public ModelAndView uploadGet()
		{
			return new ModelAndView("uploadPhoto","image", new Image());
		}
	
	@RequestMapping(value="/upload.htm", method = RequestMethod.POST)
	public String upload(
			@ModelAttribute("image") Image image)
		{
		filedao.saveImage(image);
			return "image";
		}

	
/*	@RequestMapping(value="/upload.htm", method = RequestMethod.POST)
	public String upload(HttpServletRequest req,
			ModelMap m,
			@RequestParam("id") String id,
			@RequestParam("image") MultipartFile photo)
		{
			filedao.uploadImage(photo,id);
			byte[] b =filedao.displayImage();
			m.addAttribute("image",b);
			return "showImage";
		}
		
	/*@RequestMapping(value="/upload.htm", method = RequestMethod.POST)
	public ModelAndView savePic(
			@RequestParam("file")MultipartFile file)throws Exception
	{
		byte[] b = file.getBytes();
		UploadFile u = new UploadFile();

u.setData(b);
		u.setFile((InputStream)file);
		
		int count = filedao.savePic(u);
		return new ModelAndView("Upload","msg","thanks god");
	}
/*private void upload(MultipartFile file)
{
	if(!file.isEmpty())
	{
		try {
		//	String relativePath = "D:\\Advance Java\\ECOMMERCE";
			String absFilePath ="D:\\Advance Java\\ECOMMERCE\\";
			System.out.println("Location: "+absFilePath);
			
			byte[] b = file.getBytes();
			File dir = new File(absFilePath);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			File uploadFile  = new File(dir.getAbsoluteFile()+File.separator+file.getOriginalFilename());
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(uploadFile));
			bos.write(b);
			bos.close();
		
		}catch (Exception e) {
			
			// TODO: handle exception
		}
	}
	}*/
}
