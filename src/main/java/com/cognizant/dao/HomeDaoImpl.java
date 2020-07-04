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
public class HomeDaoImpl {
		
		@Autowired
		public JdbcTemplate jdbctemplate;
		
		
		public Users VerificationCheck(Users user)
		{
			String sql="select * from user where enrol_number=? and password=?";
			
			List<Users> u = jdbctemplate.query(sql,new Object[] {user.getEnrolnumber(),user.getPassword()}, new UserMapper());
			
			if(u.isEmpty())
			{
				return null;
			}
			else
			{
				return u.get(0);
			}
		}
		
		class UserMapper implements RowMapper<Users> {
			public Users mapRow(ResultSet rs, int arg1) throws SQLException {
				Users users =new Users();
				users.setEnrolnumber(rs.getInt("enrol_number"));
				users.setPassword(rs.getString("password"));
				users.setFirstName(rs.getString("first_name"));
				users.setLastName(rs.getString("last_name"));
				users.setCategory(rs.getString("category"));
				return users;
			}
		}
}
