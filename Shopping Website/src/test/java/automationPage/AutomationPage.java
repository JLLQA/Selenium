package automationPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPage {
	

	public static final String URL = "http://automationpractice.com/index.php";

	@FindBy(linkText = "T-SHIRTS")
	private WebElement Category;

	@FindBy(linkText = "Faded Short Sleeve T-shirts")
	private WebElement ItemPress;
	
	@FindBy(name = "Submit")
	private WebElement Submit;
	
	@FindBy(linkText = "Proceed to checkout")
	private WebElement Checkout;

	public WebElement getCategory() {
		return Category;
	}

	public WebElement getItemPress() {
		return ItemPress;
	}

	public WebElement getSubmit() {
		return Submit;
	}
	
	public WebElement getCheckout() {
		return Checkout;
	}
}
