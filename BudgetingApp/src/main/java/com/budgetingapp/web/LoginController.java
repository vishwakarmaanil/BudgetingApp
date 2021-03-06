package com.budgetingapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.budgetingapp.domain.User;

@Controller
public class LoginController
{
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(ModelMap model)
	{
		User user = new User();
		model.put("user", user);

		return "login";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister(ModelMap model)
	{
		User user = new User();
		model.put("user", user);

		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(@ModelAttribute User user, ModelMap model)
	{
		return "redirect:/budgets";
	}
}
