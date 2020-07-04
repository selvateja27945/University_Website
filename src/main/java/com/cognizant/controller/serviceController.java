package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.dao.ServiceDaoImpl;
import com.cognizant.model.services;

@Controller
@ComponentScan("com.cognizant.dao")
public class serviceController {
	
	@Autowired
	public ServiceDaoImpl servicedaoimpl;
	
	@PostMapping("/addvolunteers")
	public String insertservice(@ModelAttribute("servicesdetails") services service,Model model) {
		//System.out.println("@@@" + user);
		try {
			boolean bal = servicedaoimpl.remaining(service);
			//System.out.println(bal);
			if(bal)
			{
				boolean volunteers  = servicedaoimpl.insertVolunteers(service);
				List<services> allservices = servicedaoimpl.allservices();
				if(volunteers)
				{
					model.addAttribute("volunteer",volunteers);
					model.addAttribute("allservices",allservices);
					return "services";
				}
				else
				{
					model.addAttribute("volunteer","false");
					return "services";
				}
			}
			else
			{
				List<services> allservices = servicedaoimpl.allservices();
				model.addAttribute("allservices",allservices);
				//model.addAttribute("msg", "Successfully logged in as Admin");
				return "services";
			}
		}
		catch (Exception e)
		{
			List<services> allservices = servicedaoimpl.allservices();
			model.addAttribute("allservices",allservices);
			model.addAttribute("volunteers","false");
			return "services";
		}
	}
	
	@GetMapping("/services")
	public String getAllservices(@ModelAttribute("servicesdetails") services service, Model model)
	{
		List<services> allservices = servicedaoimpl.allservices();
		model.addAttribute("allservices",allservices);
		return "services";
	}
	
	/*@PostMapping("/insertservices")
	public String insertServicesDetails(@ModelAttribute("eventdetails") services service,Model model) {
		//System.out.println("@@@" + user);
		boolean servicedetails = servicedaoimpl.insertServices(service);
		if(servicedetails)
		{
			model.addAttribute("service",servicedetails);
			return "services";
		}
		else
		{
			return "Event-error";
		}
	} */
	
	@GetMapping("/volunteers")
	public String getMembers(Model model){
		List<services> members = servicedaoimpl.volunteers();
		model.addAttribute("members",members);
		return "volunteers";
	}
}
