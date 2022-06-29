package base.Tests;

import Pages.Base.BasePage;
import Pages.listing.qaList;
import Pages.qa.qaMainPage;
import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import static common.Config.CLEAR_COOKIE_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected qaMainPage qaMainPage = new qaMainPage(driver);
    protected qaList qaList = new qaList(driver);

    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if (CLEAR_COOKIE_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");

        }
    }
    @AfterTest (alwaysRun = true)
    public void close(){
        if(!HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
