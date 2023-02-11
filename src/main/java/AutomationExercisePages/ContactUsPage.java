package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BasePage{

    public ContactUsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getGetInTouchForm(){
        return driver.findElement(By.xpath("//*[@class= 'contact-form']/h2"));
    }
    public WebElement getNameInput(){
        return driver.findElement(By.cssSelector("input[data-qa='name']"));
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.cssSelector("input[data-qa='email']"));
    }
    public WebElement getSubjectInput(){
        return driver.findElement(By.cssSelector("input[data-qa='subject']"));
    }
    public WebElement getMessageInput(){
        return driver.findElement(By.cssSelector("textarea[data-qa='message']"));
    }
    public WebElement getUploadFileInput(){
        return driver.findElement(By.cssSelector("input[type='file']"));
    }
    public WebElement getSubmitButton(){
        return driver.findElement(By.cssSelector("input[data-qa='submit-button']"));
    }
    public WebElement getSuccessMessage(){
        return driver.findElement(By.cssSelector(".status.alert"));
    }
    public WebElement getHomeButton(){
        return driver.findElement(By.cssSelector(".btn.btn-success"));
    }
}
