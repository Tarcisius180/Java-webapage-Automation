package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends baseClass {
    private By shoppingCartHeader = By.xpath("//h1[normalize-space()='Shopping Cart']");
    private By emptyCartImage = By.xpath("//img[@alt='Empty shopping cart']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnShoppingCartPage() {
        return verifyElementPresent(shoppingCartHeader);
    }

    public boolean isCartEmpty() {
        return verifyElementPresent(emptyCartImage);
    }
}