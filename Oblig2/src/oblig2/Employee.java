package oblig2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee extends Card {
	private String PIN;
	private int attempts;

	public Employee(String fName, String sName, String pin){
		super(fName, sName);
		//LATER: Add pin input validation for 4-digit pins...
		PIN = pin;
	}
	
	public Employee(String name, String pin){
		super(name);
		PIN = pin;
	}
	
	//Later: private boolean validatePIN(String pin){....}

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

}
