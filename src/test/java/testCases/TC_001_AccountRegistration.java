package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass{



		@Test(groups= {"regression","master"})
		public void test_Account_Registration() throws InterruptedException, IOException {
		try {	
		logger.info("TC_001_AccountRegistration Started");
		
		
		driver.get(rb.getString("appUrl"));
		logger.info("Web page Startred ");
		driver.manage().window().fullscreen();
		logger.info(" Full Screen ");
		HomePage hp= new HomePage(driver);

		hp.clickMyAccount();
		logger.info(" Clicked my account ");
		hp.clickRegister();
		
		logger.info("Clicked register ");

		AccountRegistrationPage reg= new AccountRegistrationPage(driver);
		reg.setFirstName("John");
		logger.info("Clicked First Name ");
		reg.setLastName("Dick");
		logger.info("Clicked Last Name ");
		reg.setEmail(randomString()+"@gmail.com");
		logger.info(" Clicked email");
		reg.setPassword("232@fdfdl!");
		logger.info("Clicked password ");
		reg.clickAgree();
		
		logger.info(" Clicked agree");
		
		
		reg.clickContinue();
		logger.info(" Clicked continue");
		}
		catch(Exception e) {
			
			logger.info("TC_001_AccountRegistration Failed");
			captureScreen(driver, "test_accout_Registration"); 
			Assert.fail();//Capturing screenshot
		}
		logger.info(" TC_001_AccountRegistration Finished");
	}
		
		

	
}
