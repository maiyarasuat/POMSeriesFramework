package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));		
		
	}
	
	@Test
	public void accPageTitleTest() {
		String accAccPageTitle = accPage.getAccPageTitle();
		Assert.assertEquals(accAccPageTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
		
	}
	
	@Test
	public void logoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	public void accPageHeadersCountTest() {
		int actAccPageHeadersCount = accPage.getAccountsPageHeaderCount();
		System.out.println("Acc page header count is:" + actAccPageHeadersCount);
		Assert.assertEquals(actAccPageHeadersCount, AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
	}
	
	public void accPageHeaderstest() {
		List<String> accAccPageHeaderList = accPage.getAccountsPageHeader();
		Assert.assertEquals(accAccPageHeaderList, AppConstants.EXPECTED_ACC_PAGE_HEADERS_LIST);
		
	}
	
	@DataProvider
	public Object[][] getSearchKey() {
		return new Object[][] {
			{"macbook" , 3},
			{"samsung" , 2},
			{"imac" , 1}
		};
	}
	

	@Test(dataProvider = "getSearchKey")
	public void searchTest(String searchkey, int productcount) {
		searchResPage = accPage.doSearch(searchkey);
		int actResultsCount = searchResPage.getSearchResultsCount();
		Assert.assertEquals(actResultsCount, productcount);
	}
	
	
	
	
	
	
	
	
	
	
}
