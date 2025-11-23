package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		
		logger.info("****** Starting TC001_AccountRegistration ******");
		try
		{
			
		
		HomePage hp= new HomePage(driver);
		hp.clickMyaccount();
		logger.info("Clicked on MyAccount Link...");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link...");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	    
		logger.info("Providing customer details.....");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastNAme(randomeString().toUpperCase());
		regpage.setEmail(randomeString() + "@gmail.com");
		regpage.setTelePhone(randomeNumber());
		
		
		String password=randomeAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setconfirmPassword(password);
		
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		
		logger.info("Validating expected message..");
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Congratulations! Your new account has been successfully created!");
		}
		catch(Exception e)
		{
			logger.error("Test failed..");
			logger.debug("Debug logs.."); 
			Assert.fail();
		}
	
		logger.info("****** Finished TC001_AccountRegistration ******");
			
	
	}
	

	
	
}
