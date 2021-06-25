package com.lmd.project.calorie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s_FoodDetails")
public class FoodDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String weight;

	@Column(nullable = false)
	private String height;

	@Column(nullable = false)
	private String age;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	private String chkin[] = null;

	@Column(nullable = false)
	private String foodData[] = null;

	@Column(nullable = false)
	private String fooName[] = null;

	@Column(nullable = false)
	private String foodTime[] = null;

	@Column(nullable = false)
	private String calories[] = null;

	@Column(nullable = false)
	private String chkout[] = null;

	@Column(nullable = false)
	private String ActivityData[] = null;

	@Column(nullable = false)
	private String ActivityName[] = null;

	@Column(nullable = false)
	private String ActivityDuration[] = null;

	@Column(nullable = false)
	private String actcalories[] = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getChkin() {
		return chkin;
	}

	public void setChkin(String[] chkin) {
		this.chkin = chkin;
	}

	public String[] getFoodData() {
		return foodData;
	}

	public void setFoodData(String[] foodData) {
		this.foodData = foodData;
	}

	public String[] getFooName() {
		return fooName;
	}

	public void setFooName(String[] fooName) {
		this.fooName = fooName;
	}

	public String[] getFoodTime() {
		return foodTime;
	}

	public void setFoodTime(String[] foodTime) {
		this.foodTime = foodTime;
	}

	public String[] getCalories() {
		return calories;
	}

	public void setCalories(String[] calories) {
		this.calories = calories;
	}

	public String[] getChkout() {
		return chkout;
	}

	public void setChkout(String[] chkout) {
		this.chkout = chkout;
	}

	public String[] getActivityData() {
		return ActivityData;
	}

	public void setActivityData(String[] activityData) {
		ActivityData = activityData;
	}

	public String[] getActivityName() {
		return ActivityName;
	}

	public void setActivityName(String[] activityName) {
		ActivityName = activityName;
	}

	public String[] getActivityDuration() {
		return ActivityDuration;
	}

	public void setActivityDuration(String[] activityDuration) {
		ActivityDuration = activityDuration;
	}

	public String[] getActcalories() {
		return actcalories;
	}

	public void setActcalories(String[] actcalories) {
		this.actcalories = actcalories;
	}

}
