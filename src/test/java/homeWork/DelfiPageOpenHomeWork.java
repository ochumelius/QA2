package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class DelfiPageOpenHomeWork {

    private static final String TITLE = "Nepieciešams visu FKTK lēmumu audits – par 'ABLV Bank' nesodīšanu Ziemeļkorejas lietā sašutis Latkovskis";
    private static final String MOBILE_TITAL = "Nepieciešams visu FKTK lēmumu audits – par 'ABLV Bank' nesodīšanu Ziemeļkorejas lietā sašutis Latkovskis";
    private static final String MAIN_PAGE_WEB_URL = "http://www.delfi.lv/";
    private static final String MAIN_PAGE_MOBILE_URL = "http://m.delfi.lv/";
    private static final By ARTICLE_MOBILE_TITAL = By.xpath("//a[@class='md-scrollpos']");
    private static final By ARTICLE_TITAL = By.xpath("//a[@class='top2012-title']");

    @Test
    public void searchpage(){

        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get(MAIN_PAGE_WEB_URL);

        // Find all titles and add them to a list
        List<WebElement> articleTitles = driver.findElements(ARTICLE_TITAL);
        // Check if list is not emty
        Assert.assertFalse("Title list is empty", articleTitles.isEmpty());
        // Go througt a list and getText() from WebElement
        Boolean isTitlePresent = false;
        for (int i = 0; i < articleTitles.size(); i++) {
            // Compare every string element to TITLE variable

            if (articleTitles.get(i).getText().equals(TITLE)) {
                // Exit loop in case if TITLE is present
                isTitlePresent = true;
                break;
            }
        }
        // if we dont find element that match TITLE - display massege "Element not find"
        Assert.assertTrue("Article is not fount", isTitlePresent);


        //Open main page in new tab of the Mobile
        driver.get(MAIN_PAGE_MOBILE_URL);
        // Check if list is not emty
        List<WebElement> articleMobileTitles = driver.findElements(ARTICLE_MOBILE_TITAL);

        // Find all titles and add them to a list
        Assert.assertFalse("Mobile titel list is emty", articleMobileTitles.isEmpty());
        // Go througt a list and getText() from WebElement
        Boolean isMobileTitlePresent = false;

        for (int i = 0; i < articleMobileTitles.size(); i++) {
            // Compare every string element to TITLE variable

            if (articleMobileTitles.get(i).getText().equals(MOBILE_TITAL)) {
                // Exit loop in case if TITLE is present

                isMobileTitlePresent = true;

            }

        }
        // if we dont find element that match TITLE - display massege "Element not find"
        Assert.assertTrue("Mobile article is not found", isMobileTitlePresent);

        // Close browser window
        driver.quit();


    }
}
