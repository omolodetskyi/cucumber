package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.SecureAreaPage;
import pageObjects.WelcomePage;

//import static org.junit.Assert.*;

import java.net.MalformedURLException;

//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import general.TestBase;


public class StepDefinitions extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;
	
	@Given("Open http:\\/\\/the-internet.herokuapp.com\\/")
	public void open_http_the_internet_herokuapp_com() throws MalformedURLException {
		driver=createWebDriver("chrome"); 
		welcomePage=new WelcomePage(driver);
		welcomePage.openPage();
	}

	@Given("click Form Authentication link")
	public void click_Form_Authentication_link() {
		loginPage=welcomePage.clickFormAuthenticationLink();
	}

	@When("I enter {string} in username field and enter {string} in password field and click Login button")
	public void i_enter_tomsmith_in_username_field(String userName,String password) {
		secureAreaPage=loginPage.enterUserNamePassword(userName, password);
	}
	@Test(description="Check that Secure Area page is opened")
	@Then("Secure Area page is opened")
	public void secure_Area_page_is_opened() {
		String expectedSecureAreaPageTitle="Secure Area";
		String actualSecureAreaPageTitle=secureAreaPage.getTitle();
		Assert.assertEquals(actualSecureAreaPageTitle, expectedSecureAreaPageTitle);
	}
    @Test(description="Check that You logged into a secure area! message appears")
	@Then("You logged into a secure area! message appears")
	public void you_logged_into_a_secure_area_message_appears() {
		String actualSecureAreaPageMsg=secureAreaPage.getMessage();
		String expectedSecureAreaPageMsg="You logged into a secure area!";
		Assert.assertEquals(actualSecureAreaPageMsg.contains(expectedSecureAreaPageMsg),true);
	}
	@When("I enter incorrect {string} in username field and enter {string} in password field and click Login button")
	public void incorrectUserName(String userName,String password) {
		secureAreaPage=loginPage.enterUserNamePassword(userName, password);
	}
	@Test(description="Check that error message appears")
	 @Then("{string} message appears")
	 public void errorMessage_appears(String errorMessage) {
			String actualSecureAreaPageMsg=loginPage.getMessage();
			String expectedSecureAreaPageMsg=errorMessage;
			Assert.assertEquals(actualSecureAreaPageMsg.contains(expectedSecureAreaPageMsg),true);
	 }
	@AfterMethod
	public void cleanUp(){
		System.out.println("Close browser");
		cleanUp();
	}
}
