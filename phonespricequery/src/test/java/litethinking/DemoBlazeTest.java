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
        WebElement firstPhoneLink = browserDriver.findElement(By.linkText("HTC One M9"));
        firstPhoneLink.click();

        WebElement phonePrice = browserDriver.findElement(By.tagName("h3"));
        
        assertTrue("$700 *includes tax".equals(phonePrice.getText()));
    }


    @Test
    public void searchSecondPhone() {
        WebElement nextPhonesTagButton = browserDriver.findElement(By.id("next2"));
        nextPhonesTagButton.click();

        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement secondPhoneLink = browserDriver.findElement(By.linkText("MacBook air"));
        secondPhoneLink.click();

        WebElement phoneName = browserDriver.findElement(By.tagName("h2"));
        
        assertTrue("MacBook air".equals(phoneName.getText()));
    }

    @Test
    public void searchFirstLaptop() {
        WebElement laptopsCategoryCard = browserDriver.findElement(By.linkText("Laptops"));
        laptopsCategoryCard.click();

        WebElement firstLaptop = browserDriver.findElement(By.linkText("MacBook Pro"));
        firstLaptop.click();

        WebElement laptopName = browserDriver.findElement(By.tagName("h2"));
        
        assertEquals("MacBook Pro", laptopName.getText());
    }

    @Test
    public void searchSecondLaptop() {
        WebElement laptopsCategoryCard = browserDriver.findElement(By.linkText("Laptops"));
        laptopsCategoryCard.click();

        WebElement secondLaptop = browserDriver.findElement(By.linkText("Dell i7 8gb"));
        secondLaptop.click();

        
        WebElement laptopName = browserDriver.findElement(By.tagName("h2"));
        
        assertEquals("Dell i7 8gb", laptopName.getText());
    }

    @Test
    public void searchFirstMonitor() {
        WebElement monitorsCategoryCard = browserDriver.findElement(By.linkText("Monitors"));
        monitorsCategoryCard.click();

        WebElement firstMonitor = browserDriver.findElement(By.linkText("ASUS Full HD"));
        firstMonitor.click();

        WebElement monitorPrice = browserDriver.findElement(By.tagName("h3"));
        
        assertEquals("$230 *includes tax", monitorPrice.getText());
    }
    

    @AfterEach
    public void closeBrowser() {
        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browserDriver.quit();
    }

}
