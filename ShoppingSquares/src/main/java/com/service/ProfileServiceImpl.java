package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProfileDao;
import com.model.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
 private ProfileDao profileDao;
	
	@Override
	public Profile getCustomerDetails(String username) {
		// TODO Auto-generated method stub
		Profile p  = profileDao.getCustomerProfile(username);
		return p;
	}

}
