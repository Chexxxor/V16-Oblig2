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
		makeCardNumber();
	}
	
	public Card(String name){
		if(name.contains(" ")){
			int spacePos = name.lastIndexOf(' ');
			firstName = name.substring(0, spacePos);
			surName = name.substring(spacePos+1, name.length());
			makeCardNumber();
		}
	}
	
	private void makeCardNumber(){
		cardLocked = false;
		while(true){
			String temp = Integer.toString((int)(Math.random()*100000000));
			while(temp.length() < 8) //Ensure 8 digits
				temp = "0" + temp;
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
		return getName() + ", " + cardNumber + "\nSperret: " + cardLocked;
	}
}
