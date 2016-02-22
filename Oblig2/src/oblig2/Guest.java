package oblig2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Guest extends Card {
	Calendar expires;

	public Guest(String fName, String sName) {
		super(fName, sName);
		refreshExpiration();
	}
	
	public Guest(String name){
		super(name);
		refreshExpiration();
	}
	
	private void refreshExpiration(){
		expires = new GregorianCalendar();
		expires.add(Calendar.DAY_OF_MONTH, 7);
	}
	
	public void extendExpiration(int days){
		expires.add(Calendar.DAY_OF_MONTH, days);
	}

	@Override
	public boolean checkPIN(String pin) {
		Calendar now = new GregorianCalendar();
		if(!isLocked() &&
				pin.equals("9999") &&
				expires.after(now))
			return true;
		//Lock the card if attempted use after expiration
		if(expires.before(now))
			lockCard();
		return false;
	}
	
	@Override
	public String toString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		return super.toString() + "\nExpires: " + dateFormat.format(expires.getTime());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Guest guest = (Guest)(super.clone());
		guest.expires = (GregorianCalendar)expires.clone();
		return guest;
	}

}
