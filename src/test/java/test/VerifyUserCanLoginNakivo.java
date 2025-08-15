package test;

import data.AccountData;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomUtils;

public class VerifyUserCanLoginNakivo extends BaseTest {

    @Test
    public void verifyUserCanLoginWithValidCredential() throws InterruptedException {
        login.inputUserName("dbd195");
        login.inputPassword("Zuong123!@#");
        login.clickOnLogin();
        Assert.assertTrue(dashboardPage.isDashboardPageDisplayed());
    }

    @Test(dataProvider = "AccountData", dataProviderClass = AccountData.class)
    public void verifyUserCannotLoginWithInvalidCredential(String username, String password) throws InterruptedException {
        login.inputUserName(username);
        login.inputPassword(password);
        login.clickOnLogin();
        Assert.assertTrue(login.isErrorMessageDisplayed());
    }

    @Test
    public void verifyUserCannotLoginWithEmptyCredential() {
        login.inputUserName("");
        login.inputPassword("");
        Assert.assertTrue(login.isLoginButtonDisabled());
    }

    @Test
    public void verifyErrorMessageOfUsernameIsNDisplayedWhenInputMoreThanTwoHundredAndFiftyFiveCharacters() {
        login.inputUserName(RandomUtils.randomString(550));
        login.hoverOnUsername();
        Assert.assertTrue(login.isErrorMessageDisplayed());
    }
}
