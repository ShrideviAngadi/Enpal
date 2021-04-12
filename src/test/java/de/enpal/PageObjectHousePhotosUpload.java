package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectHousePhotosUpload {

    WebDriver driver ;

    By housePhotosUploadText = By.xpath("//div[contains(@class, 'SingleAction_Container__39i_H transition-container components_newDesign__2I3gk SingleAction_newDesign__q6Pn-')]/p[1]");
    By uploadPhotosNowButton = By.xpath("//button[contains(@data-testid, 'submit')]");

    public PageObjectHousePhotosUpload(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnUploadPhotosButton() {
        driver.findElement(uploadPhotosNowButton).click();
    }
}
