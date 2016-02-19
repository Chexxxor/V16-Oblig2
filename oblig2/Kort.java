package oblig2;

import java.util.ArrayList;

public abstract class Kort {
	private static ArrayList<String> kortnummerListe = new ArrayList<String>();
	private String kortnummer;
	private String forNavn;
	private String etterNavn;
	private String PIN;
	private boolean sperretKort;
	//Aksesskode?
	
	public abstract boolean sjekkPIN(int pin);

	public Kort(){
		sperretKort = false;
		while(true){
			String temp = Integer.toString((int)(Math.random()*100000000));
			if(!kortnummerListe.contains(temp))
				kortnummer = temp;
				break;
		}
	}
	
	public String getNavn(){
		return forNavn + " " + etterNavn;
	}
	
	public boolean isSperret(){
		return sperretKort;
	}
	
	public String toString(){
		return getNavn() + ", " + kortnummer + ", " + PIN + "\nSperret: " + sperretKort;
	}
}
