package Pages.listing;

import Pages.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class qaList extends BasePage {


    public qaList(WebDriver driver) {
        super(driver);
    }

    private final By checks = By.xpath("//span[@class='rct-checkbox']");

    public  qaList checkCount () {
        int checkCount = driver.findElements(checks).size();
        Assert.assertEquals(checkCount, 17);
        return this;
    }
}
