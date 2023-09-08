package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WebTestBase;
import utils.Utility;

import java.io.IOException;



public class searchResultPage extends WebTestBase {
    @FindBy(xpath = "//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/span/input")
    WebElement selectedBrand;

//    @FindBy(xpath = "//*[@id="item3e041d01ae"]")
    @FindBy(xpath="//*[@id=\"item1afab26deb\"]")

    WebElement firstResult;
    
    @FindBy(id="gh-as-a")
    WebElement advanced;

    
    public searchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void selectBrand(){
        try {
            selectedBrand.click();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void selectFirstOption(){
        try {
            firstResult.click();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
	public void getScreenshot() throws IOException {
		Utility.getScreenshot();
	}
	
	public void getCookiesHandle() {
		// TODO Auto-generated method stub
		Utility.getCookies();
	}

	
//	public void windowHandle() throws InterruptedException{
//        Utility.scrollDownByElement(driver,advanced);
//        advanced.sendKeys(Keys.ENTER);
//        Utility.switchToWindows(driver);
//    }

	



}
