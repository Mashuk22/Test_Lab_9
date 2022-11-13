package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private static final String HOMEPAGE_URL = "https://www.nike.com/";
    private final WebDriver driver;

        @FindBy(xpath = "//button[@class='pre-search-btn ripple']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='product-card__img-link-overlay']")
    private WebElement accessoryButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void enterSearchText(String searchText) {
        searchInput.sendKeys(searchText);
        searchInput.submit();
    }

    public void enterAccessory() {
        accessoryButton.click();
    }

    public void searchClick() {
        searchButton.click();
    }
}
