import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.ListingsPage;
import pages.MainPage;
import pages.SearchPage;

public class ListingTest extends BaseTest {
    private MainPage mainPage;
    private ListingsPage listingsPage;

    @Before
    public void setupTestPage() {
        mainPage = new MainPage(driver);
        listingsPage = new ListingsPage(driver);
        mainPage.getAllListingsPage();
    }

    @Test
    public void checkCurrentListNumber() {
        String actualValue = Integer.toString(listingsPage.getAllElementsNumber());
        String expectedValue = listingsPage.getAllNumber();
        System.out.println("Actial value " + actualValue + " Expected value " + expectedValue);
        Assert.assertTrue(expectedValue.contains(actualValue));
    }
}
