package qaguruTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class QaguruLvTestRegestration {

    private static final String MAIN_PAGE = "http://qaguru.lv/tickets/";
    private static final By FROM = By.id("afrom");
    private static final By TO = By.id("bfrom");
    private static final By GOGOGO = By.xpath(".//*[contains(@class, 'gogogo')]");
    private static final By NAME = By.id("name");
    private static final By SURNAME = By.id("surname");
    private static final By DISCOUNTCODE = By.id("discount");
    private static final By ADULTS = By.id("adults");
    private static final By CHILDREN = By.id("children");
    private static final By BUGS = By.id("bugs");
    private static final By FLIGHT = By.id("flight");
    private static final By GETPRICE = By.xpath("//span[text()='Get Price']");
    private static final By BOOK = By.id("book2");
    private static final By SEAT = By.xpath(".//*[contains(@onclick, 'seat(1)')]");
    private static final By FINALBOOK = By.id("book3");



    @Test
    public void myqagurutest(){
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(MAIN_PAGE);

        new Select(driver.findElement(FROM)).selectByVisibleText("RIX");
        new Select(driver.findElement(TO)).selectByVisibleText("SFO");
        driver.findElement(GOGOGO).click();

        driver.findElement(NAME).sendKeys("Julija");
        driver.findElement(SURNAME).sendKeys("Prokopenko");
        driver.findElement(DISCOUNTCODE).sendKeys("123");
        driver.findElement(ADULTS).sendKeys("1");
        driver.findElement(CHILDREN).sendKeys("1");
        driver.findElement(BUGS).sendKeys("2");

        new Select(driver.findElement(FLIGHT)).selectByVisibleText("11-05-2018");

        driver.findElement(GETPRICE).click();
        driver.findElement(BOOK).click();
        driver.findElement(SEAT).click();
        driver.findElement(FINALBOOK).click();

    }
}
