package com.cognizant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.dao.EventDaoImpl;
import com.cognizant.model.Events;
import com.cognizant.model.Ideas;

@Controller
@ComponentScan("com.cognizant.dao")
public class EventController {

		@Autowired
		EventDaoImpl eventdaoimpl;
		
		@PostMapping("/insertEvents")
		public String insertEventDetails(@ModelAttribute("eventdetails") Events event,Model model) {
			//System.out.println("@@@" + user);
			boolean eventdetails = eventdaoimpl.insertEvents(event);
			if(eventdetails)
			{
				model.addAttribute("event",eventdetails);
				return "events-success";
			}
			else
			{
				return "Event-error";
			}
		}
		
		@PostMapping("/insertEventsAd")
		public String insertEventDetailsAd(@ModelAttribute("eventdetails") Events event,Model model) {
			//System.out.println("@@@" + user);
			boolean eventdetails = eventdaoimpl.insertEvents(event);
			if(eventdetails)
			{
				model.addAttribute("event",eventdetails);
				return "admin-event-succesjsp";
			}
			else
			{
				return "Event-error";
			}
		}
		
		@GetMapping("/allevents")
		public String getAllEvents(Model model)
		{
			List<Events> allevents = eventdaoimpl.allEventDetails();
			model.addAttribute("eventlist",allevents);
			return "event-list";
		}
		
		@PostMapping("/searchevents")
		public ModelAndView searchEvent(@RequestParam("search") String search, ModelAndView model)
		{
			
			List<Events> searchevents = eventdaoimpl.searchEvents(search);
			System.out.println(searchevents);
			model.addObject("events",searchevents);
			model.setViewName("search-event");
			
			return model;
		}
		
		@RequestMapping("/getevents")
		public ModelAndView getideas(@ModelAttribute("eventdetails") Events event, ModelAndView model) {

			Map<String, String> cl = new HashMap<String, String>();
			cl.put("University Events", "University Events");
			cl.put("Club Events", "Club Events");
			model.addObject("cl", cl);
			model.setViewName("events");
			return model;
		}
		
}
