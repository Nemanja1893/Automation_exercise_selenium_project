package AutomationExeciseTests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests{

    @Test(priority = 3)
    @Description("Login User with correct email and password")
    public void LoginWithCorrectCredentials(){

        pageHelper.waitForPageVisibility("/html");
        topNavPage.getLoginLink().click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginForm()));
        loginPage.getEmailInput().sendKeys("gcsejn@gmail.com");
        loginPage.getPasswordInput().sendKeys("pass123");

        loginPage.getLoginButton().click();

        wait.until(ExpectedConditions.visibilityOf(topNavPage.getLoggedInLink()));

        topNavPage.getDeleteAccountButton().click();

        driver.navigate().to(baseUrl + "/delete_account");
        Assert.assertEquals(accountCreatedPage.getAccountCreatedMessage().getText(),
                "ACCOUNT DELETED!","Account created message is wrong");

    }
    @Test(priority = 2)
    @Description("Login User with incorrect email and password")
    public void LoginWithIncorrectCredentials(){
        pageHelper.waitForPageVisibility("/html");
        topNavPage.getLoginLink().click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginForm()));
        loginPage.getEmailInput().sendKeys("mail@gmail.com");
        loginPage.getPasswordInput().sendKeys("pass3");

        loginPage.getLoginButton().click();

        Assert.assertEquals(loginPage.getLoginErrorMessage().getText(),
                "Your email or password is incorrect!", "Login error message is incorrect");


    }
    @Test(priority = 1)
    @Description("Logout user")
    public void logoutUser(){
        pageHelper.waitForPageVisibility("/html");
        topNavPage.getLoginLink().click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginForm()));
        loginPage.getEmailInput().sendKeys("gcsejn@gmail.com");
        loginPage.getPasswordInput().sendKeys("pass123");

        loginPage.getLoginButton().click();

        wait.until(ExpectedConditions.visibilityOf(topNavPage.getLoggedInLink()));

        topNavPage.getLogoutLink().click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "login");
    }
}
