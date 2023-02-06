import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.FilterPage;
import pages.MainPage;
import pages.SearchPage;

public class SearchTest extends BaseTest{
    private MainPage mainPage;
    private SearchPage searchPage;

    private String emptyString = config.getProperty("emptyString");

    @Before
    public void setupTestPage() {
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        mainPage.pressSearchButton();
    }

    @Test
    public void isCheckInDateAreCleared(){
        Assert.assertEquals( searchPage.getCheckInDateValue(), emptyString);
    }

    @Test
    public void isCheckOutDateAreCleared(){
        Assert.assertEquals( searchPage.getCheckOutDateValue(), emptyString);
    }
}
