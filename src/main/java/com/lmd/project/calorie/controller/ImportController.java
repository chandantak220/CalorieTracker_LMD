package com.lmd.project.calorie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lmd.project.calorie.model.Food;
import com.lmd.project.calorie.service.ImportService;

@RestController
@RequestMapping("/Import")
public class ImportController {

	@Autowired
	private ImportService importService;

	@RequestMapping(path = "/fileUpload", method = RequestMethod.POST)
	public String uploadFile(@ModelAttribute Food food) {
		try {
			return importService.UploadFile(food);
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
}
