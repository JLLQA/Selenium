package demo.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import demo.pages.DemoLogin;
import demo.pages.DemoPage;
import demo.pages.DemoUser;


public class DemoTest {
	
	private WebDriver driver;
	public static final String URL = "http://thedemosite.co.uk";

	@Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }
	
	@Test
	public void testUserPage() {
		driver.get(URL + "/index.php");
		DemoPage main = PageFactory.initElements(driver, DemoPage.class);
		main.getUserLink().click();
		
		assertTrue(driver.getTitle().contains("Add a user"));
	}
	
	@Test
	public void testAddUser() {
		driver.get(URL + "/addauser.php");
		DemoUser user = PageFactory.initElements(driver, DemoUser.class);
		user.createUser("username", "password");
		
		assertEquals(URL+"/savedata.php", driver.getCurrentUrl());
	}
	
	@Test
	public void testLoginUser() {
		driver.get(URL + "/login.php");
		DemoLogin login = PageFactory.initElements(driver, DemoLogin.class);
		login.loginDetails("username", "password");
		
		assertTrue(driver.getPageSource().contains("**Successful Login**"));
	}
	
	@After
    public void tearDown() {
        driver.close();
    }

}
