package testNGExcercises;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


/*
 * https://www.youtube.com/watch?v=qaLOTq2zPXU
 * As Assertions are not provided by the Selenium WebDriver, take help of /use external libraries, like TestNG/jUnit/3rd party libraries for Assertions
 * Hard Assertions - Throws exceptions immediately upon failure of the assertion
 * Best used for: Critical validations (e.g., login must succeed to proceed). Class used: org.testng.Assert
 * Soft Assertions - Continues execution even if the assertion fails. Errors are collected and thrown only when assertAll() is called.
 * Best used for: Multiple non-dependent checks (e.g., verifying UI elements). Class used: org.testng.asserts.SoftAssert
 */


public class TestNG_02 {

	WebDriver driver; // declare the WebDriver object named 'driver' at class level, to access by the
						// other methods in the same class

	String actualpgtitle;
	String expectedpgtitle = "Failed Sign up for OrangeHRM Free Trial";

	String actuallabelcontactsale;
	String expectedlabelcontactsale = "Failed Contact Sales";

	String actualcurrentpgurl;
	String extectedcurrentpgurl = "https://orangehrm.com/30-day-free-trialFailed";

	@Test(priority = 1)
	void openApplication() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // If an element isn't immediately found on
																			// the page, Selenium will wait up to 10
																			// seconds before throwing an error.
		System.out.println("I am from 'openApplication' Test Method");
		driver.get("https://orangehrm.com/30-day-free-trial");
		driver.manage().window().maximize();
	}

	// @Test(priority=2)
	void logoCheck() {
		System.out.println("I am from 'logocheck' Test Method");
		Timeout.ofSeconds(3000);
		boolean logodisplayed = driver.findElement(By.xpath("//img[@alt='OrangeHRM Logo']")).isDisplayed();
		System.out.print("Logo displayed : " + logodisplayed);
	}

	@Test(priority = 3)
	void hardAssertion() {
		System.out.println("I am from 'hardAssertion' Test Method");
	}

	@Test(priority = 4)
	void softAsssertion() {
		SoftAssert assertvalidation = new SoftAssert(); // Create an object/instance of SoftAssert() class to use the
														// Assert methods. On assert failure, won't stop execution

		actualpgtitle = driver.getTitle();
		actualcurrentpgurl = driver.getCurrentUrl();
		actuallabelcontactsale = driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul[2]/li[3]/a/button")).getText();

		System.out.println("I am from 'softAsssertion' Test Method...");

		System.out.println("The current page Title :" + actualpgtitle);
		assertvalidation.assertEquals(actualpgtitle, expectedpgtitle);
		//AssertJUnit.assertEquals(actualpgtitle, expectedpgtitle);

		// Assert.assertEquals(actualpgtitle, expectedpgtitle); // Hard Assertion - On
		// assertion failure, throws an exception and stops execution from this line.

		System.out.println("The current page URL :" + actualcurrentpgurl);
		assertvalidation.assertEquals(actualcurrentpgurl, extectedcurrentpgurl, "Current page URL mismatch");
		
		System.out.println("The contact sale Label :" + actuallabelcontactsale);
		assertvalidation.assertEquals(actuallabelcontactsale, expectedlabelcontactsale, "Contact Same label mismatch");
		
		assertvalidation.assertAll(); // To report all failures in the Test report.
	}
	
	@Test(priority = 5)
	void closeBroswer() {
		// driver.close();
		driver.quit();
	}
}
