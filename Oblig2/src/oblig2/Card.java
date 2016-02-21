package oblig2;

import java.util.ArrayList;

public abstract class Card {
	private static ArrayList<String> cardNumbers = new ArrayList<String>();
	private String cardNumber;
	private String firstName;
	private String surName;
	private boolean cardLocked;
	//Aksesskode?
	
	public abstract boolean checkPIN(String pin);

	public Card(String fName, String sName){
		firstName = fName;
		surName = sName;
		cardLocked = false;
		while(true){
			String temp = Integer.toString((int)(Math.random()*100000000));
			if(!cardNumbers.contains(temp))
				cardNumber = temp;
				break;
		}
	}
	
	public String getName(){
		return firstName + " " + surName;
	}
	
	protected void lockCard(){
		cardLocked = true;
	}
		
	public boolean isLocked(){
		return cardLocked;
	}
	
	public String toString(){
		return getName() + ", " + cardNumber + ", " + "\nSperret: " + cardLocked;
	}
}
