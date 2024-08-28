package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends baseClass {
    private By Apple_In_Results = By.xpath("//div[@class='search-count toolbar-module_search-count_P0ViI search-count-module_search-count_1oyVQ']");
    private By keep_result_onpage_button = By.xpath("//div[@data-ref='toggle-container']");
    private By iphone15Link = By.xpath("//body/div[@id='shopfront-app']/div[contains(@class,'grid-container search-listings-module_search-listings_2Lw_d')]/div[@class='grid-x grid-margin-x']/div[@class='cell auto']/div[@class='listings-container-module_listings-container_AC4LI']/div[@class='grid-x grid-margin-x']/div[@class='cell small-3']/div[@id='93936606']/div[@class='product-card product-card-module_product-card_fdqa8']/a[1]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickKeepResultOnPageButton() {
        clickElement(keep_result_onpage_button);
    }

    public boolean isAppleInResults() {
        return verifyElementPresent(Apple_In_Results);
    }

    public void clickIphone15Link() {
        clickElement(iphone15Link);
    }
}