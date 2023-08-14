package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtilNew;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtilNew eleUtil;
	
	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails li");
	private By productQuantity = By.name("quantity");
	private By addToCartBtn = By.id("button-cart");
	
	
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtilNew(driver);
	}
	
	public String getProductHeaderValue() {
		return eleUtil.doElementGetText(productHeader);
	}
	
	public int getProductImagesCount() {
		int actProductImagesCount = eleUtil.waitForElementsVisible(productImages, AppConstants.MEDIUM_TIME_OUT).size();
		System.out.println("total product images is:" +getProductHeaderValue() +"===>"+ actProductImagesCount);
		return actProductImagesCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
