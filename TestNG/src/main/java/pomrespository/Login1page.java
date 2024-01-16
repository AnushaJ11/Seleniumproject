package pomrespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;
public class Login1page {
	//initialization
		public Login1page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
	//Declartion
		@FindBy(name="user_name")
		private WebElement userTextField;
		
	//@FindBys({@FindBy(xpath="//input[@type='password']"),@FindBy(name="user_password")})
	//private WebElement passwordTextField;
		@FindBy(name="user_password")
		private WebElement passwordTextField;
		
		
	//@FindAll({@FindBy(xpath="//input[@type='submit']"),@FindBy(id="submitButton")})
	//private WebElement loginButton;
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="(//input[@value='Login'])[2]")})
	private WebElement loginButton;

	//getter Methods
	public WebElement getUserTextField() {
		return userTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	//Business-Logics
	public void loginToApplication(String userNAme,String Password)
	{
		userTextField.sendKeys(userNAme);
		passwordTextField.sendKeys(Password);
		loginButton.click();
	}
}
