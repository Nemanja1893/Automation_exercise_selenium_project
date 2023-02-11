package AutomationExeciseTests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ContactUsFormTests extends BaseTests{

    @Test(priority = 1)
    @Description("Contact Us Form test")
    public void ContactUs(){
        pageHelper.waitForPageVisibility("/html");
        topNavPage.getContuctUsLink().click();

        Assert.assertEquals(contactUsPage.getGetInTouchForm().getText(),
                "GET IN TOUCH", "Message is incorrect");

        contactUsPage.getNameInput().sendKeys("Pera");
        contactUsPage.getEmailInput().sendKeys("mail@gmail.com");
        contactUsPage.getSubjectInput().sendKeys("Test Subject");
        contactUsPage.getMessageInput().sendKeys("Some random message");

        contactUsPage.getUploadFileInput().sendKeys(new File("test_data/front.jpg").getAbsolutePath());

        actions.scrollByAmount(0,400).perform();
        contactUsPage.getSubmitButton().click();

        driver.switchTo().alert().accept();

        Assert.assertEquals(contactUsPage.getSuccessMessage().getText(),
                        "Success! Your details have been submitted successfully.",
                        "Success message is incorrect");

        contactUsPage.getHomeButton().click();
        driver.navigate().to(baseUrl);

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,"Url is incorrect");

    }

}
