package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSeleniumHQTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test (description = "first test")
    public void commonSearchTermResultsNotEmpty() {
        driver.get("http://www.selenium.dev/");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("DocSearch-Button")));

        WebElement openSeaerchBtn = waitForElementLocatedBy(driver, By.className("DocSearch-Button"));
        openSeaerchBtn.click();

        WebElement searchInput = driver.findElement(By.id("docsearch-input"));
        searchInput.sendKeys("selenium java");
        WebElement seaerchBtn = driver.findElement(By.className("DocSearch-Reset"));
        seaerchBtn.click();

        Assert.assertTrue(seaerchBtn != null, "Search btn dosnt exist");
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        WebElement openSeaerchBtn = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return openSeaerchBtn;
    }
}
