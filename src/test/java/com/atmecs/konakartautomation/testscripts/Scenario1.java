package com.atmecs.konakartautomation.testscripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.dataProvider.TestDataProvider;
import com.atmecs.konakartautomation.helpers.CommonUtility;
import com.atmecs.konakartautomation.pages.Scenario1Validation;
import com.atmecs.konakartautomation.testbase.TestBase;


public class Scenario1 extends TestBase{
	public static Logger log;
	
	@Test(priority=1, dataProvider = "searchbox", dataProviderClass = TestDataProvider.class)
	public void searchBox(String[] data) {
		log = Logger.getLogger(Scenario1.class);
		logger = extent.startTest("Search box Functionality validation");
		Scenario1Validation.isRedirection(driver, data[8],log);
		Scenario1Validation.serachBoxInput(data);
		Scenario1Validation.validateProduct(data,log);
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.home.btn"));
		Scenario1Validation.negativeInputvalidtion(data,log);
	}
}