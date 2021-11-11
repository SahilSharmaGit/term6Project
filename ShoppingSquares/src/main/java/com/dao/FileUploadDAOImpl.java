package com.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.model.Image;
import com.model.UploadFile;
@Repository
public class FileUploadDAOImpl implements FileUploadDAO {
    
	@Autowired
    private JdbcTemplate jt;
     
    public FileUploadDAOImpl() {
    }
 
    public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int save(UploadFile uploadFile) {
	
		System.out.println("save method called");
		return jt.update("insert into file_upload(pic) values(?)",uploadFile.getData());
	}
	
@Override
public int saveImage(Image image) {
	// TODO Auto-generated method stub
final String q = "insert into image values(?,?)";
	return jt.update(q,image.getBytes(),image.getId());
}
	public int savePic(UploadFile uf)throws Exception
	{
		String url = "jdbc:mysql:///shop?autoReconnect=true&useSSL=false";
		String uname = "root";
		String pwd = "MYSQL";
		Connection con = DriverManager.getConnection(url,uname,pwd);

		String query = "insert into file_upload values(?,?)";
		java.sql.PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,111);
		File f = new File("D:\\Advance Java\\ECOMMERCE\\");
		FileInputStream fis = new FileInputStream(f);
		System.out.println("Inserting image form : "+f.getAbsolutePath());
		pst.setBinaryStream(2,uf.getFile());
		int updateCount = pst.executeUpdate();
		if(updateCount == 1)
		{
			return updateCount;
		}
		else
		{
			return updateCount;
		}
	}
	
	
	public int uploadImage(MultipartFile file, String id)
	{
		byte[] b = null;
		try {
		 b = file.getBytes();
		}
		catch(Exception e) {}
		return jt.update("insert into image values(?,?)",b,id);
	}
	@Override
	public byte[] displayImage() {
		
		return jt.queryForObject("select img from image where id = 'i1'",byte[].class);
	}
 }