package com.cognizant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.cognizant.model.Users;

@Repository
public class UserDaoImpl {
	
	@Autowired
	public JdbcTemplate jdbctemplate;
	
		
	public boolean insertUserDetails(Users user)
	{
		String sql = "INSERT INTO user(enrol_number,password,first_name,last_name,gender,dob,mobile,email,category) VALUES(?,?,?,?,?,?,?,?,?)";
		
		int insert = jdbctemplate.update(sql, new Object[] {user.getEnrolnumber() , user.getPassword(), user.getFirstName(), user.getLastName(), user.getGender(), user.getDob(), user.getMobile(), user.getEmail(),"user" });
		if(insert>0)
		{
			return true;
		}
		return false;
	}
	
	public boolean userCheck(Users user)
	{
		boolean exist = false;
		Object[] params = new Object[] {
				user.getEnrolnumber()
		};
		
		int rowcount = (jdbctemplate).queryForObject("select count(*) from user"+" where enrol_number = ?", params, Integer.class);
		if(rowcount==1)
		{
			exist=true;
		}
		
		return exist;
	}

}

