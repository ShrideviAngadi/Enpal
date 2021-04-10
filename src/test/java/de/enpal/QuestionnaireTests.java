package de.enpal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuestionnaireTests {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "https://dynamic-slider-staging.azurewebsites.net/";
    }

    @Test

    public void testSattelDachFlow() throws Exception {
        driver.get(baseUrl);
        waitSeconds(2);
        PageObjectRoofType rooftype = new PageObjectRoofType(driver);
        checkIfRoofTypeQuestionIsVisible(rooftype);
        rooftype.selectSatteldach();
        waitSeconds(2);
    }

    @Test

    public void testFlachDachFlow() throws Exception {
        driver.get(baseUrl);
        PageObjectRoofType rooftype = new PageObjectRoofType(driver);
        checkIfRoofTypeQuestionIsVisible(rooftype);
        rooftype.selectFlachdach();
        waitSeconds(2);
    }

    @Test

    public void testPultDachFlow() throws Exception {
        driver.get(baseUrl);
        PageObjectRoofType rooftype = new PageObjectRoofType(driver);
        checkIfRoofTypeQuestionIsVisible(rooftype);
        rooftype.selectPultdach();
    }

    @Test

    public void testAnderesFlow() throws Exception {
        driver.get(baseUrl);
        PageObjectRoofType rooftype = new PageObjectRoofType(driver);
        checkIfRoofTypeQuestionIsVisible(rooftype);
        rooftype.selectAnderes();
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

    private void checkIfRoofTypeQuestionIsVisible(PageObjectRoofType obj) {
        boolean isDisplayed = driver.findElement(obj.questionTitle).isDisplayed();
        Assert.assertTrue("Question not visible: Welche Dachform hat Ihr Haus?", isDisplayed);
    }
}
