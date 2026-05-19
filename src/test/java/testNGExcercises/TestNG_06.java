package testNGExcercises;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_06 {

	WebDriver driver;

	@BeforeTest
	void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("I am from setUp method");
	}

	@Test(priority = 1)
	void actionMethod() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"_R_64mkqsqppb6amH1_\"]")).sendKeys("Boina@Boina.com", Keys.ENTER);
		Thread.sleep(3000);
		System.out.println("PreSteps - I am from actionMethod method");
	}

	@Test (priority = 2,description = "Method: Facebook Login Page - Empty text filed, Error boarder, Error message by Assertions")
	void assertionsCheck() {
		SoftAssert softassert = new SoftAssert();

		//Title check
		String actualPgTitle = driver.getTitle();
		String expectedPgTitle = "Facebook";
		softassert.assertEquals(actualPgTitle, expectedPgTitle, "Title mismatched");

		//Current Page URL check
		String actualPgURL = driver.getCurrentUrl();
		String expectedPgURL = "https://www.facebook.com/";
		softassert.assertEquals(actualPgURL, expectedPgURL, "Current page URL mismatched");
		
		//Empty "email or mobile number" text box check
		String actualEmailText = driver.findElement(By.xpath("//*[@id=\"_R_64mkqsqppb6amH1_\"]")).getAttribute("value");
		String expectedEmailText = " ";
		softassert.assertEquals(actualEmailText, expectedEmailText, "Email or mobile number text mismatched - not empty");
	
		/*
		//Border Assertion
		String actualBorderColor = driver.findElement(By.xpath("//*[@id=\"_R_64mkqsqppb6amH1_\"]")).getCssValue("border");
		String expectedBorderColor = ""; // Selenium will read the RGB values only not the hex decimal values
		softassert.assertEquals(actualBorderColor, expectedBorderColor, "Error message mismatch");
		*/
		
		//Error message check
		String actualEmailErrMsg = driver.findElement(By.xpath("//*[@id=\"_R_64mkqsqppb6am_\"]/div/div[2]/span/span")).getText();
		String expectedEmailErrMsg = "The email or mobile number you entered isn’t connected to an account.";
		softassert.assertEquals(actualEmailErrMsg, expectedEmailErrMsg, "Error message mismatch");
		
		softassert.assertAll();
	}

	@AfterTest
	void tearDown() {
		driver.quit();
	}
	
}
