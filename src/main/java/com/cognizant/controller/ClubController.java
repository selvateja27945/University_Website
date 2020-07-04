package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;

import com.cognizant.dao.ClubDaoImpl;
import com.cognizant.dao.EventDaoImpl;
import com.cognizant.model.Clubs;
import com.cognizant.model.Events;

@Controller
public class ClubController {

	@Autowired
	public ClubDaoImpl clubdaoimpl;
	public EventDaoImpl eventsdaoimpl;
	
	@PostMapping("/clubmember")
	public String insertClubMembers(@ModelAttribute("clubdetails") Clubs club,Model model) {
		//System.out.println("@@@" + user);
		
		try {
			boolean bal = clubdaoimpl.remaining(club);
			System.out.println(bal);
			if(bal)
			{
				boolean members  = clubdaoimpl.insertMembers(club);
				List<Clubs> allclubs = clubdaoimpl.allclubs();
				if(members)
				{
					model.addAttribute("allclubs",allclubs);
					model.addAttribute("members",members);
					return "clubs";
				}
				else
				{
					model.addAttribute("members","false");
					return "clubs";
				}
			}
			else
			{	
				List<Clubs> allclubs = clubdaoimpl.allclubs();
				model.addAttribute("allclubs",allclubs);
				model.addAttribute("members","false");
				return "clubs";
			}
		}
		catch (Exception e)
		{
			List<Clubs> allclubs = clubdaoimpl.allclubs();
			model.addAttribute("allclubs",allclubs);
			model.addAttribute("members","false");
			return "clubs";
		}
	}
	
	@GetMapping("/clubs")
	public String getAllClubs(@ModelAttribute("clubdetails") Clubs club, Model model)
	{
		List<Clubs> allClubs = clubdaoimpl.allclubs();
		model.addAttribute("allclubs",allClubs);
		return "clubs";
	}
	
	@GetMapping("/members")
	public String getMembers(Model model){
		try {
			List<Clubs> members = clubdaoimpl.clubMembers();
			model.addAttribute("members",members);
			return "members";
		}
		catch (Exception e)
		{
			return "club-error";
		}
	}
	
	@GetMapping("/clubevents")
	public String clubEvents(Model model) {
		try
		{
			List<Events> events = eventsdaoimpl.clubevents();
			//System.out.println(events);
			model.addAttribute("events",events);
			return "club-events";
		}
		catch (Exception e)
		{
			return "event-error";
		}
	}
}
