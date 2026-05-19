package testNGExcercises;

import org.testng.annotations.Test;


/*
 * Groups @ method level, groups @ class level
 * If we want to run only one groups from one class, Run As > Run Configuration > Select the required group/s from the list
 * If we want to run groups from one or more class, create a TestNG.XML, just above the <classes> include 
 * <groups>
 * <run include="group name 1"/>
 * <run exclude="group name x"/>
 * </groups>
 * 
 */

@Test(groups= "Group functionalTesting at Class level")
public class TestNG_04 {
	
	@Test(priority = -3, description =" Grourp Verification", groups = {"functionalTesting", "smokeTesting"})

	void method1(){
		System.out.println("TestNG_04 : I am from method 1");
	}
	
	@Test(groups="functionalTesting")
	void method2(){
		System.out.println("TestNG_04 : I am from method 2");
	}
	
	@Test(groups={"functionalTesting", "smokeTesting"})
	void method3(){
		System.out.println("TestNG_04 : I am from method 3");
	}
	
	@Test(groups="smokeTesting")
	void method4(){
		System.out.println("TestNG_04 : I am from method 4");
	}
	
}
