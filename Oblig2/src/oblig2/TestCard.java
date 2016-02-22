package oblig2;

import java.util.ArrayList;
import java.util.Collections;

public class TestCard {
	public static void main(String[] args){
		ArrayList<Card> cardList = new ArrayList<Card>();
		
		cardList.add(new Employee("Ole", "Olsen", "1234", 148.72f, 4));
		cardList.add(new Guest("Marit Hagen"));
		cardList.add(new Guest("Are Bjerken"));
		
		//Testing if cloning works
		try {
			cardList.add((Employee)(cardList.get(0).clone()));
			cardList.add((Guest)(cardList.get(2).clone()));
		} catch (CloneNotSupportedException e) {
			System.out.println("Cloning went wrong.");
			e.printStackTrace();
		} finally {
			//Why am I allowed to access protected method from a non-child class?
			cardList.get(3).setFirstName("Arne");
			cardList.get(4).setSurName("Bjerkmo");
			((Guest)cardList.get(4)).extendExpiration(2);
		}
		
		Collections.sort(cardList);
		
		for(Card card : cardList){
			System.out.println(card);
			System.out.println("PIN 1234 is " + (card.checkPIN("1234") ? "valid" : "invalid"));
			System.out.println("PIN 9999 is " + (card.checkPIN("9999") ? "valid" : "invalid")); //Returns valid between 7:00 and 17:00
			System.out.println();
		}
		
	}
}
