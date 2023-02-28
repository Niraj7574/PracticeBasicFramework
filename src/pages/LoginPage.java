package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id = "usernameInput-input")
	WebElement email;
	
	@FindBy(id = "password-input")
	WebElement password;
	
	@FindBy(id = "signIn")
	WebElement signInButton;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
	WebElement emaiSpacialCharlErr;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
	WebElement emptyEmailErr;
	
	@FindBy(id = "PasswordTextField__errors-password")
	WebElement emptyPasswordErr;
	
	@FindBy(id = "globalError")
	WebElement globalErr;
	
	
	public void openBrowser() throws IOException {
		FileInputStream input = new FileInputStream("C:\\QA\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(input);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}else if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}else if (browser.equals("Safari")) {
			driver = new SafariDriver();
		}
		PageFactory.initElements(driver, this);
	}
	
	public void getLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=2gwE_0lrd7I&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiMmd3RV8wbHJkN0kiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY2OTA4ODAwNCwiaWF0IjoxNjY5MDg2ODA0LCJqdGkiOiJhNWZiNmZjYS0zZWU0LTQwYjctYThjNi1jNDBiMzk0NDNjMmMiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.lj6odAo_ZMa24zXFLNYrG4x6q1OD6ohP0p41sxKxhG91caphfN_6Ueoq46zJUqlz97Vla6PKNbGNucb8a83dhpY-1EeaIvIxyJhN9hkvbk1tAFjaWcKQ7zYAKS_gDWQP7tXENaKlhnml6JTMZnvfxEzYYu19LH4i-MoQZ_LpUdZVWlLToP4YA9254baEk27TPPfcXJgI_SDgE0yKsHIx36q7eN5AcCSqTSLQdtCQI-4_lMruynJNZq11WlyBZTx8lDVS3E7dP88n5OoGZ46eaTC4TiiOosfZQ3XVGNQaZGbb3QjXPC2PXcTsTNCxDuNVg3B_ACqMPX1-SIlsBcVHZw&preferred_environment=");
	 }
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void login(String a, String b) {
		email.sendKeys(a);
		password.sendKeys(b);
		signInButton.click();
	}
	
	public String emptyEmailErr() {
		String actualErr = emptyEmailErr.getText();
		return actualErr;
	}
	
	public String emaiSpacialCharlErr() {
		String actualErr = emaiSpacialCharlErr.getText();
		return actualErr;
	}
	
	public String emptyPasswordErr() {
		String actualErr = emptyPasswordErr.getText();
		return actualErr;
	}
	
	public String globalErr() {
		String actualErr = globalErr.getText();
		return actualErr;
	}
	

}
