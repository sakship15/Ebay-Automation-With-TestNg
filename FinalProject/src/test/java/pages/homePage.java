package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WebTestBase;
import utils.Utility;

public class homePage extends WebTestBase {
    @FindBy(xpath = "//*[@id=\"gh-cat\"]/option[8]")
    WebElement searchDropDown;

    @FindBy(xpath = "//*[@id=\"gh-ac\"]")
    WebElement searchItem;

    @FindBy(id = "gh-btn")
    WebElement searchButton;
    
    @FindBy(id="glbfooter")
    WebElement footer;


    public homePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
	public void scrollDownMethod() {
		// TODO Auto-generated method stub
		Utility.scrollDownByElement(driver,footer);
		footer.click();
		
	}	
	
	public void mouseHover() {
		Utility.mouseHover(driver,searchButton);
	}



    public void selectCategory(){
        try {
            searchDropDown.click();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void searchMainProduct(String keyWord){
        try {
            searchItem.sendKeys(keyWord);
            searchButton.click();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
