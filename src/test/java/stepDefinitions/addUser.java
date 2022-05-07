package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class addUser extends TestBase {


	@Given("user is on the desired page")
	public void user_is_on_the_desired_page(){
		inititalization();
	}


	@When("user clicks on add user")
	public void user_clicks_on_add_user() {
		clickOn(driver, driver.findElement(By.xpath("//button[@class=\"btn btn-link pull-right\"]")), Duration.ofSeconds(20));
	}


	@Then("^add  first name \"([^\"]*)\"$")
	public void add_first_name(String fname) {

		//Sendkey(driver, driver.findElement(By.xpath("//input[@name=\"LastName\"]")), fname);

		driver.findElement(By.xpath("//input[@name=\"FirstName\"]")).sendKeys(fname);
	}

	@Then("^add  last name \"([^\"]*)\"$")
	public void add_last_name(String lname) {
		driver.findElement(By.xpath("//input[@name=\"LastName\"]")).sendKeys(lname);
	}

	@Then("^add  user name \"([^\"]*)\"$")
	public void add_user_name(String usrname) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name=\"UserName\"]")).sendKeys(usrname);
	}

	@Then("^add  password \"([^\"]*)\"$")
	public void add_password(String password) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name=\"Password\"]")).sendKeys(password);
	}

	@Then("click on company")
	public void click_on_company() {
		driver.findElement(By.xpath("//input[@value=\"15\"]")).click();
	}

	@Then("User Select Role")
	public void user_select_role(DataTable testData) {
		List<String> details = testData.asList(String.class);
		Select role = new Select(driver.findElement(By.xpath("//select[@name=\"RoleId\"]")));
		role.selectByVisibleText(details.get(0));
	}

	@Then("^User enter email \"([^\"]*)\"$")
	public void user_enter_email(String email) {
		driver.findElement(By.xpath("//input[@name=\"Email\"]")).sendKeys(email);
	}

	@Then("User enter phone number \"([^\"]*)\"$")
	public void user_enter_phone_number(String phone) {
		driver.findElement(By.xpath("//input[@name=\"Mobilephone\"]")).sendKeys(phone);
	}

	@Then("User Clicks on Save")
	public void user_clicks_on_save() {
		clickOn(driver, driver.findElement(By.xpath("//button[@class=\"btn btn-success\"]")), Duration.ofSeconds(20));
		//driver.findElement(By.xpath("//button[@class=\"btn btn-success\"]")).click();
	}

	@And("^Verify if username \"([^\"]*)\" is present")
	public void verify_if_user_is_added(String username) {
		findUser(username);
		try {
			this.takeSnapShot(driver, "/Users/syedahmarislam/Desktop/");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		driver.close();
		
	}
	
	@Then("^User look for \"([^\"]*)\" and delete")
	public void user_look_for_and_delete(String string) throws InterruptedException {
		deleteUser(string);
		
		clickOn(driver,driver.findElement(By.xpath("//button[contains(text(),'OK')]")),Duration.ofSeconds(20));
		Thread.sleep(2000);
		findUser(string);
		
		try {
			Thread.sleep(2000);
			this.takeSnapShot(driver, "/Users/syedahmarislam/Desktop/");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		
	}
	
	
}
