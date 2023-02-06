import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.CalendarPage;
import pages.MainPage;
import pages.SearchPage;
import utills.TestHelper;

public class CalendarTest extends BaseTest {
    private MainPage mainPage;
    private SearchPage searchPage;
    private CalendarPage calendarPage;

    private String highlightedColor = config.getProperty("highlightedColor");
    private String highlightedColorBetween = config.getProperty("highlightedColorBetween");


    @Before
    public void setupTestPage() {
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        calendarPage = new CalendarPage(driver);
        mainPage.pressSearchButton();
    }

    @Test
    public void isCheckInDateShown() {
        searchPage.pressCheckInDate();
        calendarPage.selectCheckInDate();
        String actualValue = searchPage.getCheckInDateValue();
        String expectedValue = Integer.toString(TestHelper.getCurrentDateNumber());
        Assert.assertTrue(actualValue.contains(expectedValue));
    }

    @Test
    public void isCheckOutDateShown() {
        searchPage.pressCheckOutDate();
        calendarPage.selectCheckInDate();
        calendarPage.selectCheckOutDate();
        String actualValue = searchPage.getCheckOutDateValue();
        String expectedValue = Integer.toString(TestHelper.getTomorrowDateNumber());
        Assert.assertTrue(actualValue.contains(expectedValue));
    }

    @Test
    public void checkCurrentMonth() {
        searchPage.pressCheckInDate();
        String actualValue = calendarPage.getCurrenMonth().toUpperCase();
        String expectedValue = TestHelper.getCurrentMonth();
        Assert.assertTrue(actualValue.contains(expectedValue));
    }

    @Test
    public void checkNextMonth() {
        searchPage.pressCheckInDate();
        String actualValue = calendarPage.getNextMonth().toUpperCase();
        String expectedValue = TestHelper.getNextMonth();
        Assert.assertTrue(actualValue.contains(expectedValue));
    }

    @Test
    public void checkCurrentMonthAfterSelectedDate() {
        searchPage.pressCheckInDate();
        calendarPage.selectCheckInDate();
        String actualValue = calendarPage.getCurrenMonth().toUpperCase();
        String expectedValue = TestHelper.getCurrentMonth();
        Assert.assertTrue(actualValue.contains(expectedValue));
    }

    @Test
    public void checkNextMonthIsShownAfterSelectedDate() {
        searchPage.pressCheckInDate();
        calendarPage.selectCheckInDate();
        calendarPage.selectCheckOutDate();
        searchPage.pressCheckInDate();
        String actualValue = calendarPage.getNextMonth().toUpperCase();
        String expectedValue = TestHelper.getNextMonth();
        Assert.assertTrue(actualValue.contains(expectedValue));
    }

    @Test
    public void isYesterdayCantBeSelected() {
        searchPage.pressCheckInDate();
        calendarPage.selectCheckInDate();
        Assert.assertTrue(calendarPage.isYesterdayDisabled());
    }

    @Test
    public void isCurrentDateHighlighted() {
        searchPage.pressCheckInDate();
        calendarPage.selectCheckInDate();
        calendarPage.getCheckInHighlightedColor();
        String actualValue = calendarPage.getCheckInHighlightedColor();
        String expectedValue = highlightedColor;
        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void isTomorrowDateHighlighted() {
        searchPage.pressCheckInDate();
        calendarPage.selectCheckInDate();
        calendarPage.selectCheckOutDate();
        searchPage.pressCheckOutDate();
        calendarPage.getCheckOutHighlightedColor();
        String actualValue = calendarPage.getCheckOutHighlightedColor();
        String expectedValue = highlightedColor;
        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void isDayBetweenHighlighted() {
        searchPage.pressCheckInDate();
        calendarPage.selectCheckInDate();
        calendarPage.selectDayAfterTomorrow();
        searchPage.pressCheckOutDate();
        String actualValue = calendarPage.getBetweenDateHighlightedColor();
        String expectedValue = highlightedColorBetween;
        Assert.assertEquals(actualValue, expectedValue);
    }
}
