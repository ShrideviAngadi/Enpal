package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectElectricityUsage {
    WebDriver driver;
    By questionTitle = By.xpath("//div[contains(@class, 'question-transition')]/p");
    By morningAndEvening = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[1]/div[1]/div[2]");
    By allDay = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[2]/div[1]/div[2]");
    By others = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[3]/div[1]/div[2]");

    public PageObjectElectricityUsage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectMorningAndEvening() {
        driver.findElement(morningAndEvening).click();
    }

    public void selectAllDay() {
        driver.findElement(allDay).click();
    }

    public void selectOthers() { driver.findElement(others).click(); }
}
