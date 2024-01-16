package pomrespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationpage {
	public CreateOrganizationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrganizationImg;

	@FindBy(name="accountname")
	private WebElement OrganizationName;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	//getter methods
	public WebElement getCreateOrganizationImg() {
		return CreateOrganizationImg;
	}

	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	

	public WebElement getSaveButton() {
		return saveButton;
	}

	//Business Logics

	public void clickOrgPlus()
	{
		CreateOrganizationImg.click();
	}

	public void OrganizationData(String orgName)
	{
		OrganizationName.sendKeys(orgName);
		
	}
	public void clickSaveButton()
	{
		saveButton.click();	
	}
}
