package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectAgeConfirmation {
    WebDriver driver;
    By questionTitle = By.xpath("//div[contains(@class, 'question-transition')]/p");
    By allUnderSeventy = By.xpath("//div[contains(@class, 'SingleAnswer_AnswersContainer__J2Aul')]/div[1]");
    By oneOrMoreAboveSeventy = By.xpath("//div[contains(@class, 'SingleAnswer_AnswersContainer__J2Aul')]/div[2]");
    By ageAlertInfo = By.xpath("//div[contains(@class, 'SingleAnswer_MessageContainer__GXxOI SingleAnswer_ShowMessage__UQiiI')]/div[1]");

    public PageObjectAgeConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    public void selectAllUnderSeventy(){
        driver.findElement(allUnderSeventy).click();
    }

    public void selectOneOrMoreAboveSeventy() {
        driver.findElement(oneOrMoreAboveSeventy).click();
    }

}
