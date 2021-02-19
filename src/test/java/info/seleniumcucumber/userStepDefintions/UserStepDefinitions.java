package info.seleniumcucumber.userStepDefintions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import env.Baseclass;
import env.sauceObject;



public class UserStepDefinitions extends Baseclass {

	sauceObject sc=new sauceObject();
	
	@Given("^Login to saucedemo app$")
	public void login_to_saucedemo_app() throws Throwable {
	    InitialiseSelenium(getData(1, 4));
	    for(int i=1;i<=5;i++) {
			sendkeys(sauceObject.username, getData(i, 0));
			quitBrowser();
	    }
	}

	@Given("^I check all valid and invalid username and password$")
	public void I_check_all_valid_and_invalid_username_and_password() throws Throwable {
		for(int i=1;i<=5;i++) {
		sendkeys(sauceObject.username, getData(i, 0));
		quitBrowser();
		}
	}

	@Given("^verify Able to  select the product and add to cart$")
	public void verify_Able_to_select_the_product_and_add_to_cart() throws Throwable {
	   
	}

	@When("^I click on element having class \"([^\"]*)\"$")
	public void i_click_on_element_having_class(String arg1) throws Throwable {
	   
	}

	@Then("^I should get logged out$")
	public void i_should_get_logged_out() throws Throwable {
	  
	}


}
