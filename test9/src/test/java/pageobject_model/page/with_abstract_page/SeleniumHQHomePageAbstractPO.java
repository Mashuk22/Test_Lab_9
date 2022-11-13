package pageobject_model.page.with_abstract_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHQHomePageAbstractPO extends AbstractPage {
    private static final String HOMEPAGE_URL = "http://www.selenium.dev/";
    private WebDriver driver;

    @FindBy(className = "DocSearch-Button")
    private WebElement searchOpenBtn;

    @FindBy(id = "docsearch-input")
    private WebElement searchInput;

    @FindBy(className = "DocSearch-Reset")
    private WebElement seaerchBtn;

    public SeleniumHQHomePageAbstractPO(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SeleniumHQHomePageAbstractPO openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("DocSearch-Button")));
        return this;
    }

    public SeleniumHQHomePageAbstractPO searchForTerms(String term){
        searchOpenBtn.click();
        searchInput.sendKeys(term);

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

//    @Override
//    protected AbstractPage openPage(){
//        throw new RuntimeException("No terms no result");
//    }
}
