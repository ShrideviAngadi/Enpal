package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectHouseImagesUpload {
    WebDriver driver;
    By allRoofSurfacesImageText = By.xpath("//div[contains(@class, 'ImageUpload_Header__2P1iS')]/h1");
    By cameraIcon = By.xpath("//span[contains(@class, 'ImageUploadingSteps_circle__2-A32 ImageUploadingSteps_cursor-pointer__2w5cF')]");
    By clickNextArrow = By.xpath("//a[contains(@data-testid, 'next-step')]");
    By imageUploadComponent = By.xpath("//input[contains(@data-testid, 'file-input-roof')]");
    By houseWithSurroundingsText = By.xpath("//div[contains(@class, 'ImageUpload_Header__2P1iS')]/h1");
    By clickCounterCaseArrow = By.xpath("//a[contains(@data-testid, 'next-step')]");
    By surroundingHomeImageUpload = By.xpath("//input[contains(@data-testid, 'file-input-home')]");
    By openMeterCabinetText = By.xpath("//div[contains(@class, 'ImageUpload_Header__2P1iS')]/h1");
    By clickElectricityBillArrow = By.xpath("//a[contains(@data-testid, 'next-step')]");
    By meterCabinetImageUpload = By.xpath("//input[contains(@data-testid, 'file-input-meter')]");
    By currentElectricityBillText = By.xpath("//div[contains(@class, 'ImageUpload_Header__2P1iS')]/h1");
    By clickSendPhotosArrow = By.xpath("//a[contains(@data-testid, 'next-step')]");
    By actualElectricityBillUpload = By.xpath("//input[contains(@data-testid, 'file-input-invoice')]");
    By doneButton = By.xpath("//button[contains(@data-testid, 'fertig-button')]");
    By allImagesUploadedText = By.xpath("//div[contains(@class, 'ImageUpload_Header__2P1iS')]/h1");
    By termsAndConditionLink = By.xpath("//div[contains(@class, 'ImageUpload_TextCenter__3Z-2u')]/a");
    By termsAndConditionsLinkText = By.linkText("Hier erhalten Sie weitere Informationen zum Thema Datenschutz.");
    By linkToCellPhoneQuestion = By.xpath("//div[contains(@class, 'SMSReminder_Info__3iA_y')]/p[1]");

    public PageObjectHouseImagesUpload(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadRoofImage(String imagePath) {
        driver.findElement(imageUploadComponent).sendKeys(imagePath);

    }

    public void uploadSurroundingsHomeImage(String imagePath) {
        driver.findElement(surroundingHomeImageUpload).sendKeys(imagePath);
    }

    public void meterCabinetImageUpload(String imagePath) {
        driver.findElement(meterCabinetImageUpload).sendKeys(imagePath);
    }

    public void actualElectricityBillUpload(String imagePath) {
        driver.findElement(actualElectricityBillUpload).sendKeys(imagePath);
    }

    public void clickNextIcon() {
        driver.findElement(clickNextArrow).click();
    }

    public void clickCounterCaseArrow() {
        driver.findElement(clickCounterCaseArrow).click();
    }

    public void clickElectricityBillArrow() {
        driver.findElement(clickElectricityBillArrow).click();
    }

    public void clickSendPhotos() {
        driver.findElement(clickSendPhotosArrow).click();
    }

    public void clickDoneButton() {
        driver.findElement(doneButton).click();
    }

    public void clickOnTermsAndConditionLink() {
        driver.findElement(termsAndConditionLink).click();
    }

}
