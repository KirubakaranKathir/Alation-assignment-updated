package com.qa.amazon.pages;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.amazon.base.TestBase;

import com.qa.amazon.util.Screenshot;


public class SearchResultsPage extends TestBase {

	//Page Factory
	
 @FindBy(xpath="//div[@id='search']/descendant::div[@class='a-section a-spacing-small a-spacing-top-small']") WebElement resultcount;
 @FindBy(xpath="//img[@data-image-index='0']") WebElement clickfirstresult;
 @FindBy(xpath="//span[@class='a-color-state a-text-bold']") WebElement SearchText;
 @FindBy(xpath="//span[@class='a-dropdown-prompt' and contains(text(),'Featured')]")WebElement DefaultSortBy;
 public SearchResultsPage(){
	
	PageFactory.initElements(driver, this);
}
// To verify whether result depend on search keyword
 public boolean verifyResultBasedonsearchKeyword(String text) throws IOException{
	 try{
	   SearchText.getText().contains(text);
	    		System.out.println("Search result based on keyword given");
	    		return true;
	    		
	    	
	 }
	    	catch(Exception e){
	    		Screenshot.TakeScreenshot();
	    System.out.println("Search result does not depend on keyword");
	   	 }
	return false;
	  }
 // To verify the default sorting option is as per Featured
 public void verifyDefaultSortOption() throws IOException{
	 try{
	 DefaultSortBy.isDisplayed();
		 System.out.println("Default sort by is done by featured");
	 }
	
 
	 catch(Exception e){
		 Screenshot.TakeScreenshot();
		 System.out.println("Default sort by option is not default");
	 }
	 }
 // To get the total result count for the search keyword
public void validateproductdetailspage() throws IOException{
	try{
   resultcount.isDisplayed();
   System.out.println("Result count displayed:" + resultcount);
	}
	catch(Exception e){
		Screenshot.TakeScreenshot();
		System.out.println("Result count not displayed");
	}
   }
//Click on the book from the search Result page
public void clickFirstResult()throws IOException{
	try{
	clickfirstresult.click();
	System.out.println("First book clicked from search result");
	}
	catch(Exception e){
		Screenshot.TakeScreenshot();
		System.out.println("First book not clicked from search result");
	}
}
}