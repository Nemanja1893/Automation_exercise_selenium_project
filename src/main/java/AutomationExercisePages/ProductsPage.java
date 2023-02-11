package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getAllProductsDiv(){
        return driver.findElement(By.cssSelector(".features_items"));
    }
    public WebElement getViewProductLinkByShopIndex(int productIndex){
        return driver.findElement(By.cssSelector("a[href='/product_details/"+productIndex+"']"));
    }
    public List<WebElement> getAllSearchedProducts(){
        return driver.findElements(By.xpath("//*[@class='features_items']/div[@class='col-sm-4']"));
    }
    public WebElement getProductSearchInput(){
        return driver.findElement(By.cssSelector("#search_product"));
    }
    public WebElement getProductSearchButton(){
        return driver.findElement(By.cssSelector("#submit_search"));
    }
    public List<WebElement> getProductOverlayAddToCartLinks(){
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//        "//*[@class='features_items']//*[@class='col-sm-4']" +
//                "["+productIndex+"]//*[@class='overlay-content']/a")));
//        return wait.until(ExpectedConditions.elementToBeClickable(
//                getAllSearchedProducts().get(productIndex).findElement(
//                By.xpath("//*[@class='overlay-content']/a"))));
        return driver.findElements(By.xpath(
                "//*[@class='features_items']//*[@class='col-sm-4']//*[@class='overlay-content']/a"));
    }
    public WebElement getContinueShoppingButton(){
        //modal button
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-block")));
    }
    public WebElement getViewCartLink(){
        //modal link
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/view_cart']")));
    }
}
