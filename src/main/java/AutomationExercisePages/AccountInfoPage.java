package AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountInfoPage extends BasePage{

    public AccountInfoPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getNameInput(){
        return driver.findElement(By.cssSelector("#name"));
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.cssSelector("#email"));
    }
    public WebElement getAccountInfoForm(){
        return driver.findElement(By.cssSelector(".title.text-center"));
    }
    public WebElement getMrTitleInput(){
        return driver.findElement(By.cssSelector("input[value='Mr']"));
    }
    public WebElement getMrsTitleInput(){
        return driver.findElement(By.cssSelector("input[value='Mrs']"));
    }
    public WebElement getPasswordInput(){
        return driver.findElement(By.cssSelector("#password"));
    }
    public WebElement getDayFromDateOfBirth(){
        return driver.findElement(By.cssSelector("#days"));
    }
    public WebElement getMonthFromDateOfBirth(){
        return driver.findElement(By.cssSelector("#months"));
    }
    public WebElement getYearFromDateOfBirth(){
        return driver.findElement(By.cssSelector("#years"));
    }
    public WebElement getNewsletterInput(){
        return driver.findElement(By.cssSelector("#newsletter"));
    }
    public WebElement getSpecialOfferInput(){
        return driver.findElement(By.cssSelector("#optin"));
    }
    public WebElement getFirstNameInput(){
        return driver.findElement(By.cssSelector("#first_name"));
    }
    public WebElement getLasttNameInput(){
        return driver.findElement(By.cssSelector("#last_name"));
    }
    public WebElement getCompanyInput(){
        return driver.findElement(By.cssSelector("#company"));
    }
    public WebElement getAddress1Input(){
        return driver.findElement(By.cssSelector("#address1"));
    }
    public WebElement getAddress2Input(){
        return driver.findElement(By.cssSelector("#address2"));
    }
    public WebElement getCountryInput(){
        return driver.findElement(By.cssSelector("#country"));
    }
    public WebElement getStateInput(){
        return driver.findElement(By.cssSelector("#state"));
    }
    public WebElement getCityInput(){
        return driver.findElement(By.cssSelector("#city"));
    }
    public WebElement getZipCodeInput(){
        return driver.findElement(By.cssSelector("#zipcode"));
    }
    public WebElement getMobileNumberInput(){
        return driver.findElement(By.cssSelector("#mobile_number"));
    }
    public WebElement getCreateAccountButton(){
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }
}
