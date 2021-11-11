package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.Profile;

@Repository
public class ProfileDaoImpl implements ProfileDao {

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public Profile getCustomerProfile(String username) {
		final String sql = "select email, phone, username from customer_registration where username = '"+username+"'";
		Profile profile = null;
		RowMapper<Profile> rm = (rs,count) ->
		{
			Profile p = new Profile();
			p.setEmail(rs.getString(1));
			p.setPhone(rs.getString(2));
			p.setUsername(rs.getString(3));
			return p;
		};
		
		try {
		 profile = jt.queryForObject(sql, rm);
			return profile;
		
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
