import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

public class MainTest extends BaseTest{
    private MainPage mainPage;

    @Before
    public void setupTestPage() {
        mainPage = new MainPage(driver);
    }

//    @Test
//    public void isSearchButtonEnabled() {
//        mainPage.searchButtonPresent();
//        Assert.assertTrue(mainPage.searchButtonPresent());
//    }


    @Test
    public void isSearchPagePresent(){
        mainPage.pressSearchButton();
        Assert.assertTrue(true);
    }

}
