package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utills.TestHelper;

public class MainPage {

    private WebDriver webDriver;
    @FindBy(xpath = "//*[contains(text(),'Search')]")
    private WebElement searchButton;



    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //to do!
    public SearchPage pressSearchButton() {
        //TODO WebDriver Wait!
//        WebDriverWait wait = new WebDriverWait(webDriver, 5);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
//        element.click();
        TestHelper.sleep5Seconds();
        searchButton.click();
        return new SearchPage(webDriver);
    }
}
