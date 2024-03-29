package com.atmecs.konakartautomation.constants;

import java.io.File;

/**
 * 
 * @author arjun.santra This Class contails all filepaths
 *
 */

public class FilePath {
	
	public final static String USER_HOME= System.getProperty("user.dir")+File.separator;
	public final static String RESOURCES_HOME= USER_HOME+"src"+File.separator+"test"+File.separator+"resources"+File.separator;
	public final static String LOCATOR_HOME= RESOURCES_HOME+"locators"+File.separator;
	public final static String LIB_HOME =USER_HOME+"lib"+File.separator;
	
	
	public final static String CONFIG_FILE = USER_HOME+File.separator+"config.properties";
	public final static String CHROME_PATH= LIB_HOME+"chromedriver.exe";
	public final static String FIREFOX_PATH= LIB_HOME+"geckodriver.exe";
	public final static String IE_PATH= LIB_HOME+"IEDriverServer.exe";
	
	public final static String FAILED_SCREENSHOT_FILE= USER_HOME+"FailedTestScreenShots"+File.separator;
	public final static String EXTENT_REPORT_FILE= USER_HOME+"test-output"+File.separator+"ExtentReport.html";
	public final static String EXTENT_CONFIG = USER_HOME+"extent-config.xml";
	public final static String LOG4J_FILE= RESOURCES_HOME+"log4j"+File.separator+"log4j.properties";
	public final static String LOCATOR_FILE= LOCATOR_HOME+"konakartlocators.properties";
	public final static String VALIDATION_FILE= RESOURCES_HOME+"testdata"+File.separator+"konakart_automation_testdata.xlsx";
	//public final static String VALIDATION_PROPERTY_FILE= RESOURCES_HOME+"testdata"+File.separator+"atmecs_automation_validatedata.properties";
	public final static String TESTDATA_FILE= RESOURCES_HOME+"testdata"+File.separator+"//filename"; 
	public final static int TIMEOUT_INSECONDS = 30;
//	public static void main(String[] args) {
//		System.out.println(LOG4J_FILE);
//	}
}
