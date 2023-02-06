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
    private static String DAY_AFTER_TOMORROW = Integer.toString(TestHelper.getTomorrowDateNumber() + 1);

    public CalendarPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@class ='sc-WZYut bJAXZb CalendarDay'][contains(text(),CURRENT_DATE)]")
    private WebElement checkInDate;

    @FindBy(xpath = "//*[@class ='sc-WZYut bJAXZb CalendarDay'][contains(text(),TOMORROW_DATE)]")
    private WebElement checkOutDate;

    @FindBy(xpath = "//*[@class ='sc-dkQUaI ktZJUZ CalendarDay'][contains(text(),DAY_AFTER_TOMORROW)]")
    private WebElement dayAfterTomorrow;

    @FindBy(xpath = "//*[@class ='sc-WZYut dIegcZ CalendarDay'][contains(text(),CURRENT_DATE)]")
    private WebElement yesterdayDate;

    @FindBy(xpath = "//*[@class ='sc-WZYut canGOi CalendarDay'][contains(text(),CURRENT_DATE)]")
    private WebElement selectedCheckInDate;

    @FindBy(xpath = "//*[@class ='sc-WZYut canGOi CalendarDay'][contains(text(),TOMORROW_DATE)]")
    private WebElement selectedCheckOutDate;

    @FindBy(xpath = "//*[@class = 'sc-WZYut canGOi CalendarDay'][contains(text(),TOMORROW_DATE)]")
    private WebElement selectedCheckOutDateAfterReopening;

    @FindBy(xpath = "//*[@class ='sc-WZYut canGOi CalendarDay'][contains(text(),TOMORROW_DATE)]")
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

    public boolean isYesterdayDisabled() {
        return yesterdayDate.isDisplayed();
    }
}
