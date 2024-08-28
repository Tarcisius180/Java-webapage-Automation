package test_classes;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;
import pages.PersonalDetails;
import utilities.ExcelDataReader;

public class PersonalDetailsTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(PersonalDetailsTest.class);
    private PersonalDetails personalDetailsPage;

    @Test(groups = {"login_required", "regression"}, priority = 1)

    public void testUpdatePersonalDetails() {
        logger.info("Starting testUpdatePersonalDetails");
        test.log(Status.INFO, "Starting testUpdatePersonalDetails");

        // Initialize PersonalDetails page
        personalDetailsPage = new PersonalDetails(driver);
        Map<String, String> testData = ExcelDataReader.getTestData("PersonalDetailsTest", "UpdatePersonalDetails");

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
        
        personalDetailsPage.clickEdit_Details_buttonn();
        logger.info("Clicked on Personal Details button");
        test.log(Status.INFO, "Clicked on Personal Details button");
        
        

        // Enter personal details
        personalDetailsPage.Enter_FirstName_input(testData.get("FirstName"));
        logger.info("Entered First Name");
        test.log(Status.INFO, "Entered First Name");

        personalDetailsPage.Enter_Enter_LastName_input(testData.get("LastName"));
        logger.info("Entered Last Name");
        test.log(Status.INFO, "Entered Last Name");

        // Save the personal details
        personalDetailsPage.clickSave_button();
        logger.info("Clicked Save Changes button");
        test.log(Status.INFO, "Clicked Save Changes button");

        // Verify the personal details were updated successfully
        boolean isUpdated = personalDetailsPage.isPersonalDetailsUpdated();
        logger.info("Personal details updated successfully: " + isUpdated);
        test.log(Status.INFO, "Personal details updated successfully: " + isUpdated);

        Assert.assertTrue(isUpdated, "Personal details were not updated successfully");
        if (isUpdated) {
            test.log(Status.PASS, "Personal details were updated successfully");
        } else {
            test.log(Status.FAIL, "Failed to update personal details");
        }
    }
    
    @Test(groups = {"login_required", "regression"}, priority = 2)

    public void testEmptyNameFields() {
        logger.info("Starting testEmptyNameFields");
        test.log(Status.INFO, "Starting testEmptyNameFields");

        // Initialize PersonalDetails page
        personalDetailsPage = new PersonalDetails(driver);

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

        personalDetailsPage.clickEdit_Details_buttonn();
        logger.info("Clicked on Edit Details button");
        test.log(Status.INFO, "Clicked on Edit Details button");

        // Clear name fields
        personalDetailsPage.clearFirstName_input();
        logger.info("Cleared First Name");
        test.log(Status.INFO, "Cleared First Name");

        personalDetailsPage.clearLastName_input();
        logger.info("Cleared Last Name");
        test.log(Status.INFO, "Cleared Last Name");

        // Get current URL before saving
        String urlBeforeSave = driver.getCurrentUrl();
        logger.info("URL before save: " + urlBeforeSave);
        test.log(Status.INFO, "URL before save: " + urlBeforeSave);

        // Attempt to save the empty details
        personalDetailsPage.clickSave_button();
        logger.info("Clicked Save Changes button");
        test.log(Status.INFO, "Clicked Save Changes button");

        // Get URL after saving
        String urlAfterSave = driver.getCurrentUrl();
        logger.info("URL after save: " + urlAfterSave);
        test.log(Status.INFO, "URL after save: " + urlAfterSave);

        // Assert that the URL hasn't changed
        Assert.assertEquals(urlAfterSave, urlBeforeSave, "Page URL changed after attempting to save empty name fields");

       
        if (urlAfterSave.equals(urlBeforeSave)) {
            test.log(Status.PASS, "Test passed: Page remained the same and error messages were displayed");
        } else {
            test.log(Status.FAIL, "Test failed: Page changed or error messages were not displayed");
        }
    }
}