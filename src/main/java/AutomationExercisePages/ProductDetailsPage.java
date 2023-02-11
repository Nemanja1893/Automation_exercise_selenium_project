package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePage{

    public ProductDetailsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getProductName(){
        return driver.findElement(By.xpath("//*[@class='product-information']/h2"));
    }
    public WebElement getProductCategory(){
        return driver.findElement(By.xpath("//*[@class='product-information']/p[1]"));
    }
    public WebElement getProductPrice(){
        return driver.findElement(By.xpath("//*[@class='product-information']/span"));
    }
    public WebElement getProductAvailability(){
        return driver.findElement(By.xpath("//*[@class='product-information']/p[2]"));
    }
    public WebElement getProductCondition(){
        return driver.findElement(By.xpath("//*[@class='product-information']/p[3]"));
    }
    public WebElement getProductBrand(){
        return driver.findElement(By.xpath("//*[@class='product-information']/p[4]"));
    }
    public WebElement getQuantityInput(){
        return driver.findElement(By.cssSelector("#quantity"));
    }
    public WebElement getAddToCartButton(){
        return driver.findElement(By.cssSelector(".cart"));
    }
}
