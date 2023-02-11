package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLoginForm(){
        return driver.findElement(By.cssSelector(".login-form"));
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.cssSelector("input[data-qa='login-email']"));
    }
    public WebElement getPasswordInput(){
        return driver.findElement(By.cssSelector("input[data-qa='login-password']"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("button[data-qa='login-button']"));
    }
    public WebElement getLoginErrorMessage(){
        return driver.findElement(By.xpath("//form[@action='/login']//p"));
    }

}
