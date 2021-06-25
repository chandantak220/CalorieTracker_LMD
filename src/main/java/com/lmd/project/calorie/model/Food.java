package com.lmd.project.calorie.model;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "s_Fooddata")
public class Food {

	@Id
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String foodGroup;

	@Column(nullable = false)
	private BigDecimal calories;

	@Column(nullable = false)
	private BigDecimal fat;

	@Column(nullable = false)
	private BigDecimal protein;

	@Column(nullable = false)
	private BigDecimal carbohydrate;

	@Column(nullable = false)
	private String description;

	@Basic
	private MultipartFile formFile[];

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodGroup() {
		return foodGroup;
	}

	public void setFoodGroup(String foodGroup) {
		this.foodGroup = foodGroup;
	}

	public BigDecimal getCalories() {
		return calories;
	}

	public void setCalories(BigDecimal calories) {
		this.calories = calories;
	}

	public BigDecimal getFat() {
		return fat;
	}

	public void setFat(BigDecimal fat) {
		this.fat = fat;
	}

	public BigDecimal getProtein() {
		return protein;
	}

	public void setProtein(BigDecimal protein) {
		this.protein = protein;
	}

	public BigDecimal getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(BigDecimal carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile[] getFormFile() {
		return formFile;
	}

	public void setFormFile(MultipartFile[] formFile) {
		this.formFile = formFile;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", foodGroup=" + foodGroup + ", calories=" + calories + ", fat="
				+ fat + ", protein=" + protein + ", carbohydrate=" + carbohydrate + ", description=" + description
				+ ", formFile=" + Arrays.toString(formFile) + "]";
	}

}
