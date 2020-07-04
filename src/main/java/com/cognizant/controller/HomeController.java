package com.cognizant.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.dao.HomeDaoImpl;
import com.cognizant.model.Clubs;
import com.cognizant.model.Events;
import com.cognizant.model.Ideas;
import com.cognizant.model.Users;

@Controller

public class HomeController {

	@RequestMapping("/")
	public ModelAndView getHomeIndexPage(@ModelAttribute("logins") Users user,ModelAndView model) {
		model.setViewName("index");
		return model;
	}

	@RequestMapping("/registration")
	public String getRegistration(@ModelAttribute("userdetails") Users user) {
		return "user-registration";
	}

	@RequestMapping("/userhome")
	public String getRegisterSuccess() {
		return "user-success-page";
	}

	@RequestMapping("/userhome1")
	public String getUserHome() {
		return "userhome1";
	}

	@RequestMapping("/dashboard")
	public String getDashboard() {
		return "admin-home";
	}

	@RequestMapping("/clubs")
	public String getClubs(@ModelAttribute("clubdetails") Clubs club) {
		return "clubs";
	}

	/*@RequestMapping("/getevents")
	public String getIdeasPage(@ModelAttribute("eventdetails") Events events) {
		return "events";
	}*/
	
	@RequestMapping("/members")
	public String getMembers()
	{
		return "members";
	}
	//DropDown for idea category
	@RequestMapping("/ideas")
	public ModelAndView getideas(@ModelAttribute("ideaList") Ideas idea, ModelAndView model) {

		Map<String, String> cl = new HashMap<String, String>();
		cl.put("technology", "technology");
		cl.put("clubs", "clubs");
		cl.put("implementations", "implementations");
		cl.put("publications", "publications");
		model.addObject("cl", cl);
		model.setViewName("ideas1");
		return model;
	}

	@RequestMapping("/searchevent")
	public String getsearchPage(@ModelAttribute("searchevent") Events events) {
		return "search-event";
	}
	
	@Autowired
	public HomeDaoImpl homedaoimpl;

	@PostMapping("/alllogins")
	public ModelAndView adminLogin(@ModelAttribute("logins") Users user,
			ModelAndView model, HttpSession session) {

		Users userVerification = homedaoimpl.VerificationCheck(user);
		if (userVerification != null) {
			session.setAttribute("userSession", userVerification);
			String cat = userVerification.getCategory();
			if (cat.equals("admin")) {
				model.addObject("user", userVerification);
				model.addObject("msg", "Successfully logged in as Admin");
				model.setViewName("admin-success-page");
			} else if (cat.equals("user")) {
				model.addObject("user", userVerification);
				model.addObject("msg", "Successfully logged in as New User");
				model.setViewName("user-success-page");
			}
		} else {
			model.addObject("msg", "Invalid UserName or Password");
			model.setViewName("admin-error-page");
		}

		return model;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(ModelAndView model, HttpSession session) {
		Users attribute = (Users) session.getAttribute("userSession");
		//System.out.println(attribute.getUserId());
		session.removeAttribute("userSession");
		session.invalidate();
		model.setViewName("session-expire");
		return model;
	}
} 
