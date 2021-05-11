package automationTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import automationPage.AutomationPage;

public class AutomationTest {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void testSite() throws InterruptedException {
        driver.get(AutomationPage.URL);
        assertEquals("My Store", driver.getTitle());
    }
    
    @Test
    public void searchSite() {
        driver.get(AutomationPage.URL);
        AutomationPage page = PageFactory.initElements(driver, AutomationPage.class);
        page.getCategory().click();
        page.getItemPress().click();
        WebElement text1 = this.driver.findElement(By.tagName("h1"));
        String text2 = text1.getText();
        page.getSubmit().click();
        page.getCheckout().click();
        WebElement text3 = this.driver.findElement(By.linkText("Faded Short Sleeve T-shirts"));
        String text4 = text3.getText();
        
        assertEquals(text2,text4);
    }
    
    @After
    public void tearDown() {
        driver.close();
    }
}