package AutomationExeciseTests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.function.Function;

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
    @Test(priority = 50)
    @Description("Download Invoice after purchase order")
    public void downloadInvoice(){
        String email = "newmail_4@mail.com";
        String name = "Pera";

        pageHelper.waitForPageVisibility("/html");

        driver.navigate().to(baseUrl+"products");

        actions.scrollByAmount(0,400).perform();
        actions.moveToElement(productsPage.getAllDisplayedProducts().get(0)).perform();

        wait.until(ExpectedConditions.elementToBeClickable(productsPage
                        .getAddToCartButtons().get(0)))
                .click();

        productsPage.getContinueShoppingButton().click();
        topNavPage.getCartLink().click();
        CheckUrl("view_cart");

        cartPage.getCheckoutButton().click();
        cartPage.getRegisterLink().click();

        newUserPage.getEmailInput().sendKeys(email);
        newUserPage.getNameInput().sendKeys(name);
        newUserPage.getSignupButton().click();

        accountInfoPage.getPasswordInput().sendKeys("pass123");

        accountInfoPage.getDayFromDateOfBirth().sendKeys("4");
        accountInfoPage.getMonthFromDateOfBirth().sendKeys("May");
        accountInfoPage.getYearFromDateOfBirth().sendKeys("1995");

        actions.scrollToElement(accountInfoPage.getZipCodeInput()).perform();

        wait.until(ExpectedConditions.elementToBeClickable(accountInfoPage.getNewsletterInput()));
        accountInfoPage.getNewsletterInput().click();

        wait.until(ExpectedConditions.elementToBeClickable(accountInfoPage.getSpecialOfferInput()));
        accountInfoPage.getSpecialOfferInput().click();

        accountInfoPage.getFirstNameInput().sendKeys("Pera");
        accountInfoPage.getLasttNameInput().sendKeys("Peric");
        accountInfoPage.getCompanyInput().sendKeys("CoolCompany");
        accountInfoPage.getAddress1Input().sendKeys("address1 street");
        accountInfoPage.getAddress2Input().sendKeys("address2 avenue");
        accountInfoPage.getCountryInput().sendKeys("Canada");
        accountInfoPage.getStateInput().sendKeys("Ontario");
        accountInfoPage.getCityInput().sendKeys("Toronto");
        accountInfoPage.getZipCodeInput().sendKeys("1234");
        accountInfoPage.getMobileNumberInput().sendKeys("5594447224");

        accountInfoPage.getCreateAccountButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/account_created"),"Url is wrong");
        Assert.assertEquals(accountCreatedPage.getAccountCreatedMessage().getText(),
                "ACCOUNT CREATED!","Account created message is wrong");

        accountCreatedPage.getContinueButton().click();

        driver.navigate().to(baseUrl);

        wait.until(ExpectedConditions.visibilityOf(topNavPage.getLoggedInLink()));

        topNavPage.getCartLink().click();
        cartPage.getCheckoutButton().click();

        Assert.assertEquals(checkoutPage.getAccountDetailsH2().getText(), "Address Details",
                "Message is incorrect");
        Assert.assertEquals(checkoutPage.getReviewOrderH2().getText(), "Review Your Order",
                "Message is incorrect");

        actions.scrollByAmount(0,400);
        checkoutPage.getDescriptionTextarea().sendKeys("Description here");
        checkoutPage.getPlaceOrderButton().click();
        CheckUrl("payment");

        String nameOnCard = "Pera Peric";
        String cardNumber = "2131232131231";
        String cvc = "344";
        String expMonth = "11";
        String expYear = "2025";
        String successMessage = "Your order has been placed successfully!";

        paymentPage.getNameOnCardInput().sendKeys(nameOnCard);
        paymentPage.getCardNumberInput().sendKeys(cardNumber);
        paymentPage.getCvcInput().sendKeys(cvc);
        paymentPage.getExpirationMonthInput().sendKeys(expMonth);
        paymentPage.getExpirationYearInput().sendKeys(expYear);
        paymentPage.getPayButton().click();

//        Assert.assertEquals(paymentPage.getSuccessMessageDiv().getText(),successMessage,
//                "Success message is incorrect");



        paymentPage.getDownloadInvoiceLink().click();
        wait.until(filepresent());

        paymentPage.getContinueButton().click();
        topNavPage.getDeleteAccountButton().click();

        Assert.assertEquals(accountCreatedPage.getAccountCreatedMessage().getText(),
                "ACCOUNT DELETED!","Account created message is wrong");


    }

}
