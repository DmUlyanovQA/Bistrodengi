package PagesMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Methods {
    public WebDriver driver;
    public WebDriverWait wait;

    public Methods(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);

    }
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    //a[@href='https://bistrodengi.ru/']
    //input[@class='input__control input__input mini-suggest__input']
    public void  WriteText(By elementBy, String text) {
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);

    }

    public void Click(By elementBy){
       driver.findElement(elementBy).click();

    }

    /*public void AssertLink(By elementBy){
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
        //driver.navigate().back();
    }
*/


}
