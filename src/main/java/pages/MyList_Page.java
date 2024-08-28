package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MyList_Page extends baseClass {
    
    private By My_List_empty_sentence = By.xpath("//h3[normalize-space()='This list is empty!']");
    private By My_List_Page_Title = By.xpath("//h1[contains(text(), 'My Lists')]");
    private By My_List_New_Name_input = By.xpath("//input[@id='List Name_name']");
    private By My_List_New_Name_save_button = By.xpath("//button[normalize-space()='Save']");
    private By My_List_New_Name_save_alert = By.xpath("//div[@class='cell auto toast-content-module_message_g0BFC']");
    private By View_List_button = By.xpath("//body//div[@id='shopfront-app']//div[contains(@class,'groups-module_wishlists_1eeyR')]//div//div//div[2]//div[1]//div[1]//div[1]//div[2]//a[1]");
    private By Rename_button = By.xpath("//a[normalize-space()='Rename']");
    private By Delete_List_Name = By.xpath("//button[normalize-space()='Delete']");
    private By Delete_Button = By.xpath("//button[@class='button modal-button primary-button modal-module_modal-button_1kOq9']");
    private By WishLits_Locator = By.xpath("//h1[normalize-space()='Wish List']");
    

    

    
    public MyList_Page(WebDriver driver) {
        super(driver);
    }
    
    public boolean verifyEmptyListMessage(String expectedText) {
        return verifyAttribute(getMy_List_empty_sentence(), expectedText);
    }
    
    public String getEmptyListMessageText() {
        return getElementText(getMy_List_empty_sentence());
    }
    
    public boolean isMyListPageLoaded() {
        return waitForElementPresence(My_List_Page_Title);
    }
    
    public void waitForEmptyListMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMy_List_empty_sentence()));
    }

	public By getMy_List_empty_sentence() {
		return My_List_empty_sentence;
	}

	public void setMy_List_empty_sentence(By my_List_empty_sentence) {
		My_List_empty_sentence = my_List_empty_sentence;
	}

	
	public void Enter_My_List_New_Name_input(String my_list_new_name) {
        enterText(My_List_New_Name_input, my_list_new_name);
    }
	
	public boolean isNewListAdded() {
        return waitForElementPresence(My_List_New_Name_save_alert);
    }
	
	

	public boolean isWishListPresent() {
        return verifyElementPresent(WishLits_Locator);
    }

	public boolean isListRenamed(String newListName) {
        By renamedListLocator = By.xpath("//h1[normalize-space()='" + newListName + "']");
        return verifyAttribute(renamedListLocator, newListName);
    }
	
	public void clickViewListButton() {
        waitForElementToBeClickable(View_List_button);
        clickElement(View_List_button);
    }

    public void clickRenameButton() {
        waitForElementToBeClickable(Rename_button);
        clickElement(Rename_button);
    }

    public void clickMy_List_New_Name_save_button() {
        waitForElementToBeClickable(My_List_New_Name_save_button);
        clickElement(My_List_New_Name_save_button);
    }

    public void clickDelete_List_Name() {
        waitForElementToBeClickable(Delete_List_Name);
        clickElement(Delete_List_Name);
    }

    public void clickDelete_Button() {
        waitForElementToBeClickable(Delete_Button);
        clickElement(Delete_Button);
    }

}