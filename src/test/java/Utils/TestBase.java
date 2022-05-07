package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;


	public TestBase(){
		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/syedahmarislam/teladoc/teladoc/src/test/java/config/config.properties");
			prop.load(ip);

		}catch(FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void inititalization() {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/syedahmarislam/Downloads/chromedriver 2");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/syedahmarislam/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		// wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		
		driver.get(prop.getProperty("url"));
		
		//verification that the site has been loaded successfully 
		try {
			HttpURLConnection c=
					(HttpURLConnection)new
					URL("https://www.way2automation.com/angularjs-protractor/webtables/").openConnection();
			// set the HEAD request with setRequestMethod
			c.setRequestMethod("HEAD");
			// connection started and get response code
			c.connect();
			int r = c.getResponseCode();
			System.out.println("Http response code: " + r);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		Date d = new Date();
		String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		File DestFile=new File(fileWithPath + FileName);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public static  void clickOn(WebDriver driver, WebElement locator, Duration i) {
		new WebDriverWait(driver, i).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

	public static void sendkey(WebDriver driver, WebElement locator, Duration timeout, String value) {
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(locator));
		locator.sendKeys(value);
	}



	public static boolean findUser(String name) {
		int rowsize = driver.findElements(By.xpath("//table[@class=\"smart-table table table-striped\"]/tbody/tr")).size();
		int colNum = driver.findElements(By.xpath("//table[@class=\"smart-table table table-striped\"]/thead/tr/th")).size();

		boolean flag = false;


		for(int i=1; i<rowsize; i++) {
			for( int j =1; j<=colNum;j++) {

				String s = driver.findElement(By.
						xpath("//table[@class=\"smart-table table table-striped\"]/tbody/tr[" + i +" ]/td[" + j + "]")).getText();

				if(s.equals(name)) {
					flag = true;
					System.out.println("user found/added with username as: " + name);
					break;

				}
				if(flag==true) {
					break;
				}
			}
		}
		if(flag) {
			System.out.println("user present");
			return true;
		}
		System.out.println("User Not Present");
		return flag;
	}

	public static void deleteUser(String name) {
		int rowsize = driver.findElements(By.xpath("//table[@class=\"smart-table table table-striped\"]/tbody/tr")).size();
		int colNum = driver.findElements(By.xpath("//table[@class=\"smart-table table table-striped\"]/thead/tr/th")).size();
		int k=0;

		for(int i=1; i<rowsize; i++) {
			for( int j =1; j<=colNum;j++) {

				String s = driver.findElement(By.
						xpath("//table[@class=\"smart-table table table-striped\"]/tbody/tr[" + i +" ]/td[" + j + "]")).getText();

				if(s.equals(name)) {
					k=1;
					driver.findElement(By.xpath("//tr["+ i +"]/td["+ colNum +"]/button[@ng-click=\"delUser()\"]")).click();
					break;
				}
				if(k==1) {
					break;
				}

			}
		}

	}


}
