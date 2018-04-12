package StvPackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class InvalidOperationException extends Exception {
	InvalidOperationException() {
		super();
	}
	
	InvalidOperationException(String msg) {
		super(msg);
	}
}

class InvalidNumberPhoneException extends Exception {
	InvalidNumberPhoneException() {
		super();
	}
	
	InvalidNumberPhoneException(String msg) {
		super(msg);
	}
}

public class  Client {
	String name;
	Integer nif;
	Set<Integer> phoneNumbers = new HashSet<Integer>();
	Set<Integer> friends = new HashSet<Integer>();

	Client(String name, int nif, int phoneNumber) {
		this.name = name;
		this.nif = nif;
		this.phoneNumbers.add(phoneNumber);
	}

	// Management of the phone numbers of this client
	void addPhoneNumber(int phoneNumber) throws InvalidOperationException {
		if (this.phoneNumbers.size() >= 5) {
			throw new InvalidOperationException("Maximum number of phones exceeded");
		}
		
		if (!this.phoneNumbers.add(phoneNumber)) {
			throw new InvalidOperationException("Phone number already exists");
		}
	}

	void removePhoneNumber(int phoneNumber) throws InvalidOperationException {
		if (this.phoneNumbers.size() <= 1) {
			throw new InvalidOperationException("Cannot remove principal phone number");
		}

		if (!this.phoneNumbers.remove(phoneNumber)) {
			throw new InvalidOperationException("Phone number not found");
		}
	}

	// returns the phone numbers assigned to this client.
	public List<Integer> getPhoneNumbers() {
		return new ArrayList<Integer>(this.phoneNumbers);
	}

	// returns name of client
	public String getName() {
		return this.name;
	}

	// return list of registered friends
	public List<Integer> getFriends() {
		return new ArrayList<Integer>(this.friends);
	}

	// friends management
	public void addFriend(int phoneNumber) throws InvalidNumberPhoneException {
		if (this.friends.size() + 1 >= this.phoneNumbers.size() * 3 + 1) {
			throw new InvalidNumberPhoneException("Maximum number of friends exceeded");
		}
	}

	public void removeFriend(int phoneNumber) throws InvalidOperationException {
		if (!this.friends.remove(phoneNumber)) {
			throw new InvalidOperationException("Friend not found");
		}
	}
}
