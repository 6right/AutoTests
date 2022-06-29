package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static Constants.Constant.TimeVariable.IMPLICIT_WAIT;
import static common.Config.PLATFORM_BROWSER;

public class CommonActions {
    public static WebDriver createDriver(){
        WebDriver driver = null;

        switch (PLATFORM_BROWSER){
            case "win_chrome":
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("**Incorrect platform or browser name: " + PLATFORM_BROWSER);

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
