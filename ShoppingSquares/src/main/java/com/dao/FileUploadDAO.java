package com.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.model.Image;
import com.model.UploadFile;

public interface FileUploadDAO {
    int save(UploadFile uploadFile);
    public int savePic(UploadFile uf) throws Exception;
    public int uploadImage(MultipartFile file, String id);
    public byte[] displayImage();
    int saveImage(Image image);
}