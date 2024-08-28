package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class NewsLetterPage extends baseClass{
	
	private By NewsLetterOption_button = By.xpath("//div[contains(text(),'General')]");
    private By Save_preferences_button = By.xpath("//button[normalize-space()='Save Preferences']");
    private By remove_preferences_button = By.xpath("//div[contains(text(),'Unsubscribe from all Takealot newsletters')]");
    private By Saved_preferences_alert = By.xpath("//div[@class='cell auto toast-content-module_message_g0BFC']");
	
	public NewsLetterPage(WebDriver driver) {
        super(driver);
    }
	
	public void clickNewsLetterOption_button() {
        clickElement(NewsLetterOption_button);
    }
	
	public void clickSave_preferences_button() {
        clickElement(Save_preferences_button);
    }
	
	public void clickremove_preferences_buttonn() {
        clickElement(remove_preferences_button);
    }
	
	public boolean isPreferencesUpdated() {
        return waitForElementPresence(Saved_preferences_alert);
    }
	
	
	
	

}
