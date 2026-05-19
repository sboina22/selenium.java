package testNGExcercises;

import org.testng.annotations.Test;


public class TestNG_05 {

	@Test(groups={"functionalTesting","smokeTesting"})
	void method01(){
		
		System.out.println("TestNG_05 : I am from method01");
	}

	
	@Test(groups={"smokeTesting"})
	void method02(){
		System.out.println("TestNG_05 : I am from method02");
	}
}



