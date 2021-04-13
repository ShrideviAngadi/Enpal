package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PageObjectSolarOfferInformation {
    WebDriver driver;
    By offerInformationText = By.xpath("//div[contains(@class, 'Form_ContentContainer__jbB6M form-content')]/p");
    By firstAndLastNameTextField = By.xpath("//input[contains(@name, 'name')]");
    By strasseTextField = By.xpath("//input[contains(@name, 'address')]");
    By handyNumberTextField = By.xpath("//input[contains(@name, 'phone')]");
    By emailTextField = By.xpath("//input[contains(@name, 'email')]");
    By getFreeInformationButton = By.xpath("//button[contains(@data-testid, 'submit')]");
    By nameErrorText = By.xpath("//form[contains(@class, 'Form_Form__3Lt5d')]/div[1]/label");
    By phoneNumberErrorText = By.xpath("//form[contains(@class, 'Form_Form__3Lt5d')]/div[3]/label");
    By emailErrorText = By.xpath("//form[contains(@class, 'Form_Form__3Lt5d')]/div[4]/label");

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

        // This is because of firefox webdriver bug for number input
        // driver.findElement(handyNumberTextField).sendKeys(phoneNumber); NOT WORKING IN FIREFOX

        for (int i=0; i<phoneNumber.length(); i++) {
            String singleCharString = Character.toString(phoneNumber.charAt(i));
            driver.findElement(handyNumberTextField).sendKeys(singleCharString);
        }
    }

    public void enterEmail(String emailId) {

        driver.findElement(emailTextField).sendKeys(emailId);
    }

    public void clickGetFreeInformationButton() {
        driver.findElement(getFreeInformationButton).click();
    }

}
