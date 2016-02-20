package oblig2;

import java.util.ArrayList;

public abstract class Card {
	private static ArrayList<String> cardNumbers = new ArrayList<String>();
	private String cardNumber;
	private String firstName;
	private String surName;
	private String PIN;
	private boolean cardLocked;
	//Aksesskode?
	
	public abstract boolean checkPIN(int pin);

	public Card(){
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
	
	public boolean isLocked(){
		return cardLocked;
	}
	
	public String toString(){
		return getName() + ", " + cardNumber + ", " + PIN + "\nSperret: " + cardLocked;
	}
}
