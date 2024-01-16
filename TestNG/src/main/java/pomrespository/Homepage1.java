package pomrespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utilities.Webdriver_utility;

public class Homepage1 {
	//initalization
			public Homepage1(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
	//Declartion
			@FindBy(linkText="Organizations")
			private WebElement OrganizationLink;
			
			@FindBy(xpath="//a[text()='Products']")
			private WebElement ProductLink;
			
			@FindBy(linkText="More")
			private WebElement moreLink;
			
			@FindBy(linkText="Campaigns")
			private WebElement campaignsLink;
			
			@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
			private WebElement Administrator;
			
			@FindBy(xpath="//a[text()='Sign Out']")
			private WebElement signout;
			
	//gettermethod
			public WebElement getOrganizationLink() {
				return OrganizationLink;
			}
			public WebElement getAdministrator() {
				return Administrator;
			}
			public WebElement getSignout() {
				return signout;
			}
			public WebElement getProductLink() {
				return ProductLink;
			}
			
			public WebElement getMoreLink() {
				return moreLink;
			}
			public WebElement getCampaignsLink() {
				return campaignsLink;
			}
			
	//BusinessLogics
			public void organizationLink()
			{
				OrganizationLink.click();
			}
			public void productLink()
			{
				ProductLink.click();
			}
			public void logout(WebDriver driver) {
				Webdriver_utility wlib = new Webdriver_utility();
				wlib.Actionsmoveelement(driver, Administrator);
				//Actions act = new Actions(driver);
				//act.moveToElement(Administrator).perform();
				signout.click();
			}
			
			public void clickMoreLink(WebDriver driver)
			{
				Webdriver_utility wlib = new Webdriver_utility();
				wlib.Actionsmoveelement(driver, moreLink);
			campaignsLink.click();
			}
}
