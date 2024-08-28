package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BusinessNamePage extends baseClass{
	
	private By Edit_Business_button = By.xpath("//div[contains(@class,'button ghost blue')][normalize-space()='Add']");
    private By businessName_input = By.xpath("//input[@id='business_businessName']");
    private By vatNumber__input = By.xpath("//input[@id='business_vatNumber']");
    private By Save_button = By.xpath("//button[normalize-space()='Save']");
    private By Saved_details_alert = By.xpath("//div[@class='toast-content-module_toast-content_2KtAk']//div[@class='grid-x']");
    private By Edit_Business_details = By.xpath("//div[@id='Business Details_button']//div[@class='button ghost blue'][normalize-space()='Edit']");
    
	public BusinessNamePage(WebDriver driver) {
        super(driver);
    }
	
	public void clickAdd_Details_buttonn() {
        clickElement(Edit_Business_button);
    }
	
	public void clickEdit_Details_button() {
        clickElement(Edit_Business_details);
    }
    
    
    public void enter_businessName(String username_change) {
        enterText(businessName_input, username_change);
    }
    
    public void enter_vatNumber(String lastname_change) {
        enterText(vatNumber__input, lastname_change);
    }
    
    public void clickSave_button() {
        clickElement(Save_button);
    }
    
    public boolean isBusinessDetailsUpdated() {
        return waitForElementPresence(Saved_details_alert);
    }
    
    public void clearbusinessName_input() {
        WebElement element = driver.findElement(businessName_input);
        element.clear();
    }

    public void clearvatNumber__input() {
        WebElement element = driver.findElement(vatNumber__input);
        element.clear();
    }
	
	

}
