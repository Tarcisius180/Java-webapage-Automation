package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends baseClass {
    private By Search_Bar = By.xpath("//input[@placeholder='Search for products, brands...']");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By redWineHeader = By.xpath("//h1[normalize-space()='Red Wine']");
    private By Liqour_option = By.xpath("//span[normalize-space()='Liquor']");
    private By wine_option = By.xpath("//span[normalize-space()='Wine']");
    private By redWine_option = By.xpath("//a[normalize-space()='Red']");
    private By cartIcon = By.xpath("//div[@class='badge-button-module_badge-icon-wrapper_1C06p']");
    private By cartPayButton = By.xpath("//button[@class='button cart pay']");
    private By removeItemButton = By.xpath("//button[@class='button clear remove-item']");
    private By homepageButton = By.xpath("//img[@alt='Takealot']");
    


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterSearchTerm(String term) {
        enterText(Search_Bar, term);
    }

    public void submitSearch() {
        clickElement(searchButton);
    }

    public boolean isOnRedWinePage() {
        return verifyElementPresent(redWineHeader);
    }

    public void hoverOnLiquor() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Liqour_option)).perform();
    }

    public void clickWineOption() {
        clickElement(wine_option);
    }

    public void clickRedWineOption() {
        clickElement(redWine_option);
    }

    public void hoverOnCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(cartIcon)).perform();
    }

    public void clickCartPay() {
        clickElement(cartPayButton);
    }

    public void removeItemFromCart() {
        clickElement(removeItemButton);
    }
    public void clickHomepageButton() {
        clickElement(homepageButton);
    }
}