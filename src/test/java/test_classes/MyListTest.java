package test_classes;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.Status;
import pages.MyList_Page;
import utilities.ExcelDataReader;

public class MyListTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(MyListTest.class);
    private MyList_Page myListPage;

    @Test(groups = {"login_required", "regression"}, priority = 1)

    public void testEmptyMyList() {
        logger.info("Starting testEmptyMyList");
        test.log(Status.INFO, "Starting testEmptyMyList");

        // Initialize MyList_Page
        myListPage = new MyList_Page(driver);

        // Perform login
        loginUser();
        logger.info("Login completed");
        test.log(Status.INFO, "Login completed");

        myAccountPage.clickAccountButton();
        logger.info("Clicked on My Account button");
        test.log(Status.INFO, "Clicked on My Account button");

        myAccountPage.clickMyList_button();
        logger.info("Clicked on My List button");
        test.log(Status.INFO, "Clicked on My List button");

        boolean isMessageCorrect = myListPage.verifyEmptyListMessage("This list is empty!");
        logger.info("Empty list message verified (using verifyAttribute): " + isMessageCorrect);
        test.log(Status.INFO, "Empty list message verified (using verifyAttribute): " + isMessageCorrect);
        Assert.assertTrue(isMessageCorrect, "Empty list message is not correct (verifyAttribute)");

        String actualMessage = myListPage.getEmptyListMessageText();
        logger.info("Actual empty list message (using getElementText): " + actualMessage);
        test.log(Status.INFO, "Actual empty list message (using getElementText): " + actualMessage);
        Assert.assertEquals(actualMessage, "This list is empty!", "Empty list message is not correct (getElementText)");

        if (isMessageCorrect && actualMessage.equals("This list is empty!")) {
            test.log(Status.PASS, "Empty My List message verified successfully");
        } else {
            test.log(Status.FAIL, "Failed to verify empty My List message");
        }
    }
    
    
    @Test(groups = {"login_required", "regression"}, priority = 2)

    public void testCreateNewList() {
        logger.info("Starting testCreateNewList");
        test.log(Status.INFO, "Starting testCreateNewList");

        // Initialize MyList_Page
        myListPage = new MyList_Page(driver);
        Map<String, String> testData = ExcelDataReader.getTestData("MyListTest", "RenameList");
        String newListName = testData.get("NewListName");

        // Perform login
        loginUser();
        logger.info("Login completed");
        test.log(Status.INFO, "Login completed");


        // Navigate to My Account
        myAccountPage.clickAccountButton();
        logger.info("Clicked on My Account button");
        test.log(Status.INFO, "Clicked on My Account button");

        myAccountPage.clickMyList_button();
        logger.info("Clicked on My List button");
        test.log(Status.INFO, "Clicked on My List button");

        myAccountPage.clickCreateNew_List_button();
        logger.info("Clicked on Create New List button");
        test.log(Status.INFO, "Clicked on Create New List button");



        // Enter new list name
        myListPage.Enter_My_List_New_Name_input(newListName);
        logger.info("Entered new list name: " + newListName);
        test.log(Status.INFO, "Entered new list name: " + newListName);

        myListPage.clickMy_List_New_Name_save_button();

        boolean isNewListAdded = myListPage.isNewListAdded();
        logger.info("New list added: " + isNewListAdded);
        test.log(Status.INFO, "New list added: " + isNewListAdded);

        Assert.assertTrue(isNewListAdded, "New list was not added successfully");

        if (isNewListAdded) {
            test.log(Status.PASS, "New list created successfully");
        } else {
            test.log(Status.FAIL, "Failed to create new list");
        }
    }
    
    @Test(groups = {"login_required", "regression"}, priority = 3)

    public void testRenameList() {
        logger.info("Starting testRenameList");
        test.log(Status.INFO, "Starting testRenameList");

        // Initialize MyList_Page
        myListPage = new MyList_Page(driver);
        Map<String, String> testData = ExcelDataReader.getTestData("MyListTest", "RenameList");
        String newListName = testData.get("NewListName");

        // Perform login
        loginUser();
        logger.info("Login completed");
        test.log(Status.INFO, "Login completed");

        // Navigate to My Account
        myAccountPage.clickAccountButton();
        logger.info("Clicked on My Account button");
        test.log(Status.INFO, "Clicked on My Account button");

        myAccountPage.clickMyList_button();
        logger.info("Clicked on My List button");
        test.log(Status.INFO, "Clicked on My List button");

        myListPage.clickViewListButton();
        logger.info("Clicked on View List button");
        test.log(Status.INFO, "Clicked on View List button");

        myListPage.clickRenameButton();
        logger.info("Clicked on Rename button");
        test.log(Status.INFO, "Clicked on Rename button");

        // Enter new list name
        myListPage.Enter_My_List_New_Name_input(newListName);
        logger.info("Entered new list name: " + newListName);
        test.log(Status.INFO, "Entered new list name: " + newListName);

        myListPage.clickMy_List_New_Name_save_button();

        boolean isListRenamed = myListPage.isListRenamed(newListName);
        logger.info("List renamed: " + isListRenamed);
        test.log(Status.INFO, "List renamed: " + isListRenamed);

        Assert.assertTrue(isListRenamed, "List was not renamed successfully");

        if (isListRenamed) {
            test.log(Status.PASS, "List renamed successfully");
        } else {
            test.log(Status.FAIL, "Failed to rename list");
        }
    
    }
    
    @Test(groups = {"login_required", "regression"}, priority = 4)

    public void testDeleteList() {
        logger.info("Starting testDeleteList");
        test.log(Status.INFO, "Starting testDeleteList");

        // Initialize MyList_Page
        myListPage = new MyList_Page(driver);

        // Perform login
        loginUser();
        logger.info("Login completed");
        test.log(Status.INFO, "Login completed");


        // Navigate to My Account
        myAccountPage.clickAccountButton();
        logger.info("Clicked on My Account button");
        test.log(Status.INFO, "Clicked on My Account button");

        myAccountPage.clickMyList_button();
        logger.info("Clicked on My List button");
        test.log(Status.INFO, "Clicked on My List button");

        myListPage.clickViewListButton();
        logger.info("Clicked on View List button");
        test.log(Status.INFO, "Clicked on View List button");

        myListPage.clickDelete_List_Name();
        logger.info("Clicked on Delete_List_Name");
        test.log(Status.INFO, "Clicked on Delete_List_Name");

        myListPage.clickDelete_Button();
        logger.info("Clicked delete button");
        test.log(Status.INFO, "Clicked delete button");

        // Verify the list is renamed
        boolean isWishListPresent = myListPage.isWishListPresent();
        logger.info("Wish List present after deletion: " + isWishListPresent);
        test.log(Status.INFO, "Wish List present after deletion: " + isWishListPresent);

        Assert.assertTrue(isWishListPresent, "Wish List was not found after deletion, indicating the list was not properly deleted");

        if (isWishListPresent) {
            test.log(Status.PASS, "List deleted successfully and Wish List is present");
        } else {
            test.log(Status.FAIL, "Failed to delete list or Wish List is not present");
        }
    }
}