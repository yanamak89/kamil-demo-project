import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utills.Config;

import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    protected final Properties config = Config.loadProperties("src/main/resources/test.properties");


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", config.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseurl"));
    }

    @After
    public void closeBrowser(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
