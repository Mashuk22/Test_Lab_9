package pageobject_model.page.without_abstact_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHQHomePage {
    private static final String HOMEPAGE_URL = "http://www.selenium.dev/";
    private WebDriver driver;

    @FindBy(className = "DocSearch-Button")
    private WebElement searchOpenBtn;

    @FindBy(id = "docsearch-input")
    private WebElement searchInput;

    @FindBy(className = "DocSearch-Reset")
    private WebElement seaerchBtn;

    public SeleniumHQHomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SeleniumHQHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("DocSearch-Button")));
        return this;
    }

    public SeleniumHQHomePage searchForTerms(String terms){
        WebElement openSeaerchBtn = waitForElementLocatedBy(driver, By.className("DocSearch-Button"));
        openSeaerchBtn.click();

        WebElement searchInput = driver.findElement(By.id("docsearch-input"));
        searchInput.sendKeys(terms);

        return this;
    }

    public WebElement resetSearchText(){
        WebElement seaerchBtn = driver.findElement(By.className("DocSearch-Reset"));
        seaerchBtn.click();

        return seaerchBtn;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        WebElement openSeaerchBtn = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return openSeaerchBtn;
    }
}
