package com.qa.amazon.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.qa.amazon.base.TestBase;
import com.qa.amazon.util.ExcelfileClass;
import com.qa.amazon.util.Screenshot;

public class BookDetailsPage extends TestBase {

	//Page Factory

	
 @FindBy(xpath="//div[@class='a-section a-spacing-none']/child::h1") WebElement Bookname;
 @FindBy(xpath="//span[@data-action='acrStarsLink-click-metrics']") WebElement movetoRatingsection;
 @FindBy(xpath="//div[@class='a-fixed-left-grid-col a-col-left']/descendant::span[@class='a-size-base a-color-secondary']") WebElement Rating;
 @FindBy(xpath="//span[contains(text(),'Paperback')]/ancestor::a/ancestor::li") WebElement paperbacksection;
 @FindBy(xpath="//span[contains(text(),'Kindle')]/ancestor::li") WebElement Kindlesection;
 @FindBy(xpath="//span[contains(text(),'Hardcover')]/ancestor::li") WebElement Hardcover;
 @FindBy(css="a[class='a-link-normal contributorNameID']")WebElement AuthorName;
 @FindBy(css="span[id='acrCustomerReviewText']")WebElement NumberofCutomerReviews;
 @FindBy(css="table[id='productDetailsTable']")WebElement Details;
 @FindBy(xpath="//div[@class='a-row a-carousel-header-row a-size-large']/ancestor::div[@id='p13n-m-desktop-dp-sims_session-similarities-sims-feature-1']") WebElement ViewedProducts;
 @FindBy(xpath="//div[@id='wayfinding-breadcrumbs_container']")WebElement Bookcategory;

 ExcelfileClass excel=new ExcelfileClass("C:/Users/vasanthpc/workspace/Alation-assignment/TestData.xlsx");
 public BookDetailsPage(){
	
	PageFactory.initElements(driver, this);
}
// to get bookname
public void getBookName() throws IOException{
	try{
	String BookName=Bookname.getText();
	System.out.println(BookName);
	excel.setCellData("Product Details", "BookName", 2, BookName);
	}
	
   
	catch(Exception e){
		Screenshot.TakeScreenshot();
		System.out.println("Bookname not available");
	}
}
//to get Ratings

public void getRatings() throws IOException{
	try{
	
		Actions actions=new Actions(driver);
		actions.moveToElement(movetoRatingsection).build().perform();
		String Ratings=Rating.getText();
		System.out.println(Ratings);
		// To get number of customer Reviews
		String NoOfReviews=NumberofCutomerReviews.getText();
		System.out.println(NoOfReviews);
		actions.moveToElement(Bookname).build().perform();
		excel.setCellData("Product Details", "Ratings", 2, Ratings);
		excel.setCellData("Product Details", "NoOf CutomerReviews", 2, NoOfReviews);
		 
	}

	catch(Exception e){
		Screenshot.TakeScreenshot();
		System.out.println("Rating not available");
	}
}
public void getPaperbackEdition() throws IOException{
	try{
	// to get Paperbackcost edition price
		String Paperbackcost=paperbacksection.getText();
		System.out.println(Paperbackcost);
		paperbacksection.click();
		
		// to get paperback edition product details
		String paperbackProductdetails=Details.getText();
		System.out.println(paperbackProductdetails);
		excel.setCellData("Product Details", "Paperback cost", 2, Paperbackcost);
		excel.setCellData("Product Details", "Paperback Details", 2, paperbackProductdetails);
	}

	
catch(Exception e){
	Screenshot.TakeScreenshot();
	System.out.println("Paperback edition not available");
	}
}
public void getKindleEdition() throws IOException{
	try{
		// to get Kindle edition price
		String Kindlecost=Kindlesection.getText();
		System.out.println(Kindlecost);
		Kindlesection.click();
		// to get Kindle edition product details
		String kindleProductdetails=Details.getText();
		System.out.println(kindleProductdetails);
		excel.setCellData("Product Details", "Kindle cost", 2, Kindlecost);
		excel.setCellData("Product Details", "Kindle Details", 2, kindleProductdetails);
		
	
}
catch(Exception e){
		Screenshot.TakeScreenshot();
		System.out.println("kindleProductdetails  not available");
	}
}
public void getHardCoverEdition() throws IOException{
	try{
		// to get Hardcover  edition price
		String Hardcovercost=Hardcover.getText();
		System.out.println(Hardcovercost);
		Hardcover.click();
		// to get Hardcover edition product details
		String HardcoverProductdetails=Details.getText();
		System.out.println(HardcoverProductdetails);
		excel.setCellData("Product Details", "HardCover cost", 2, Hardcovercost);
		excel.setCellData("Product Details", "HardCover Details", 2, HardcoverProductdetails);
		
	
}
catch(Exception e){
	Screenshot.TakeScreenshot();
	System.out.println("Hardcover edition not available");
	}	
}
// to get author name
public void getAuthorName() throws IOException{
	try{
	
		String Author=AuthorName.getText();
		System.out.println(Author);
		excel.setCellData("Product Details", "AuthorName", 2, Author);
}
catch(Exception e){
	Screenshot.TakeScreenshot();
	System.out.println("Author not available");
	}	
}


// to get Also viewed product details
public void getAlsoViewedProductDetails() throws IOException{
	try{
	
		String AlsoViewed=ViewedProducts.getText();
		System.out.println(AlsoViewed);
		excel.setCellData("Product Details", "Also viewed Porduct details", 2, AlsoViewed);
	}

catch(Exception e){
	Screenshot.TakeScreenshot();
	System.out.println("AlsoViewed Products not available");
	}	
}
// to get book category
public void Bookcategory() throws IOException{
	try{
	
		String category=Bookcategory.getText();
		System.out.println(category);
		excel.setCellData("Product Details", "Book category", 2, category);
	
}
	catch(Exception e){
		Screenshot.TakeScreenshot();
		System.out.println("category not available");
		}	
	}
}
