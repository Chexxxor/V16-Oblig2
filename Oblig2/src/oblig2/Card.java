package oblig2;

import java.util.ArrayList;
import java.util.InputMismatchException;

public abstract class Card {
	private static ArrayList<String> cardNumbers = new ArrayList<String>();
	private String cardNumber;
	private String firstName;
	private String surName;
	private boolean cardLocked;
	//Aksesskode?
	
	public abstract boolean checkPIN(String pin);

	public Card(String fName, String sName) throws InputMismatchException {
		if(fName.isEmpty() || sName.isEmpty())
			throw new InputMismatchException("Both input strings must be non-empty.");
		firstName = fName;
		surName = sName;
		makeCardNumber();
	}
	
	public Card(String name) throws InputMismatchException {
		if(name.trim().length() < 3)
			throw new InputMismatchException("String must be at least 3 characters long.");
		setFullName(name.trim());
		makeCardNumber();
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
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getSurName(){
		return surName;
	}
	
	public String getFullName(){
		return firstName + " " + surName;
	}

	protected void setFullName(String name) throws InputMismatchException {
		if(name.contains(" ")){
			int spacePos = name.lastIndexOf(' ');
			firstName = name.substring(0, spacePos);
			surName = name.substring(spacePos+1, name.length());
		}
		else
			throw new InputMismatchException("Names must be separated by whitespace character ' '.");
	}
	
	protected void setFirstName(String name){
		firstName = name;
	}
	
	protected void setSurName(String name){
		surName = name;
	}
	
	protected void lockCard(){
		cardLocked = true;
	}
		
	public boolean isLocked(){
		return cardLocked;
	}
	
	@Override
	public String toString(){
		return getFullName() + ", " + cardNumber + "\nLocked: " + cardLocked;
	}
}
