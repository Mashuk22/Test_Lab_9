package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomCondition;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final int WAIT_TIME_IN_SECONDS = 30;
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private final WebDriver driver;

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement newText;

    @FindBy(xpath = "//span[@data-select2-id='1']")
    private WebElement selectHighlighting;

    @FindBy(xpath = "//select[@id='postform-expiration']/following::span[1]")
    private WebElement selectExpiration;

    @FindAll({ @FindBy(xpath = "//li[@class='select2-results__option']") })
    private List<WebElement> expirationOptions;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteName;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement newPasteButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(CustomCondition.jQueryAJAXsCompleted());
        return this;
    }

    public void enterNewText(String name) {
        newText.sendKeys(name);
    }

    public void setSelectOption(WebElement select, String optionValue) {
        select.click();
        for (WebElement selectOption : expirationOptions) {
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.elementToBeClickable(selectOption));
            if (selectOption.getText().trim().equals(optionValue.trim())) {
                selectOption.click();
                new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.invisibilityOf(selectOption));
                break;
            }
        }
    }

    public void enterExpiration(String expiration) {
        setSelectOption(selectExpiration, expiration);
    }

    public void enterName(String name) {
        pasteName.sendKeys(name);
    }

    public void clickCreateNewPasteButton() {
        newPasteButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(CustomCondition.changingURL(driver.getCurrentUrl()));
    }
}
