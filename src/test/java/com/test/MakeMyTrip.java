package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MakeMyTrip {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
	}
	
	@Test
	public void VerifyLogo() {
	boolean img = driver.findElement(By.xpath("//span[@class='logoContainer']//child::img[@src='//imgak.mmtcdn.com/pwa_v3/pwa_hotel_assets/header/logo@2x.png']")).isDisplayed();
	Assert.assertFalse(img);
	}
	
	@Test
	public void login() {
	WebElement login = driver.findElement(By.xpath("//p[text()='Login or Create Account']"));
	login.click();
	Set<String> windowIds = driver.getWindowHandles();
	List<String> windowIDs = new ArrayList(windowIds);
	String parent = windowIDs.get(0);
	String child = windowIDs.get(1);
	System.out.println("parentID" + parent);
	System.out.println("childID" + child);
	
	
	WebElement num = driver.findElement(By.xpath("//div[@class='landingSprite2 signInByMailIcon appendLeft15 mousePointer']"));
	num.click();
	
	
	
	
	}
}
