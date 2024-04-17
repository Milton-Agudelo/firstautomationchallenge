package litethinking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBlazeTest {

    WebDriver browserDriver = new ChromeDriver();
    String URL = "https://www.demoblaze.com";

    @BeforeEach
    public void setupBrowser() {
        browserDriver = new ChromeDriver();
        browserDriver.get(URL);
        browserDriver.manage().window().maximize();
        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void searchFirstPhone() {
        WebElement phonesCategoryCard = browserDriver.findElement(By.linkText("Phones"));
        phonesCategoryCard.click();
        
        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement firstPhoneLink = browserDriver.findElement(By.linkText("HTC One M9"));
        firstPhoneLink.click();

        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement phonePrice = browserDriver.findElement(By.tagName("h3"));
        
        assertTrue("$700 *includes tax".equals(phonePrice.getText()));
    }


    @Test
    public void searchFirstLaptop() {
        WebElement laptopsCategoryCard = browserDriver.findElement(By.linkText("Laptops"));
        laptopsCategoryCard.click();

        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement firstLaptop = browserDriver.findElement(By.linkText("MacBook air"));
        firstLaptop.click();

        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement laptopPrice = browserDriver.findElement(By.tagName("h3"));
        
        assertEquals("$700 *includes tax", laptopPrice.getText());
    }

    @Test
    public void searchSecondLaptop() {
        WebElement laptopsCategoryCard = browserDriver.findElement(By.linkText("Laptops"));
        laptopsCategoryCard.click();

        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement secondLaptop = browserDriver.findElement(By.linkText("MacBook Pro"));
        secondLaptop.click();

        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        WebElement laptopPrice = browserDriver.findElement(By.tagName("h3"));
        
        assertEquals("$1100 *includes tax", laptopPrice.getText());
    }

    @Test
    public void searchThirdLaptop() {
        WebElement laptopsCategoryCard = browserDriver.findElement(By.linkText("Laptops"));
        laptopsCategoryCard.click();

        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement secondPhoneLink = browserDriver.findElement(By.linkText("Dell i7 8gb"));
        secondPhoneLink.click();

        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement laptopPrice = browserDriver.findElement(By.tagName("h3"));
        
        assertTrue("$700 *includes tax".equals(laptopPrice.getText()));
    }

    @Test
    public void searchFirstMonitor() {
        WebElement monitorsCategoryCard = browserDriver.findElement(By.linkText("Monitors"));
        monitorsCategoryCard.click();

        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement firstMonitor = browserDriver.findElement(By.linkText("ASUS Full HD"));
        firstMonitor.click();

        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement monitorPrice = browserDriver.findElement(By.tagName("h3"));
        
        assertEquals("$230 *includes tax", monitorPrice.getText());
    }
    

    @AfterEach
    public void closeBrowser() {
        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browserDriver.quit();
    }

}
