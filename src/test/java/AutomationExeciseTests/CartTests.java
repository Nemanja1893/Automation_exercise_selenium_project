package AutomationExeciseTests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTests{

    @Test(priority = 40)
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
    @Test(priority = 20)
    @Description("Remove products from cart")
    public void removeProductsFromCart(){
        pageHelper.waitForPageVisibility("/html");
        topNavPage.getProductsLink().click();

        driver.navigate().to(baseUrl+"products");
        CheckUrl("products");

        actions.scrollByAmount(0,400).perform();
        actions.moveToElement(productsPage.getAllDisplayedProducts().get(0)).perform();

        wait.until(ExpectedConditions.elementToBeClickable(productsPage
                        .getAddToCartButtons().get(0)))
                .click();

        productsPage.getViewCartLink().click();

        CheckUrl("view_cart");

//        for (int i = 0; i < cartPage.getProductsInCart().size(); i++) {
////            cartPage.getProductRemoveButtons(1).click();
//            wait.until(ExpectedConditions
//                    .elementToBeClickable(cartPage
//                            .getProductRemoveButtons(1))).click();
////            cartPage.getProductsInCart().remove(i);
//        }
//        actions.scrollByAmount(0, 300).perform();
        for (int i = 0; i < cartPage.getProductRemoveButtons().size(); i++) {
            wait.until(ExpectedConditions.elementToBeClickable(cartPage
                            .getProductRemoveButtons().get(i)))
                    .click();

            wait.until(ExpectedConditions.invisibilityOf(cartPage.getProductRemoveButtons().get(i)));
        }
        cartPage.waitForProductsToBeRemoved();
        Assert.assertEquals(cartPage.getProductsInCart().size(), 0,
                "Cart is not empty");

    }
    @Test(priority = 10)
    @Description("Add Products in Cart")
    public void AddProductsInCart(){
        int productIndex = 1;
        pageHelper.waitForPageVisibility("/html");
        topNavPage.getProductsLink().click();

        driver.navigate().to(baseUrl+"products");
        CheckUrl("products");

        actions.scrollByAmount(0,400).perform();
        actions.moveToElement(productsPage.getAllDisplayedProducts().get(0)).perform();

        wait.until(ExpectedConditions.elementToBeClickable(productsPage
                        .getAddToCartButtons().get(0)))
                .click();

        productsPage.getContinueShoppingButton().click();

        actions.moveToElement(productsPage.getAllDisplayedProducts().get(1)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(productsPage
                        .getAddToCartButtons().get(1)))
                .click();

        productsPage.getViewCartLink().click();

        CheckUrl("view_cart");

        Assert.assertEquals(cartPage.getProductsInCart().size(), 2,
                "Number of products in cart is incorrect");

        for (int i = 1; i <= cartPage.getProductsInCart().size(); i++) {
            wait.until(ExpectedConditions.visibilityOfAllElements(cartPage.getProductInCartElements(i)));
        }
        //remove products from cart
        for (int i = 0; i < cartPage.getProductRemoveButtons().size(); i++) {
            cartPage.getProductRemoveButtons().get(i).click();
        }
        cartPage.waitForProductsToBeRemoved();
        Assert.assertEquals(cartPage.getProductsInCart().size(), 0,
                "Cart is not empty");
    }
    @Test(priority = 30)
    @Description("Verify Product quantity in Cart")
    public void productQuantityInCart() throws InterruptedException {
        pageHelper.waitForPageVisibility("/html");

        actions.scrollByAmount(0,650).perform();
        productsPage.getViewProductLinkByShopIndex(1).click();
        driver.navigate().to(baseUrl+"product_details/"+1);

        CheckUrl("product_details/"+ 1);

        productDetailsPage.getQuantityInput().clear();
        productDetailsPage.getQuantityInput().sendKeys("4");

        wait.until(ExpectedConditions.elementToBeClickable(productDetailsPage.getAddToCartButton()));
        productDetailsPage.getAddToCartButton().click();

        productsPage.getViewCartLink().click();

        CheckUrl("view_cart");


        for (int i = 0; i < cartPage.getProductsInCart().size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(cartPage.getProductsInCart().get(i)));
            Assert.assertEquals(cartPage.getQuantityButton(i + 1).getText(),"4",
                    "Quantity value is incorrect");
        }
        for (int i = 0; i < cartPage.getProductRemoveButtons().size(); i++) {
            cartPage.getProductRemoveButtons().get(i).click();
        }

    }

}
