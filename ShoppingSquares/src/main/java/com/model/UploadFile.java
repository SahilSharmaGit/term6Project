package com.model;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	private Integer id;
	private byte[] data;
	
	private InputStream file;
	
public InputStream getFile() {
	return file;
}
public void setFile(InputStream file) {
	this.file = file;
}
	public int getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
    public byte[] getData() {
        return data;
    }
 
    public void setData(byte[] data) {
        this.data = data;
    }
}
