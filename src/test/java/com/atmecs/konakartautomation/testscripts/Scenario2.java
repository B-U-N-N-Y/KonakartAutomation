package com.atmecs.konakartautomation.testscripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.dataProvider.TestDataProvider;
import com.atmecs.konakartautomation.helpers.CommonUtility;
import com.atmecs.konakartautomation.pages.Scenario2Validation;
import com.atmecs.konakartautomation.testbase.TestBase;

public class Scenario2 extends TestBase {
	public static Logger log;

	@Test(priority = 2, dataProvider = "heroimage", dataProviderClass = TestDataProvider.class)
	public void heroImgContent(String[] data) {
		log = Logger.getLogger(Scenario2.class);
		logger = extent.startTest("Hero image content validation");
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.heroimg.btn"));
		Scenario2Validation.heroImgContentValidation(driver, data,log);
	}

	@Test(priority = 3,dataProvider = "reviewdropdown", dataProviderClass = TestDataProvider.class)
	public void heroImgSortingDateFunctionality(String[]  data) {
		log = Logger.getLogger(Scenario2.class);
		logger = extent.startTest("Hero image sorting validation by date");
		Scenario2Validation.heroImgSortOption(data[0]);
		Scenario2Validation.sortingDateValidation(data[0],log);
		Scenario2Validation.heroImgSortOption(data[1]);
		Scenario2Validation.sortingDateValidation(data[1],log);
	}

	@Test(priority = 4,dataProvider = "reviewdropdown", dataProviderClass = TestDataProvider.class)
	public void heroImgSortingRatingFunctionality(String[] data) {
		log = Logger.getLogger(Scenario2.class);
		logger = extent.startTest("Hero image sorting validation by rating");
		Scenario2Validation.heroImgSortOption(data[2]);
		Scenario2Validation.starRatingValidation(data[2],log);
		Scenario2Validation.heroImgSortOption(data[3]);
		Scenario2Validation.starRatingValidation(data[3],log);
	}

}
