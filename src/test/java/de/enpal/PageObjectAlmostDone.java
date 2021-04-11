package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectAlmostDone {
    WebDriver driver;

    By almostDoneText = By.xpath("//div[contains(@class, 'success-content')]/p[1]");
    By nextButton = By.xpath("//button[contains(@data-testid, 'submit')]");

    public PageObjectAlmostDone(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}
