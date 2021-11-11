package com.dao;

import com.model.Profile;

public interface ProfileDao {

	Profile getCustomerProfile(String username);
}
