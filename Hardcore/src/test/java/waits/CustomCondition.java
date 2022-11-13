package waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomCondition {
    public static ExpectedCondition<Boolean> isButtonEnabled(WebElement button) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return button.isEnabled();
            }
        };
    }
}
