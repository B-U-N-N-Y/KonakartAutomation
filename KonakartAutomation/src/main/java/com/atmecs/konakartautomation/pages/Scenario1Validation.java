package com.atmecs.konakartautomation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.helpers.CommonUtility;

public class Scenario1Validation {

	public static void serachBoxInput(String[] data) {
		CommonUtility.selectDropdown(LoadPropertyFile.locators.getProperty("loc.konakart.homepage.dpdn"), data[0]);
		CommonUtility.clickAndSendText(LoadPropertyFile.locators.getProperty("loc.konakart.search.txtbox"), data[1]);
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.search.btn"));
	}

	public static void isRedirection(WebDriver driver, String validatedata) {
		String title = driver.getTitle();
		Assert.assertEquals(title, validatedata, "Page is not redirect properly");
		System.out.println("Page is redirecting to proper web page");
	}

	public static void validateProduct(String[] data) {
		String producttitle = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.producttitle.txt")).getText();
		Assert.assertEquals(producttitle, data[1], "Product title validationfailed");
		System.out.println("Product title validate successfully");
		String producprice = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.productprice.txt")).getText();
		Assert.assertEquals(producprice, data[3], "Product price validationfailed");
		System.out.println("Product price validate successfully");
		CommonUtility.action(LoadPropertyFile.locators.getProperty("loc.konakart.productclick.btn"));
		String addtocart = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.productaddtocart.txt")).getText();
		Assert.assertEquals(addtocart, data[6], "Product add to cart validationfailed");
		System.out.println("Product add to cart button validate successfully");
		String addtowishlist = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.productaddtowishlist.txt")).getText();
		Assert.assertEquals(addtowishlist, data[7], "Product add to wishlist validationfailed");
		System.out.println("Product add to wishlist button validate successfully");
		String productavailibility = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.productavailaibilty.txt")).getText();
		System.out.println(productavailibility);
		Assert.assertEquals(productavailibility, data[4].replace(" ", "\n"), "Product availibility validationfailed");
		System.out.println("Product availibility validate successfully");
	}

	public static void negativeInputvalidtion(String[] data) {
		CommonUtility.selectDropdown(LoadPropertyFile.locators.getProperty("loc.konakart.homepage.dpdn"), data[0]);
		CommonUtility.clickAndSendText(LoadPropertyFile.locators.getProperty("loc.konakart.search.txtbox"), data[2]);
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.search.btn"));
		String errormsg = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.negative.input.txt")).getText();
		Assert.assertEquals(errormsg, data[5], "Negative input validation failed");
		System.out.println("Negative input validation passed");
	}
}
