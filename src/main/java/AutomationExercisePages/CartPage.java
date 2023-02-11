package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

}
