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
    public List<WebElement> getAllDisplayedProducts(){
        return driver.findElements(By.xpath("//*[@class='features_items']/div[@class='col-sm-4']"));
    }
    public List<WebElement> getAllDisplayedProductsName(){
        return driver.findElements(By.xpath(
                "//*[@class='features_items']/div[@class='col-sm-4']" +
                        "//div[@class='productinfo text-center']//p"));
//        return getAllSearchedProducts().get(productIndex).
//                findElement(By.xpath("//div[@class='productinfo text-center']//p"));
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
    public WebElement getBrandsDiv(){
        return driver.findElement(By.cssSelector(".brands_products"));
    }
    public WebElement getFirstBrandLink(){
        return driver.findElement(By.cssSelector(".brands_products li:nth-child(1) a"));
    }
    public WebElement getSecondBrandLink(){
        return driver.findElement(By.cssSelector(".brands_products li:nth-child(2) a"));
    }
    public WebElement getCategoryDiv(){
        return driver.findElement(By.cssSelector("#accordian"));
    }
    public WebElement getWomenCategoryLink(){
        return driver.findElement(By.xpath("//a[@href='#Women']"));
    }

    //Dress link from women category dropdown
    public WebElement getDressLink(){
        return driver.findElement(By.xpath("//*[@id='Women']//li[1]/a"));
    }
    public WebElement getTitleText(){
        return driver.findElement(By.cssSelector(".title"));
    }
    public WebElement getMenCategoryLink(){
        return driver.findElement(By.xpath("//a[@href='#Men']"));
    }
    public WebElement getTshirtLink(){
        return driver.findElement(By.xpath("//*[@id='Men']//li[1]/a"));
    }
    public List<WebElement> getAddToCartButtons(){
        return driver.findElements(By.cssSelector(".productinfo a"));
    }

}
