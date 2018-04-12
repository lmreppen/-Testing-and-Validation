package StvPackage;


import java.util.ArrayList;

import java.util.UUID;

public class Client {
	
	
	UUID number;
	String name;
	ArrayList<String> phoneNumbers;
	ArrayList<String> clientPhones;
	ArrayList<String> clientsFriends;
	
	public Client() {
		
	}
	
	public UUID getUUID() {
		
		return number;
		
	}
	
	public String getClientsName() {
		return name;
	}
	
	public ArrayList<String> getPhoneNumbers() throws Exception {
		if(phoneNumbers.size() > 0 && phoneNumbers.size() < 5) {
			return phoneNumbers;
		}
		
		throw new Exception("whateves");
	}
	
	public ArrayList<String> getClientsPhones() throws Exception{
		if(clientPhones.size() == phoneNumbers.size()) {
			return clientPhones;
		}
		throw new Exception("this");
	}

	
	public ArrayList<String> getClientsFriends() throws Exception{
		if(clientsFriends.size() <= 3* phoneNumbers.size() ) {
			return clientsFriends;
		}
		throw new Exception("");
	}
}
