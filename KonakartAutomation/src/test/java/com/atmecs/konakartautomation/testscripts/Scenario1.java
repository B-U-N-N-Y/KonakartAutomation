package com.atmecs.konakartautomation.testscripts;

import org.testng.annotations.Test;

import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.dataProvider.TestDataProvider;
import com.atmecs.konakartautomation.helpers.CommonUtility;
import com.atmecs.konakartautomation.pages.Scenario1Validation;
import com.atmecs.konakartautomation.testbase.TestBase;


public class Scenario1 extends TestBase{
	
	
	@Test( dataProvider = "searchbox", dataProviderClass = TestDataProvider.class)
	public void searchBox(String[] data) {
		Scenario1Validation.isRedirection(driver, data[8]);
		Scenario1Validation.serachBoxInput(data);
		Scenario1Validation.validateProduct(data);
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.home.btn"));
		Scenario1Validation.negativeInputvalidtion(data);
	}
}