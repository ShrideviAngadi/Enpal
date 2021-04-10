package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectRoofType {

    WebDriver driver;

    By questionTitle = By.xpath("//div[contains(@class, 'question-transition')]/p");
    By satteldach = By.xpath("//div[contains(@class, 'SingleAnswer_AnswersContainer__J2Aul')]/div[1]");
    By flachdach = By.xpath("//div[contains(@class, 'SingleAnswer_AnswersContainer__J2Aul')]/div[2]");
    By pultdach = By.xpath("//div[contains(@class, 'SingleAnswer_AnswersContainer__J2Aul')]/div[3]");
    By anderes = By.xpath("//div[contains(@class, 'SingleAnswer_AnswersContainer__J2Aul')]/div[4]");

    public PageObjectRoofType(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSatteldach() {

        driver.findElement(satteldach).click();

    }

    public void selectFlachdach() {

        driver.findElement(flachdach).click();
    }

    public void selectPultdach() {

        driver.findElement(pultdach).click();
    }

    public void selectAnderes() {

        driver.findElement(anderes).click();
    }

}
