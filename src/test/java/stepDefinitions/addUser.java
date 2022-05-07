package stepDefinitions;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import Utils.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class addUser extends TestBase {
	
	

	@Given("user is on the desired page")
	public void user_is_on_the_desired_page(){
		//Calling initialization from Test Base class
		inititalization();
	}


	@When("user clicks on add user")
	public void user_clicks_on_add_user() {
		WebElement addUserbtn = driver.findElement(By.xpath("//button[@class=\"btn btn-link pull-right\"]"));
		
		//Calling clickOn from Test Base class
		clickOn(driver, addUserbtn, Duration.ofSeconds(20));
	}


	@Then("^add  first name \"([^\"]*)\"$")
	public void add_first_name(String fname) {
		WebElement firstName = driver.findElement(By.xpath("//input[@name=\"FirstName\"]"));
		sendkey(driver, firstName, Duration.ofSeconds(20), fname);	
	}

	@Then("^add  last name \"([^\"]*)\"$")
	public void add_last_name(String lname) {
		WebElement lastName = driver.findElement(By.xpath("//input[@name=\"LastName\"]"));
		
		//Calling Send key method from TestBase
		sendkey(driver, lastName, Duration.ofSeconds(20), lname);	

	}

	@Then("^add  user name \"([^\"]*)\"$")
	public void add_user_name(String usrname) {
		WebElement userName = driver.findElement(By.xpath("//input[@name=\"UserName\"]"));
		
		sendkey(driver, userName, Duration.ofSeconds(20), usrname);
	}

	@Then("^add  password \"([^\"]*)\"$")
	public void add_password(String password) {
		WebElement pswd = driver.findElement(By.xpath("//input[@name=\"Password\"]"));
		
		sendkey(driver, pswd, Duration.ofSeconds(20), password);
		
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
		WebElement eMail = driver.findElement(By.xpath("//input[@name=\"Email\"]"));
		sendkey(driver, eMail, Duration.ofSeconds(20), email);
	}

	@Then("User enter phone number \"([^\"]*)\"$")
	public void user_enter_phone_number(String phone) {
		WebElement phoneNumber =  driver.findElement(By.xpath("//input[@name=\"Mobilephone\"]"));
		sendkey(driver, phoneNumber, Duration.ofSeconds(20), phone);
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
