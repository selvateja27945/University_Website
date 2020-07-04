package com.cognizant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.dao.AdminDaoImpl;
import com.cognizant.dao.ClubDaoImpl;
import com.cognizant.dao.EventDaoImpl;
import com.cognizant.dao.UserDaoImpl;
import com.cognizant.model.Clubs;
import com.cognizant.model.Events;
import com.cognizant.model.Users;

@Controller
@ComponentScan("com.cognizant.dao")
public class AdminController {
	
	@Autowired
	public AdminDaoImpl adminDaoImpl;
	
	@Autowired
	public EventDaoImpl eventdaoimpl;
	
	@Autowired
	public UserDaoImpl userDaoImpl;
	
	@Autowired
	public ClubDaoImpl clubdaoimpl;
	
	@GetMapping("/allusers")
	public String getAllUsers(Model model,HttpSession session)
	{
		String str="";
		try {
			Users user=(Users)session.getAttribute("userSession");
			System.out.println(user.getFirstName());
			if(user.getFirstName()!=null) {
				List<Users> allusers = adminDaoImpl.allUserDetails();
				model.addAttribute("userlist",allusers);
				str= "user-list";	
			}
			else {
				str= "admin-error-page";
			}
		}
		catch (Exception e) {
			str= "session-expire";
		}
		return str;
		
	}
	
	@RequestMapping("/Aevents")
	public String getAdminEventPage(@ModelAttribute("eventdetails") Events  events) {
		return "admin-events";
	}
	
	@RequestMapping("/gevents")
	public ModelAndView getideas(@ModelAttribute("eventdetails") Events event, ModelAndView model) {

		Map<String, String> cl = new HashMap<String, String>();
		cl.put("University Events", "University Events");
		cl.put("Club Events", "Club Events");
		model.addObject("cl", cl);
		model.setViewName("admin-events2");
		return model;
	}
	
	@RequestMapping("/addClub")
	public String getclubDetails(@ModelAttribute("insertclub") Clubs  club) {
		return "add-club";
	}
	
	@GetMapping("/listevents")
	public String getAllEvent(Model model) {
		List<Events> allevents = eventdaoimpl.allEventDetails();
		model.addAttribute("eventlist", allevents);
		return "admin-event-list";
	}
	
	@RequestMapping("/deleteEvent/{eventId}")
	public String deleteEvent(Model model, @PathVariable("eventId") int eventId) {
		boolean deleteEvent = eventdaoimpl.deleteEvent(eventId);
		if (deleteEvent) {
			List<Events> allusers = eventdaoimpl.allEventDetails();
			model.addAttribute("eventlist", allusers);
			return "admin-event-list";
		} else {
			return "delete-error";
		}
	}

	@PostMapping("/inserteventsadmin")
	public String insertEvent(@ModelAttribute("eventdetails") Events event,Model model) {
		//System.out.println("@@@" + user);
		boolean eventdetails = eventdaoimpl.insertEvents(event);
		if(eventdetails)
		{
			model.addAttribute("event",eventdetails);
			return "admin-event-success";
		}
		else
		{
			return "Event-error";
		}
	}
	
	@RequestMapping("/editEvent/{eventId}")
	public String editEvent(Model model, @PathVariable("eventId") int eventId) {
		System.out.println("inside controller" + eventId);
		Events event = eventdaoimpl.getEventByEventId(eventId);
		if (event != null) {

			model.addAttribute("event", event);
			return "admin-event-edit";
		} else {
			return "delete-error";
		}
	} 
	
	
	@PostMapping("/updatEventDetail")
	public String updateEventDetail(Model model, @ModelAttribute("event") Events event) {
		System.out.println("inside controller " + event);
		boolean update = eventdaoimpl.updateEvent(event);
		if (update) {
			model.addAttribute("message", "User Updated Successfully");
			return "display-page";
		}
		else
		{
			return "delete-error";
		}
		
	}
	
	@RequestMapping("/deleteUser/{userId}")
	public String deleteUser(Model model, @PathVariable("userId") int userId,HttpSession session)
	{
		String str = "";
		try {
			Users user = (Users)session.getAttribute("userSession");
			if(user.getFirstName()!=null)
			{
				boolean deleteUser = adminDaoImpl.deleteUser(userId);
				if(deleteUser)
				{
					List<Users> allusers = adminDaoImpl.allUserDetails();
					model.addAttribute("userlist",allusers);
					str="user-list";
				}
				else
				{
					return "delete-error";
				}
			}
			else {
				return "session-expire";
			}
		}
		catch (Exception e) {
			str = "session-expire";
		}
		
		return str;
	}
	
	
	@PostMapping("/insertClub")
	public String insertClubDetails(@ModelAttribute("insertclub") Clubs club,Model model) {
		//System.out.println("@@@" + user);
		System.out.println(club.getClubStrength());
		System.out.println(club.getClubName());
		System.out.println(club.getEligibility());
		boolean Clubdetails = clubdaoimpl.insertClubs(club);
		if(Clubdetails)
		{
			model.addAttribute("club",Clubdetails);
			return "add-club";
		}
		else
		{
			return "Event-error";
		}
	}
	
	@GetMapping("/Adminclubs")
	public String getAllClubs(@ModelAttribute("clubdetails") Clubs club, Model model)
	{
		List<Clubs> allClubs = clubdaoimpl.allclubs();
		model.addAttribute("allclubs",allClubs);
		return "admin-club";
	}
	
	@RequestMapping("/deleteclub/{clubId}")
	public String deleteclub(Model model, @PathVariable("clubId") int clubId) {
		boolean deleteclub = clubdaoimpl.deleteclub(clubId);
		if (deleteclub) {
			List<Clubs> allclubs = clubdaoimpl.allclubs();
			model.addAttribute("allclubs", allclubs);
			return "admin-club";
		} else {
			return "delete-error";
		}
	}

	@RequestMapping("/editclub/{clubId}")
	public String editClub1(Model model, @PathVariable("clubId") int clubId,@ModelAttribute("clubdetails") Clubs club) {
		Clubs clubs = clubdaoimpl.getClubByClubId(clubId);
		if (clubs != null) {

			model.addAttribute("club", clubs);
			return "admin-club-edit";
		} else {
			return "delete-error";
		}
	} 
	
	@PostMapping("/updatClubDetail")
	public String updateCLubDetail(Model model, @ModelAttribute("clubdetails") Clubs club) {
		//System.out.println("inside controller " + event);
		boolean update = clubdaoimpl.updateClub(club);
		if (update) {
			model.addAttribute("message", update);
			return "display-page";
		}
		else
		{
			return "delete-error";
		}
		
	}
}
