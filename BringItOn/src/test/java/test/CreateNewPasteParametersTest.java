package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CreatedPaste;
import page.MainPage;

public class CreateNewPasteParametersTest {
    private WebDriver driver;
    private static final String PASTETEXT = "git config --global user.name  \"New Sheriff in Town\"\n" + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" + "git push origin master --force";
    private static final String PASTE_NAME = "how to gain dominance among developers";
    private static final String PASTE_HIGHLIGHTING = "Bash";
    private static final String PASTE_EXPIRATION = "10 Minutes";
    CreatedPaste createdPaste;

    @BeforeMethod
    public void createNewPaste() {
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.enterNewText(PASTETEXT);
        mainPage.enterHighlighting(PASTE_HIGHLIGHTING);
        mainPage.enterExpiration(PASTE_EXPIRATION);
        mainPage.enterName(PASTE_NAME);
        createdPaste = mainPage.clickCreateNewPasteButton();
    }

    @Test
    public void compareHighlighting() {
        Assert.assertEquals(createdPaste.getHighlighting(),PASTE_HIGHLIGHTING);
    }
    @Test
    public void compareTitle() {
        Assert.assertEquals(createdPaste.getPageTitle().split("-")[0].trim(), PASTE_NAME);
    }
    @Test
    public void compareText() {
        Assert.assertEquals(createdPaste.getRawPaste(), PASTETEXT);
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
