package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.MainPage;

public class CreateNewPasteTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void driverSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void isNewPateCreated() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.enterNewText("Hello from WebDriver");
        mainPage.enterExpiration("10 Minutes");
        mainPage.enterName("helloweb");
        String oldUrl = driver.getCurrentUrl();
        mainPage.clickCreateNewPasteButton();
        Assert.assertNotEquals(oldUrl, driver.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
