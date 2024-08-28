package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;

import configUtils.ConfigReader;

import java.time.Duration;

public class baseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public baseClass(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }

    public boolean verifyAttribute(By locator, String expectedText) {
        String actualText = driver.findElement(locator).getText();
        Assert.assertTrue(actualText.contains(expectedText),
            "Expected text that contains '" + expectedText + "' not found in actual text: '" + actualText + "'");
        return true;
    }

    public boolean verifyPage(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,
            "Expected URL to be '" + expectedUrl + "' but was '" + actualUrl + "'");
        return true;
    }

    public boolean verifyAlert(String expectedAlertText) {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            if (alertText.contains(expectedAlertText)) {
                driver.switchTo().alert().accept();
                return true;
            } else {
                System.out.println("Alert text '" + alertText + "' does not contain expected text '" + expectedAlertText + "'");
                return false;
            }
        } catch (TimeoutException | NoAlertPresentException e) {
            System.out.println("No alert present or timeout waiting for alert");
            return false;
        }
    }

    public String getElementText(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
    }

    public boolean waitForElementPresence(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    
    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getIntProperty("explicit_wait")));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean verifyElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element not present: " + locator);
            return false;
        }
    }
    
    
    
}