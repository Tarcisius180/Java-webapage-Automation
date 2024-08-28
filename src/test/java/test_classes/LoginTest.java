package test_classes;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;
import utilities.ExcelDataReader;


import java.util.Map;

public class LoginTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test(groups = {"no_login_required", "regression"}, priority = 1)
    public void testUserLogin() {
        logger.info("Starting testUserLogin");
        test.log(Status.INFO, "Starting testUserLogin");

        // Perform login using Excel data
        loginUser();
        logger.info("Login attempt completed");
        test.log(Status.INFO, "Login attempt completed");

        // Verify that the user is logged in
        boolean isLoggedIn = loginPage.isUserLoggedIn();
        logger.info("User logged in status: " + isLoggedIn);
        test.log(Status.INFO, "User logged in status: " + isLoggedIn);

        Assert.assertTrue(isLoggedIn, "User should be logged in");
        if (isLoggedIn) {
            test.log(Status.PASS, "User successfully logged in");
        } else {
            test.log(Status.FAIL, "User failed to log in");
        }
    }

    @Test(groups = {"no_login_required", "regression"}, priority = 2)
    public void testInvalidLogin() {
        logger.info("Starting testInvalidLogin");
        test.log(Status.INFO, "Starting testInvalidLogin");

        Map<String, String> testData = ExcelDataReader.getTestData("LoginTest", "InvalidLogin");
        String invalidUsername = testData.get("InvalidUsername");
        String invalidPassword = testData.get("InvalidPassword");

        // Attempt login with invalid credentials
        loginPage.login(invalidUsername, invalidPassword);
        logger.info("Invalid login attempt completed");
        test.log(Status.INFO, "Invalid login attempt completed");

        // Verify that the error message is present
        boolean isErrorPresent = loginPage.isErrorMessagePresent();
        logger.info("Error message present: " + isErrorPresent);
        test.log(Status.INFO, "Error message present: " + isErrorPresent);

        Assert.assertTrue(isErrorPresent, "Error message should be displayed for invalid login");
        if (isErrorPresent) {
            test.log(Status.PASS, "Error message displayed for invalid login");
        } else {
            test.log(Status.FAIL, "Error message not displayed for invalid login");
        }
    }}