package de.enpal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;


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
        waitSeconds(2);
        driver.findElement(By.xpath("//button[contains(@data-testid, 'submit')]")).click();
        waitSeconds(2);

        //uploading image  1st screen
        WebElement uploadFile=driver.findElement(By.xpath("//input[contains(@data-testid, 'file-input-roof')]"));
        File file = new File("TestImage.jpeg");
        uploadFile.sendKeys(file.getAbsolutePath());
        waitSeconds(6);

        //2nd screen
        driver.findElement(By.xpath("//a[contains(@data-testid, 'next-step')]")).click();

        WebElement uploadFile1=driver.findElement(By.xpath("//input[contains(@data-testid, 'file-input-home')]"));
        File file1 = new File("TestImage.jpeg");
        uploadFile1.sendKeys(file1.getAbsolutePath());
        waitSeconds(6);

        //3rd screen
        driver.findElement(By.xpath("//a[contains(@data-testid, 'next-step')]")).click();

        WebElement uploadFile2=driver.findElement(By.xpath("//input[contains(@data-testid, 'file-input-meter')]"));
        File file2 = new File("TestImage.jpeg");
        uploadFile2.sendKeys(file2.getAbsolutePath());
        waitSeconds(6);

        //4th screen
        driver.findElement(By.xpath("//a[contains(@data-testid, 'next-step')]")).click();

        WebElement uploadFile3=driver.findElement(By.xpath("//input[contains(@data-testid, 'file-input-invoice')]"));
        File file3 = new File("TestImage.jpeg");
        uploadFile3.sendKeys(file3.getAbsolutePath());
        waitSeconds(6);

        //final phtos sending
        driver.findElement(By.xpath("//a[contains(@data-testid, 'next-step')]")).click();
        waitSeconds(2);
        //fertig button
        driver.findElement(By.xpath("//button[contains(@data-testid, 'fertig-button')]")).click();
        waitSeconds(2);



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
