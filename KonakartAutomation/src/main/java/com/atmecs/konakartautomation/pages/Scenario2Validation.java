package com.atmecs.konakartautomation.pages;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.helpers.CommonUtility;

public class Scenario2Validation {

	public static void heroImgValidation(WebDriver driver, String[] data) {
		if (driver.getTitle().equalsIgnoreCase(data[0])) {
			pageDescriptionvalidation(data[2]);
			specificationValidation(data[3]);

		} else if (driver.getTitle().equalsIgnoreCase(data[1])) {
			pageDescriptionvalidation(data[4]);
			specificationValidation(data[3]);
		}
	}

	private static void specificationValidation(String validatedata) {
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.heroimg.specification.btn"));
		CommonUtility.scrollDownPage(0, 300);
		String specification = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.heroimg.specification.txt")).getText();
		System.out.println(specification);
		System.out.println(validatedata);
		Assert.assertTrue(specification.contains(validatedata), "Failed");
		System.out.println("specification validate successfully");
	}

	private static void pageDescriptionvalidation(String validatedata) {
		String description = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.heroimg.description.txt")).getText();
		Assert.assertTrue(description.contains(validatedata), "Failed");
		System.out.println("description validate successfully");
	}

	

	public static void val() {
		
		List<WebElement> elements = CommonUtility
				.getElementsList(LoadPropertyFile.locators.getProperty("loc.konakart.reviewcount"));
		int loopCount = elements.size();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
		for(int index=1;index<loopCount;index++) {
			String date1 = CommonUtility.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.reviewdates").replace("index", index + "")).getText();
		}
	}

}
