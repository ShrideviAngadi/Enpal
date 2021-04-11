package de.enpal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectNumberOfPeople {
    WebDriver  driver;

    By questionTitle = By.xpath("//div[contains(@class, 'question-transition')]/p");
    By oneToTwo = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[1]/div[1]/div[2]");
    By threeToFour = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[2]/div[1]/div[2]");
    By fiveAndMore = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[3]/div[1]/div[2]");
    By wisseNicht = By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[4]/div[1]/div[2]");

    public PageObjectNumberOfPeople(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOneToTwo() {
        driver.findElement(oneToTwo).click();
    }

    public void selectThreeToFour() {
        driver.findElement(threeToFour).click();
    }

    public void selectFiveAndMore() {
        driver.findElement(fiveAndMore).click();
    }

    public void selectWisseNicht() {
        driver.findElement(wisseNicht).click();
    }

}
