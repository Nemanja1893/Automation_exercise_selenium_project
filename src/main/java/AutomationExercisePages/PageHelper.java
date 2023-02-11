package AutomationExercisePages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageHelper extends BasePage {

    public PageHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForPageVisibility(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

}
