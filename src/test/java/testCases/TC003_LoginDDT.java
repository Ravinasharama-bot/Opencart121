package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 Data is valid - login success - test pass - logout
 Data is valid --login failed - test fail
 
 Data in invalid - login success - test fail - logout
 Data is invalid - login failed - test pass
 */

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups="datadrivern")  //getting dataProvider from different class 
	public void verify_loginDDT(String email, String pwd, String res)
	{
		logger.info("****** starting TC_003_LoginDDT ******");
		
		try
		{
		//HomePage
		   HomePage hp= new HomePage(driver);
		   hp.clickMyaccount();
		   hp.clickLogin();
		   
		   //LoginPage
		   LoginPage lp=new LoginPage(driver);
		   lp.setEmail(email);
		   lp.setPassword(pwd);
		   lp.clickLogin();
		   
		   //MyAccount
		   MyAccountPage macc=new MyAccountPage(driver);
		   boolean targetPage=macc.isMyAccountPageExists();
		  

            /*
              Data is valid - login success - test pass - logout
                            -login failed - test fail
 
              Data in invalid - login success - test fail - logout
                              - login failed - test pass
            */
		
		  if(res.equalsIgnoreCase("Valid"))
		  {
			  if(targetPage==true)
			  { 
				 macc.clickLogout();
				 Assert.assertTrue(true); 
			  }
		 else
			  {
				  Assert.assertTrue(false);
			  }
		  }
		  
		if(res.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
		{
			macc.clickLogout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
		
   	}

		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****** finished TC_003_LoginDDT ******");  		  
		  
	}
}
