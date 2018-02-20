package com.webdriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
		
	    @Test(dataProvider="searchs")
		public void searchs(String search_text) throws InterruptedException
		{
	    	
	    	String mainWin=driver.getWindowHandle();
			WebElement search_box= driver.findElement(By.xpath("//*[@name='q']"));
			search_box.sendKeys(search_text);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Google Search']")).click();
			Thread.sleep(2000);
			Actions builder=new Actions(driver);
			Action a= builder.keyDown(Keys.SHIFT).build();
			a.perform();
			driver.findElement(By.linkText(search_text)).click();
			Thread.sleep(2000);
			Action b=builder.keyUp(Keys.SHIFT).build();
			b.perform();
			driver.switchTo().window(mainWin);
			driver.navigate().back();
//			System.out.println("here");
//			Set<String> area=driver.getWindowHandles();
		//	driver.switchTo().window(area.)
			
			//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
		
		}

	    @AfterTest
	    public void Finish() throws InterruptedException
		{
		
	    	Set<String> area=driver.getWindowHandles();
	    	for(String a : area)
	    	{
	    		System.out.println( "Value"+a); 
	    	    driver.switchTo().window(a);
	    	    Thread.sleep(2000);
	    	}	
	    	
	    	
		}
	    
	    @DataProvider(name="searchs")
	    public Object[] lookps()
	    {
	    	
	    	Object search_text[]={"Android","iPhone - Apple (IN)","Nokia Corporation","Gmail"};
	    	
			return search_text;
	    	
	    	
	    }



}


