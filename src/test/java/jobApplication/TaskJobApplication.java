package jobApplication;

import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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
    private static final By BookingSubmit = By.id("flightBookingSubmit");
    private static final By Economy = By.xpath(".//*[contains(@id, 'mm_display_be')]");
    private static final By ICONSORTER = By.xpath(".//*[contains(@class, 'icon-sorter')]");
    private static final By DEPART = By.xpath(".//*[contains(@class, 'flight-time flight-time-depart')]");
    private static final By ARRIVE = By.xpath(".//*[contains(@class, 'flight-time flight-time-arrive')]");
    private static final By STOPS = By.xpath(".//*[contains(@class, 'flight-connection-tooltip-trigger connection-count')]");
    private static final By DURATION = By.xpath(".//*[contains(@class, 'flight-duration otp-tooltip-trigger')]");


    @Test

    public void myjobapplicationtest () throws InterruptedException{
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
   //     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(MAIN_PAGE);
        Thread.sleep(2000);


        driver.findElement(SIMPLEMODAL_CLOSE_BTN).click();
        if(SIMPLEMODAL_CLOSE_BTN.equals(null)) {
            System.out.println("No pop-up window found");
        }


        driver.findElement(ONE_WAY).click();
        driver.findElement(FROM).sendKeys("New York, NY, US (JFK - Kennedy)");
        driver.findElement(TO).sendKeys("Miami, FL, US (MIA - All\n" +
                "Airports)");
        driver.findElement(DATE).sendKeys("20.08");
        driver.findElement(BookingSubmit).click();


        driver.findElement(Economy).click();
        driver.findElement(ICONSORTER).click();

        List <WebElement> FlightList = driver.findElements(DEPART);








    }

}
