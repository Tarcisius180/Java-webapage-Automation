package test_classes;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;

import pages.NewsLetterPage;


public class NewsLetterSubscriptionTest extends BaseTest{
	
	private static final Logger logger = LogManager.getLogger(NewsLetterSubscriptionTest.class);
    private NewsLetterPage newsLetterPage;

    @Test(groups = {"regression", "newsletter"}, priority = 1)
    public void testLetterSubscription() {
        logger.info("Starting testLetterSubscription");
        test.log(Status.INFO, "testLetterSubscription");

        // Initialize PersonalDetails page
        newsLetterPage = new NewsLetterPage(driver);

        // Perform login
        loginUser();
        logger.info("Login completed");
        test.log(Status.INFO, "Login completed");
        
        // Navigate to My Account
        myAccountPage.clickAccountButton();
        logger.info("Clicked on My Account button");
        test.log(Status.INFO, "Clicked on My Account button");

        // Click on News Letter 
        myAccountPage.clickNewsLetter_button();
        logger.info("Clicked on News Letter button");
        test.log(Status.INFO, "Clicked on News Letter button");
        
        // Click on News Letter Option
        newsLetterPage.clickNewsLetterOption_button();
        logger.info("Clicked on news letter preference button");
        test.log(Status.INFO, "Clicked on news letter preference button");
        
        
        // Saved preferences details
        newsLetterPage.clickSave_preferences_button();
        logger.info("Saved prefrence");
        test.log(Status.INFO, "Saved prefrence");


        // Verify the preferences were updated successfully
        boolean isUpdated = newsLetterPage.isPreferencesUpdated();
        logger.info("Preferences were updated successfully: " + isUpdated);
        test.log(Status.INFO, "Preferences were updated successfully: " + isUpdated);

        Assert.assertTrue(isUpdated, "Preferences were not updated successfully");
        if (isUpdated) {
            test.log(Status.PASS, "Preferences were updated successfully");
        } else {
            test.log(Status.FAIL, "Failed to update Preferences");
        }
        

}
    @Test(groups = {"regression", "newsletter"}, priority = 2)
    public void testremoveLetterSubscription() {
        logger.info("Starting testremoveLetterSubscription");
        test.log(Status.INFO, "testremoveLetterSubscriptionn");

        // Initialize PersonalDetails page
        newsLetterPage = new NewsLetterPage(driver);

        // Perform login
        loginUser();
        logger.info("Login completed");
        test.log(Status.INFO, "Login completed");
        

        // Navigate to My Account
        myAccountPage.clickAccountButton();
        logger.info("Clicked on My Account button");
        test.log(Status.INFO, "Clicked on My Account button");

        // Click on News Letter 
        myAccountPage.clickNewsLetter_button();
        logger.info("Clicked on News Letter button");
        test.log(Status.INFO, "Clicked on News Letter button");
        
        // Click on remove prefrence
        newsLetterPage.clickremove_preferences_buttonn();
        logger.info("Clicked on  remove news letter preference button");
        test.log(Status.INFO, "Clicked on  remove news letter preference button");
        
        
        // Saved preferences details
        newsLetterPage.clickSave_preferences_button();
        logger.info("Saved prefrence");
        test.log(Status.INFO, "Saved prefrence");


        // Verify the preferences were updated successfully
        boolean isUpdated = newsLetterPage.isPreferencesUpdated();
        logger.info("Preferences were updated successfully: " + isUpdated);
        test.log(Status.INFO, "Preferences were updated successfully: " + isUpdated);

        Assert.assertTrue(isUpdated, "Preferences were not updated successfully");
        if (isUpdated) {
            test.log(Status.PASS, "Preferences were updated successfully");
        } else {
            test.log(Status.FAIL, "Failed to update Preferences");
        }
        

}
	
	

}
