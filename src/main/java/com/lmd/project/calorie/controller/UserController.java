package com.lmd.project.calorie.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lmd.project.calorie.exeption.UserNotFoundException;
import com.lmd.project.calorie.model.User;
import com.lmd.project.calorie.repository.FoodRepository;
import com.lmd.project.calorie.repository.UserRepository;
import com.lmd.project.calorie.service.UserFoodDataService;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private UserFoodDataService userFoodDataService;

	@PostMapping("/fetchAll")
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User findOne(@PathVariable long id) {
		return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
	}

	@RequestMapping(path = "/save", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestBody User user) {
		user = userRepository.save(user);
		return "Data Saved Successfully and Generated id--> " + user.getId();
	}

	@PostMapping(path = "/delete/{id}")
	public String delete(@PathVariable long id) {
		userRepository.findById(id).orElseThrow(UserNotFoundException::new);
		userRepository.deleteById(id);
		return "/fetchUserPage";
	}

	@GetMapping(path = "/fillFoodDetails/{id}")
	public ModelAndView fillFoodDetails(@PathVariable long id) {
		String sUserName = userRepository.findById(id).get().getUsername();
		String sGender = userRepository.findById(id).get().getGender();
		int iWeight = userRepository.findById(id).get().getWeight();
		int iHeight = userRepository.findById(id).get().getHeight();
		String sDate = userRepository.findById(id).get().getDob();
		LocalDate currentDate = LocalDate.now();
		LocalDate dateofBirth = LocalDate.parse(sDate);
		int age = Period.between(dateofBirth, currentDate).getYears();
		Iterable<String> sFooddata = foodRepository.getFoodGroup();
		Iterable<String> sActivityData = foodRepository.getActivityGroup();
		ModelAndView mv = new ModelAndView("FoodDetails");
		mv.addObject("username", sUserName);

		mv.addObject("gender", sGender);
		mv.addObject("weight", iWeight);
		mv.addObject("height", iHeight);
		mv.addObject("age", age);
		mv.addObject("userid", id);
		mv.addObject("foodList", sFooddata);
		mv.addObject("actList", sActivityData);
		return mv;
	}

	@PostMapping(path = "/fetchDetails/{data}")
	public String fetchFoodData(@PathVariable String data) {
		String sType[] = data.split("~");
		String[][] str = null;
		if (sType[1].equalsIgnoreCase("Food")) {
			str = foodRepository.getFoodNameAsPerFoodGroup(sType[0].trim());
		} else {
			str = foodRepository.getActivityNameAsPerFoodGroup(sType[0].trim());
		}
		String sReturnData = "[";
		if (str != null) {
			if (sType[1].equalsIgnoreCase("Food")) {
				for (int i = 0; i < str.length; i++) {
					String format = "{\"id\":\"";
					format = format + str[i][0] + "\",";
					format = format + "\"foodName\":\"";
					format = format + str[i][1] + "\",";
					format = format + "\"foodCalories\":\"";
					format = format + str[i][2] + "\"},";
					sReturnData = sReturnData + format;
				}
			} else {
				for (int i = 0; i < str.length; i++) {
					String format = "{\"id\":\"";
					format = format + str[i][0] + "\",";
					format = format + "\"activityName\":\"";
					format = format + str[i][1] + "\"},";
					sReturnData = sReturnData + format;
				}
			}
			sReturnData = sReturnData.substring(0, sReturnData.length() - 1);
			sReturnData = sReturnData + "]";
			System.out.println("OutPut String---> " + sReturnData);
		} else {
			return null;
		}
		return sReturnData;
	}

	@PostMapping("/saveAllUserFoodData")
	public String saveAllFoodData(@RequestBody String foodData) {
		String returnData = "Failure";
		try {
			org.codehaus.jettison.json.JSONObject obj = new org.codehaus.jettison.json.JSONObject(foodData);
			returnData = userFoodDataService.saveUserFoodData(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnData;
	}
}