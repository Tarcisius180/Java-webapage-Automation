package test_classes;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;
import utilities.ExcelDataReader;
import java.util.Map;

public class PromoCodeTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(PromoCodeTest.class);

    @Test(groups = {"login_required", "regression"}, priority = 1)
    public void testApplyPromoCode() {
        logger.info("Starting testApplyPromoCode");
        test.log(Status.INFO, "Starting testApplyPromoCode");

        // Perform login
        loginUser();
        logger.info("Login successful");
        test.log(Status.PASS, "Login successful");


        // Get promo code from Excel
        Map<String, String> testData = ExcelDataReader.getTestData("PromoCodeTest", "ApplyPromo");
        String promoCode = testData.get("PromoCode");

        // Navigate to promo code page and apply code
        myAccountPage.clickAccountButton();
        myAccountPage.clickRedeemPromo_DiscountButton();
        myAccountPage.enterPromoCode(promoCode);
        myAccountPage.clickApplyButton();

        // Verify that the promo code was applied successfully
        boolean isApplied = myAccountPage.isPromoCodeApplied();
        logger.info("Promo code applied status: " + isApplied);
        test.log(Status.INFO, "Promo code applied status: " + isApplied);

        Assert.assertTrue(isApplied, "Promo code was not applied successfully");
        if (isApplied) {
            test.log(Status.PASS, "Promo code was applied successfully");
        } else {
            test.log(Status.FAIL, "Promo code was not applied successfully");
        }
    }
}