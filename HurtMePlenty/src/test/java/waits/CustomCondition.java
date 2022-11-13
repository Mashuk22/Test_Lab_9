package waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomCondition {
    public static ExpectedCondition<Boolean> changingURL(String url) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return !driver.getCurrentUrl().equals(url);
            }
        };
    }
}
