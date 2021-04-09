package de.enpal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTests {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://dynamic-slider-staging.azurewebsites.net/";
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testSeleniumTestCase() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[contains(@data-testid, 'label-container')]")).click();
        waitSeconds(2);
        driver.findElement(By.xpath("//div[contains(@class,'SingleAnswer_AnswersContainer__J2Aul')]/div[2]/div[1]/div[2]")).click();//Nein clicking
        waitSeconds(2);

       // driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
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
