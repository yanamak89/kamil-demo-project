package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utills.TestHelper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class FilterPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//input[contains(@placeholder,'From')]")
    private WebElement priceFrom;
    @FindBy(xpath = "//input[contains(@placeholder,'To')]")
    private WebElement priceTo;

    //The same class locator for checkboxes, I found unique
    @FindBy(xpath = "//div[contains(text(),'Beds')]/following::div[1]//button[1]")
    private WebElement bedsDecreaseButton;
    @FindBy(xpath = "//div[contains(text(),'Beds')]/following::div[1]//button[2]")
    private WebElement bedsIncreaseButton;
    @FindBy(xpath = "//div[contains(text(),'Beds')]/following::div[1]//span[1]")
    private WebElement bedsAmount;
    @FindBy(xpath = "//div[contains(text(),'Bedrooms')]/following::div[1]//button[1]")
    private WebElement bedroomsDecreaseButton;
    @FindBy(xpath = "//div[contains(text(),'Bedrooms')]/following::div[1]//button[2]")
    private WebElement bedroomsIncreaseButton;
    @FindBy(xpath = "//div[contains(text(),'Bedrooms')]/following::div[1]//span[1]")
    private WebElement bedroomsAmount;
    @FindBy(xpath = "//div[contains(text(),'Bathrooms')]/following::div[1]//button[1]")
    private WebElement bathroomsDecreaseButton;
    @FindBy(xpath = "//div[contains(text(),'Bathrooms')]/following::div[1]//button[2]")
    private WebElement bathroomsIncreaseButton;
    @FindBy(xpath = "//div[contains(text(),'Bathrooms')]/following::div[1]//span[1]")
    private WebElement bathroomsAmount;

    //The same class locator for checkboxes, I found unique
    @FindBy(xpath = "//*[@class ='sc-dTSzeu krkYvd'][contains(text(),'Beach front')]")
    private WebElement beachFrontCheckBox;

    @FindBy(xpath = "//*[@class ='sc-dTSzeu krkYvd']")
    private List<WebElement> amenitiesCheckboxes;

    @FindBy(xpath = "//*[contains(text(),'Clear all')]")
    private WebElement clearAll;

    @FindBy(xpath = "//*[contains(text(),'Apply')]")
    private WebElement applyButton;

    @FindBy(xpath = "//*[contains(text(),'No results')]")
    private WebElement noResultsFound;

    public FilterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPriceFromEnabled() {
        return priceFrom.isEnabled();
    }

    public boolean isPriceToEnabled() {
        return priceTo.isEnabled();
    }

    public int getBedFilterValue() {
        return Integer.parseInt(bedsAmount.getText());
    }

    public int getBedroomsFilterValue() {
        return Integer.parseInt(bedroomsAmount.getText());
    }

    public int getBathroomsFilterValue() {
        return Integer.parseInt(bathroomsAmount.getText());
    }

    public void increaseBedFilterToMaxValue(int bedMaxValue) {
        for (int i = 0; i < bedMaxValue; i++) {
            bedsIncreaseButton.click();
        }
    }

    public void increaseBedroomsFilterToMaxValue(int bedroomsMaxValue) {
        for (int i = 0; i < bedroomsMaxValue; i++) {
            bedroomsIncreaseButton.click();
        }
    }

    public void increaseBathroomsFilterToMaxValue(int bathroomsMaxValue) {
        for (int i = 0; i < bathroomsMaxValue; i++) {
            bathroomsIncreaseButton.click();
        }
    }

    public void pressClearAllButton() {
        clearAll.click();
    }

    public void clickApplyButton() {
        applyButton.click();
    }

    public void selectBeachFrontCheckBox() {
        beachFrontCheckBox.click();
    }

    public void selectAllCheckboxes() {
        for (WebElement element : amenitiesCheckboxes) {
            element.click();
        }
    }

    public boolean isNoResultsPresent() {
        return noResultsFound.isDisplayed();
    }
}
