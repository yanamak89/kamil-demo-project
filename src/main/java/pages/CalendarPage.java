package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utills.TestHelper;

import java.util.List;

public class CalendarPage {
    private WebDriver webDriver;
    private static String CURRENT_DATE = Integer.toString(TestHelper.getCurrentDateNumber());
    private static String TOMORROW_DATE = Integer.toString(TestHelper.getTomorrowDateNumber());
    //private static String DAY_AFTER_TOMORROW = Integer.toString(TestHelper.getTomorrowDateNumber()+1);

    public CalendarPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@class ='sc-dkQUaI ktZJUZ CalendarDay'][contains(text(),CURRENT_DATE)]")
    private WebElement checkInDate;

    @FindBy(xpath = "//*[@class ='sc-dkQUaI ktZJUZ CalendarDay'][contains(text(),TOMORROW_DATE)]")
    private WebElement checkOutDate;

    //TODO Figure out with DAY_AFTER_TOMORROW
    @FindBy(xpath = "//*[@class ='sc-dkQUaI ktZJUZ CalendarDay'][contains(text(),7)]")
    private WebElement dayAfterTomorrow;

    @FindBy(xpath = "//*[@class ='sc-dkQUaI kAGYPk CalendarDay'][contains(text(),CURRENT_DATE)]")
    private WebElement selectedCheckInDate;

    @FindBy(xpath = "//*[@class ='sc-dkQUaI kAGYPk CalendarDay'][contains(text(),TOMORROW_DATE)]")
    private WebElement selectedCheckOutDate;

    @FindBy(xpath = "//*[@class = 'sc-dkQUaI iLCJWy CalendarDay'][contains(text(),TOMORROW_DATE)]")
    private WebElement selectedCheckOutDateAfterReopening;

    @FindBy(xpath = "//*[@class ='sc-dkQUaI eHAbRu CalendarDay'][contains(text(),TOMORROW_DATE)]")
    private WebElement selectedBetweenDay;

    @FindBy(xpath = "//*[@class='sc-fHCHyC crlswz']")
    private List<WebElement> mouths;

    public void selectCheckInDate() {
        checkInDate.click();
    }

    public void selectCheckOutDate() {
        checkOutDate.click();
    }

    public String getCurrenMonth() {
        return mouths.get(0).getText();
    }

    public String getNextMonth() {
        return mouths.get(1).getText();
    }

    public String getCheckInHighlightedColor() {
        return selectedCheckInDate.getCssValue("background-color");
    }

    public String getCheckOutHighlightedColor() {
        return selectedCheckOutDateAfterReopening.getCssValue("background-color");
    }

    public String getBetweenDateHighlightedColor() {
        return selectedBetweenDay.getCssValue("background-color");
    }

    public void selectDayAfterTomorrow() {
        dayAfterTomorrow.click();
    }


}
