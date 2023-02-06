package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListingsPage {
    private WebDriver webDriver;

    public ListingsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//span[text()='All']/span")
    private WebElement all;

    @FindBy(xpath = "//*[@class = 'sc-kJNqyW iVxkeF']")
    private List<WebElement> allListings;

    public int getAllElementsNumber() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        for (int i = 0; i < 4; i++) {
            js.executeScript("window.scrollBy(0,10000)", "");
        }
        return allListings.size();
    }

    public String getAllNumber() {
        return all.getText();
    }

}
