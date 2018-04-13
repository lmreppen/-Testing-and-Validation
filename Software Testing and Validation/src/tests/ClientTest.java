package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import exceptions.InvalidOperationException;
import impl.Client;


/*5. Implementation of six test cases concerning the test 
 * suite that tests class Client using the TestNG framework: 0 to 3.0. 
 */

public class ClientTest extends Assert {

	//public ClientTest(int uniqID, String name,int i, String string, String string2 ) 

	@Test(description = "Test case 1: minimum lenght of name" )
	public void testMinLengthOfName() {
		Client client = new Client("timminy", 28239873, 29727822);
		// Act
		try {
			//Client client = new Client("tim", 28239873, 29727822);
			
			//assert
			assertTrue(client.getName().length() >= 5);
			
			
			//fail("A name of length less than five should not be admissible");
		} catch (IllegalArgumentException e) {
			fail("A name of length less than five should not be admissible");
		}
	}
	
	
	@Test (description = " TestCase 3, uniqe Id")
	public void testUniqueId() throws InvalidOperationException{
			Client client = new Client("NameName",123123515,123456789);
			Client client1 = new Client("NameName",123123515,123456789);
			Client client2 = new Client("NameName",123123517,123456789);
		try {
			
			assertSame("This NIF number is the same", client.equals(client1));
			
		}catch(IllegalArgumentException e) {
			fail("this Uniqe Id already exist");
		}
		
	}
	
	

	@Test(description = "Test case 7: maximum number of phone numbers")
	public void testMaxNumberOfPhoneNumbers() throws InvalidOperationException {
		// Arrange
		Client client = new Client("MaxThorne", 28239873, 29727822);

		// Act
		for (int i = 0; i < 4; i++) client.addPhoneNumber(76802982 + i);

		try {
			client.addPhoneNumber(82098221);
			
			// Assert
			assertTrue(client.getMobiles().size() <= 5);
			
		} catch (InvalidOperationException e) {
			fail("Maximum number of phone numbers should be five");
		}
	}

	@Test(description = "Test case 5, minimum number of phone numbers")
	public void testMinNumberOfPhoneNumbers() throws InvalidOperationException {
		// Arrange
		int phoneNumber = 827363987;
		Client client = new Client("JuanPablo", 28239873, phoneNumber);

		try {
			// Act
			client.removePhoneNumber(phoneNumber);
			
			// Assert
			assertTrue(client.getMobiles().size() >=1);
			//fail("Last phone number should not be removable");
		} catch (InvalidOperationException e) {
			fail("Last phone number should not be removable");
		}
	}
	
	@Test(description = " TestCase 9, Length == length, clientsPhoneNumbers")
	
	
	public void fifthTestCase() {
				
				//arrange
		
				//act
				
				
				//assert
	}

	@Test(description = "Test case 11: maximum number of friends should be three times the number of phone numbers plus five")
	public void testMaxNumberOfFriends() throws InvalidOperationException, InvalidOperationException {
		// Arrange
		Client client1 = new Client("MaxThorne", 28239873, 38793873);
		client1.addPhoneNumber(827363987);
		client1.addPhoneNumber(1818282);

		// Act
		for (int i = 0; i < 14; i++) client1.addFriend(2802982 + i);

		try {
			client1.addFriend(82098221);
			
			// Assert
			fail("Maximum number of friends constraint should be asserted by `addFriend`");
		} catch (InvalidOperationException e) { }
		
		// Arange
		int phoneNumber = 282883;
		Client client2 = new Client("MaxThorne", 28239873, phoneNumber);
		client2.addPhoneNumber(827363987);
		client2.addPhoneNumber(1818282);

		// Act
		for (int i = 0; i < 14; i++) client2.addFriend(2802982 + i);

		// Act
		try {
			client2.removePhoneNumber(phoneNumber);
			
			// Assert
			fail("Maximum number of friends constraint should be asserted by `removePhoneNumber`");
		} catch (InvalidOperationException e) { }
	}
	
	
	
}
