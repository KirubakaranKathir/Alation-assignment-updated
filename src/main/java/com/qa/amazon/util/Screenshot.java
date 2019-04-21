package com.qa.amazon.util;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.qa.amazon.base.TestBase;

public class Screenshot extends TestBase {
	public static void TakeScreenshot()  throws IOException
	{
	
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    // Now you can do whatever you need to do with it, for example copy somewhere
	    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"/test-output/new.png"));
	   
	}

}
