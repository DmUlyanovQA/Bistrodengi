package PagesMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage extends Methods {
    String SITE_URL = "https://ya.ru/";

    public MainPage(WebDriver driver) {

        super(driver);
    }

    public void goTO(){
        driver.get(SITE_URL);
    }

    public void WriteBD(String text){
        WriteText(By.xpath("//input[@class='input__control input__input mini-suggest__input']"), text);
    }

    public void ClickBDandAssertTitle(){
        Click(By.xpath("//span[contains(text(),'Займы - взять быстрый займ в МФО')]"));
        //Click(By.xpath("//a[@href='https://bistrodengi.ru/']"));

        waitForSecondWindow();

        Set<String> windows = driver.getWindowHandles();
        List<String> winds = new ArrayList<>(windows);

        String childWindow = winds.get(1);

        driver.switchTo().window(childWindow);
        assertEquals("Займы - взять быстрый займ в МФО «Быстроденьги» под 0% для новых клиентов.", driver.getTitle());

    }

    private void waitForSecondWindow() {
        wait.until(((ExpectedCondition<Boolean>) d -> driver.getWindowHandles().size() > 1));
    }

    /*public void Assert(){
        AssertLink(By.xpath("//img[@src='/local/assets/img/logo_doma.svg']"));
        //assertEquals("Займы - взять быстрый займ в МФО «Быстроденьги» под 0% для новых клиентов. ", driver.getTitle());
    }
*/
}



