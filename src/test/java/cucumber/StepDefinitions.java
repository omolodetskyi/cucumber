package cucumber;



import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObjects.LoginPage;
import pageObjects.SecureAreaPage;
import pageObjects.WelcomePage;
import utils.Helpers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import general.TestBase;


public class StepDefinitions extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;
	@Before
	public void setUp() throws MalformedURLException{
		driver=createWebDriver("chrome");	
	}
	
	@Given("Open http:\\/\\/the-internet.herokuapp.com\\/")
	public void open_http_the_internet_herokuapp_com() throws MalformedURLException {
		 
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
	@Then("Secure Area page is opened")
	public void secure_Area_page_is_opened() {
		String expectedSecureAreaPageTitle="Secure Area";
		String actualSecureAreaPageTitle=secureAreaPage.getTitle();
		Assert.assertEquals(actualSecureAreaPageTitle, expectedSecureAreaPageTitle);
	}

	@Then("You logged into a secure area! message appears")
	public void you_logged_into_a_secure_area_message_appears() {
		String actualSecureAreaPageMsg=secureAreaPage.getMessage();
		String expectedSecureAreaPageMsg="You logged into a secure area!2";
		Assert.assertEquals(actualSecureAreaPageMsg.contains(expectedSecureAreaPageMsg),true);
	}
	@When("I enter incorrect {string} in username field and enter {string} in password field and click Login button")
	public void incorrectUserName(String userName,String password) {
		secureAreaPage=loginPage.enterUserNamePassword(userName, password);
	}
	 @Then("{string} message appears")
	 public void errorMessage_appears(String errorMessage) {
			String actualSecureAreaPageMsg=loginPage.getMessage();
			String expectedSecureAreaPageMsg=errorMessage;
			Assert.assertEquals(actualSecureAreaPageMsg.contains(expectedSecureAreaPageMsg),true);
	 }
	 @After
	public void tearDown(Scenario scenario) throws IOException{
		 if(scenario.isFailed()){
			   String imgPath=Helpers.takeScreenshot(driver, scenario.getName());
				Path content=Paths.get(imgPath);
				Allure.addAttachment("Screenshot for failed Test", Files.newInputStream(content)); 
		 }
		 cleanUp(driver);
	 }
	 
}
