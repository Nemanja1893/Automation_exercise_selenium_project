package AutomationExeciseTests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends BaseTests {

    @Test(priority = 1)
    @Description("Verify All Products and product detail page")
    public void verifyProductsPage(){
        pageHelper.waitForPageVisibility("/html");
        topNavPage.getProductsLink().click();

        driver.navigate().to(baseUrl+"products");
        CheckUrl("products");

        wait.until(ExpectedConditions.visibilityOf(productsPage.getAllProductsDiv()));
        actions.scrollByAmount(0, 500).perform();

        int productIndex = 1;
        productsPage.getViewProductLinkByShopIndex(productIndex).click();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "product_details/" + productIndex + "",
                "Url is incorrect");

        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getProductName()));
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getProductCategory()));
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getProductPrice()));
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getProductAvailability()));
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getProductCondition()));
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getProductBrand()));

    }
    @Test(priority = 2)
    @Description("Verify all the products related to search are visible")
    public void searchProduct(){
        pageHelper.waitForPageVisibility("/html");
        topNavPage.getProductsLink().click();

        driver.navigate().to(baseUrl+"products");
        CheckUrl("products");

        productsPage.getProductSearchInput().sendKeys("Blue");
        productsPage.getProductSearchButton().click();

        wait.until(ExpectedConditions.visibilityOf(productsPage.getAllProductsDiv()));

        for (int i = 0; i < productsPage.getAllSearchedProducts().size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(productsPage.getAllSearchedProducts().get(i)));
        }

    }
    @Test(priority = 3)
    @Description("Add Products in Cart")
    public void AddProductsToCart(){
        pageHelper.waitForPageVisibility("/html");
        topNavPage.getProductsLink().click();

        driver.navigate().to(baseUrl+"products");
        CheckUrl("products");

        actions.scrollByAmount(0,400).perform();
        actions.moveToElement(productsPage.getAllSearchedProducts().get(0)).perform();


        wait.until(ExpectedConditions.elementToBeClickable(productsPage
                        .getProductOverlayAddToCartLinks().get(0)))
                        .click();

        productsPage.getContinueShoppingButton().click();

        actions.moveToElement(productsPage.getAllSearchedProducts().get(1)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(productsPage
                        .getProductOverlayAddToCartLinks().get(1)))
                .click();

        productsPage.getViewCartLink().click();

        CheckUrl("view_cart");

        Assert.assertEquals(cartPage.getProductsInCart().size(), 2,
                        "Number of products in cart is incorrect");

        for (int i = 1; i <= cartPage.getProductsInCart().size(); i++) {
            wait.until(ExpectedConditions.visibilityOfAllElements(cartPage.getProductInCartElements(i)));
        }
    }
    @Test(priority = 4)
    @Description("Verify Product quantity in Cart")
    public void productQuantityInCart(){
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
            Assert.assertEquals(cartPage.getProductsInCart().get(i).getAttribute("button"),"4",
                    "Quantity value is incorrect");
        }
    }

}
