package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cognizant.model.services;

@Repository
public class ServiceDaoImpl {
	
	@Autowired
	public JdbcTemplate jdbctemplate;
	
	
	public boolean insertVolunteers(services service)
	{	
		String sql = "INSERT INTO volunteers(service_id,user_id) VALUES(?,?)";
		String sql1 = "update services set volunteers = volunteers-1 where service_id=?";
		//jdbctemplate.update(sql1,club.getClubId());
		
		int insert = jdbctemplate.update(sql, new Object[] {service.getServiceId(), service.getEnrolnumber() });
		if(insert>0)
		{
			jdbctemplate.update(sql1,service.getServiceId());
			return true;
			
		}
		return false;
	} 
	
	/*public boolean insertServices(services service)
	{	
		String sql = "INSERT INTO services(service_name,description,date,no0fvol,user_id) VALUES(?,?,?,?,?)";
		//String date = "now()";
		int insert = jdbctemplate.update(sql, new Object[] {service.getServiceName(), service.getDescription() , service.getDate(), service.getVolunteers(), service.getEnrolnumber() });
		if(insert>0)
		{
			return true;
		}
		return false;
	}*/
	
	public List<services> allservices()
	{
		String sql = "SELECT * FROM services";
		List<services> query = jdbctemplate.query(sql,new RowMapper<services>() {
			
			@Override
			public services mapRow(ResultSet rs, int arg1) throws SQLException {
				services service = new services();
				service.setServiceId(rs.getInt("service_id"));
				service.setServiceName(rs.getString("service_name"));
				service.setDescription(rs.getString("description"));
				service.setDate(rs.getString("date"));
				service.setVolunteers(rs.getInt("volunteers"));
				service.setEnrolnumber(rs.getInt("user_id"));
				return service;
			}
		});
		
		return query;
	}
	
	public boolean remaining(services service)
	{
		
		Object[] params = new Object[] {
				service.getServiceId()
		};
		
		int rowcount = (jdbctemplate).queryForObject("select volunteers from services " + "where service_id = ?",params,Integer.class);
		
		if(rowcount>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public List<services> volunteers()
	{
		String str = "select services.service_id,services.service_name,services.user_id from services where services.service_id IN (select volunteers.service_id from  volunteers where services.service_id = volunteers.service_id )";
		
		List<services> query = jdbctemplate.query(str,new RowMapper<services>() {
			
			@Override
			public services mapRow(ResultSet rs, int arg1) throws SQLException {
				services service = new services();
				service.setEnrolnumber(rs.getInt("user_id"));
				service.setServiceName(rs.getString("service_name"));
				service.setServiceId(rs.getInt("service_id"));
				return service;
			}
		});
		
		return query;
	}
}
