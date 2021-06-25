package com.lmd.project.calorie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lmd.project.calorie.model.Food;

public interface FoodRepository extends CrudRepository<Food, Long> {

	@Query(value = "select food_group from s_fooddata where food_group<>'NULL' group by food_group", nativeQuery = true)
	public List<String> getFoodGroup();

	@Query(value = "select s_activity from s_met group by s_activity order by s_activity", nativeQuery = true)
	public List<String> getActivityGroup();

	@Query(value = "select id,name,calories from s_fooddata where food_group=:foodGroup order by name ", nativeQuery = true)
	public String[][] getFoodNameAsPerFoodGroup(@Param("foodGroup") String foodGroup);

	@Query(value = "select dmet,s_motion from s_met where s_activity=:activityGroup ", nativeQuery = true)
	public String[][] getActivityNameAsPerFoodGroup(@Param("activityGroup") String activityGroup);

	@Modifying
	@Query(value = "insert into s_userFoodData (usr_userid,usr_height,usr_weight,usr_age,usr_gender,date,food_foodGroup,food_foodName,food_calories,food_time,act_group,act_name,act_duration,act_calories)\r\n"
			+ "values (:userid,:userHeight,:userWeight,:userAge,:userGender,:date,:foodGrp,:foodName,:foodCalories,:foodTime,:actGrp,:actName,:actDuration,:actCalories)", nativeQuery = true)
	public void saveUserFoodDetails(@Param("userid") long userId, @Param("userHeight") long userHeight,
			@Param("userWeight") long userWeight, @Param("userAge") long usr_age,
			@Param("userGender") String usr_gender, @Param("date") String date, @Param("foodGrp") String food_foodGroup,
			@Param("foodName") String food_foodName, @Param("foodCalories") double food_calories,
			@Param("foodTime") String food_time, @Param("actGrp") String act_group, @Param("actName") String act_name,
			@Param("actDuration") int act_duration, @Param("actCalories") double act_calories);

	@Modifying
	@Query(value = "insert into s_caloryData (caloryData_date,caloryData_userId,caloryData_InCalories,caloryData_OutCalories,caloryData_NetCalories) "
			+ "values (:date,:userid,:InCalories,:OutCalories,:NetCalories)", nativeQuery = true)
	public void saveCaloryDetails(@Param("date") String date, @Param("userid") long userId,
			@Param("InCalories") double InCalories, @Param("OutCalories") double OutCalories,
			@Param("NetCalories") double NetCalories);

}
