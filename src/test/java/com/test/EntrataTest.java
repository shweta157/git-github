package com.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EntrataTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.entrata.com/");
	}
	
	@Test()
	public void verifyLogo() {
	boolean logo = driver.findElement(By.xpath("//a[@class='main-header-logo']")).isDisplayed();
	Assert.assertTrue(logo);
	}
	
	@Test
	public void verifyNavigation() {
	WebElement baseCamp = driver.findElement(By.xpath("//a[text()='Base Camp']//parent::div[@class='header-nav-item']"));
	baseCamp.click();
	Set<String> handler =driver.getWindowHandles();
	Iterator<String> it = handler.iterator();
	String parentWindow =it.next();
	System.out.println(parentWindow);
	String childWindow = it.next();
	System.out.println(childWindow);
	
	driver.switchTo().window(childWindow);
	String title = driver.getTitle();
	Assert.assertEquals(title, "Base Camp 2024 | Entrata");
	}
	
	@Test
	public void fillForm() {
		driver.findElement(By.xpath("//a[text()='Watch Demo' and @class ='button-default solid-dark-button']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Peterson");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("jp@gmail.com");
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Google");
		driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("+12225677890");
		WebElement unitCount = driver.findElement(By.xpath("//select[@id='Unit_Count__c']"));
		Select select = new Select(unitCount);
		select.selectByVisibleText("11 - 100");
		driver.findElement(By.xpath("//input[@id='Title']")).sendKeys("Test Engineer");
		WebElement iam = driver.findElement(By.xpath("//select[@id='demoRequest']"));
	    Select select1 = new Select(iam);
	    select1.selectByValue("a Resident");
	    String actualUrl = driver.getCurrentUrl();
	    Assert.assertEquals(actualUrl, "https://go.entrata.com/watch-demo.html");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
