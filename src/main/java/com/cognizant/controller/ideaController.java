package com.cognizant.controller;

import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.dao.ideaDaoImpl;
import com.cognizant.model.Events;
//import com.cognizant.model.Events;
import com.cognizant.model.Ideas;
//import com.cognizant.model.Users;

@Controller
@ComponentScan("com.cognizant.dao")
public class ideaController {

		@Autowired
		public ideaDaoImpl ideadaoimpl;
	
		@GetMapping("/viewideas")
		public String getAllideas(Model model)
		{
			List<Ideas> allideas = ideadaoimpl.allIdeaDetails();
			model.addAttribute("ideas",allideas);
			return "list-ideas";
		}
		
		
		@RequestMapping("/option")
		public String getideasPage(@ModelAttribute("ideaList") Ideas idea, Model model) {
			List<Ideas> allideas = ideadaoimpl.allIdeaDetails();
			model.addAttribute("ideas",allideas);
			return "ideas1";
		}
		
		//notification
		/*@GetMapping("/notification")
		 * List<User> notification = userdaoimpl.notification();
		 * model.addAttribute(Model model);
		 * return notification;
		 */
		
		
		@PostMapping("/insertidea")
		public ModelAndView insertEventDetails(@ModelAttribute("ideaList") Ideas idea,ModelAndView model) {
			//System.out.println("@@@" + user);
			boolean insertidea  = ideadaoimpl.insertIdeas(idea);
			//List<Ideas> allideas = ideadaoimpl.allIdeaDetails();
			if(insertidea)
			{
				model.addObject("idea",insertidea);
				model.setViewName("ideas");
			}
			else
			{
				model.addObject("idea","false");
				model.setViewName("ideas");
			}
			
			return model;
		}
		
		@RequestMapping("/Updateidea1/{ideaId}")
		public String deleteUser(@ModelAttribute("categoryList") Ideas idea, Model model, @PathVariable("ideaId") int ideaId)
		{
			boolean vote = ideadaoimpl.updateIdea1(ideaId);
			if(vote)
			{
				List<Ideas> allideas = ideadaoimpl.allIdeaDetails();
				model.addAttribute("ideas",allideas);
				return "list-ideas";
			}
			else
			{
				return "delete-error";
			}
		}

		@RequestMapping("/Updateidea2/{ideaId}")
		public String updateIdea(@ModelAttribute("categoryList") Ideas idea, Model model, @PathVariable("ideaId") int ideaId)
		{
			boolean vote = ideadaoimpl.updateIdea2(ideaId);
			if(vote)
			{
				List<Ideas> allideas = ideadaoimpl.allIdeaDetails();
				model.addAttribute("ideas",allideas);
				return "list-ideas";
			}
			else
			{
				return "delete-error";
			}
		}
		
		@PostMapping("/comments/{ideaId}")
		public ModelAndView updatecomments(@RequestParam("comments") String comment,@PathVariable("ideaId") int ideaId, ModelAndView model)
		{
			boolean comm = ideadaoimpl.addcomment(ideaId,comment);
			List<Ideas> allideas = ideadaoimpl.allIdeaDetails();
			if(comm)
			{
				model.addObject("ideas",allideas);
				model.setViewName("list-ideas");
			}
			else
			{
				model.setViewName("event-success");
			}
			
			return model;
		}
		
		/*@RequestMapping("/ideas")
		public ModelAndView getideas(@ModelAttribute("ideaList") Ideas idea, ModelAndView model) {

			Map<String, String> cl = new HashMap<String, String>();
			cl.put("Technology", "Technology");
			cl.put("Social", "Social");
			cl.put("Others", "Others");
			model.addObject("cl", cl);
			model.setViewName("ideas");
			return model;
		}*/
}
