package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStep
{

	WebDriver driver;
	By userName = By.xpath("//input[@id='user-name']");
    By password = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//input[@id='login-button']");
    By product = By.xpath("//span[contains(text(),'Products')]");
    By menuButton = By.xpath("//button[@id='react-burger-menu-btn']");

	By logOutMenuListItem = By.xpath("//a[@id='logout_sidebar_link']");

	@Given("user is on login page")
	public void user_is_on_login_page() {
		this.driver = new ChromeDriver();

		System.out.println("Inside Step - user is on login page");
		driver.navigate().to("https://www.saucedemo.com/");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {


		System.out.println("Inside Step - user enters username and password");
		driver.findElement(userName).sendKeys("standard_user");
		driver.findElement(password).sendKeys("secret_sauce");

	}

	@And("clicks on login button")
	public void clicks_on_login_button() {


		System.out.println("Inside Step - clicks on login button");
		driver.findElement(loginButton).click();

	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		String Actual = driver.findElement(product).getText();
		Assert.assertEquals("PRODUCTS",Actual);
	}
	@And("user is logged out and browser closes")
	public void user_is_logged_out_and_browser_closes()
	{
		driver.findElement(menuButton).click();
		driver.findElement(logOutMenuListItem).click();
		driver.close();
	}
}
