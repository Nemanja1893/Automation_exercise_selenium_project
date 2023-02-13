package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecommendedItemsPage extends BasePage{

    public RecommendedItemsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getFooter(){
        return driver.findElement(By.cssSelector("#footer"));
    }
    public WebElement getRecommendedItemsDiv(){
        return driver.findElement(By.cssSelector(".recommended_items"));
    }

    //First item in recommended list
    public WebElement getAddToCartLink(){
        return wait.until(ExpectedConditions
                .elementToBeClickable(By
                .cssSelector(".recommended_items a[data-product-id='1']")));
    }
    public WebElement getViewCartModalLink(){
        return wait.until(ExpectedConditions
                .elementToBeClickable(By
                        .xpath("//*[@class='modal-content']//a")));
    }
    public WebElement getRightArrowLink(){
        return driver.findElement(By.cssSelector(".recommended-item-control.right"));
    }
}
