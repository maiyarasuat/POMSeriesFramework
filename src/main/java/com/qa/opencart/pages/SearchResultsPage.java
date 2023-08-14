package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtilNew;

public class SearchResultsPage {
	
	private By productsResults = By.cssSelector("div.product-layout");
	
	
	
	private WebDriver driver;
	private ElementUtilNew eleUtil;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtilNew(driver);
		
	}
	
	public int getSearchResultsCount() {
		return eleUtil.waitForElementsVisible(productsResults, AppConstants.MEDIUM_TIME_OUT).size();
	}
	
	public ProductInfoPage selectProduct(String productName) {
		eleUtil.clickElementWhenReady(By.linkText(productName), AppConstants.MEDIUM_TIME_OUT);
		return new ProductInfoPage(driver);
	}
	
	
	
	
	
	

}
