package test_classes;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;
import pages.*;
import utilities.CartUtils;

public class EmptyCartTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(EmptyCartTest.class);
    private HomePage homePage;
    private CartPage cartPage;
    private CartUtils cartUtils;

    @Test(groups = {"no_login_required", "regression"}, priority = 1)
    public void testEmptyCart() {
        logger.info("Starting testEmptyCart");
        test.log(Status.INFO, "Starting testEmptyCart");

        // Initialize pages and utilities
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        cartUtils = new CartUtils(driver, test);

        // Step 1: Add iPhone 15 to cart
        cartUtils.addIPhoneToCart();

        // Step 2: Navigate back to homepage
        homePage.clickHomepageButton();
        logger.info("Navigated back to homepage");
        test.log(Status.INFO, "Navigated back to homepage");

        // Step 3: Empty the cart
        cartUtils.emptyCart();

        // Verify that the cart is empty
        boolean isCartEmpty = cartPage.isCartEmpty();
        Assert.assertTrue(isCartEmpty, "Your cart is empty");
        logger.info("Cart is empty: " + isCartEmpty);
        test.log(Status.PASS, "Successfully emptied the cart");
    }
}