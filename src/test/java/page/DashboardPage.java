package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    // === Locator ===
    @FindBy(xpath = "//div[@title=\"Overview\"]")
    @CacheLookup
    WebElement lblOverview;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // === Action ===

    // === Assertion ===
    public boolean isDashboardPageDisplayed() {
        return lblOverview.isDisplayed();
    }

}
