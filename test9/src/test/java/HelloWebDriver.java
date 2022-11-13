import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloWebDriver {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.selenium.dev/");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("DocSearch-Button")));

        WebElement openSeaerchBtn = waitForElementLocatedBy(driver, By.className("DocSearch-Button"));
        openSeaerchBtn.click();

        WebElement searchInput = driver.findElement(By.id("docsearch-input"));
        searchInput.sendKeys("selenium java");
        Thread.sleep(4000);
        WebElement seaerchBtn = driver.findElement(By.className("DocSearch-Reset"));
        seaerchBtn.click();
        Thread.sleep(2000);
        driver.quit();


    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        WebElement openSeaerchBtn = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return openSeaerchBtn;
    }
}
