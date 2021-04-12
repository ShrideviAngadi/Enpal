package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectHouseFeatures {

    WebDriver driver;
    By questionTitle = By.xpath("//div[contains(@class, 'FreeText_Container__2X8aX')]/p[2]");
    By explainationTextField = By.xpath("//textarea[contains(@name, 'freetext')]");
    By nextButton = By.xpath("//button[contains(@data-testid, 'freetext-submit')]");

    public PageObjectHouseFeatures(WebDriver driver) {
        this.driver = driver;
    }

    public void enterHouseFeatures() {
        driver.findElement(explainationTextField).sendKeys("Testing");
    }

    public void clickOnNextButton() {
        driver.findElement(nextButton).click();
    }
}
