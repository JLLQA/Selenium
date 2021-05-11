package demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoLogin {
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	WebElement uLogin;

	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	WebElement pLogin;
	
	public void loginDetails(String username, String password) {
		uLogin.sendKeys(username);
		pLogin.sendKeys(password);
		pLogin.submit();
	}

	public WebElement getuLogin() {
		return uLogin;
	}

	public WebElement getpLogin() {
		return pLogin;
	}
	
	
}
