package AutomationExeciseTests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTests{

    @Test(priority = 10)
    @Description("Add to cart from Recommended items")
    public void addToCartRecommended(){
        pageHelper.waitForPageVisibility("/html");

        actions.moveToElement(recommendedItemsPage.getRecommendedItemsDiv()).perform();
        actions.scrollByAmount(0,100).perform();
        wait.until(ExpectedConditions.visibilityOf(recommendedItemsPage.getRecommendedItemsDiv()));

        recommendedItemsPage.getRightArrowLink().click();
        String dataProductId = recommendedItemsPage.getAddToCartLink().getAttribute("data-product-id");
        recommendedItemsPage.getAddToCartLink().click();
        recommendedItemsPage.getViewCartModalLink().click();


        Assert.assertEquals(cartPage.getProductRemoveButtons().get(0)
                .getAttribute("data-product-id"),
                dataProductId,
                "It is not the right product");
    }
}
