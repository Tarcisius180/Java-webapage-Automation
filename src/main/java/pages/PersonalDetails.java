package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalDetails extends baseClass{
	private By Edit_Details_button = By.xpath("//div[@class='button ghost blue'][normalize-space()='Edit']");
    private By Enter_FirstName = By.xpath("//input[@id='name_firstName']");
    private By Enter_LastName = By.xpath("//input[@id='name_lastName']");
    private By Save_button = By.xpath("//button[normalize-space()='Save']");
    private By Saved_details_alert = By.xpath("//div[@class='cell auto toast-content-module_message_g0BFC']");

    
    
    
    

    public PersonalDetails(WebDriver driver) {
        super(driver);
    }
    
    public void clickEdit_Details_buttonn() {
        clickElement(Edit_Details_button);
    }
    
    
    public void Enter_FirstName_input(String username_change) {
        enterText(Enter_FirstName, username_change);
    }
    
    public void Enter_Enter_LastName_input(String lastname_change) {
        enterText(Enter_LastName, lastname_change);
    }
    
    public void clickSave_button() {
        clickElement(Save_button);
    }
    
    public boolean isPersonalDetailsUpdated() {
        return waitForElementPresence(Saved_details_alert);
    }
    
    public void clearFirstName_input() {
        WebElement element = driver.findElement(Enter_FirstName);
        element.clear();
    }

    public void clearLastName_input() {
        WebElement element = driver.findElement(Enter_LastName);
        element.clear();
    }
    
    
    

}


