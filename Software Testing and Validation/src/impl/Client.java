package impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import exceptions.DuplicateNIFException;
import exceptions.InvalidOperationException;

public class  Client {
	static Set<Integer> nifs = new HashSet<Integer>();

	String name;
	Integer nif;
	Set<Integer> phoneNumbers = new HashSet<Integer>();
	Set<Integer> friends = new HashSet<Integer>();
	Map<Integer, Mobile> mobiles = new HashMap<Integer, Mobile>();

	public Client(String name, int nif, int phoneNumber) throws DuplicateNIFException {
		if (name.length() < 5) {
			throw new IllegalArgumentException("Name too short");
		}
		
		if (!nifs.add(nif)) {
			throw new DuplicateNIFException();
		}

		this.name = name;
		this.nif = nif;
		this.phoneNumbers.add(phoneNumber);
	}

	// Management of the phone numbers of this client
	public void addPhoneNumber(int phoneNumber) throws InvalidOperationException {
		if (phoneNumbers.size() >= 5) {
			throw new InvalidOperationException("Maximum number of phones exceeded");
		}
		
		if (!phoneNumbers.add(phoneNumber)) {
			throw new InvalidOperationException("Phone number already exists");
		}
	}

	public void removePhoneNumber(int phoneNumber) throws InvalidOperationException {
		if (phoneNumbers.size() <= 1) {
			throw new InvalidOperationException("Cannot remove principal phone number");
		}

		if (friends.size() > (this.phoneNumbers.size() - 1) * 3 + 5) {
			throw new InvalidOperationException("Maximum number of friends exceeded");
		}

		if (!phoneNumbers.remove(phoneNumber)) {
			throw new InvalidOperationException("Phone number not found");
		}
	}

	// returns the phone numbers assigned to this client.
	public List<Integer> getPhoneNumbers() {
		return new ArrayList<Integer>(phoneNumbers);
	}

	// returns name of client
	public String getName() {
		return name;
	}

	// return list of registered friends
	public List<Integer> getFriends() {
		return new ArrayList<Integer>(friends);
	}

	// friends management
	public void addFriend(int phoneNumber) throws InvalidOperationException {
		if (friends.size() + 1 > this.phoneNumbers.size() * 3 + 5) {
			throw new InvalidOperationException("Maximum number of friends exceeded");
		}
		
		if (!friends.add(phoneNumber)) {
			throw new InvalidOperationException("Friend already exists");
		}
	}

	public void removeFriend(int phoneNumber) throws InvalidOperationException {
		if (!friends.remove(phoneNumber)) {
			throw new InvalidOperationException("Friend not found");
		}
	}
	
	// registers a phoneNumber of this client to a given type of mobile phone.
	public Mobile registerMobile(int phoneNumber) throws InvalidOperationException {
		if (!phoneNumbers.contains(phoneNumber)) {
			throw new InvalidOperationException("Phone number does not belong to client");
		}
		
		Mobile mobile = new Mobile(this, phoneNumber);
		
		mobiles.put(phoneNumber, mobile);
		
		return mobile;
	}

	// unregisters the mobile phone associated with phoneNumber
	public void unregisterMobile(int phoneNumber) throws InvalidOperationException {
		if (mobiles.remove(phoneNumber) == null) {
			throw new InvalidOperationException("Mobile not found");
		}
	}

	// returns the mobiles of this client
	public List<Mobile> getMobiles() {
		return new ArrayList<Mobile>(mobiles.values());
	}
}
