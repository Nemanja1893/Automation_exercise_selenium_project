package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BottomNavPage extends BasePage{

    public BottomNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSubscriptionH2(){
        return driver.findElement(By.cssSelector(".single-widget h2"));
    }
    public WebElement getScrollUpArrowLink(){
        return driver.findElement(By.id("scrollUp"));
    }

}
