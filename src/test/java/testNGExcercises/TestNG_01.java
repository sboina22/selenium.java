package testNGExcercises;

import org.testng.annotations.Test;

public class TestNG_01 {

	/* public static void main(String[] args) method is not required to compile and execute the tests in TestNG
	 * @Test(priority = num) controls the order of execution 
	 * By default, tests run in alphabetical order, if no priority numbers are mentioned
	 * Priority order : -16, -10, -1, 0, 5,9,11, 22 If no priority number. I.e Priorities can be random numbers, no need to have consecutive numbers)
	 * has mentioned will treated as priority 0 If tests are in same priority
	 * number, will run based on a alphabetical order
	 * If no @Test or related test run annotations available, that test wont run and won't show in reports
	 * Install TestNG for Eclipse plug in from Eclipse Market place - will be available for all projects, 
	 * Add TestNG dependency in pom.xml for that project
	 * Add TestNG libraries to the project build path
	 * Install New Software as mentioned in the TestNG Documentation
	 * Settings > Preferences - shows the Installed TestNG libraries / plug ins
	 * Create TestNG file automatically (TestNG > Convert to TestNG) / Manually (New > File > name.xml)
	 * RunAs > TestNG Test (right click test/.java) ; RunAs > TestNG Suite (right click testng.xml)
	 * After each test run, Refresh Project for 'test-output' > emailable-report.html, index.html
	 * Console report
	 * The primary shortcut to organize imports and remove duplicate or unused packages in Eclipse on a Mac is:Command + Shift + O
	 * The Classes runs based on the class order mentioned in TestNG.xml
	 * Annotations are not introduce by TestNG, Annotations are introduced by Java, TestNG used concepts annotations and released some TestNG annotations
	 * Annotations is a form of metadata that can be added to the java source code(Say, Package, Class, Variable, Methods, Parameters..)
	 */

	@Test(priority = 6, description = "openBrowser")
	void openBrowser() {

		System.out.println("I am from openBrowser");
	}

	@Test(priority = -2, description = "loginApp")
	void loginApp() {

		System.out.println("I am from loginApp");
	}

	@Test(description = "zlogoCheck")
	void zlogoCheck() {
		System.out.println("I am from zlogoCheck");
	}

	@Test(description = "closeBrowser")
	void closeBrowser() {
		System.out.println("I am from closeBrowser");
	}

}
