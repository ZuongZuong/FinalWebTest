package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // === Locator ===
    @FindBy(xpath = "//input[@name=\"username\"]")
    @CacheLookup
    WebElement txtUsername;
    @FindBy(xpath = "//input[@type=\"password\"]")
    @CacheLookup
    WebElement txtPassword;
    @FindBy(xpath = "//span[text()=\"Log In\"]//parent::button")
    @CacheLookup
    WebElement btnLogin;
    @FindBy(xpath = "//div[text()=\"Incorrect credentials.\"]")
    @CacheLookup
    WebElement errorMsg;
    @FindBy(xpath = "//div[@id=\"msg-error-username\"]")
    @CacheLookup
    WebElement errorMsgOfUsername;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // === Action ===
    public void inputUserName(String username) {
        keyword.sendText(txtUsername, username);
    }

    public void inputPassword(String password) {
        keyword.sendText(txtPassword, password);
    }

    public void clickOnLogin() {
        keyword.click(btnLogin);
    }

    public void hoverOnUsername() {
        keyword.hoverOnElement(txtUsername);
    }

    // === Assertion ===
    public boolean isErrorMessageDisplayed() {
        keyword.waitUntilElementDisplayed(errorMsg);
        return errorMsg.isDisplayed();
    }

    public boolean isLoginButtonDisabled() {
        return btnLogin.getAttribute("aria-disabled").equals("true");
    }

    public boolean getErrorMessageOfUsernameDisplayed() {
        return errorMsgOfUsername.isDisplayed();
    }

}
