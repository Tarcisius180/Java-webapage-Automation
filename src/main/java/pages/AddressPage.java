package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class AddressPage extends baseClass {
     private By Residential_button = By.xpath("//div[contains(text(),'Residential')]");
     private By Name_input = By.xpath("//input[@id='address-edit_recipient']");
     private By number_input = By.xpath("//input[@id='address-edit_contact_number']");
     private By Address_input = By.xpath("//input[@id='address-edit_street']");
     private By Subarb_input = By.xpath("//input[@id='address-edit_suburb']");
     private By City_input = By.xpath("//input[@id='address-edit_city']");
     private By Province_input = By.xpath("//select[@id='address-edit_province']");
     private By PostalCode_input = By.xpath("//input[@id='address-edit_postal_code']");
     private By SaveaddressButton = By.xpath("//button[normalize-space()='Save Address']");
     private By ConfirmAddress = By.xpath("//button[normalize-space()='Save Address']");
     private By addressFormContainer = By.xpath("//div[@class='panel panel-collapse']");

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public void clickResidential_buttonButton() {
        clickElement(Residential_button);
    }

    public void enterName_input(String rec_name) {
        enterText(Name_input, rec_name);
    }
    
    public void enternumber_inputt(String rec_number) {
        enterText(number_input, rec_number);
    }
    
    public void enterAddress_input(String rec_add) {
        enterText(Address_input, rec_add);
    }
    
    public void enterSubarb_input(String rec_subarb) {
        enterText(Subarb_input, rec_subarb);
    }
    
    public void enterCity_input(String rec_City) {
        enterText(City_input, rec_City);
    }
    
    public void selectFirstProvince() {
        Select provinceDropdown = new Select(driver.findElement(Province_input));
        provinceDropdown.selectByIndex(1);
    }
    
    public void enterPostalCode_input(String rec_pscode) {
        enterText(PostalCode_input, rec_pscode);
    }

    public void clickSaveaddressButton() {
        clickElement(SaveaddressButton);
    }

    public boolean isAddressAdded() {
        return waitForElementPresence(ConfirmAddress);
    }
    
    public boolean isAddressFormVisible() {
        return waitForElementPresence(addressFormContainer);
    }
}