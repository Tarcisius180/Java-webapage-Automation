package test_classes;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;
import pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;

public class NavigateToRedWineTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(NavigateToRedWineTest.class);
    private HomePage homePage;

    @Test(groups = {"no_login_required", "regression"}, priority = 1)
    public void testNavigateToRedWine() {
        logger.info("Starting testNavigateToRedWine");
        test.log(Status.INFO, "Starting testNavigateToRedWine");

        // Initialize HomePage
        homePage = new HomePage(driver);

        // Hover over Liquor option
        homePage.hoverOnLiquor();
        logger.info("Hovered over Liquor option");
        test.log(Status.INFO, "Hovered over Liquor option");

        // Click on Wine option
        homePage.clickWineOption();
        logger.info("Clicked on Wine option");
        test.log(Status.INFO, "Clicked on Wine option");

        // Click on Red Wine option
        homePage.clickRedWineOption();
        logger.info("Clicked on Red Wine option");
        test.log(Status.INFO, "Clicked on Red Wine option");

        // Scroll to the top of the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
        logger.info("Scrolled to the top of the page");
        test.log(Status.INFO, "Scrolled to the top of the page");

        // Verify that we are on the Red Wine page
        boolean isOnRedWinePage = homePage.isOnRedWinePage();
        Assert.assertTrue(isOnRedWinePage, "Not on Red Wine page");
        logger.info("On Red Wine page: " + isOnRedWinePage);
        test.log(Status.PASS, "Successfully navigated to Red Wine page");
    }
}