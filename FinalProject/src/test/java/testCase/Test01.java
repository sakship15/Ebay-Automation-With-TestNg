package testCase;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;
import testBase.WebTestBase;
import pages.homePage;
import pages.searchResultPage;

import java.io.IOException;



public class Test01 extends WebTestBase {
    //WebDriver driver;
	homePage Home;
	searchResultPage searchresult;

	public Test01() {
		//parent class cunstrutor call means loading property file or config.property file
		super();
	}

    @BeforeTest
       public void BeforeTest() {
    	   initialization();
    	   Home=new homePage(driver);
    	   searchresult=new searchResultPage(driver);
    	   
    	
    }
    
	@Test(priority=0)
	public void verifyScrollDown() throws InterruptedException {
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(2000);

	}

	@Test(priority=1)  //mouse hovering on the user
	public void verifyMouseHover() throws InterruptedException{
	     SoftAssert softAssert = new SoftAssert();
	   Home.mouseHover();
	     softAssert.assertAll();
	        Thread.sleep(2000);

	 }
	@Test(priority=2)
	public void verifyScrollup() throws InterruptedException {
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(2000);

	}


    @Test(priority = 3)
    public void selectCellPhoneCategory() throws InterruptedException{
        homePage home = new homePage(driver);
        home.selectCategory();
        Thread.sleep(2000);

    }
    

    @Test(priority = 4)
    public void searchMobilePhone() throws InterruptedException{
        homePage home = new homePage(driver);
        home.searchMainProduct("Mobile phone");
        Thread.sleep(2000);

    }

    @Test(priority = 5)
    public void selectAppleBrand() throws InterruptedException{
        searchResultPage resultPage=new searchResultPage(driver);
        resultPage.selectBrand();
        Thread.sleep(2000);

    }

    @Test(priority = 6)
    public void selectFirstSearchItem() throws InterruptedException{
        searchResultPage resultPage=new searchResultPage(driver);
        resultPage.selectFirstOption();
        Thread.sleep(5000);
    }
    


	@Test(priority=7)
	 public void verifyScreenshot() throws IOException{
	     SoftAssert softAssert = new SoftAssert();
	     searchresult.getScreenshot();
	     softAssert.assertAll();
	 }
	
//	@Test(priority=8)  
//	 public void verifyGetWindowHandle() throws InterruptedException{
//	     SoftAssert softAssert = new SoftAssert();
//	     searchresult.windowHandle();
//	     softAssert.assertAll();
//	 }		




	@Test(priority=8)  
	public void verifyCookiesHandle(){
	     SoftAssert softAssert = new SoftAssert();
	    searchresult.getCookiesHandle();
	     softAssert.assertAll();
	 }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
