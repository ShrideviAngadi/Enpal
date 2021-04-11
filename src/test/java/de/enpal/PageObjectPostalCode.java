package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectPostalCode {
    WebDriver driver;
    By questionTitle = By.xpath("//div[contains(@class, 'NumericAnswer_Container__25PMZ')]/p[2]");
    By postalCodeTextfield = By.xpath("//input[contains(@name, 'zipCode')]");
    By nextButton = By.xpath("//button[contains(@data-testid, 'submit')]");

    public PageObjectPostalCode(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPostalCode() {
        driver.findElement(postalCodeTextfield).sendKeys("10367");
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
