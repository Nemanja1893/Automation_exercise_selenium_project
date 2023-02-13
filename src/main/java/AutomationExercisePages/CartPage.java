package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public List<WebElement> getProductsInCart(){
        return driver.findElements(By.xpath("//tbody/tr"));
    }
    public List<WebElement> getProductInCartElements(int productIndex){
        return driver.findElements(By.xpath("//tbody/tr["+productIndex+"]/td"));
    }
    public List<WebElement> getProductRemoveButtons(){
//        return driver.findElement(By.xpath("//tbody/tr["+productIndex+"]/td[6]"));
        return driver.findElements(By.cssSelector(".cart_quantity_delete"));
    }
    public WebElement getQuantityButton(int productIndex){
        return driver.findElement(By.xpath("//tbody/tr["+productIndex+"]/td/button"));
    }
    public void waitForProductsToBeRemoved(){
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"),0));
    }
    public WebElement getCheckoutButton(){
        return driver.findElement(By.cssSelector(".check_out"));
    }
    public WebElement getRegisterLink(){
        //modal link
        return wait.until(ExpectedConditions
                .elementToBeClickable(By
                        .xpath("//*[@class='modal-body']//a")));
    }

}
