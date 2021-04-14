package de.enpal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

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

        driver.get(baseUrl);
    }

    @Test
    public void testSattelDachFlow() throws Exception {
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

        PageObjectPostalCode postalCode = new PageObjectPostalCode(driver);
        checkIfPostalCodeQuestionIsVisible(postalCode);
        postalCode.enterPostalCode();
        postalCode.clickNextButton();
        waitSeconds(6);

        PageObjectSolarOfferInformation solarOfferInformation = new PageObjectSolarOfferInformation(driver);
        checkIfSolarInformationTextIsVisible(solarOfferInformation);

        boolean isButtonEnabled = driver.findElement(solarOfferInformation.getFreeInformationButton).isEnabled();
        Assert.assertFalse("Form is empty but getOffers button is enabled", isButtonEnabled);


        solarOfferInformation.enterFirstAndLastName("Thomas tortal");
        solarOfferInformation.enterStrasse("Gotlinder strasse 26");
        driver.findElement(solarOfferInformation.handyNumberTextField).click();
        solarOfferInformation.enterHandyNumber("015216778865");
        solarOfferInformation.enterEmail("thomas.tortal@gmail.com");
        solarOfferInformation.clickGetFreeInformationButton();
        waitSeconds(6);

        PageObjectAlmostDone almostDone = new PageObjectAlmostDone(driver);
        checkIfAlmostDoneTextIsVisible(almostDone);
        almostDone.clickNextButton();
        waitSeconds(2);

        PageObjectLandRegistrationDetails landRegistrationDetails = new PageObjectLandRegistrationDetails(driver);
        checkIfLandRegistrationQuestionIsVisible(landRegistrationDetails);
        landRegistrationDetails.selectOnePerson();
        waitSeconds(2);

        PageObjectAgeConfirmation ageConfirmation = new PageObjectAgeConfirmation(driver);
        checkIfAgeConfirmationQuestionIsVisible(ageConfirmation);
        ageConfirmation.selectAllUnderSeventy();
        waitSeconds(2);

        PageObjectHouseFeatures houseFeatures = new PageObjectHouseFeatures(driver);
        checkIfHouseFeaturesQuestionIsVisible(houseFeatures);
        houseFeatures.enterHouseFeatures();
        houseFeatures.clickOnNextButton();
        waitSeconds(2);

        PageObjectHousePhotosUpload uploadPhotos = new PageObjectHousePhotosUpload(driver);
        checkIfUploadHousePhotosTextIsVisible(uploadPhotos);
        uploadPhotos.clickOnUploadPhotosButton();
        waitSeconds(2);


        PageObjectHouseImagesUpload imagesUpload = new PageObjectHouseImagesUpload(driver);
        checkIfRoofSurfacesTextIsVisible(imagesUpload);

        boolean isCameraButtonEnabled = driver.findElement(imagesUpload.cameraIcon).isEnabled();
        Assert.assertTrue("Camera button should be Enabled", isCameraButtonEnabled);

        File file = new File("TestImage.jpeg");
        imagesUpload.uploadRoofImage(file.getAbsolutePath());
        waitSeconds(6);

        imagesUpload.clickNextIcon();
        waitSeconds(2);

        checkIfHouseSurroundingsTextIsVisible(imagesUpload);

        boolean isCameraButton2Enabled = driver.findElement(imagesUpload.cameraIcon).isEnabled();
        Assert.assertTrue("Camera button should be Enabled", isCameraButton2Enabled);

        File file1 = new File("TestImage.jpeg");
        imagesUpload.uploadSurroundingsHomeImage(file1.getAbsolutePath());
        waitSeconds(6);

        imagesUpload.clickCounterCaseArrow();
        waitSeconds(2);

        checkIfOpenMeterCabinetTextIsVisible(imagesUpload);

        boolean isCameraButton3Enabled = driver.findElement(imagesUpload.cameraIcon).isEnabled();
        Assert.assertTrue("Camera button should be Enabled", isCameraButton3Enabled);

        File file2 = new File("TestImage.jpeg");
        imagesUpload.meterCabinetImageUpload(file2.getAbsolutePath());
        waitSeconds(6);

        imagesUpload.clickElectricityBillArrow();
        waitSeconds(2);

        checkIfActualElectricityBillTextIsVisible(imagesUpload);

        boolean isCameraButton4Enabled = driver.findElement(imagesUpload.cameraIcon).isEnabled();
        Assert.assertTrue("Camera button should be Enabled", isCameraButton4Enabled);

        File file3 = new File("TestImage.jpeg");
        imagesUpload.actualElectricityBillUpload(file3.getAbsolutePath());
        waitSeconds(6);

        imagesUpload.clickSendPhotos();
        waitSeconds(2);

        checkIfAllImagesUploadedQuestionIsVisible(imagesUpload);
        imagesUpload.clickDoneButton();
        waitSeconds(2);

        imagesUpload.clickOnTermsAndConditionLink();
        waitSeconds(2);
    }

    @Test
    public void testContactFormValidation() throws Exception {

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

        PageObjectPostalCode postalCode = new PageObjectPostalCode(driver);
        checkIfPostalCodeQuestionIsVisible(postalCode);
        postalCode.enterPostalCode();
        postalCode.clickNextButton();
        waitSeconds(6);

        PageObjectSolarOfferInformation solarOfferInformation = new PageObjectSolarOfferInformation(driver);
        checkIfSolarInformationTextIsVisible(solarOfferInformation);

        boolean isButtonEnabled = driver.findElement(solarOfferInformation.getFreeInformationButton).isEnabled();
        Assert.assertFalse("Form is empty but getOffers button is enabled", isButtonEnabled);

        boolean isGetInfoormationButtonEnabled = driver.findElement(solarOfferInformation.getFreeInformationButton).isEnabled();
        Assert.assertFalse("getFreeInformationButton should be disabled when form is empty", isGetInfoormationButtonEnabled);

        solarOfferInformation.enterFirstAndLastName("Thomas");
        solarOfferInformation.enterStrasse("Gotlinder strasse 26");

        boolean isFirstAndLastNameErrorVisible = driver.findElement(solarOfferInformation.nameErrorText).isDisplayed();
        Assert.assertTrue("First and last name validation failed", isFirstAndLastNameErrorVisible);

        solarOfferInformation.enterEmail("thomas.tortal@gmail.abcd");

        boolean phoneNumberErrorVisible = driver.findElement(solarOfferInformation.phoneNumberErrorText).isDisplayed();
        Assert.assertTrue("Phone number validation failed", phoneNumberErrorVisible);

        boolean isEmailErrorVisible = driver.findElement(solarOfferInformation.emailErrorText).isDisplayed();
        Assert.assertTrue("Email validation failed", isEmailErrorVisible);
    }

    @Test
    public void testPultDachFlow() throws Exception {

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

        PageObjectPostalCode postalCode = new PageObjectPostalCode(driver);
        checkIfPostalCodeQuestionIsVisible(postalCode);
        postalCode.enterPostalCode();
        postalCode.clickNextButton();
        waitSeconds(6);

        PageObjectSolarOfferInformation solarOfferInformation = new PageObjectSolarOfferInformation(driver);
        checkIfSolarInformationTextIsVisible(solarOfferInformation);

        boolean isButtonEnabled = driver.findElement(solarOfferInformation.getFreeInformationButton).isEnabled();
        Assert.assertFalse("Form is empty but getOffers button is enabled", isButtonEnabled);

        solarOfferInformation.enterFirstAndLastName("Thomas tortal");
        solarOfferInformation.enterStrasse("Gotlinder strasse 26");
        solarOfferInformation.enterHandyNumber("015216778876");
        solarOfferInformation.enterEmail("thomas.tortal@gmail.com");
        solarOfferInformation.clickGetFreeInformationButton();
        waitSeconds(6);

        PageObjectAlmostDone almostDone = new PageObjectAlmostDone(driver);
        checkIfAlmostDoneTextIsVisible(almostDone);
        almostDone.clickNextButton();
        waitSeconds(2);

        PageObjectLandRegistrationDetails landRegistrationDetails = new PageObjectLandRegistrationDetails(driver);
        checkIfLandRegistrationQuestionIsVisible(landRegistrationDetails);
        landRegistrationDetails.selectUnkown();
        waitSeconds(2);

        PageObjectAgeConfirmation ageConfirmation = new PageObjectAgeConfirmation(driver);
        checkIfAgeConfirmationQuestionIsVisible(ageConfirmation);
        ageConfirmation.selectOneOrMoreAboveSeventy();
        checkIfAgeLimitAlertIsVisible(ageConfirmation);

        ageConfirmation.selectAllUnderSeventy();
        waitSeconds(2);

        PageObjectHouseFeatures houseFeatures = new PageObjectHouseFeatures(driver);
        checkIfHouseFeaturesQuestionIsVisible(houseFeatures);
        houseFeatures.enterHouseFeatures();
        houseFeatures.clickOnNextButton();
        waitSeconds(2);

        PageObjectHousePhotosUpload uploadPhotos = new PageObjectHousePhotosUpload(driver);
        checkIfUploadHousePhotosTextIsVisible(uploadPhotos);
        uploadPhotos.clickOnUploadPhotosButton();
        waitSeconds(2);

        PageObjectHouseImagesUpload imagesUpload = new PageObjectHouseImagesUpload(driver);
        checkIfRoofSurfacesTextIsVisible(imagesUpload);
        File file = new File("TestImage.jpeg");
        imagesUpload.uploadRoofImage(file.getAbsolutePath());

        boolean isCameraButtonEnabled = driver.findElement(imagesUpload.cameraIcon).isEnabled();
        Assert.assertTrue("Camera button should be Enabled", isCameraButtonEnabled);

        imagesUpload.clickNextIcon();
        waitSeconds(2);

        checkIfHouseSurroundingsTextIsVisible(imagesUpload);

        boolean isCameraButton2Enabled = driver.findElement(imagesUpload.cameraIcon).isEnabled();
        Assert.assertTrue("Camera button should be Enabled", isCameraButton2Enabled);

        File file1 = new File("TestImage.jpeg");
        imagesUpload.uploadSurroundingsHomeImage(file1.getAbsolutePath());
        waitSeconds(6);

        imagesUpload.clickCounterCaseArrow();
        waitSeconds(2);

        checkIfOpenMeterCabinetTextIsVisible(imagesUpload);

        boolean isCameraButton3Enabled = driver.findElement(imagesUpload.cameraIcon).isEnabled();
        Assert.assertTrue("Camera button should be Enabled", isCameraButton3Enabled);

        File file2 = new File("TestImage.jpeg");
        imagesUpload.meterCabinetImageUpload(file2.getAbsolutePath());
        waitSeconds(6);

        imagesUpload.clickElectricityBillArrow();
        waitSeconds(2);

        checkIfActualElectricityBillTextIsVisible(imagesUpload);

        boolean isCameraButton4Enabled = driver.findElement(imagesUpload.cameraIcon).isEnabled();
        Assert.assertTrue("Camera button should be Enabled", isCameraButton4Enabled);

        File file3 = new File("TestImage.jpeg");
        imagesUpload.actualElectricityBillUpload(file3.getAbsolutePath());
        waitSeconds(6);

        imagesUpload.clickSendPhotos();
        waitSeconds(2);


    }

    @Test
    public void testAnderesFlow() throws Exception {

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

        PageObjectPostalCode postalCode = new PageObjectPostalCode(driver);
        checkIfPostalCodeQuestionIsVisible(postalCode);
        postalCode.enterPostalCode();
        postalCode.clickNextButton();
        waitSeconds(6);

        PageObjectSolarOfferInformation solarOfferInformation = new PageObjectSolarOfferInformation(driver);
        checkIfSolarInformationTextIsVisible(solarOfferInformation);

        boolean isButtonEnabled = driver.findElement(solarOfferInformation.getFreeInformationButton).isEnabled();
        Assert.assertFalse("Form is empty but getOffers button is enabled", isButtonEnabled);

        solarOfferInformation.enterFirstAndLastName("Thomas tortal");
        solarOfferInformation.enterStrasse("Gotlinder strasse 26");
        solarOfferInformation.enterHandyNumber("015212167876");
        solarOfferInformation.enterEmail("thomas.tortal@gmail.com");
        solarOfferInformation.clickGetFreeInformationButton();
        waitSeconds(6);

        PageObjectAlmostDone almostDone = new PageObjectAlmostDone(driver);
        checkIfAlmostDoneTextIsVisible(almostDone);
        almostDone.clickNextButton();
        waitSeconds(2);

        PageObjectLandRegistrationDetails landRegistrationDetails = new PageObjectLandRegistrationDetails(driver);
        checkIfLandRegistrationQuestionIsVisible(landRegistrationDetails);
        landRegistrationDetails.selectUnkown();
        waitSeconds(2);

        PageObjectAgeConfirmation ageConfirmation = new PageObjectAgeConfirmation(driver);
        checkIfAgeConfirmationQuestionIsVisible(ageConfirmation);
        ageConfirmation.selectOneOrMoreAboveSeventy();
        checkIfAgeLimitAlertIsVisible(ageConfirmation);

        ageConfirmation.selectAllUnderSeventy();
        waitSeconds(2);

        PageObjectHouseFeatures houseFeatures = new PageObjectHouseFeatures(driver);
        checkIfHouseFeaturesQuestionIsVisible(houseFeatures);
        houseFeatures.enterHouseFeatures();
        houseFeatures.clickOnNextButton();
        waitSeconds(2);

        PageObjectHousePhotosUpload uploadPhotos = new PageObjectHousePhotosUpload(driver);
        checkIfUploadHousePhotosTextIsVisible(uploadPhotos);
        uploadPhotos.clickOnUploadPhotosButton();
        waitSeconds(2);

        PageObjectHouseImagesUpload imagesUpload = new PageObjectHouseImagesUpload(driver);
        checkIfRoofSurfacesTextIsVisible(imagesUpload);
        File file = new File("TestImage.jpeg");
        imagesUpload.uploadRoofImage(file.getAbsolutePath());

        boolean isCameraButtonEnabled = driver.findElement(imagesUpload.cameraIcon).isEnabled();
        Assert.assertTrue("Camera button should be Enabled", isCameraButtonEnabled);

        imagesUpload.clickNextIcon();
        waitSeconds(2);

        checkIfHouseSurroundingsTextIsVisible(imagesUpload);

        boolean isCameraButton2Enabled = driver.findElement(imagesUpload.cameraIcon).isEnabled();
        Assert.assertTrue("Camera button should be Enabled", isCameraButton2Enabled);

        File file1 = new File("TestImage.jpeg");
        imagesUpload.uploadSurroundingsHomeImage(file1.getAbsolutePath());
        waitSeconds(6);

        imagesUpload.clickCounterCaseArrow();
        waitSeconds(2);

        checkIfOpenMeterCabinetTextIsVisible(imagesUpload);

        boolean isCameraButton3Enabled = driver.findElement(imagesUpload.cameraIcon).isEnabled();
        Assert.assertTrue("Camera button should be Enabled", isCameraButton3Enabled);

        File file2 = new File("TestImage.jpeg");
        imagesUpload.meterCabinetImageUpload(file2.getAbsolutePath());
        waitSeconds(6);

        imagesUpload.clickElectricityBillArrow();
        waitSeconds(2);

        checkIfActualElectricityBillTextIsVisible(imagesUpload);

        boolean isCameraButton4Enabled = driver.findElement(imagesUpload.cameraIcon).isEnabled();
        Assert.assertTrue("Camera button should be Enabled", isCameraButton4Enabled);

        File file3 = new File("TestImage.jpeg");
        imagesUpload.actualElectricityBillUpload(file3.getAbsolutePath());
        waitSeconds(6);

        imagesUpload.clickSendPhotos();
        waitSeconds(2);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
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

    private void checkIfPostalCodeQuestionIsVisible(PageObjectPostalCode obj) {
        boolean isDisplayed = driver.findElement(obj.questionTitle).isDisplayed();
        Assert.assertTrue("Question not visible: Wie lautet Ihre Postleitzahl?", isDisplayed);
    }

    private void checkIfSolarInformationTextIsVisible(PageObjectSolarOfferInformation obj) {
        boolean isDisplayed = driver.findElement(obj.offerInformationText).isDisplayed();
        Assert.assertTrue("Text not visible: Gratulation, das Angebot ist in Ihrer Region noch verfügbar! Wir senden Ihnen gerne kostenlose Informationen zu.", isDisplayed);
    }

    private void checkIfAlmostDoneTextIsVisible(PageObjectAlmostDone obj) {
        boolean isDisplayed = driver.findElement(obj.almostDoneText).isDisplayed();
        Assert.assertTrue("Text not visible: Fast geschafft", isDisplayed);
    }

    private void checkIfLandRegistrationQuestionIsVisible(PageObjectLandRegistrationDetails obj) {
        boolean isDisplayed = driver.findElement(obj.questionTitle).isDisplayed();
        Assert.assertTrue("Question not visible: Wie viele Personen stehen bei Ihrem Haus im Grundbuch?", isDisplayed);
    }

    private void checkIfAgeConfirmationQuestionIsVisible(PageObjectAgeConfirmation obj) {
        boolean isDisplayed = driver.findElement(obj.questionTitle).isDisplayed();
        Assert.assertTrue("Question not visible: Sind alle Personen im Grundbuch unter 70 Jahre alt?", isDisplayed);
    }

    private void checkIfAgeLimitAlertIsVisible(PageObjectAgeConfirmation obj) {
        boolean isDisplayed = driver.findElement(obj.ageAlertInfo).isDisplayed();
        Assert.assertTrue("Question not visible: Sind Sie sich sicher?", isDisplayed);
    }

    private void checkIfHouseFeaturesQuestionIsVisible(PageObjectHouseFeatures obj) {
        boolean isDisplayed = driver.findElement(obj.questionTitle).isDisplayed();
        Assert.assertTrue("Question not visible: Gibt es Besonderheiten bei Ihrem Dach oder Haus, die für eine Planung relevant sein könnten?", isDisplayed);
    }

    private void checkIfUploadHousePhotosTextIsVisible(PageObjectHousePhotosUpload obj) {
        boolean isDisplayed = driver.findElement(obj.housePhotosUploadText).isDisplayed();
        Assert.assertTrue("Question not visible: Jetzt  Fotos Ihres Daches hochladen und direkt Angebot erhalten", isDisplayed);
    }

    private void checkIfRoofSurfacesTextIsVisible(PageObjectHouseImagesUpload obj) {
        boolean isDisplayed = driver.findElement(obj.allRoofSurfacesImageText).isDisplayed();
        Assert.assertTrue("Question not visible: Alle Dachflächen", isDisplayed);
    }

    private void checkIfHouseSurroundingsTextIsVisible(PageObjectHouseImagesUpload obj) {
        boolean isDisplayed = driver.findElement(obj.houseWithSurroundingsText).isDisplayed();
        Assert.assertTrue("Question not visible: Haus mit Umgebung", isDisplayed);
    }

    private void checkIfOpenMeterCabinetTextIsVisible(PageObjectHouseImagesUpload obj) {
        boolean isDisplayed = driver.findElement(obj.openMeterCabinetText).isDisplayed();
        Assert.assertTrue("Question not visible: Offener Zählerschrank", isDisplayed);
    }


    private void checkIfActualElectricityBillTextIsVisible(PageObjectHouseImagesUpload obj) {
        boolean isDisplayed = driver.findElement(obj.currentElectricityBillText).isDisplayed();
        Assert.assertTrue("Question not visible: Aktuelle Stromrechnung", isDisplayed);
    }

    private void checkIfAllImagesUploadedQuestionIsVisible(PageObjectHouseImagesUpload obj) {
        boolean isDisplayed = driver.findElement(obj.allImagesUploadedText).isDisplayed();
        Assert.assertTrue("Question not visible: Alles hochgeladen?", isDisplayed);
    }
}
