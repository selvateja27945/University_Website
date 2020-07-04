package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.dao.UserDaoImpl;
import com.cognizant.model.Users;

@Controller
public class UserController {
	
	@Autowired
	UserDaoImpl userdaoimpl;
	
	@PostMapping("/insertUserDetails")
	public String insertUserDetails(@ModelAttribute("userdetails") Users user,Model model) {
		//System.out.println("@@@" + user);
		boolean exist = userdaoimpl.userCheck(user);
		if(exist)
		{
			return "user-exist";
		}
		else
		{	
			boolean insertdetails = userdaoimpl.insertUserDetails(user);
			if(insertdetails)
			{
				model.addAttribute("user",insertdetails);
				return "registration-success";
			}
			else
			{
				return "admin-error-page";
			}
		}
	}
		
	
}
