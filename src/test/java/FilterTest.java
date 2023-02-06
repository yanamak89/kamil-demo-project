import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.FilterPage;
import pages.MainPage;
import pages.SearchPage;

public class FilterTest extends BaseTest{
    private MainPage mainPage;
    private SearchPage searchPage;
    private FilterPage filterPage;

    private int minFilterValue = Integer.valueOf(config.getProperty("minFilterValue"));
    private int maxFilterValue = Integer.valueOf(config.getProperty("maxFilterValue"));


    @Before
    public void setupTestPage() {
        filterPage = new FilterPage(driver);
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        mainPage.pressSearchButton();
        searchPage.pressFilterButton();
    }

    @Test
    public void checkClearAllButton(){
        filterPage.increaseBedroomsFilterToMaxValue(maxFilterValue);
        filterPage.pressClearAllButton();
        int expectedAmount = minFilterValue;
        int actualAmount = filterPage.getBedroomsFilterValue();
        Assert.assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void isMinBedsValuePresent(){
        int expectedAmount = minFilterValue;
        int actualAmount = filterPage.getBedFilterValue();
        Assert.assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void isMinBedroomsValuePresent(){
        Assert.assertEquals(minFilterValue, filterPage.getBedroomsFilterValue());
    }

    @Test
    public void isMinBathroomsValuePresent(){
        Assert.assertEquals(minFilterValue, filterPage.getBathroomsFilterValue());
    }

    @Test
    public void isMaxBedsValuePresent(){
        filterPage.increaseBedFilterToMaxValue(maxFilterValue);
        int expectedAmount = maxFilterValue;
        int actualAmount = filterPage.getBedFilterValue();
        Assert.assertEquals(expectedAmount, actualAmount);

    }

    @Test
    public void isMaxBedroomsValuePresent(){
        filterPage.increaseBedroomsFilterToMaxValue(maxFilterValue);
        Assert.assertEquals(maxFilterValue, filterPage.getBedroomsFilterValue());

    }

    @Test
    public void isMaxBathroomsValuePresent(){
        filterPage.increaseBathroomsFilterToMaxValue(maxFilterValue);
        Assert.assertEquals(maxFilterValue, filterPage.getBathroomsFilterValue());

    }

    @Test
    public void isPriceFromEnabled(){
        Assert.assertTrue (filterPage.isPriceFromEnabled());
    }

    @Test
    public void isPriceToEnabled(){
        Assert.assertTrue (filterPage.isPriceToEnabled());
    }

    @Test
    public void applyCheckboxIsWorking(){
        filterPage.selectAllCheckboxes();
        filterPage.clickApplyButton();
        Assert.assertTrue(filterPage.isNoResultsPresent());
    }
}


