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

        PageObjectSkyLight skyLight = new PageObjectSkyLight(driver);
        checkIfSkyLightQuestionIsVisible(skyLight);
        skyLight.selectJa();
        waitSeconds(2);

        PageObjectNumberOfPeople numberOfPeople = new PageObjectNumberOfPeople(driver);
        checkIfNumberOfPeopleQuestionIsVisible(numberOfPeople);
        numberOfPeople.selectOneToTwo();
        waitSeconds(2);

        PageObjectElectricityUsage electricityUsage = new PageObjectElectricityUsage(driver);
        checkIfElectricityUsageQuestionIsVisible(electricityUsage);
        electricityUsage.selectMorningAndEvening();
        waitSeconds(2);

        PageObjectHouseOwner houseOwner = new PageObjectHouseOwner(driver);
        checkIfHouseOwnerQuestionIsVisible(houseOwner);
        houseOwner.selectJa();
        waitSeconds(2);


    }

    @Test

    public void testFlachDachFlow() throws Exception {
        driver.get(baseUrl);

        PageObjectRoofType rooftype = new PageObjectRoofType(driver);
        checkIfRoofTypeQuestionIsVisible(rooftype);
        rooftype.selectFlachdach();
        waitSeconds(2);

        PageObjectSkyLight skyLight = new PageObjectSkyLight(driver);
        checkIfSkyLightQuestionIsVisible(skyLight);
        skyLight.selectJa();
        waitSeconds(2);

        PageObjectNumberOfPeople numberOfPeople = new PageObjectNumberOfPeople(driver);
        checkIfNumberOfPeopleQuestionIsVisible(numberOfPeople);
        numberOfPeople.selectThreeToFour();
        waitSeconds(2);

        PageObjectElectricityUsage electricityUsage = new PageObjectElectricityUsage(driver);
        checkIfElectricityUsageQuestionIsVisible(electricityUsage);
        electricityUsage.selectMorningAndEvening();
        waitSeconds(2);

        PageObjectHouseOwner houseOwner = new PageObjectHouseOwner(driver);
        checkIfHouseOwnerQuestionIsVisible(houseOwner);
        houseOwner.selectNein();
        waitSeconds(2);

    }

    @Test

    public void testPultDachFlow() throws Exception {
        driver.get(baseUrl);

        PageObjectRoofType rooftype = new PageObjectRoofType(driver);
        checkIfRoofTypeQuestionIsVisible(rooftype);
        rooftype.selectPultdach();
        waitSeconds(2);

        PageObjectSkyLight skyLight = new PageObjectSkyLight(driver);
        checkIfSkyLightQuestionIsVisible(skyLight);
        skyLight.selectNein();
        waitSeconds(2);

        PageObjectNumberOfPeople numberOfPeople = new PageObjectNumberOfPeople(driver);
        checkIfNumberOfPeopleQuestionIsVisible(numberOfPeople);
        numberOfPeople.selectFiveAndMore();
        waitSeconds(2);

        PageObjectElectricityUsage electricityUsage = new PageObjectElectricityUsage(driver);
        checkIfElectricityUsageQuestionIsVisible(electricityUsage);
        electricityUsage.selectAllDay();
        waitSeconds(2);

        PageObjectHouseOwner houseOwner = new PageObjectHouseOwner(driver);
        checkIfHouseOwnerQuestionIsVisible(houseOwner);
        houseOwner.selectJa();
        waitSeconds(2);
    }

    @Test

    public void testAnderesFlow() throws Exception {
        driver.get(baseUrl);

        PageObjectRoofType rooftype = new PageObjectRoofType(driver);
        checkIfRoofTypeQuestionIsVisible(rooftype);
        rooftype.selectAnderes();
        waitSeconds(2);

        PageObjectSkyLight skyLight = new PageObjectSkyLight(driver);
        checkIfSkyLightQuestionIsVisible(skyLight);
        skyLight.selectJa();
        waitSeconds(2);

        PageObjectNumberOfPeople numberOfPeople = new PageObjectNumberOfPeople(driver);
        checkIfNumberOfPeopleQuestionIsVisible(numberOfPeople);
        numberOfPeople.selectWisseNicht();
        waitSeconds(2);

        PageObjectElectricityUsage electricityUsage = new PageObjectElectricityUsage(driver);
        checkIfElectricityUsageQuestionIsVisible(electricityUsage);
        electricityUsage.selectOthers();
        waitSeconds(2);

        PageObjectHouseOwner houseOwner = new PageObjectHouseOwner(driver);
        checkIfHouseOwnerQuestionIsVisible(houseOwner);
        houseOwner.selectNein();
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

    private void checkIfSkyLightQuestionIsVisible(PageObjectSkyLight obj) {
        boolean isDisplayed = driver.findElement(obj.questionTitle).isDisplayed();
        Assert.assertTrue("Question not visible: Besitzt Ihr Haus Gauben oder Dachfenster?", isDisplayed);
    }

    private void checkIfNumberOfPeopleQuestionIsVisible(PageObjectNumberOfPeople obj) {
        boolean isDisplayed = driver.findElement(obj.questionTitle).isDisplayed();
        Assert.assertTrue("Question not visible: Wie viele Personen leben in Ihrem Haushalt?", isDisplayed);
    }

    private void checkIfElectricityUsageQuestionIsVisible(PageObjectElectricityUsage obj) {
        boolean isDisplayed = driver.findElement(obj.questionTitle).isDisplayed();
        Assert.assertTrue("Question not visible: Wann verbrauchen Sie Ihren Strom??", isDisplayed);
    }

    private void checkIfHouseOwnerQuestionIsVisible(PageObjectHouseOwner obj) {
        boolean isDisplayed = driver.findElement(obj.questionTitle).isDisplayed();
        Assert.assertTrue("Question not visible: Sind Sie Eigentümer des Hauses?", isDisplayed);
    }
}
