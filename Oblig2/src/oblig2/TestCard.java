package oblig2;

import java.util.ArrayList;

public class TestCard {
	public static void main(String[] args){
		ArrayList<Card> cardList = new ArrayList<Card>();
		
		cardList.add(new Employee("Ole", "Olsen", "1234"));
		cardList.add(new Guest("Marit Olsen"));
		
		for(Card card : cardList){
			System.out.println(card);
			System.out.println("PIN 1234 is " + (card.checkPIN("1234") ? "valid" : "invalid"));
			System.out.println("PIN 9999 is " + (card.checkPIN("9999") ? "valid" : "invalid"));
			System.out.println();
		}
		
	}
}
