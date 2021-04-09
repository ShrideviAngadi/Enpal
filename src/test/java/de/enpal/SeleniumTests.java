package de.enpal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class SeleniumTests {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://dynamic-slider-staging.azurewebsites.net/";

    }
    @Test
    public void testSeleniumTestCase() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[contains(@data-testid, 'label-container')]")).click();
        waitSeconds(2);
        driver.findElement(By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[2]/div[1]/div[2]")).click();//Nein clicking
        waitSeconds(2);
        driver.findElement(By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[2]/div[1]/div[2]")).click();//3-4 click
        waitSeconds(2);
        driver.findElement(By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[1]/div[1]/div[2]")).click();//morgens
        waitSeconds(2);
        driver.findElement(By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[1]/div[1]/div[2]")).click();//Ja
        waitSeconds(2);
        driver.findElement(By.xpath("//input[contains(@name, 'zipCode')]")).sendKeys("10367");
        waitSeconds(2);
        driver.findElement(By.xpath("//button[contains(@data-testid, 'submit')]")).click();
        waitSeconds(6);
        driver.findElement(By.xpath("//input[contains(@name, 'name')]")).sendKeys("Thomas tortal");
        driver.findElement(By.xpath("//input[contains(@name, 'address')]")).sendKeys("Gotlinder strasse 26");
        driver.findElement(By.xpath("//input[contains(@name, 'phone')]")).sendKeys("015212141879");
        driver.findElement(By.xpath("//input[contains(@name, 'email')]")).sendKeys("thomas.tortal@gmail.com");
        driver.findElement(By.xpath("//button[contains(@data-testid, 'submit')]")).click();
        waitSeconds(6);
        driver.findElement(By.xpath("//button[contains(@data-testid, 'submit')]")).click();
        waitSeconds(2);
        driver.findElement(By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[2]")).click();
        waitSeconds(2);
        driver.findElement(By.xpath("//div[contains(@class, 'SingleAnswer_AnswersContainer__J2Aul')]/div[1]")).click();
        waitSeconds(2);
        driver.findElement(By.xpath("//textarea[contains(@name, 'freetext')]")).sendKeys("selenium testing");
        waitSeconds(2);
        driver.findElement(By.xpath("//button[contains(@data-testid, 'freetext-submit')]")).click();

    }

    @After
    public void tearDown() throws Exception {


        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
        }
    }

    private void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException ignored) {

        }
    }

}
