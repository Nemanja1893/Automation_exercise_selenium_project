package AutomationExeciseTests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTests{

    @Test(priority = 1)
    @Description("User registration")
    public void RegisterUser(){

        pageHelper.waitForPageVisibility("/html");
        topNavPage.getLoginLink().click();
        wait.until(ExpectedConditions.visibilityOf(newUserPage.getSignUpForm()));

        newUserPage.getNameInput().sendKeys("Nemanja");
        newUserPage.getEmailInput().sendKeys("gcsejn@gmail.com");
        newUserPage.getSignupButton().click();

        wait.until(ExpectedConditions.visibilityOf(accountInfoPage.getAccountInfoForm()));

        accountInfoPage.getMrTitleInput().click();
        accountInfoPage.getNameInput().clear();
        accountInfoPage.getNameInput().sendKeys("Sejn");
//        accountInfoPage.getEmailInput().clear();
//        accountInfoPage.getEmailInput().sendKeys("somemail@gmail.com");
        accountInfoPage.getPasswordInput().sendKeys("pass123");

        accountInfoPage.getDayFromDateOfBirth().sendKeys("4");
        accountInfoPage.getMonthFromDateOfBirth().sendKeys("May");
        accountInfoPage.getYearFromDateOfBirth().sendKeys("1995");

        actions.scrollToElement(accountInfoPage.getZipCodeInput()).perform();

        wait.until(ExpectedConditions.elementToBeClickable(accountInfoPage.getNewsletterInput()));
        accountInfoPage.getNewsletterInput().click();

        wait.until(ExpectedConditions.elementToBeClickable(accountInfoPage.getSpecialOfferInput()));
        accountInfoPage.getSpecialOfferInput().click();

        accountInfoPage.getFirstNameInput().sendKeys("Pera");
        accountInfoPage.getLasttNameInput().sendKeys("Peric");
        accountInfoPage.getCompanyInput().sendKeys("CoolCompany");
        accountInfoPage.getAddress1Input().sendKeys("address1 street");
        accountInfoPage.getAddress2Input().sendKeys("address2 avenue");
        accountInfoPage.getCountryInput().sendKeys("Canada");
        accountInfoPage.getStateInput().sendKeys("Ontario");
        accountInfoPage.getCityInput().sendKeys("Toronto");
        accountInfoPage.getZipCodeInput().sendKeys("1234");
        accountInfoPage.getMobileNumberInput().sendKeys("5594447224");

        accountInfoPage.getCreateAccountButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/account_created"),"Url is wrong");
        Assert.assertEquals(accountCreatedPage.getAccountCreatedMessage().getText(),
                "ACCOUNT CREATED!","Account created message is wrong");

        accountCreatedPage.getContinueButton().click();

        driver.navigate().to(baseUrl);

        wait.until(ExpectedConditions.visibilityOf(topNavPage.getLoggedInLink()));
        topNavPage.getDeleteAccountButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/delete_account"), "Url is wrong");
        Assert.assertEquals(accountCreatedPage.getAccountCreatedMessage().getText(),
                "ACCOUNT DELETED!","Account created message is wrong");
        accountCreatedPage.getContinueButton().click();

    }
    @Test(priority = 2)
    @Description("Register user with existing email")
    public void RegisterWithExistingEmail(){

        pageHelper.waitForPageVisibility("/html");
        topNavPage.getLoginLink().click();

        wait.until(ExpectedConditions.visibilityOf(newUserPage.getSignUpForm()));

        newUserPage.getNameInput().sendKeys("Nemanja");
        newUserPage.getEmailInput().sendKeys("gcsejn@gmail.com");
        newUserPage.getSignupButton().click();

        Assert.assertEquals(newUserPage.getEmailErrorMessage().getText(), "Email Address already exist!",
                "Error message is not correct");

    }
}
