package com.qa.amazon.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.amazon.util.TestUtil;

public class TestBase {

	 public static WebDriver driver;
	 public static Properties prop;
	 
	 public TestBase(){
		 
		 try{
			 
			 prop=new Properties();
			 FileInputStream fis=new FileInputStream("/Users/vasanthpc/workspace/Alation-assignment/src/main/java/com/qa/amazon/config/config.properties");
			  prop.load(fis);
			 
			 }
		 
		 catch(IOException e){
			 e.printStackTrace();		 }
		 
	 }
	 
	 public static void initialization(){
		 String browserName=prop.getProperty("browser");
		 if(browserName.equals("chrome")) {
		//	 System.setProperty("webdriver.chrome.driver", "C:/Users/vasanthpc/Downloads/chromedriver_win32/chromedriver.exe");
			  driver=new ChromeDriver();
		 }
		 else if(browserName.equals("FF")) {
			  driver=new FirefoxDriver();
		 }
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 
		 driver.get(prop.getProperty("url"));
	 }
	 
	
}
