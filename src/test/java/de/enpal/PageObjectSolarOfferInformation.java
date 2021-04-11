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

    public void enterFirstAndLastName() {
        driver.findElement(firstAndLastNameTextField).sendKeys("Thomas tortal");
    }

    public void enterStrasse() {
        driver.findElement(strasseTextField).sendKeys("Gotlinder strasse 26");
    }

    public void enterHandyNumber() {
        driver.findElement(handyNumberTextField).sendKeys("015212141879");
    }

    public void enterEmail() {
        driver.findElement(emailTextField).sendKeys("thomas.tortal@gmail.com");
    }

    public void clickGetFreeInformationButton() {
        driver.findElement(getFreeInformationButton).click();
    }

}
