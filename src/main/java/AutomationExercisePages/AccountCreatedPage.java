package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreatedPage extends BasePage{

    public AccountCreatedPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getAccountCreatedMessage(){
        return driver.findElement(By.cssSelector(".title.text-center"));
    }
    public WebElement getContinueButton(){
        return driver.findElement(By.cssSelector("a[data-qa='continue-button']"));
    }

    public WebElement getAdCloseButton(){
        return driver.findElement(By.cssSelector("#dismiss-button"));
    }

}
