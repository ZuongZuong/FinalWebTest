package test;

import constants.FrameworkConstants;
import driver.TargetFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import action.Keyword;
import configuration.Configuration;
import driver.DriverFactory;
import page.BasePage;
import page.DashboardPage;
import page.LoginPage;

public class BaseTest {
	public WebDriver driver;
    public Keyword keyword;
    public Configuration config;
    TargetFactory targetFactory;
    LoginPage login;
    BasePage basePage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() throws Exception {
        targetFactory = new TargetFactory();
        this.driver = targetFactory.createInstance();
        this.keyword = new Keyword(driver);
        keyword.openUrl(FrameworkConstants.URL);
        basePage = new BasePage(driver);
        login = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        this.driver.close();
        this.driver.quit();
    }
    
}
