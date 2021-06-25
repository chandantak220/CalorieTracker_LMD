package com.lmd.project.calorie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	@RequestMapping(path = "/")
	public String showWelcomePage() {
		return "welcome";
	}

	@RequestMapping("/addUserPage")
	public String showUserRegisterPage() {
		return "index";
	}

	@RequestMapping("/fetchUserPage")
	public String showAllUserPage() {
		return "FetchUser";
	}

	@RequestMapping("/importData")
	public String uploadFoodActivityData() {
		return "ImportData";
	}
}
