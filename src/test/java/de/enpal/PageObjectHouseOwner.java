package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectHouseOwner {

    WebDriver driver;

    By questionTitle = By.xpath("//div[contains(@class, 'question-transition')]/p");
    By ja = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[1]/div[1]/div[2]");
    By nein = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[2]/div[1]/div[2]");

    public PageObjectHouseOwner(WebDriver driver) {
        this.driver = driver;
    }

    public void selectJa() {
        driver.findElement(ja).click();
    }

    public void selectNein() {
        driver.findElement(nein).click();
    }
}
