package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import pages.*;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class CartUtils {
    private static final Logger logger = LogManager.getLogger(CartUtils.class);
    private WebDriver driver;
    private ExtentTest test;
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private ProductPage productPage;

    public CartUtils(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.homePage = new HomePage(driver);
        this.searchResultPage = new SearchResultPage(driver);
        this.productPage = new ProductPage(driver);
    }

    public void addIPhoneToCart() {
        Map<String, String> testData = ExcelDataReader.getTestData("SearchAProductTest", "SearchiPhone");
        String searchTerm = testData.get("SearchTerm");

        homePage.enterSearchTerm(searchTerm);
        logger.info("Entered search term: " + searchTerm);
        test.log(Status.INFO, "Entered search term: " + searchTerm);

        homePage.submitSearch();
        logger.info("Submitted search");
        test.log(Status.INFO, "Submitted search");

        searchResultPage.clickKeepResultOnPageButton();
        logger.info("Clicked keep result on page button");
        test.log(Status.INFO, "Clicked keep result on page button");

        searchResultPage.clickIphone15Link();
        logger.info("Clicked on iPhone 15 product");
        test.log(Status.INFO, "Clicked on iPhone 15 product");

        productPage.clickColorDropdown();
        logger.info("Clicked color dropdown");
        test.log(Status.INFO, "Clicked color dropdown");

        productPage.selectColor("Blue");
        logger.info("Selected Blue color");
        test.log(Status.INFO, "Selected Blue color");

        productPage.clickAddToCart();
        logger.info("Clicked Add to Cart button");
        test.log(Status.INFO, "Clicked Add to Cart button");

        logger.info("Successfully added iPhone 15 to cart");
        test.log(Status.INFO, "Successfully added iPhone 15 to cart");
    }

    public void emptyCart() {
        homePage.hoverOnCart();
        logger.info("Hovered over cart icon");
        test.log(Status.INFO, "Hovered over cart icon");

        homePage.clickCartPay();
        logger.info("Clicked on cart pay button");
        test.log(Status.INFO, "Clicked on cart pay button");

        homePage.removeItemFromCart();
        logger.info("Removed item from cart");
        test.log(Status.INFO, "Removed item from cart");
    }
}