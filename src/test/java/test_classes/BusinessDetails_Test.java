package test_classes;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;

import utilities.ExcelDataReader;
import java.util.Map;
import pages.BusinessNamePage;

public class BusinessDetails_Test extends BaseTest{
	
	private static final Logger logger = LogManager.getLogger(BusinessDetails_Test.class);
    private BusinessNamePage businessNamePage;

    @Test(groups = {"login_required", "regression"}, priority = 3)

    public void testBusinessDetails() {
        logger.info("Starting testBusinessDetails");
        test.log(Status.INFO, "Starting testBusinessDetails");

        // Initialize PersonalDetails page
        businessNamePage = new BusinessNamePage(driver);

        // Perform login

        loginUser();
        Map<String, String> testData = ExcelDataReader.getTestData("BusinessDetails_Test", "UpdateBusinessDetails");
        logger.info("Login completed");
        test.log(Status.INFO, "Login completed");
        
        try {
            Thread.sleep(3000);
            logger.info("Waited for 3 seconds after login");
            test.log(Status.INFO, "Waited for 3 seconds after login");
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
            test.log(Status.WARNING, "Thread sleep interrupted: " + e.getMessage());
        }

        // Navigate to My Account
        myAccountPage.clickAccountButton();
        logger.info("Clicked on My Account button");
        test.log(Status.INFO, "Clicked on My Account button");

        // Click on Personal Details
        myAccountPage.clickPersonalDetails_button();
        logger.info("Clicked on Personal Details button");
        test.log(Status.INFO, "Clicked on Personal Details button");
        
        businessNamePage.clickAdd_Details_buttonn();
        logger.info("Clicked on add button");
        test.log(Status.INFO, "Clicked on Personal Details button");
        
        // Enter Business details
        businessNamePage.enter_businessName(testData.get("BusinessName"));
        logger.info("Entered Business name");
        test.log(Status.INFO, "Entered Business name");

        businessNamePage.enter_vatNumber(testData.get("VATNumber"));
        logger.info("Entered VAT number");
        test.log(Status.INFO, "Entered VAT number");
        
        
        try {
            Thread.sleep(3000);
            logger.info("Waited for 3 seconds after login");
            test.log(Status.INFO, "Waited for 3 seconds after login");
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
            test.log(Status.WARNING, "Thread sleep interrupted: " + e.getMessage());
        }

        // Verify the personal details were updated successfully
        boolean isUpdated = businessNamePage.isBusinessDetailsUpdated();
        logger.info("Business Details Updated successfully: " + isUpdated);
        test.log(Status.INFO, "Business Details Updated successfully: " + isUpdated);

        Assert.assertTrue(isUpdated, "Business Details were not updated successfully");
        if (isUpdated) {
            test.log(Status.PASS, "Business Details were updated successfully");
        } else {
            test.log(Status.FAIL, "Failed to update Business Details");
        }
        

}
    @Test(groups = {"login_required", "regression"}, priority = 4)

    public void testRemoveBusinessDetails() {
        logger.info("Starting testRemoveBusinessDetails");
        test.log(Status.INFO, "Starting testRemoveBusinessDetails");

        // Initialize BusinessNamePage
        businessNamePage = new BusinessNamePage(driver);

        // Perform login
        loginUser();
        logger.info("Login completed");
        test.log(Status.INFO, "Login completed");
        

        // Navigate to My Account
        myAccountPage.clickAccountButton();
        logger.info("Clicked on My Account button");
        test.log(Status.INFO, "Clicked on My Account button");

        // Click on Personal Details
        myAccountPage.clickPersonalDetails_button();
        logger.info("Clicked on Personal Details button");
        test.log(Status.INFO, "Clicked on Personal Details button");
        
        businessNamePage.clickEdit_Details_button();
        logger.info("Clicked on edit button");
        test.log(Status.INFO, "Clicked on edit button");

        // Clear business details
        businessNamePage.clearbusinessName_input();
        logger.info("Cleared Business name");
        test.log(Status.INFO, "Cleared Business name");

        businessNamePage.clearvatNumber__input();
        logger.info("Cleared VAT number");
        test.log(Status.INFO, "Cleared VAT number");

        // Save the empty details
        businessNamePage.clickSave_button();
        logger.info("Clicked Save Changes button");
        test.log(Status.INFO, "Clicked Save Changes button");

        // Verify the alert appears after saving
        boolean isAlertPresent = businessNamePage.isBusinessDetailsUpdated();
        logger.info("Alert appeared after saving: " + isAlertPresent);
        test.log(Status.INFO, "Alert appeared after saving: " + isAlertPresent);

        Assert.assertTrue(isAlertPresent, "Alert did not appear after removing Business Details");
        if (isAlertPresent) {
            test.log(Status.PASS, "Alert appeared after removing Business Details");
        } else {
            test.log(Status.FAIL, "Alert did not appear after removing Business Details");
        }
    }

    @Test(groups = {"login_required", "regression"}, priority = 5)

    public void testSaveEmptyBusinessDetails() {
        logger.info("Starting testSaveEmptyBusinessDetails");
        test.log(Status.INFO, "Starting testSaveEmptyBusinessDetails");

        // Initialize BusinessNamePage
        businessNamePage = new BusinessNamePage(driver);

        // Perform login
        loginUser();
        logger.info("Login completed");
        test.log(Status.INFO, "Login completed");


        // Navigate to My Account
        myAccountPage.clickAccountButton();
        logger.info("Clicked on My Account button");
        test.log(Status.INFO, "Clicked on My Account button");

        // Click on Personal Details
        myAccountPage.clickPersonalDetails_button();
        logger.info("Clicked on Personal Details button");
        test.log(Status.INFO, "Clicked on Personal Details button");
        
        businessNamePage.clickAdd_Details_buttonn();
        logger.info("Clicked on edit button");
        test.log(Status.INFO, "Clicked on edit button");

        // Attempt to save empty details
        businessNamePage.clickSave_button();
        logger.info("Clicked Save Changes button");
        test.log(Status.INFO, "Clicked Save Changes button");

        // Verify the alert appears after saving
        boolean isAlertPresent = businessNamePage.isBusinessDetailsUpdated();
        logger.info("Alert appeared after saving empty details: " + isAlertPresent);
        test.log(Status.INFO, "Alert appeared after saving empty details: " + isAlertPresent);

        Assert.assertTrue(isAlertPresent, "Alert did not appear after saving empty Business Details");
        if (isAlertPresent) {
            test.log(Status.PASS, "Alert appeared after saving empty Business Details");
        } else {
            test.log(Status.FAIL, "Alert did not appear after saving empty Business Details");
        }
    }
    }

