package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Events;

@Repository
public class EventDaoImpl {

		@Autowired
		public JdbcTemplate jdbctemplate;
		
		public boolean insertEvents(Events event)
		{
			Calendar calendar = Calendar.getInstance();
		    java.sql.Timestamp CURRENT_TIMESTAMP = new java.sql.Timestamp(calendar.getTime().getTime());
			
			String sql = "INSERT INTO events(event_name,event_place,start_date,end_date,event_des,category,insert_date,user_id) VALUES(?,?,?,?,?,?,?,?)";
			//String date = "now()";
			int insert = jdbctemplate.update(sql, new Object[] {event.getEventName(), event.getEventPlace(), event.getStartDate(), event.getEndDate(), event.getDescription(),event.getCategory(), CURRENT_TIMESTAMP, event.getEnrolnumber() });
			if(insert>0)
			{
				return true;
			}
			return false;
		}
		
		public List<Events> allEventDetails()
		{
			String sql = "SELECT * FROM events";
			List<Events> query = jdbctemplate.query(sql,new RowMapper<Events>() {
				
				@Override
				public Events mapRow(ResultSet rs, int arg1) throws SQLException {
					Events events = new Events();
					events.setEventId(rs.getInt("event_id"));
					events.setEventName(rs.getString("event_name"));
					events.setEventPlace(rs.getString("event_place"));
					events.setStartDate(rs.getString("start_date"));
					events.setEndDate(rs.getString("end_date"));
					events.setPublished(rs.getString("insert_date"));
					events.setDescription(rs.getString("event_des"));
					events.setEnrolnumber(rs.getInt("user_id"));
					return events;
				}
			});
			
			return query;
		}
		
		public List<Events> searchEvents(String search)
		{
			String sql= "select * from events where (event_name like ?) OR (event_des like ?);";
			List<Events> event = jdbctemplate.query(sql,new Object[] {"%"+search+"%","%"+search+"%"}, new RowMapper<Events>() {
				
				@Override
				public Events mapRow(ResultSet rs, int arg1) throws SQLException {
					Events events = new Events();
					events.setEventId(rs.getInt("Event_id"));
					events.setEventName(rs.getString("event_name"));
					events.setEventPlace(rs.getString("event_place"));
					events.setStartDate(rs.getString("start_date"));
					events.setEndDate(rs.getString("end_date"));
					events.setDescription(rs.getString("event_des"));
					return events;
				}
			});
			
			return event;
		}
		
		public List<Events> clubevents()
		{
			String sql = "SELECT * FROM events WHERE category='Club Events'";
			List<Events> query = jdbctemplate.query(sql, new RowMapper<Events>() {
				
				@Override
				public Events mapRow(ResultSet rs, int arg1) throws SQLException {
					Events events = new Events();
					events.setEventId(rs.getInt("Event_id"));
					events.setEventName(rs.getString("event_name"));
					events.setEventPlace(rs.getString("event_place"));
					events.setStartDate(rs.getString("start_date"));
					events.setEndDate(rs.getString("end_date"));
					events.setDescription(rs.getString("event_des"));
					return events;
				}
			});
			
			return query;
		}

		public boolean deleteEvent(int eventId)
		{
			String sql = "delete from events where event_id=?";
			int delete = jdbctemplate.update(sql,eventId);
			if(delete>0) {
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public Events getEventByEventId(int eventId)
		{
			String sql = "SELECT * FROM events where event_id=?";
			List<Events> query = jdbctemplate.query(sql,new Object[] {eventId},new RowMapper<Events>() {
				
				@Override
				public Events mapRow(ResultSet rs, int arg1) throws SQLException {
					Events events = new Events();
					events.setEventId(rs.getInt("event_id"));
					events.setEventName(rs.getString("event_name"));
					events.setEventPlace(rs.getString("event_place"));
					events.setStartDate(rs.getString("start_date"));
					events.setEndDate(rs.getString("end_date"));
					events.setDescription(rs.getString("event_des"));
					return events;
				}
			});
			
			return query.get(0);
		}
		
		public boolean updateEvent(Events event) {
			System.out.println("inside dao >" + event);
			String sql = "update events set event_name=?,event_place=?,start_date=?,end_date=?,event_des=? where event_id=?";
			int update = jdbctemplate.update(sql, new Object[] { event.getEventName(),event.getEventPlace(),event.getStartDate(),event.getEndDate(),event.getDescription(),event.getEventId() });
			if (update > 0) {
				return true;
			}
			return false;
		}
}
