package AutomationExeciseTests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends BaseTests {

    @Test(priority = 10)
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
    @Test(priority = 40)
    @Description("Verify all the products related to search are visible")
    public void searchProduct(){
        String searchInput = "blue";

        pageHelper.waitForPageVisibility("/html");
        topNavPage.getProductsLink().click();

        driver.navigate().to(baseUrl+"products");
        CheckUrl("products");

        productsPage.getProductSearchInput().sendKeys(searchInput);
        productsPage.getProductSearchButton().click();

        wait.until(ExpectedConditions.visibilityOf(productsPage.getAllProductsDiv()));

        for (int i = 0; i < productsPage.getAllDisplayedProducts().size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(productsPage.getAllDisplayedProducts().get(i)));

            Assert.assertTrue(productsPage.getAllDisplayedProductsName().get(i)
                            .getText().toLowerCase().contains(searchInput),
                    "Product's name does not contain value from search input");
        }
    }
    @Test(priority = 20)
    @Description("View Category Products")
    public void verifyCategoriesAreVisible(){
        String dressCatTitle = "WOMEN - DRESS PRODUCTS";
        String tShirtCatTitle = "MEN - TSHIRTS PRODUCTS";

        pageHelper.waitForPageVisibility("/html");
        topNavPage.getProductsLink().click();

        driver.navigate().to(baseUrl+"products");
        CheckUrl("products");
        actions.scrollByAmount(0, 500).perform();

        wait.until(ExpectedConditions.visibilityOf(productsPage.getCategoryDiv()));
        productsPage.getWomenCategoryLink().click();
        wait.until(ExpectedConditions.elementToBeClickable(productsPage.getDressLink())).click();

        Assert.assertEquals(productsPage.getTitleText().getText(), dressCatTitle,
                "Page title is incorrect");

        productsPage.getMenCategoryLink().click();
        wait.until(ExpectedConditions.elementToBeClickable(productsPage.getTshirtLink())).click();

        Assert.assertEquals(productsPage.getTitleText().getText(), tShirtCatTitle,
                "Page title is incorrect");
    }
    @Test(priority = 30)
    @Description("View & Cart Brand Products")
    public void verifyBrandsAreVisible(){
        int firstCategory = 6;
        int secondCategory = 5;
        pageHelper.waitForPageVisibility("/html");
        topNavPage.getProductsLink().click();

        driver.navigate().to(baseUrl+"products");
        CheckUrl("products");
        actions.scrollByAmount(0, 660).perform();

        wait.until(ExpectedConditions.visibilityOf(productsPage.getBrandsDiv()));
        productsPage.getFirstBrandLink().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("brand_products"),
                "It is not brand product page");
        Assert.assertEquals(productsPage.getAllDisplayedProducts().size(), firstCategory,
                "The number of displayed brand products is incorrect");

        productsPage.getSecondBrandLink().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("brand_products"),
                "It is not brand product page");
        Assert.assertEquals(productsPage.getAllDisplayedProducts().size(), secondCategory,
                "The number of displayed brand products is incorrect");
    }
    @Test(priority = 50)
    @Description("Search Products and Verify Cart After Login")
    public void addSearchProductsToCart(){
        String searchInput = "blue";
        int expectedNumOfProducts = 7;

        pageHelper.waitForPageVisibility("/html");
        topNavPage.getProductsLink().click();

        driver.navigate().to(baseUrl+"products");
        CheckUrl("products");


        productsPage.getProductSearchInput().sendKeys(searchInput);
        productsPage.getProductSearchButton().click();

        actions.scrollByAmount(0, 500).perform();
        wait.until(ExpectedConditions.visibilityOf(productsPage.getAllProductsDiv()));

        for (int i = 0; i < productsPage.getAllDisplayedProducts().size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(productsPage.getAllDisplayedProducts().get(i)));

            Assert.assertTrue(productsPage.getAllDisplayedProductsName().get(i)
                            .getText().toLowerCase().contains(searchInput),
                    "Product's name does not contain value from search input");
            actions.moveToElement(productsPage.getAllDisplayedProducts().get(i)).perform();

            if(i % 3 == 0){
                actions.scrollByAmount(0,565).perform();
            }

            wait.until(ExpectedConditions.elementToBeClickable(productsPage
                            .getAddToCartButtons().get(i)))
                            .click();
            productsPage.getContinueShoppingButton().click();
        }
        topNavPage.getCartLink().click();

        Assert.assertEquals(cartPage.getProductsInCart().size(), expectedNumOfProducts,
                "Number of products in cart is incorrect");

        topNavPage.getLoginLink().click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginForm()));
        loginPage.getEmailInput().sendKeys("gcsejn@gmail.com");
        loginPage.getPasswordInput().sendKeys("pass123");
        loginPage.getLoginButton().click();

        topNavPage.getCartLink().click();
        Assert.assertEquals(cartPage.getProductsInCart().size(), expectedNumOfProducts,
                "Number of products in cart is incorrect");
    }
    @Test(priority = 60)
    @Description("Add review on product")
    public void addReview(){
        String name = "Pera";
        String email = "mail@mail.com";
        String review = "Added review here";

        pageHelper.waitForPageVisibility("/html");
        topNavPage.getProductsLink().click();

        driver.navigate().to(baseUrl+"products");
        CheckUrl("products");

        actions.scrollByAmount(0,400).perform();
        productsPage.getViewProductLinkByShopIndex(1).click();
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getReviewProductDiv()));

        actions.scrollByAmount(0,400).perform();
        productDetailsPage.getNameInput().sendKeys(name);
        productDetailsPage.getEmailInput().sendKeys(email);
        productDetailsPage.getReviewTextarea().sendKeys(review);

        productDetailsPage.getSubmitReviewButton().click();

        Assert.assertEquals(productDetailsPage.getSuccessReviewDiv().getText(),
                "Thank you for your review.",
                "Success message is incorrect");
    }
}
