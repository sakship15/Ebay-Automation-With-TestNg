package utils;



import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;

import testBase.WebTestBase;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Cookie;
import org.apache.commons.io.FileUtils;




public class Utility extends WebTestBase {
	public static void scrollDownByElement(WebDriver driver, WebElement element) {
		// TODO Auto-generated method stub
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element );
	}
	public static void scrollUpByElement(WebDriver driver)throws InterruptedException {
		// TODO Auto-generated method stub
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(3000);
//		JavascriptExecutor j=(JavascriptExecutor)driver;
//		//j.executeScript("window.scrollBy(0,500)");
//		
//		for(int i=0;i<10;i++) 
//		{
//			j.executeScript("window.scrollBy(0,-500)");
//			
//		}
		
	}
	
	public static void mouseHover(WebDriver driver, WebElement element){
        Actions action=new Actions(driver);
        action.moveToElement(element)
                .build()
                .perform();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
   }


	
	public static void scrollPage(WebDriver driver) throws InterruptedException {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,500)");
		
		for(int i=0;i<10;i++) 
		{
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		}
		
		for(int i=0;i<10;i++) 
		{
			j.executeScript("window.scrollBy(0,-500)");
			Thread.sleep(1000);
		}
	}
	
	public static void selectValue(WebElement element, String term, String value) {
		// TODO Auto-generated method stub
		Select dropDown=new Select(element);
		if(term.equalsIgnoreCase("byValue")){
            dropDown.selectByValue(value);
        }else if(term.equalsIgnoreCase("byIndex")){
            dropDown.selectByIndex(Integer.parseInt(value));
        }else if(term.equalsIgnoreCase("byVisibleText")){
            dropDown.selectByVisibleText(value);
        }else{
            System.out.println("Please select the correct value");
        }
	}
	
	public static void getScreenshot() throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		//taking screenshot and storing it in the temporary file
		File source=tk.getScreenshotAs(OutputType.FILE);
		//creating destination file
		File des=new File("D:/ebay.png");
		//moving the file from source to destination
		FileUtils.copyFile(source,des);
		
	}
	
	public static void switchToWindows(WebDriver driver) throws InterruptedException {
        String parentWindows = driver.getWindowHandle();//parent Id==1
        Set<String> allWindow = driver.getWindowHandles();//Parent+child<1,2>
        for (String s : allWindow) {
        	//child Id
            if (!parentWindows.contentEquals(s)) {
                driver.switchTo().window(s);
                Thread.sleep(10000);
                driver.close();
            }
           
        }
        driver.switchTo().window(parentWindows);
    }

	public static void getCookies(){
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies){
            System.out.println(c);
        }
    }

	
	


	
}

