package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage{

    public PaymentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameOnCardInput(){
        return driver.findElement(By.xpath("//*[@data-qa='name-on-card']"));
    }
    public WebElement getCardNumberInput(){
        return driver.findElement(By.xpath("//*[@data-qa='card-number']"));
    }
    public WebElement getCvcInput(){
        return driver.findElement(By.xpath("//*[@data-qa='cvc']"));
    }
    public WebElement getExpirationMonthInput(){
        return driver.findElement(By.xpath("//*[@data-qa='expiry-month']"));
    }
    public WebElement getExpirationYearInput(){
        return driver.findElement(By.xpath("//*[@data-qa='expiry-year']"));
    }
    public WebElement getPayButton(){
        return driver.findElement(By.xpath("//*[@data-qa='pay-button']"));
    }
    public WebElement getSuccessMessageDiv(){
        return driver.findElement(By.xpath("//*[@id='success_message']"));
    }
    public WebElement getDownloadInvoiceLink(){
        return driver.findElement(By.cssSelector(".check_out"));
    }
    public WebElement getContinueButton(){
        return driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
    }



}
