package com.qa.amazon.testclasses;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.qa.amazon.pages.*;
import com.qa.amazon.util.ExcelfileClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.qa.amazon.base.*;

public class AmazonTest extends TestBase{


	public String reportName;
	 ExtentReports extent;
	    ExtentTest test;
	HomePage homepage;
	SearchResultsPage product;
	BookDetailsPage productdetails; 
	
	public AmazonTest(){
		// to call the parent class constructors(calling constructor in TestBase class)
		super();
	}

	 ExcelfileClass excel=new ExcelfileClass("C:/Users/vasanthpc/workspace/Alation-assignment/TestData.xlsx");
	 String search=excel.getCellData("Data", "Search Keyword",2);
	@BeforeClass
	
	public void setup(){
		
	// Run the initialization method for browser
		 extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/Amazon.html");
		initialization();
		homepage=new HomePage();
		product=new SearchResultsPage();
	productdetails=new BookDetailsPage();
	 test = extent.startTest("Amazon");
	}
	

	@Test(priority=1)
	//call the homepage class
	public void selectBooksearchDropdown() throws IOException{
		homepage.selectBooksinSearchCategory();
		test.log(LogStatus.INFO, "selectBooksearchDropdown class executed");
	}
	@Test(priority=2)
	
	//call second method in homepage class
	public void enterSearchtext() throws Exception{
		
		homepage.enterSearchKeyword(search);
		
		test.log(LogStatus.INFO, "enterSearchtext class executed");
	
	
	}
	@Test(priority=3)
	//call third method in homepage class
	public void clickGoIcon() throws IOException{
		homepage.clickOnGoIcon();
		test.log(LogStatus.INFO, "clickGoIcon class executed");
	
		
}
	@Test(priority=4)
	//To verify whether the search result is based on search keyword
	public void verifyresultbasedonsearchkeyword() throws IOException{
		Assert.assertTrue(product.verifyResultBasedonsearchKeyword("data catalog"));
		test.log(LogStatus.INFO, "verifyresultbasedonsearchkeyword class executed");
	}
	
	@Test(priority=5)

	public void defaultSortByOption() throws IOException{
	product.verifyDefaultSortOption();
	test.log(LogStatus.INFO, "defaultSortByOption class executed");
	
	}
	


	@Test(priority=6)

	public void clickOnFirstResult() throws IOException{
		product.clickFirstResult();
		test.log(LogStatus.INFO, "clickOnFirstResult class executed");
		
}
	
	@Test(priority=7)

	public void BookName() throws IOException{
		productdetails.getBookName();
		test.log(LogStatus.INFO, "BookName class executed");
	}
	
	@Test(priority=8)

	public void Ratings() throws IOException{
		productdetails.getRatings();
		test.log(LogStatus.INFO, "Ratings class executed");
	}
	
	@Test(priority=9)
	
	public void PaperbackEditionDetails() throws IOException{
		productdetails.getPaperbackEdition();
		test.log(LogStatus.INFO, "PaperbackEditionDetails class executed");
	}
	@Test(priority=10)

	public void kindleDetails() throws IOException{
		productdetails.getKindleEdition();
		test.log(LogStatus.INFO, "kindleDetails class executed");
	}
	@Test(priority=11)
	
	public void hardCoreDetails() throws IOException{
		productdetails.getHardCoverEdition();
		test.log(LogStatus.INFO, "hardCoreDetails class executed");
	}
	
	@Test(priority=12)

	public void getAuthorName() throws IOException{
		productdetails.getAuthorName();
		test.log(LogStatus.INFO, "getAuthorName call executed");
	}
	
	@Test(priority=13)

	public void ViewedProducts()throws IOException{
		productdetails.getAlsoViewedProductDetails() ;
		test.log(LogStatus.INFO, "ViewedProducts class executed");
	}
	
	@Test(priority=14)

	public void BookCategory() throws IOException{
		productdetails.Bookcategory();
		test.log(LogStatus.INFO, "BookCategory class executed");
	}
	
	
	@AfterClass(alwaysRun=true)

	public void tearDown()
	{
		
	//extent.flush();
		extent.endTest(test);
			driver.quit();
		 extent.flush();
		 extent.close();

	
	}
}
	
	