package pages;

import org.openqa.selenium.By;

public class TicRegistrationPage {
    BaseFunc baseFunc;

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

    public TicRegistrationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }


        public void nameRegistrationFild(String s) {
            baseFunc.getElement(NAME).sendKeys(s);
        }

        public void surenameRegistrationFild(String s) {
            baseFunc.getElement(SURNAME).sendKeys(s);
        }

        public void discountCodeFild(String s) {
            baseFunc.getElement(DISCOUNTCODE).sendKeys(s);
        }

        public void adultsRegistrationFild(String s) {
            baseFunc.getElement(ADULTS).sendKeys(s);
        }

        public void childrenRegistrationFild(String s) {
            baseFunc.getElement(CHILDREN).sendKeys(s);
        }

        public void bugsRegistrationFild(String s) {
            baseFunc.getElement(BUGS).sendKeys(s);
        }

        public void selectDate(String data) {
            baseFunc.selectFromDropDown(FLIGHT, data);
        }

        public void pressGetprice() {
            baseFunc.getElement(GETPRICE).click();
        }

        public void pressBook() {
            baseFunc.getElement(BOOK).click();
        }

        public void pressSeat() {
            baseFunc.getElement(SEAT).click();
        }

        public void pressFinalBook() {
            baseFunc.getElement(FINALBOOK).click();
        }
}
