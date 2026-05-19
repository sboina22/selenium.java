package testNGExcercises;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
// import org.testng.annotations.*;


public class TestNG_03 {

	@BeforeSuite //@BeforeSuite: The annotated method will be run before all tests in this suite have run.
	void beforeSuite() {
		System.out.println("I am from @BeforeSuite");
	}
	
	@BeforeTest //@BeforeTest: The annotated method will be run before any test method belonging to the classes inside the <test> tag is run
	void beforeTest() {
		System.out.println("I am from @BeforeTest");
	}
	
	@BeforeClass //@BeforeClass: The annotated method will be run before the first test method in the current class is invoked.
	void beforeClass() {
		System.out.println("I am from @BeforeClass");
	}
	
	@BeforeMethod //@BeforeMethod: The annotated method will be run before each test method.
	void beforeMethod() {
		System.out.println("I am from @BeforeMethod");
	}
	
	@Test
	void test1() {
		System.out.println("I am from @test1");
	}
	
	@Test
	void test2() {
		System.out.println("I am from @test2");
	}
	
}

