package tests;

import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
	@BeforeMethod
	  public void beforeMethod() throws IOException {
			lp.openBrowser();
			lp.getLoginPage();
	}

	  @AfterMethod
	  public void afterMethod() {
		  lp.closeBrowser();
	}
	  
	  
  @Test
  public void emailWithSpecialCharTest() throws InterruptedException {
	  
	lp.login(df.emailWithSpecialChar, df.wrongPassword );		
	Thread.sleep(2000);
	Assert.assertEquals(lp.emaiSpacialCharlErr(), df.emailSpecErr);
  }
  
  @Test
  public void emptyEmaiTest() throws InterruptedException {
	  
	lp.login("", df.wrongPassword);		
	Thread.sleep(2000);
		
	Assert.assertEquals(lp.emptyEmailErr(), df.emailErr);
  }
  
  @Test
  public void emptyPasswordTest() throws InterruptedException {
	  
	lp.login(df.wrongEmail, "");		
	Thread.sleep(2000);
		
	Assert.assertEquals(lp.emptyPasswordErr(), df.passwordErr);
  }
  
  @Test
  public void wrongEmailAndWrongPasswordTest() throws InterruptedException {
	  
	lp.login(df.wrongEmail, df.wrongPassword);
	Thread.sleep(2000);
	Assert.assertEquals(lp.globalErr(), df.globalErr);
  }
  

}
