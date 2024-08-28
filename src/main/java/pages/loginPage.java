package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class loginPage extends baseClass {
    private By loginButton = By.xpath("//a[normalize-space()='Login']");
    private By usernameInputLocator = By.xpath("//input[@id='customer_login_email']");
    private By passwordInputLocator = By.xpath("//input[@id='customer_login_password']");
    private By submitButtonLocator = By.xpath("//button[normalize-space()='Login']");
    private By userProfileLocator = By.xpath("//button[normalize-space()='Logout']");
    private By errorMessage = By.xpath("//div[@class='message alert-banner-module_message_2sinO']");
    private By logoutButton = By.xpath("//button[normalize-space()='Logout']");

    public loginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        clickLoginButton();
        enterUsername(username);
        enterPassword(password);
        clickSubmitButton();
    }

    public void clickLoginButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        } catch (Exception e) {
            // If normal click fails, try JavaScript click
            WebElement element = driver.findElement(loginButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void enterUsername(String username) {
        enterText(usernameInputLocator, username);
    }

    public void enterPassword(String password) {
        enterText(passwordInputLocator, password);
    }

    public void clickSubmitButton() {
        clickElement(submitButtonLocator);
    }

    public boolean isUserLoggedIn() {
        return waitForElementPresence(userProfileLocator);
    }

    public boolean isErrorMessagePresent() {
        return verifyElementPresent(errorMessage);
    }
    
    public void clickLogoutButton() {
    	clickElement(logoutButton);
    }
    
    public boolean isUserLoggedOut() {
        return waitForElementPresence(loginButton);
    }
    
    
}