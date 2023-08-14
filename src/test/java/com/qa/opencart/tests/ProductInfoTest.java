package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class ProductInfoTest extends BaseTest{
	
	@BeforeClass
	public void prodInfoSetup() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));		

	}
	
	@DataProvider
	public Object[][] productTestData() {
		return new Object[][] {
			{"macbook" , "MacBook Pro"},
			{"macbook" , "MacBook Air"},
			{"iMac" , "iMac"},
			{"samsung" , "Samsung SyncMaster 941BW"},
			{"samsung" , "Samsung Galaxy Tab 10.1"},
		};
	}
	
	@Test(dataProvider = "productTestData")
	public void productHeaderTest(String searchKey, String productName) {
		searchResPage = accPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
		String actProductHeader = productInfoPage.getProductHeaderValue();
		Assert.assertEquals(actProductHeader, productName);
	}
	
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{"macbook" , "MacBook Pro" , 4},
			{"macbook" , "MacBook Air" , 4},
			{"iMac" , "iMac" , 3},
			{"samsung" , "Samsung SyncMaster 941BW" , 1},
			{"samsung" , "Samsung Galaxy Tab 10.1" , 7},
		};
	}
	
	
	
	@Test(dataProvider = "productData")
	public void productImagesCountTest(String searchKey, String productName, int expProductImagesCount) {
		searchResPage = accPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
		int actProductImagesCount = productInfoPage.getProductImagesCount();
		Assert.assertEquals(actProductImagesCount, expProductImagesCount);
	}
	
	
	
	
	
	
	

}
