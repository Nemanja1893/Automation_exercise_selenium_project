package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewUserPage extends BasePage{

    public NewUserPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSignUpForm(){
        return driver.findElement(By.cssSelector(".signup-form"));
    }
    public WebElement getNameInput(){
        return driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
    }
    public WebElement getSignupButton(){
        return driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
    }
    public WebElement getEmailErrorMessage(){
        return getSignUpForm().findElement(By.tagName("p"));
    }




}
