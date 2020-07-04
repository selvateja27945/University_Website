package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//import com.cognizant.model.Events;
import com.cognizant.model.Ideas;

@Repository
public class ideaDaoImpl {

	
	@Autowired
	public JdbcTemplate jdbctemplate;
	
	public boolean insertIdeas(Ideas idea)
	{	
		String sql = "INSERT INTO ideas(idea_category,idea_description,idea_voteup,idea_votedown,comments,user_id) VALUES(?,?,?,?,?,?)";
		//String date = "now()";
		int insert = jdbctemplate.update(sql, new Object[] {idea.getCategory(), idea.getDescription(), 0, 0, "", idea.getEnrolnumber() });
		if(insert>0)
		{
			return true;
		}
		return false;
	}
	
	public List<Ideas> allIdeaDetails()
	{
		String sql = "SELECT * FROM ideas";
		List<Ideas> query = jdbctemplate.query(sql,new RowMapper<Ideas>() {
			
			@Override
			public Ideas mapRow(ResultSet rs, int arg1) throws SQLException {
				Ideas idea = new Ideas();
				idea.setIdeaId(rs.getInt("idea_id"));
				idea.setCategory(rs.getString("idea_category"));
				idea.setDescription(rs.getString("idea_description"));
				idea.setVoteup(rs.getInt("idea_voteup"));
				idea.setVotedown(rs.getInt("idea_votedown"));
				idea.setComments(rs.getString("comments"));
				idea.setEnrolnumber(rs.getInt("user_id"));
				return idea;
			}
		});
		
		return query;
	}
	
	public boolean updateIdea1(int ideaId)
	{
		String sql = "update ideas set idea_voteup = idea_voteup+1 where idea_id=?";
		int update = jdbctemplate.update(sql,ideaId);
		if(update>0) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean updateIdea2(int ideaId)
	{
		String sql = "update ideas set idea_votedown = idea_votedown+1 where idea_id=?";
		int update = jdbctemplate.update(sql,ideaId);
		if(update>0) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean addcomment(int ideaId,String comment)
	{
		String sql = "INSERT INTO comments VALUES(?,?)";
		int comments = jdbctemplate.update(sql, new Object[] {ideaId,comment });
		if(comments>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	//notification
	/*public boolean notification()
	 * {
	 * 	String sql = "SELECT * FROM notifications where user_id = ? ";
	 * 	List<Users> query = jdbctemplate.query(sql,new RowMapper<Ideas>() {
			
			@Override
			public Ideas mapRow(ResultSet rs, int arg1) throws SQLException {
				Notification note = new Notification();
				note.setNoteId(rs.getInt("note_id"));
				note.setUserId(rs.getString("note_name"));
				note.setIdeaId(rs.getString("idea_id"));
				return note;
			}
		});
		
		return query;
	}	 * }
	 */
	
	
	
}
