package StvPackage;

import org.testng.annotations.Test;


/*5. Implementation of six test cases concerning the test 
 * suite that tests class Client using the TestNG framework: 0 to 3.0. 
 */

public class ClientTestclass {
	
	//public ClientTestclass(int uniqID, String name,int i, String string, String string2 ) 
		
	
	
	@Test (description = "TestCaseOne check lenght of Naem" )//testCase1
	public void firstTestCase() {
		
		//Arrange
		//check if clients name >= 5 characters
		
		//act
		
		
		//assert
		}

	@Test (description  = " TestCase3, uniqe conditions")//testCase 3
	public void secondTestCase() {
		
		//arrange
		
		//act
		
		
		//assert
		
	}
	@Test(description = "Testcase7 check number of clients PhoneNumbers <= 5 ") // testCase 7
	public void thirdTestCase() {
				//arrange
		
				//act
				
				
				//assert
		
	}
	@Test(description = "Testcase 5, check number of clients PhoneNumbers >= 1")
	public void fourthTestCase() {
				
			//arrange
		
				//act
				
				
				//assert
	}
	
	@Test (description = " TestCase 9, Length == length, clientsPhoneNumbers")
	public void fifthTestCase() {
				
				//arrange
		
				//act
				
				
				//assert
	}
	@Test (description = " TestCase 11,check clients frindes phone numbers of length")
	public void SixtTestCase() {
		
		//arrange
		
		//act
		
		
		//assert
		
	}
	
	
	
}
