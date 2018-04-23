package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkDelfi {

// Article page

    private static final String MAIN_PAGE_WEB_URL = "http://www.delfi.lv/";
    private static final By ARTICLE = By.xpath(".//h3[contains(@class, 'top2012-title')]");
    private static final By TITLE = By.xpath(".//a[contains(@class, 'top2012-title')]");
    private static final By COMMENTS = By.xpath(".//a[contains(@class, 'comment-count')]");
    private static final By REGCOMMENTS = By.xpath(".//*[contains(@class,'comment-thread-switcher-list-a comment-thread-switcher-list-a-reg'");
    private static final By ANONCOMMENTS = By.xpath(".//*[contains(@class, 'comment-thread-switcher-list-a comment-thread-switcher-list-a-anon'");
    private static final By ARTICLETITLE = By.xpath(".//*[contains(@itemprop, 'headline name')]");

    private static final String MOB_MAIN_PAGE_WEB_URL = "http://m.delfi.lv/";
    private static final By MOB_ARTICLE = By.className("md-mosaic-big ");
    private static final By MOB_TITLE = By.xpath(".//*[contains(@class, 'top2012-title')]");
    private static final By MOB_COMMENTS = By.xpath(".//*[contains(@class, 'commentCount')]");
    private static final By MOB_REGCOMMENTS = By.xpath(".//*[contains(@class,'comment-thread-switcher-list-a comment-thread-switcher-list-a-reg'");
    private static final By MOB_ANONCOMMENTS = By.xpath(".//*[contains(@class, 'comment-thread-switcher-list-a comment-thread-switcher-list-a-anon')]");
    private static final By MOB_ARTICLETITLE = By.xpath(".//*[contains(@class, 'article-title')]");


    @Test
    public void myhomeworkdelfi() {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

// Delfi web page

        driver.get(MAIN_PAGE_WEB_URL);

        List<WebElement> articles = driver.findElements(ARTICLE);

        Assert.assertFalse("Article list is empty", articles.isEmpty());

        List<String> titles = new ArrayList<String>();
        List<String> links = new ArrayList<String>();
        List<Integer> counts = new ArrayList<Integer>();


        for (int i = 0; i < 5; i++) {
            WebElement we = articles.get(i);

            String title = we.findElement(TITLE).getText();
            String link = we.findElement(TITLE).getAttribute("href");
            String count = we.findElement(COMMENTS).getText();

            Integer counter = getCounter(count);

            titles.add(title);
            links.add(link);
            counts.add(counter);
        }

        Assert.assertFalse("Titles list is emty", titles.isEmpty());
        Assert.assertFalse("Links list is emty", links.isEmpty());
        Assert.assertFalse("Counts list is emty", counts.isEmpty());


        articles.get(0).click();
        Assert.assertEquals("Web title and article title don't match", titles.get(0), driver.findElement(ARTICLETITLE).getText());

        String regComments = driver.findElement(REGCOMMENTS).getText();
        Integer regComm = getCounter(regComments);

        String anonComments = driver.findElement(ANONCOMMENTS).getText();
        Integer anonComm = getCounter(anonComments);

        Integer summOfComments = regComm + anonComm;

        Assert.assertEquals("Web comments count and article comments count don't match", counts.get(0), summOfComments);



        //Delfi mobile page

        WebDriver driverMob = new FirefoxDriver();
        driverMob.manage().window().maximize();

        driverMob.get(MOB_MAIN_PAGE_WEB_URL);

        List<WebElement> mobArticles = driverMob.findElements(MOB_ARTICLE);
        Assert.assertFalse("Articles list is emty", mobArticles.isEmpty());

        List<String> mobTitles = new ArrayList<String>();
        List<String> mobLinks = new ArrayList<String>();
        List<Integer> mobCounts = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++){
            WebElement mob = mobArticles.get(i);

            String mobTitle = mob.findElement(MOB_TITLE).getText();
            String mobLink = mob.findElement(MOB_TITLE).getAttribute("href");
            String mobCount = mob.findElement(MOB_COMMENTS).getText();

            Integer mobCounter = getMobCounter(mobCount);

            mobTitles.add(mobTitle);
            mobLinks.add(mobLink);
            mobCounts.add(mobCounter);
        }

        Assert.assertFalse("Mobile titles list is emty", mobTitles.isEmpty());
        Assert.assertFalse("Mobile links list is emty", mobLinks.isEmpty());
        Assert.assertFalse("Mobile counts list is emty", mobCounts.isEmpty());

        mobArticles.get(0).click();
        Assert.assertEquals("Mobile title and mobile article title don't match", mobTitles.get(0), driverMob.findElement(MOB_ARTICLETITLE).getText());

        String mobRegComments = driverMob.findElement(MOB_REGCOMMENTS).getText();
        Integer mobRegComm = getMobCounter(mobRegComments);

        String mobAnonComments = driverMob.findElement(MOB_ANONCOMMENTS).getText();
        Integer mobAnonComm = getMobCounter(mobAnonComments);

        Integer mobSumComments = mobRegComm + mobAnonComm;

        Assert.assertEquals("Mobile comments count and mobile article comments count don't match", mobCounts.get(0), mobSumComments);

        Assert.assertEquals("Web title and mobile title don't match", titles, mobTitles);
        Assert.assertEquals("Web comments amount and mobile comments amount don't match", counts, mobCounts);

        driver.quit();


    }

    private Integer getCounter(String text) {

        text = text.substring(1);
        text = text.substring(0, text.length() -  1);

        return Integer.parseInt(text);

    }

    private Integer getMobCounter (String text){
        text = text.substring(1);
        text = text.substring(0, text.length() -  1);

        return Integer.parseInt(text);
    }



}
