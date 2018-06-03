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
    private static final By ECONOMY = By.xpath(".//*[contains(@id, 'mm_display_be')]");
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


        driver.findElement(ONE_WAY).click();
        driver.findElement(FROM).sendKeys("New York, NY, US (JFK - Kennedy)");
        driver.findElement(TO).sendKeys("Miami, FL, US (MIA - All\n" +
                "Airports)");
        driver.findElement(DATE).sendKeys("20.08");
        driver.findElement(BOOKINGSUMBIT).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(ECONOMY).click();
        driver.findElement(ICONSORTER).click();
        driver.findElement(SHOWALL).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Find all information of the flights and add them to a list
        List<WebElement> Results = driver.findElements(RESULTS);

        // Check if list is not emty
        Assert.assertFalse("Result list is emty", Results.isEmpty());

        JSONObject Flights = new JSONObject();

        // Go througt a list and getText() from WebElements
        for (int i = 0; i<Results.size(); i++){
            WebElement we = Results.get(i);

            String Departs = we.findElement(DEPART).getText();
            String Arrives = we.findElement(ARRIVE).getText();
            String Stops = we.findElement(STOPS).getText();
            String Durations = we.findElement(DURATION).getText();
            String Prices = we.findElement(PRICES).getText();

            Flights.put("Depart", Departs);
            Flights.put("Arrive", Arrives);
            Flights.put("Stops", Stops);
            Flights.put("Durations", Durations);
            Flights.put("Prices", Prices);

            System.out.println(Flights.toJSONString());
            Flights.clear();

        }

   //    //Write JSON to file
   //    try (FileWriter file = new FileWriter("c:\\test.json")){

   //        file.write(Flights.toJSONString());
   //        file.flush();
    //    } catch (IOException e){
    //        e.printStackTrace();
    //    }


    }
}


