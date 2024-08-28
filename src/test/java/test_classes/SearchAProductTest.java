package test_classes;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;
import pages.*;
import utilities.ExcelDataReader;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Map;

public class SearchAProductTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(SearchAProductTest.class);
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @Test(groups = {"no_login_required", "regression"}, priority = 1)
    public void testSearchAndKeepResults() {
        logger.info("Starting testSearchAndKeepResults");
        test.log(Status.INFO, "Starting testSearchAndKeepResults");

        // Initialize pages
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);

        // Get search term from Excel data
        Map<String, String> testData = ExcelDataReader.getTestData("SearchAProductTest", "SearchApple");
        String searchTerm = testData.get("SearchTerm");

        // Perform search
        homePage.enterSearchTerm(searchTerm);
        logger.info("Entered search term: " + searchTerm);
        test.log(Status.INFO, "Entered search term: " + searchTerm);

        homePage.submitSearch();
        logger.info("Submitted search");
        test.log(Status.INFO, "Submitted search");

        // Keep results on page
        searchResultPage.clickKeepResultOnPageButton();
        logger.info("Clicked keep result on page button");
        test.log(Status.INFO, "Clicked keep result on page button");

        // Verify search results
        boolean isAppleInResults = searchResultPage.isAppleInResults();
        Assert.assertTrue(isAppleInResults, "Apple not found in search results");
        logger.info("Apple found in search results: " + isAppleInResults);
        test.log(Status.PASS, "Apple found in search results");
    }

    @Test(groups = {"no_login_required", "regression"}, priority = 2)
    public void testSearchAndAddToCart() {
        logger.info("Starting testSearchAndAddToCart");
        test.log(Status.INFO, "Starting testSearchAndAddToCart");

        // Initialize pages
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        // Get search term from Excel data
        Map<String, String> testData = ExcelDataReader.getTestData("SearchAProductTest", "SearchiPhone");
        String searchTerm = testData.get("SearchTerm");

        // Perform search
        homePage.enterSearchTerm(searchTerm);
        logger.info("Entered search term: " + searchTerm);
        test.log(Status.INFO, "Entered search term: " + searchTerm);

        homePage.submitSearch();
        logger.info("Submitted search");
        test.log(Status.INFO, "Submitted search");

        // Keep results on page
        searchResultPage.clickKeepResultOnPageButton();
        logger.info("Clicked keep result on page button");
        test.log(Status.INFO, "Clicked keep result on page button");

        // Click on iPhone 15 product
        searchResultPage.clickIphone15Link();
        logger.info("Clicked on iPhone 15 product");
        test.log(Status.INFO, "Clicked on iPhone 15 product");

        // Select color
        productPage.clickColorDropdown();
        logger.info("Clicked color dropdown");
        test.log(Status.INFO, "Clicked color dropdown");

        productPage.selectColor("Blue");
        logger.info("Selected Blue color");
        test.log(Status.INFO, "Selected Blue color");

        // Click Show More button
        productPage.clickShowMore();
        logger.info("Clicked Show More button");
        test.log(Status.INFO, "Clicked Show More button");

        // Scroll to top
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
        logger.info("Scrolled to top of page");
        test.log(Status.INFO, "Scrolled to top of page");

        // Add to cart
        productPage.clickAddToCart();
        logger.info("Clicked Add to Cart button");
        test.log(Status.INFO, "Clicked Add to Cart button");

        productPage.clickCheckoutNow();
        logger.info("Clicked Checkout Now button");
        test.log(Status.INFO, "Clicked Checkout Now button");

        // Verify on Shopping Cart page
        boolean isOnShoppingCart = cartPage.isOnShoppingCartPage();
        Assert.assertTrue(isOnShoppingCart, "Not on Shopping Cart page");
        logger.info("On Shopping Cart page: " + isOnShoppingCart);
        test.log(Status.PASS, "Successfully added product to cart and navigated to Shopping Cart");
    }
}

    




// i want to enter in the 	Search_Bar found in my HomePage "apple"
// then click keep_result_onpage_button found in my searchresultspage and then use Apple_In_Results as an assert for it being present on page 


// then in a new test case i want to repeat the above thest but not assert the Apple_In_Results and then click on the following (//body/div[@id='shopfront-app']/div[contains(@class,'grid-container search-listings-module_search-listings_2Lw_d')]/div[@class='grid-x grid-margin-x']/div[@class='cell auto']/div[@class='listings-container-module_listings-container_AC4LI']/div[@class='grid-x grid-margin-x']/div[@class='cell small-3']/div[@id='93936606']/div[@class='product-card product-card-module_product-card_fdqa8']/a[1]) and call it iphone_15
// then click on this //div[@role='listbox'] then a drop down list will appear and i want you to select this once you click the dropdown menu and select this //a[normalize-space()='Blue']
// then scroll down and click on this //div[contains(@class,'description-card-module_description-card_m9PqC')]//button[contains(@class,'button dark ghost')][normalize-space()='Show More']
// then scroll back to the top and click on //a[normalize-space()='Add to Cart'] then click on //button[contains(@class,'button checkout-now dark')]
// then assert by checking if //h1[normalize-space()='Shopping Cart'] is on the page 


// the next test case is going to be where from the home page we select/hover on  //span[normalize-space()='Liquor']
// then move over to //span[normalize-space()='Wine'] and click/select it 
// then click on //a[normalize-space()='Red']
// then scroll up 
// then check that //h1[normalize-space()='Red Wine'] is present 

//the next test class will be to start from the home page then hover on //div[@class='badge-button-module_badge-icon-wrapper_1C06p']
// then click on //button[@class='button cart pay'] and then after click on //button[@class='button clear remove-item']
// then assert by checking if this is present //img[@alt='Empty shopping cart']




