package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utills.TestHelper;

import java.time.Duration;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(2000));

    @FindBy(xpath = "//*[contains(text(),'Search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[contains(text(), 'All listings')]")
    private WebElement allListingsButton;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public SearchPage pressSearchButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        element.click();
        return new SearchPage(webDriver);
    }

    public void getAllListingsPage() {
        allListingsButton.click();
    }
}
