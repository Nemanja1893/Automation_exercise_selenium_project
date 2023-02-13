package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getAccountDetailsH2(){
        return driver.findElement(By.xpath("//*[@class='step-one'][1]/h2"));
    }
    public WebElement getReviewOrderH2(){
        return driver.findElement(By.xpath("//*[@class='step-one'][2]/h2"));
    }
    public WebElement getDescriptionTextarea(){
        return driver.findElement(By.cssSelector(".form-control"));
    }
    public WebElement getPlaceOrderButton(){
        return driver.findElement(By.cssSelector("a[href='/payment']"));
    }
}
