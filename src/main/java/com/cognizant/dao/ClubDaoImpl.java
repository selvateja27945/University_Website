package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Clubs;
//import com.cognizant.model.Events;

@Repository
public class ClubDaoImpl {
	
	@Autowired
	public JdbcTemplate jdbctemplate;
	
	
	public boolean insertMembers(Clubs club)
	{	
		String sql = "INSERT INTO club_member(club_id,user_id,profession) VALUES(?,?,?)";
		String sql1 = "update clubs set club_strength = club_strength-1 where club_id=?";
		//jdbctemplate.update(sql1,club.getClubId());
		
		int insert = jdbctemplate.update(sql, new Object[] {club.getClubId(), club.getUserId(), club.getProfession() });
		if(insert>0)
		{
			jdbctemplate.update(sql1,club.getClubId());
			return true;
			
		}
		return false;
	} 
	
	
	public List<Clubs> allclubs()
	{
		String sql = "SELECT * FROM clubs";
		List<Clubs> query = jdbctemplate.query(sql,new RowMapper<Clubs>() {
			
			@Override
			public Clubs mapRow(ResultSet rs, int arg1) throws SQLException {
				Clubs club = new Clubs();
				club.setClubId(rs.getInt("club_id"));
				club.setClubName(rs.getString("club_name"));
				club.setClubSterngth(rs.getInt("club_strength"));
				club.setEligibility(rs.getString("eligibility"));
				return club;
			}
		});
		
		return query;
	}
	
	public boolean remaining(Clubs club)
	{
		//String sql = "SELECT club_strength from clubs where club_id = ?";
		
		Object[] params = new Object[] {
				club.getClubId()
		};
		
		int rowcount = (jdbctemplate).queryForObject("select club_strength from clubs " + "where club_id = ?",params,Integer.class);
		
		if(rowcount>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public List<Clubs> clubMembers()
	{
		String str = "select clubs.club_id,clubs.club_name,clubs.club_strength,clubs.eligibility,club_member.user_id,club_member.profession From clubs INNER JOIN club_member ON clubs.club_id = club_member.club_id";
		
		List<Clubs> query = jdbctemplate.query(str,new RowMapper<Clubs>() {
			
			@Override
			public Clubs mapRow(ResultSet rs, int arg1) throws SQLException {
				Clubs club = new Clubs();
				club.setClubId(rs.getInt("club_id"));
				club.setClubName(rs.getString("club_name"));
				//club.setClubSterngth(rs.getInt("club_strength"));
				club.setEligibility(rs.getString("eligibility"));
				club.setUserId(rs.getInt("user_id"));
				club.setProfession(rs.getString("profession"));
				return club;
			}
		});
		
		return query;
	}
	
	public boolean deleteclub(int clubId)
	{
		String sql = "delete from clubs where club_id=?";
		int delete = jdbctemplate.update(sql,clubId);
		if(delete>0) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean insertClubs(Clubs club)
	{	
		String sql = "INSERT INTO clubs(club_name,club_strength,eligibility) VALUES(?,?,?)";
		//String date = "now()";
		int insert = jdbctemplate.update(sql, new Object[] {club.getClubName(), club.getClubStrength(), club.getEligibility()});
		if(insert>0)
		{
			return true;
		}
		return false;
	}
	
	public Clubs getClubByClubId(int clubId)
	{
		String sql = "SELECT * FROM clubs where club_id=?";
		List<Clubs> query = jdbctemplate.query(sql,new Object[] {clubId},new RowMapper<Clubs>() {
			
			@Override
			public Clubs mapRow(ResultSet rs, int arg1) throws SQLException {
				Clubs club = new Clubs();
				club.setClubId(rs.getInt("club_id"));
				club.setClubName(rs.getString("club_name"));
				club.setClubSterngth(rs.getInt("club_strength"));
				club.setEligibility(rs.getString("eligibility"));
				return club;
			}
		});
		
		return query.get(0);
	}
	
	public boolean updateClub(Clubs club) {
		//System.out.println("inside dao >" + event);
		String sql = "update clubs set club_name=?,club_strength=?,eligibility=? where club_id=?";
		int update = jdbctemplate.update(sql, new Object[] { club.getClubName(), club.getClubStrength(), club.getEligibility(), club.getClubId() });
		if (update > 0) {
			return true;
		}
		return false;
	}
}
