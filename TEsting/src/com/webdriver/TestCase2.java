package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase2 {
	WebDriver driver;
		
	    @BeforeTest
		public void  Setup()
		{
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			 driver = new ChromeDriver();
			driver.get("https://www.google.co.in");
		}
		
	    @Test
	    @DataProvider
		public void searchs(String search_text) throws InterruptedException
		{
			WebElement search_box= driver.findElement(By.xpath("//*[@name='q']"));
			search_box.sendKeys(search_text);
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*h3[class='r']"));
			Thread.sleep(10000);
			
			//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
		
		}

	    @AfterTest
	    public void Finish()
		{
		
	    	driver.close();
	    	
	    	
		}
	    
	    @DataProvider(name="searchs")
	    public Object[] lookps()
	    {
	    	
	    	Object search_text[]={"Android","IOS","Blackberry"};
	    	
			return search_text;
	    	
	    	
	    }



}


