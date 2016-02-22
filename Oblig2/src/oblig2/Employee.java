package oblig2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee extends Card implements Constants {
	private String PIN;
	private int attempts;
	private float wage;
	private int seniority;

	public Employee(String fName, String sName, String pin, float wage, int seniority){
		super(fName, sName);
		//LATER: Set pins with validatePIN method or make isValidPIN method before setting value
		PIN = pin;
		this.wage = wage;
		this.seniority = seniority;
	}
	
	public Employee(String name, String pin){
		super(name);
		PIN = pin;
	}
	
	//LATER: private boolean validatePIN(String pin){....}

	@Override
	public boolean checkPIN(String pin) {
		Calendar now = new GregorianCalendar();
		int hour = now.get(GregorianCalendar.HOUR_OF_DAY);
		if((hour < 17 && hour >= 7 || PIN.equals(pin)) && !isLocked()){
			attempts = 0;
			return true;
		}
		//3 wrong attempts outside hours leads to a cardLock.
		else if((hour >= 17 && hour < 7 && !PIN.equals(pin)) && !isLocked()){
			attempts++;
			if(attempts>=3)
				lockCard();
		}
		return false;
	}
	
	@Override
	public double calculateCredit(){
		return wage*CREDIT_FACTOR;
	}
	
	@Override
	public int calculateBonus(){
		return seniority*BONUS_FACTOR;
	}
	
	@Override
	public String toString(){
		return super.toString() + String.format("\nCredit:\t%.2f\nBonus:\t%d",calculateCredit(), calculateBonus());
	}
}
