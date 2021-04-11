package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectLandRegistrationDetails {
    WebDriver driver;
    By questionTitle = By.xpath("//div[contains(@class, 'question-transition')]/p");
    By onePerson = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[1]");
    By twoPerson = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[2]");
    By threeOrMorePersons = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[3]");
    By unkown = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[4]");

    public PageObjectLandRegistrationDetails(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOnePerson() {
        driver.findElement(onePerson).click();
    }

    public void selectTwoPerson() {
        driver.findElement(twoPerson).click();
    }

    public void selectThreeOrMorePersons() {
        driver.findElement(threeOrMorePersons).click();
    }

    public void selectUnkown() {
        driver.findElement(unkown).click();
    }

}
