package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    @FindBy(xpath = "//div[contains(@class,'devsite-searchbox')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'devsite-searchbox')]/input")
    private WebElement searchInput;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultPage startSearch(String searchText) {
        searchButton.click();
        searchInput.sendKeys(searchText + "\n");
        return new SearchResultPage(driver);
    }
}
