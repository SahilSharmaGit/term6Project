package com.model;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class Product {

	private int pid;
	private String pTitle;
	private String pDesc;
	// private MultipartFile photo;
	//private InputStream fis;
	private double price;
	private double discount;
	private double quantity;
	private String category;
	private String supplier_id;
	private String photo_name;
	
	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	/*public InputStream getFis() {
		return fis;
	}

	public void setFis(InputStream inputStream) {
		this.fis = inputStream;
	}
*/
	/*
	 * public MultipartFile getPhoto() { return photo; } public void
	 * setPhoto(MultipartFile photo) { this.photo = photo; }
	 */
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
