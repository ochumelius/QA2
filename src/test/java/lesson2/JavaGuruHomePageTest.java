package lesson2;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * this test is opening JavaGuru home page
 */
public class JavaGuruHomePageTest {

    @Test
    public void myFirstTest () {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://javaguru.lv");
        driver.quit();


    }
}
