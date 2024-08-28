package test_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.loginPage;
import configUtils.ConfigReader;
import pages.MyAccount_Page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTest {
    protected WebDriver driver;
    protected loginPage loginPage;
    protected MyAccount_Page myAccountPage;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void setUpSuite() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/Spark.html");
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void setUp(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        initializeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getIntProperty("implicit_wait")));
        loginPage = new loginPage(driver);
        myAccountPage = new MyAccount_Page(driver);
        driver.get(ConfigReader.getProperty("base_url"));
        dismissCookieBanner();
        logger.info("Starting test: " + result.getMethod().getMethodName());
    }

    private void initializeDriver() {
        String browser = ConfigReader.getProperty("browser").toLowerCase();
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }
    
    protected void loginUser() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        loginPage.login(username, password);
        logger.info("Logged in with username: " + username);
        waitForLoginCompletion();
    }

    protected void waitForLoginCompletion() {
        myAccountPage.waitForLogoutButton();
        logger.info("Logout button is present, login appears to be complete");
        test.log(Status.INFO, "Logout button is present, login appears to be complete");
    }

    

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = takeScreenshot(result.getName());
            test.log(Status.FAIL, "Test Failed");
            test.addScreenCaptureFromPath(screenshotPath);
            logger.error("Test failed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed");
            logger.info("Test passed: " + result.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        extent.flush();
    }

    private String takeScreenshot(String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destination = "test-output/screenshots/" + screenshotName + "_" + 
                                 new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
            return destination;
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }
    
    private void dismissCookieBanner() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getIntProperty("explicit_wait")));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                org.openqa.selenium.By.cssSelector(".cookies-banner-module_cookie-banner_hsodu")));
            
            ((JavascriptExecutor) driver).executeScript(
                "var element = document.querySelector('.cookies-banner-module_cookie-banner_hsodu');" +
                "if (element) element.parentNode.removeChild(element);");
            
            logger.info("Cookie banner dismissed");
        } catch (org.openqa.selenium.TimeoutException e) {
            logger.info("Cookie banner not found or already dismissed");
        }
    }
    
}