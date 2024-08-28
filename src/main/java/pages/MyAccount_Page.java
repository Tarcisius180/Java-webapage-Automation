package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MyAccount_Page extends baseClass {
    private By Myaccount_button = By.xpath("//button[normalize-space()='My Account']");
    private By RedeemPromo_Discount_button = By.xpath("//a[normalize-space()='Redeem Gift Voucher']");
    private By Promo_Code_input = By.xpath("//input[@id='voucher_voucherOrCoupon']");
    private By ApplyCode_button = By.xpath("//button[normalize-space()='Apply Voucher']");
    private By PromoCodeSuccessMessage = By.xpath("//div[contains(@class, 'success-message')]");
    private By AddressBook_Button = By.xpath("//a[normalize-space()='Address Book']");
    private By Add_Address = By.xpath("//a[@id='addAddress']");
    private By PersonalDetails_button = By.xpath("//ul[@class='card-module_menu-container_3Hu8Y']//a[@data-react-link='true'][normalize-space()='Personal Details']");
    private By NewsLetter_button = By.xpath("//a[normalize-space()='Newsletter Subscriptions']");
    private By MyList_button = By.xpath("//a[normalize-space()='My Lists']");
    private By CreateNew_List_button = By.xpath("//a[normalize-space()='Create a List']");
    private By LogoutButton = By.xpath("//button[normalize-space()='Logout']");


    public MyAccount_Page(WebDriver driver) {
        super(driver);
    }

    public void clickAccountButton() {
        waitForElementToBeClickable(getMyaccount_button());
        clickElement(getMyaccount_button());
    }

    public void clickMyList_button() {
        waitForElementToBeClickable(getMyList_button());
        clickElement(getMyList_button());
    }

    public void clickCreateNew_List_button() {
        waitForElementToBeClickable(CreateNew_List_button);
        clickElement(CreateNew_List_button);
    }

    public void clickRedeemPromo_DiscountButton() {
        clickElement(RedeemPromo_Discount_button);
    }

    public void enterPromoCode(String promoCode) {
        enterText(Promo_Code_input, promoCode);
    }

    public void clickApplyButton() {
        clickElement(ApplyCode_button);
    }

    public boolean isPromoCodeApplied() {
        return waitForElementPresence(PromoCodeSuccessMessage);
    }
    
    public void clickAddressBook_Button() {
        clickElement(AddressBook_Button);
    }
    
    public void clickAdd_Address() {
        clickElement(Add_Address);
    }
    
    public void clickPersonalDetails_button() {
        clickElement(PersonalDetails_button);
    }
    
    public void clickNewsLetter_button() {
        clickElement(NewsLetter_button);
    }


    public By getMyaccount_button() {
        return Myaccount_button;
    }

    public void setMyaccount_button(By myaccount_button) {
        Myaccount_button = myaccount_button;
    }

    public By getMyList_button() {
        return MyList_button;
    }

    public void setMyList_button(By myList_button) {
        MyList_button = myList_button;
    }
    
    public void waitForLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(LogoutButton));
    }
}