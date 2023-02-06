package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver webDriver;
    @FindBy(xpath = "//*[contains(text(),'Filter')]")
    private WebElement filterButton;

    @FindBy(xpath = "//*[contains(text(),'Check-in')]")
    private WebElement checkInDate;

    @FindBy(xpath = "//*[contains(text(),'Check-out')]")
    private WebElement checkOutDate;

    @FindBy(xpath = "//div[contains(text(),'Check-in')]/following::div[1]")
    private WebElement selectedCheckInDate;

    @FindBy(xpath = "//div[contains(text(),'Check-out')]/following::div[1]")
    private WebElement selectedCheckOutDate;

    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

//    public boolean filterButtonPresent(){
//        return filterButton.isEnabled();
//    }

    public FilterPage pressFilterButton(){
        filterButton.click();
        return new FilterPage(webDriver);
    }

    public String getCheckInDateValue(){
        return selectedCheckInDate.getText();
    }

    public String getCheckOutDateValue(){
        return selectedCheckOutDate.getText();

    }

    public CalendarPage pressCheckInDate(){
        checkInDate.click();
        return new CalendarPage(webDriver);
    }

    public CalendarPage pressCheckOutDate(){
        checkOutDate.click();
        return new CalendarPage(webDriver);
    }
}
