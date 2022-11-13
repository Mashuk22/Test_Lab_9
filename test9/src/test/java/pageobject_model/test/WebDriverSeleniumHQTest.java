package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.with_abstract_page.SeleniumHQHomePageAbstractPO;

public class WebDriverSeleniumHQTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test (description = "first test")
    public void commonSearchTermResultsNotEmpty() {

        WebElement seaerchBtn = new SeleniumHQHomePageAbstractPO(driver)
                .openPage()
                .searchForTerms("selenium java")
                .resetSearchText();

        Assert.assertTrue(seaerchBtn != null, "Search btn dosnt exist");
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }


}
