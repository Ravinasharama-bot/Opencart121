package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	WebDriver driver;
	public  AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
		
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconfirmPassword;
	
	
    @FindBy(xpath="//input[@name='agree']")
    WebElement chkpolicy;
    
    
    @FindBy(xpath="//input[@value='Continue']")
    WebElement btnContinue;
    
    @FindBy(xpath="//p[contains(text(),'Congratulations! Your new account has been success')]")
    WebElement msgConfirmation;
    
    
    public void setFirstName(String fname)
    {
    	txtFirstname.sendKeys(fname);
    }
    
    public void setLastNAme(String lname)
    {
    	txtLastname.sendKeys(lname);
    }
    
    public void setEmail(String email)
    {
    	txtEmail.sendKeys(email);
    }
    
    public void setTelePhone(String tele)
    {
    	txtTelephone.sendKeys(tele);
    }
    
    public void setPassword(String pwd)
    {
    	txtPassword.sendKeys(pwd);
    }
    
    public void setconfirmPassword(String pwd)
    {
    	txtconfirmPassword.sendKeys(pwd);
    }
    
  
    public void setPrivacyPolicy()
    {
    	chkpolicy.click();
    }
    
    public void clickContinue() 
    {   
    	//sol1
    	btnContinue.click();
    }
    
    //sol2
    //btnContinue.submit();
    
    //sol3
    //Action act=new Action(driver);
    // act.moveToElement(btnContinue).click().perform();
    
    
    //sol4
    //JavascriptExecutore js=(JavascriptExecutor)driver;
    //js.executeScript("argument[0].click(); ",btnContinue);
    
    //sol5
    //btnContinue.sendKeys(Keys.RETURN);
    
    //sol6 
    //WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSecond(10));
    //mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
    
    public String getConfirmationMsg() {
   try {
    	return(msgConfirmation.getText());
    }catch (Exception e)
    {
    	return(e.getMessage());
    }
    
      
    }   
	
}
