package demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoPage {
	

	@FindBy(linkText = "3. Add a User")
	private WebElement userLink;

	@FindBy(linkText = "4. Login")
	private WebElement loginLink;
	
	public WebElement getUserLink() {
		return userLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}
}
