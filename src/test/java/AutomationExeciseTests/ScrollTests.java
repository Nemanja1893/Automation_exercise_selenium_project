package AutomationExeciseTests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollTests extends BaseTests{

    @Test(priority = 10)
    @Description("Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void scrollUsingArrows(){
        pageHelper.waitForPageVisibility("/html");
        actions.scrollToElement(recommendedItemsPage.getFooter()).perform();

        wait.until(ExpectedConditions.visibilityOf(bottomNavPage.getSubscriptionH2()));
        Assert.assertEquals(bottomNavPage.getSubscriptionH2().getText(),
                "SUBSCRIPTION", "Subscription text is incorrect");

        actions.moveToElement(bottomNavPage.getScrollUpArrowLink()).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(topNavPage.getCarouselH2()));
        Assert.assertEquals(topNavPage.getCarouselH2().getText(),
                "Full-Fledged practice website for Automation Engineers",
                "Text in carousel is incorrect");

    }
    @Test(priority = 10)
    @Description("Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
    public void scrollWithoutUsingArrows(){
        pageHelper.waitForPageVisibility("/html");
        actions.scrollToElement(recommendedItemsPage.getFooter()).perform();

        wait.until(ExpectedConditions.visibilityOf(bottomNavPage.getSubscriptionH2()));
        Assert.assertEquals(bottomNavPage.getSubscriptionH2().getText(),
                "SUBSCRIPTION", "Subscription text is incorrect");

        actions.scrollToElement(topNavPage.getHomeLink()).perform();
        wait.until(ExpectedConditions.visibilityOf(topNavPage.getCarouselH2()));
        Assert.assertEquals(topNavPage.getCarouselH2().getText(),
                "Full-Fledged practice website for Automation Engineers",
                "Text in carousel is incorrect");

    }

}
