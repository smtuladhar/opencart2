package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {

	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	WebElement txt_FirstName_loc;
	
	@FindBy(id="input-lastname")
	WebElement txt_LastName_loc;
	
	@FindBy(id="input-email")
	WebElement txt_email_loc;
	
	@FindBy(id="input-password")
	WebElement txt_password_loc;
	
	@FindBy(name="agree")
	WebElement btn_agree_loc;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btn_continue_loc;
	
	
	public void setFirstName(String fname) {
	txt_FirstName_loc.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txt_LastName_loc.sendKeys(lname);
		}
	
	
	public void setEmail(String email) {
		txt_email_loc.sendKeys(email);
		}
	
	public void setPassword(String pass) {
		txt_password_loc.sendKeys(pass);
		}
	
	public void clickAgree() {
		btn_agree_loc.click();
		}
	
	public void clickContinue() {
		btn_continue_loc.click();
		}
	
}
