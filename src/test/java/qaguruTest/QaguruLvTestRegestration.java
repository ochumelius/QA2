package qaguruTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import pages.BaseFunc;
import pages.TicHomePage;
import pages.TicRegistrationPage;

public class QaguruLvTestRegestration {

    private static final String MAIN_PAGE = "http://qaguru.lv/tickets/";

    @Test
    public void myqagurutest(){
        BaseFunc qaBaseFunc = new BaseFunc();

        qaBaseFunc.goToUrl(MAIN_PAGE);

        TicHomePage ticHomePage = new TicHomePage(qaBaseFunc);

        ticHomePage.selectFrom("RIX");
        ticHomePage.selectTo("SFO");

        TicRegistrationPage registrationPage = ticHomePage.pressGoGoGo();

        registrationPage.nameRegistrationFild("Julija");
        registrationPage.surenameRegistrationFild("Prokopenko");
        registrationPage.discountCodeFild("123");
        registrationPage.adultsRegistrationFild("1");
        registrationPage.childrenRegistrationFild("1");
        registrationPage.bugsRegistrationFild("2");

        registrationPage.selectDate("11-05-2018");

        registrationPage.pressGetprice();
        registrationPage.pressBook();
        registrationPage.pressSeat();
        registrationPage.pressFinalBook();

    }
}
