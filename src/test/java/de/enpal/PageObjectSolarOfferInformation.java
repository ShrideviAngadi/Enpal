package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectSolarOfferInformation {
    WebDriver driver;
    By offerInformationText = By.xpath("//div[contains(@class, 'Form_ContentContainer__jbB6M form-content')]/p");
    By firstAndLastNameTextField = By.xpath("//input[contains(@name, 'name')]");
    By strasseTextField = By.xpath("//input[contains(@name, 'address')]");
    By handyNumberTextField = By.xpath("//input[contains(@name, 'phone')]");
    By emailTextField = By.xpath("//input[contains(@name, 'email')]");
    By getFreeInformationButton = By.xpath("//button[contains(@data-testid, 'submit')]");

    public PageObjectSolarOfferInformation(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstAndLastName(String firstLastName) {
        driver.findElement(firstAndLastNameTextField).sendKeys(firstLastName);
    }

    public void enterStrasse(String address) {
        driver.findElement(strasseTextField).sendKeys(address);
    }

    public void enterHandyNumber(String phoneNumber) {
        driver.findElement(handyNumberTextField).sendKeys(phoneNumber);
    }

    public void enterEmail(String emailId) {
        driver.findElement(emailTextField).sendKeys(emailId);
    }

    public void clickGetFreeInformationButton() {
        driver.findElement(getFreeInformationButton).click();
    }

}
