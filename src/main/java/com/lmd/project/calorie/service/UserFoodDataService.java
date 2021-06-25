package com.lmd.project.calorie.service;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lmd.project.calorie.repository.FoodRepository;

@Component
public class UserFoodDataService extends Throwable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private FoodRepository FoodRepository;

	@Transactional(rollbackFor = Exception.class)
	public String saveUserFoodData(JSONObject jsonObj) throws Exception {
		String sResult = "failure";
		System.out.println("Input JSON String--> " + jsonObj.toString());
		double lNetCalories = Double.parseDouble(jsonObj.getString("netCalories").trim());
		double lTotalInCalories = Double.parseDouble(jsonObj.getString("totalInCalories").trim());
		double lTotalOutCalories = Double.parseDouble(jsonObj.getString("totalOutCalories").trim());
		long userId = Long.parseLong(jsonObj.getString("userid").trim());
		String sGender = jsonObj.getString("gender");
		long age = Long.parseLong(jsonObj.getString("age").trim());
		long weight = Long.parseLong(jsonObj.getString("weight").trim());
		long height = Long.parseLong(jsonObj.getString("height").trim());
		String sDate = jsonObj.getString("foodDate").trim();
		String foodData = jsonObj.getString("foodData").trim();
		String foodName = jsonObj.getString("foodName").trim();
		String sfoodCalories = jsonObj.getString("calories").trim();
		String sFoodTime = jsonObj.getString("foodTime").trim();
		String sActivityGroup = jsonObj.getString("ActivityData").trim();
		String sActivityName = jsonObj.getString("ActivityName").trim();
		String sActivityDuration = jsonObj.getString("ActivityDuration").trim();
		String sActivityCalories = jsonObj.getString("actcalories").trim();
		if (!foodData.contains("[")) {
			foodData = "[" + foodData;
			foodData = foodData + "]";

			foodName = "[" + foodName;
			foodName = foodName + "]";

			sfoodCalories = "[" + sfoodCalories;
			sfoodCalories = sfoodCalories + "]";

			sFoodTime = "[" + sFoodTime;
			sFoodTime = sFoodTime + "]";
		} else if (!sActivityGroup.contains("[")) {
			sActivityGroup = "[" + sActivityGroup;
			sActivityGroup = sActivityGroup + "]";

			sActivityName = "[" + sActivityName;
			sActivityName = sActivityName + "]";

			sActivityDuration = "[" + sActivityDuration;
			sActivityDuration = sActivityDuration + "]";

			sActivityCalories = "[" + sActivityCalories;
			sActivityCalories = sActivityCalories + "]";
		}
		JSONArray FoodGrp = new JSONArray(foodData);
		JSONArray foodNameArray = new JSONArray(foodName);
		JSONArray foodCalories = new JSONArray(sfoodCalories);
		JSONArray foodTime = new JSONArray(sFoodTime);
		JSONArray activityGroup = new JSONArray(sActivityGroup);
		JSONArray activityName = new JSONArray(sActivityName);
		JSONArray activityDuration = new JSONArray(sActivityDuration);
		JSONArray activityCalories = new JSONArray(sActivityCalories);
		int iCheck = 0;

		if (FoodGrp.length() < activityGroup.length()) {
			for (int i = 0; i < FoodGrp.length(); i++) {
				FoodRepository.saveUserFoodDetails(userId, height, weight, age, sGender, sDate, FoodGrp.getString(i),
						foodNameArray.getString(i), Double.parseDouble(foodCalories.getString(i).trim()),
						foodTime.getString(i), activityGroup.getString(i), activityName.getString(i),
						Integer.parseInt(activityDuration.getString(i)),
						Double.parseDouble(activityCalories.getString(i).trim()));
			}
			for (int j = FoodGrp.length(); j < activityGroup.length(); j++) {
				FoodRepository.saveUserFoodDetails(userId, height, weight, age, sGender, sDate, "", "", 0.0d, "",
						activityGroup.getString(j), activityName.getString(j),
						Integer.parseInt(activityDuration.getString(j).trim()),
						Double.parseDouble(activityCalories.getString(j).trim()));
			}
			iCheck = 1;
		} else if (FoodGrp.length() > activityGroup.length()) {
			for (int i = 0; i < activityGroup.length(); i++) {
				FoodRepository.saveUserFoodDetails(userId, height, weight, age, sGender, sDate, FoodGrp.getString(i),
						foodNameArray.getString(i), Double.parseDouble(foodCalories.getString(i).trim()),
						foodTime.getString(i), activityGroup.getString(i), activityName.getString(i),
						Integer.parseInt(activityDuration.getString(i).trim()),
						Double.parseDouble(activityCalories.getString(i).trim()));
			}
			for (int j = activityGroup.length(); j < FoodGrp.length(); j++) {
				FoodRepository.saveUserFoodDetails(userId, height, weight, age, sGender, sDate, FoodGrp.getString(j),
						foodNameArray.getString(j), Double.parseDouble(foodCalories.getString(j).trim()),
						foodTime.getString(j), "", "", 0, 0.0d);
			}
			iCheck = 1;
		} else if (FoodGrp.length() == activityGroup.length()) {
			for (int i = 0; i < activityGroup.length(); i++) {
				FoodRepository.saveUserFoodDetails(userId, height, weight, age, sGender, sDate, FoodGrp.getString(i),
						foodNameArray.getString(i), Double.parseDouble(foodCalories.getString(i).trim()),
						foodTime.getString(i), activityGroup.getString(i), activityName.getString(i),
						Integer.parseInt(activityDuration.getString(i).trim()),
						Double.parseDouble(activityCalories.getString(i).trim()));
			}
			iCheck = 1;
		}
		if (iCheck == 1)
			FoodRepository.saveCaloryDetails(sDate, userId, lTotalInCalories, lTotalOutCalories, lNetCalories);

		sResult = "success";
		return sResult;
	}

}
