package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TicHomePage {

    BaseFunc baseFunc;

    private static final By FROM = By.id("afrom");
    private static final By TO = By.id("bfrom");
    private static final By GOGOGO = By.xpath(".//*[contains(@class, 'gogogo')]");

    public TicHomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

    }

    public void selectFrom(String airport) {
        baseFunc.selectFromDropDown(FROM, airport);
    }

    public void selectTo(String airport) {
        baseFunc.selectFromDropDown(TO, airport);
    }

    public TicRegistrationPage pressGoGoGo() {
        baseFunc.getElement(GOGOGO).click();
        return new TicRegistrationPage(baseFunc);
    }
}
