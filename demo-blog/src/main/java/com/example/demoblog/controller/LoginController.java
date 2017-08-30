package com.example.demoblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demoblog.form.LoginForm;
import com.example.demoblog.service.LoginService;
import com.example.demoblog.service.NotificationService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@Autowired
	private NotificationService notifyService;

	@RequestMapping("/users/login")
	public String login(LoginForm loginForm) {
		return "users/login";
	}

	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			notifyService.addErrorMessage("Please fill the form correctly!");
			return "users/login";
		}

		if (!loginService.authenticate(loginForm.getUsername(), loginForm.getPassword())) {
			notifyService.addErrorMessage("Invalid login!");
			return "users/login";
		}

		notifyService.addInfoMessage("Login successful");
		return "redirect:/";
	}
}
