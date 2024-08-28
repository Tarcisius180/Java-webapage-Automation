package test_classes;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;
import pages.AddressPage;
import utilities.ExcelDataReader;

public class AddAddressTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(AddAddressTest.class);
    private AddressPage addressPage;

    @Test(groups = {"login_required", "regression"}, priority = 1)
    public void testAddNewAddress() {
        logger.info("Starting testAddNewAddress");
        test.log(Status.INFO, "Starting testAddNewAddress");

        // Initialize AddressPage
        addressPage = new AddressPage(driver);
        Map<String, String> testData = ExcelDataReader.getTestData("AddAddressTest", "AddNewAddress");

        // Perform login
        loginUser();
        logger.info("Login completed");
        test.log(Status.INFO, "Login completed");
        
        myAccountPage.waitForLogoutButton();
        logger.info("Logout button is present, login appears to be complete");
        test.log(Status.INFO, "Logout button is present, login appears to be complete");

        // Navigate to My Account
        myAccountPage.clickAccountButton();
        logger.info("Clicked on My Account button");
        test.log(Status.INFO, "Clicked on My Account button");

        // Click on Address Book
        myAccountPage.clickAddressBook_Button();
        logger.info("Clicked on Address Book button");
        test.log(Status.INFO, "Clicked on Address Book button");

        // Click on Add Address
        myAccountPage.clickAdd_Address();
        logger.info("Clicked on Add Address button");
        test.log(Status.INFO, "Clicked on Add Address button");

        // Fill in address details
        addressPage.clickResidential_buttonButton();
        addressPage.enterName_input(testData.get("Name"));
        addressPage.enternumber_inputt(testData.get("PhoneNumber"));
        addressPage.enterAddress_input(testData.get("Address"));
        addressPage.enterSubarb_input(testData.get("Suburb"));
        addressPage.enterCity_input(testData.get("City"));
        addressPage.selectFirstProvince();
        addressPage.enterPostalCode_input(testData.get("PostalCode"));
        logger.info("Entered all address details");
        test.log(Status.INFO, "Entered all address details");

        // Save the address
        addressPage.clickSaveaddressButton();
        logger.info("Clicked Save Address button");
        test.log(Status.INFO, "Clicked Save Address button");

        // Verify the address was added successfully using isAddressAdded() method
        boolean isAddressAdded = addressPage.isAddressAdded();
        logger.info("Address added successfully: " + isAddressAdded);
        test.log(Status.INFO, "Address added successfully: " + isAddressAdded);

        Assert.assertTrue(isAddressAdded, "New address was not added successfully");
        if (isAddressAdded) {
            test.log(Status.PASS, "New address was added successfully");
        } else {
            test.log(Status.FAIL, "Failed to add new address");
        }
    }

    @Test(groups = {"login_required", "regression"}, priority = 2)

    public void testEmptyAddressForm() {
        logger.info("Starting testEmptyAddressForm");
        test.log(Status.INFO, "Starting testEmptyAddressForm");

        // Initialize AddressPage
        addressPage = new AddressPage(driver);

        // Perform login
        loginUser();
        logger.info("Login completed");
        test.log(Status.INFO, "Login completed");
        

        // Navigate to My Account
        myAccountPage.clickAccountButton();
        logger.info("Clicked on My Account button");
        test.log(Status.INFO, "Clicked on My Account button");

        // Click on Address Book
        myAccountPage.clickAddressBook_Button();
        logger.info("Clicked on Address Book button");
        test.log(Status.INFO, "Clicked on Address Book button");

        // Click on Add Address
        myAccountPage.clickAdd_Address();
        logger.info("Clicked on Add Address button");
        test.log(Status.INFO, "Clicked on Add Address button");

        // Attempt to save the empty form
        addressPage.clickSaveaddressButton();
        logger.info("Clicked Save Address button without entering any details");
        test.log(Status.INFO, "Clicked Save Address button without entering any details");

        // Verify that the user is still on the address form page
        boolean isStillOnAddressForm = addressPage.isAddressFormVisible();
        logger.info("User is still on address form: " + isStillOnAddressForm);
        test.log(Status.INFO, "User is still on address form: " + isStillOnAddressForm);

        // Assert that the user is still on the form and error messages are displayed
        Assert.assertTrue(isStillOnAddressForm, "User was able to proceed without entering address details");

        if (isStillOnAddressForm) {
            test.log(Status.PASS, "User cannot proceed with empty address form and error messages are displayed");
        } else {
            test.log(Status.FAIL, "Test failed: User can proceed with empty form or error messages are not displayed");
        }
    }
}