package Pages.qa;

import Pages.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class qaMainPage extends BasePage {
    public qaMainPage(WebDriver driver) {
        super(driver);
    }

    private final By elements = By.xpath("//h5[normalize-space()='Elements']");
    private final By CheckBox = By.xpath("(//li[@id='item-1'])[1]");
    private final By check = By.xpath("//button[@title='Expand all']");

    public qaMainPage joinForm() {
        driver.findElement(elements).click();
        driver.findElement(CheckBox).click();

        return this;
    }

    public qaMainPage listOut() {
        WebElement listOut = driver.findElement(check);
        waitElemetsIsVisible(listOut).click();
        return this;
    }
}
