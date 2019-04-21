package com.qa.amazon.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.amazon.base.TestBase;
import com.qa.amazon.util.ExcelfileClass;
import com.qa.amazon.util.Screenshot;


public class HomePage extends TestBase{



	// PageFactory
	@FindBy(xpath="//div[@id='nav-search-dropdown-card']/descendant::option[contains(text(),'Books')]")WebElement searchDropDown;
	@FindBy(xpath="//input[@id='twotabsearchtextbox' and @type='text']")WebElement searchbox;
	@FindBy(xpath="//input[@value='Go']") WebElement searchicon;
	@FindBy(xpath="//div[@class='a-section a-spacing-medium a-spacing-top-base a-padding-none a-text-center']") WebElement LastelementToLoad;
	
	//To intialize all the above elements created as Page Factory

	
	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
   public void selectBooksinSearchCategory() throws IOException{
	  try{
	   searchDropDown.click();
	   System.out.println("Books selected in search dropdown category");
	  }
	  catch(Exception e){
		  Screenshot.TakeScreenshot();
		  System.out.println("Books not selected in search dropdown category");
	  }
	   }
  //enter search value in search box
   public void enterSearchKeyword(String search) throws IOException{
	   try{
	   searchbox.sendKeys(search);
	   System.out.println("Search Keyword entered in searchbox");
		  }
		  catch(Exception e){
			  Screenshot.TakeScreenshot();
			  System.out.println("Search Keyword not entered in searchbox");
		  }
		   }
   //click on Go search icon
   
   public void clickOnGoIcon() throws IOException{
	   try{
	   searchicon.click();
	   System.out.println("Search Keyword entered in searchbox");
		  }
		  catch(Exception e){
			  Screenshot.TakeScreenshot();
			  System.out.println("Search Keyword not entered in searchbox");
		  }
		   }
}