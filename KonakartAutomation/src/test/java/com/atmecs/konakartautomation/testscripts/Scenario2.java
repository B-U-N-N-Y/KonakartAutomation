package com.atmecs.konakartautomation.testscripts;

import org.testng.annotations.Test;

import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.dataProvider.TestDataProvider;
import com.atmecs.konakartautomation.helpers.CommonUtility;
import com.atmecs.konakartautomation.pages.Scenario2Validation;
import com.atmecs.konakartautomation.testbase.TestBase;

public class Scenario2 extends TestBase{

	@Test(dataProvider = "heroimage", dataProviderClass = TestDataProvider.class)
	public void heroImg(String[] data) {
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.heroimg.btn"));
		Scenario2Validation.heroImgValidation(driver, data);
	}
	
	
}
