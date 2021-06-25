package com.lmd.project.calorie.service;

import java.io.InputStream;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lmd.project.calorie.model.Food;
import com.lmd.project.calorie.model.MET;
import com.lmd.project.calorie.repository.FoodRepository;
import com.lmd.project.calorie.repository.METRepository;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Component
public class ImportService extends Throwable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private METRepository metRepository;

	@Transactional(rollbackFor = Exception.class)
	public String UploadFile(Food food) throws Exception {
		String sResult = "";
		for (int i = 0; i < food.getFormFile().length; i++) {
			String sFileName = food.getFormFile()[i].getOriginalFilename();
			if (sFileName.endsWith(".xls")) {
				InputStream fis = null;
				Workbook workbook = null;
				Sheet worksheet = null;

				fis = food.getFormFile()[i].getInputStream();
				workbook = Workbook.getWorkbook(fis);
				worksheet = workbook.getSheet(0);
				int iRow = worksheet.getRows();
				if (worksheet.getColumns() == 8) {
					for (int j = 0; j < iRow; j++) {
						Cell cID = worksheet.getCell(0, j);
						Cell cName = worksheet.getCell(1, j);
						Cell cFoodGroup = worksheet.getCell(2, j);
						Cell cCalories = worksheet.getCell(3, j);
						Cell cFat = worksheet.getCell(4, j);
						Cell cProtein = worksheet.getCell(5, j);
						Cell cCarbohydrate = worksheet.getCell(6, j);
						Cell cDescription = worksheet.getCell(7, j);

						if (j == 0) {
							if ((!cID.getContents().trim().equalsIgnoreCase("ID"))
									|| (!cName.getContents().trim().equalsIgnoreCase("name"))
									|| (!cFoodGroup.getContents().trim().equalsIgnoreCase("Food Group"))
									|| (!cCalories.getContents().trim().equalsIgnoreCase("Calories"))
									|| (!cFat.getContents().trim().equalsIgnoreCase("Fat (g)"))
									|| (!cProtein.getContents().trim().equalsIgnoreCase("Protein (g)"))
									|| (!cCarbohydrate.getContents().trim().equalsIgnoreCase("Carbohydrate (g)"))
									|| (!cDescription.getContents().trim()
											.equalsIgnoreCase("Serving Description 1 (g)"))) {

								sResult = "invalid";
							}
						} else {
							if ((cID.getContents().trim().equalsIgnoreCase(""))
									|| (cName.getContents().trim().equalsIgnoreCase(""))
									|| (cFoodGroup.getContents().trim().equalsIgnoreCase(""))
									|| (cCalories.getContents().trim().equalsIgnoreCase(""))
									|| (cFat.getContents().trim().equalsIgnoreCase(""))
									|| (cProtein.getContents().trim().equalsIgnoreCase(""))
									|| (cCarbohydrate.getContents().trim().equalsIgnoreCase(""))) {

								sResult = "invalid";
							} else {
								food.setId(Integer.parseInt(cID.getContents()));
								food.setName(cName.getContents());
								food.setFoodGroup(cFoodGroup.getContents());
								food.setCalories(new BigDecimal(cCalories.getContents()));
								food.setFat(new BigDecimal(cFat.getContents()));
								food.setProtein(new BigDecimal(cProtein.getContents()));
								food.setCarbohydrate(new BigDecimal(cCarbohydrate.getContents()));
								food.setDescription(cDescription.getContents());
								MultipartFile[] formFile = food.getFormFile();

								food.setFormFile(null);
								foodRepository.save(food);
								food.setFormFile(formFile);
							}
						}
					}
					sResult = "success";
				} else if (worksheet.getColumns() == 3) {

					for (int j = 0; j < iRow; j++) {
						Cell cActivity = worksheet.getCell(0, j);
						Cell cSpecMotion = worksheet.getCell(1, j);
						Cell cMet = worksheet.getCell(2, j);

						if (j == 0) {
							if ((!cActivity.getContents().trim().equalsIgnoreCase("ACTIVITY"))
									|| (!cSpecMotion.getContents().trim().equalsIgnoreCase("SPECIFIC MOTION"))
									|| (!cMet.getContents().trim().equalsIgnoreCase("METs"))) {

								sResult = "invalid";
							}
						} else {
							if ((cActivity.getContents().trim().equalsIgnoreCase(""))
									|| (cSpecMotion.getContents().trim().equalsIgnoreCase(""))
									|| (cMet.getContents().trim().equalsIgnoreCase(""))) {

								sResult = "invalid";
							} else {
								MET met = new MET();
								met.setsActivity(cActivity.getContents());
								met.setsMotion(cSpecMotion.getContents());
								met.setdMET(Double.parseDouble(cMet.getContents()));

								metRepository.save(met);
							}
						}
					}
					sResult = "success";
				}
				sResult = "failure";
			} else {
				sResult = "failure";
			}
		}
		return sResult;
	}
}
