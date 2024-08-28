package test_classes;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;

public class LogoutTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LogoutTest.class);

    @Test(groups = {"login_required", "regression"}, priority = 1)
    public void testUserLoggedOut() {
        logger.info("Starting testUserLoggedOut");
        test.log(Status.INFO, "Starting testUserLoggedOut");

        // Perform login
        loginUser();
        logger.info("Login completed");
        test.log(Status.INFO, "Login completed");

        // Verify that the user is logged in
        boolean isLoggedIn = loginPage.isUserLoggedIn();
        logger.info("User logged in status before logout: " + isLoggedIn);
        test.log(Status.INFO, "User logged in status before logout: " + isLoggedIn);

        Assert.assertTrue(isLoggedIn, "User should be logged in before attempting to log out");
        if (isLoggedIn) {
            test.log(Status.PASS, "User successfully logged in before logout attempt");
        } else {
            test.log(Status.FAIL, "User not logged in before logout attempt");
            return;  // Skip the rest of the test if login failed
        }

        // Perform logout
        loginPage.clickLogoutButton();
        logger.info("Logout button clicked");
        test.log(Status.INFO, "Logout button clicked");

        // Verify that the user is logged out
        boolean isLoggedOut = loginPage.isUserLoggedOut();
        logger.info("User logged out status: " + isLoggedOut);
        test.log(Status.INFO, "User logged out status: " + isLoggedOut);

        Assert.assertTrue(isLoggedOut, "User is not logged out");
        if (isLoggedOut) {
            test.log(Status.PASS, "User successfully logged out");
        } else {
            test.log(Status.FAIL, "User failed to log out");
        }
    }
}