package com.parameters;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
	
	@Test
	public void test1() {
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Open Browser");
		
		Assert.assertEquals(true, true);
		
		System.out.println("enter username");
		System.out.println("enter password");
		System.out.println("click on sign in button");
		
		Assert.assertEquals(true, true);
		
		System.out.println("Validate homepage");
		softAssert.assertEquals(true, false, "Home page title is missing");
		
		System.out.println("Go to deals page");
		System.out.println("Create a deals page");
		softAssert.assertEquals(true, false, "not able to create deal");
		
		System.out.println("Go to contact page");
		System.out.println("Create a contact");
		softAssert.assertEquals(true, false, "not able to create contact");
		
		softAssert.assertAll();
	}

	@Test
	public void test2() {
		SoftAssert softAssert1 = new SoftAssert();
		System.out.println("Logout");
		softAssert1.assertEquals(true, false);
		softAssert1.assertAll();
		
	}
}
