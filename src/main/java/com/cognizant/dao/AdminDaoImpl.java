package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Users;

@Repository
public class AdminDaoImpl {
	
	@Autowired
	public JdbcTemplate jdbctemplate;
	
	public List<Users> allUserDetails()
	{
		String sql = "SELECT * FROM user where category='user'";
		List<Users> query = jdbctemplate.query(sql,new RowMapper<Users>() {
			
			@Override
			public Users mapRow(ResultSet rs, int arg1) throws SQLException {
				Users user = new Users();
				user.setEnrolnumber(rs.getInt("enrol_number"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setGender(rs.getString("gender"));
				user.setMobile(rs.getString("mobile"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		});
		
		return query;
	}

	public boolean deleteUser(int userId)
	{
		String sql = "delete from user where enrol_number=?";
		int delete = jdbctemplate.update(sql,userId);
		if(delete>0) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
