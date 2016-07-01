package net.codejava.spring.controller;


import net.codejava.spring.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	 
	@RequestMapping(method=RequestMethod.GET)
	public String showForm(ModelMap model){
		User user = new User();
		model.addAttribute("USER", user);
		return "Registration";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String processForm(@ModelAttribute(value="USER") User user,BindingResult result){
		if(result.hasErrors()){
			return "Registration";
		}else{
			System.out.println("User values is : " + user);
			return "RegistrationSuccess";
		}		
	}

}
