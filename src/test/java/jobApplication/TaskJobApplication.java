package jobApplication;


import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TaskJobApplication {

    private static final String MAIN_PAGE = "https://www.united.com/";
    private static final By SIMPLEMODAL_CLOSE_BTN = By.xpath(".//*[contains(@class, 'modalCloseImg simplemodal-close')]");
    private static final By ONE_WAY = By.id("SearchTypeMain_oneWay");
    private static final By FROM = By.id("Origin");
    private static final By TO = By.id("Destination");
    private static final By DATE = By.id("DepartDate");
    private static final By BOOKINGSUMBIT = By.id("flightBookingSubmit");
    private static final By ECONOMY = By.xpath(".//*[contains(@class, 'col-description-bg')]");
    private static final By ICONSORTER = By.xpath(".//*[contains(@class, 'icon-sorter')]");
    private static final By DEPART = By.xpath(".//*[contains(@class, 'flight-time flight-time-depart')]");
    private static final By ARRIVE = By.xpath(".//*[contains(@class, 'flight-time flight-time-arrive')]");
    private static final By STOPS = By.xpath(".//*[contains(@class, 'flight-connection-tooltip-trigger connection-count')]");
    private static final By DURATION = By.xpath(".//*[contains(@class, 'flight-duration otp-tooltip-trigger')]");
    private static final By PRICES = By.xpath(".//*[contains(@class, 'price-point price-point-revised use-roundtrippricing')]");
    private static final By RESULTS = By.id("fl-results");
    private static final By SHOWALL = By.xpath(".//*[contains(@class, 'pagerShowAll')]");


    @Test

    public void myjobapplicationtest() {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open main page of the Web version
        driver.get(MAIN_PAGE);

        // Close pop-up window
        driver.findElement(SIMPLEMODAL_CLOSE_BTN).click();
        if (SIMPLEMODAL_CLOSE_BTN.equals(null)) {
            System.out.println("No pop-up window found");
        }

        // Choose one way flight
        driver.findElement(ONE_WAY).click();
        // Choose from where flight
        driver.findElement(FROM).sendKeys("New York, NY, US (JFK - Kennedy)");
        //Choose destination
        driver.findElement(TO).sendKeys("Miami, FL, US (MIA - All\n" +
                "Airports)");
        //Choose date
        driver.findElement(DATE).sendKeys("20.08");
        //Click button 'sumbit', to see result
        driver.findElement(BOOKINGSUMBIT).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Sort from low to high price
        driver.findElement(ECONOMY).click();
        driver.findElement(ICONSORTER).click();
        //Click button 'show all', to see all result
        driver.findElement(SHOWALL).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (SHOWALL.equals(null)){
            System.out.println("Button show all not found");
        }

        // Find all information of the flights and add them to a list
        List<WebElement> results = driver.findElements(RESULTS);
        // Check if list is not emty
        Assert.assertFalse("Result list is emty", results.isEmpty());

        JSONObject flights = new JSONObject();

        // Go througt a list and getText() from WebElements
        for (int i = 0; i<results.size(); i++){
            WebElement we = results.get(i);

            String departs = we.findElement(DEPART).getText();
            String arrives = we.findElement(ARRIVE).getText();
            String stops = we.findElement(STOPS).getText();
            String durations = we.findElement(DURATION).getText();
            String prices = we.findElement(PRICES).getText();

            flights.put("Depart", departs);
            flights.put("Arrive", arrives);
            flights.put("Stops", stops);
            flights.put("Durations", durations);
            flights.put("Prices", prices);

            System.out.println(flights.toJSONString());
            flights.clear();

        }


    }
}


