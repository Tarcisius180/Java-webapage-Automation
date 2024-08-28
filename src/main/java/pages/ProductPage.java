package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends baseClass {
    private By colorDropdown = By.xpath("//div[@role='listbox']");
    private By addToCartButton = By.xpath("//a[normalize-space()='Add to Cart']");
    private By checkoutNowButton = By.xpath("//button[contains(@class,'button checkout-now dark')]");
    private By showMoreButton = By.xpath("//div[contains(@class,'description-card-module_description-card_m9PqC')]//button[contains(@class,'button dark ghost')][normalize-space()='Show More']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickColorDropdown() {
        clickElement(colorDropdown);
    }

    public void selectColor(String color) {
        clickElement(By.xpath("//a[normalize-space()='" + color + "']"));
    }

    public void clickAddToCart() {
        clickElement(addToCartButton);
    }

    public void clickCheckoutNow() {
        clickElement(checkoutNowButton);
    }

    public void clickShowMore() {
        clickElement(showMoreButton);
    }
}