package oblig2;

public interface Constants {
	public static final double CREDIT_FACTOR = 0.67;
	public static final int BONUS_FACTOR = 20000;
	
	//Moved these methods into the Card class. It makes little sense to only implement them in the Employee class
	//since they are going to be needed in both Employee AND Guest class for the compareTo() methods.
	//The remaining methods should NOT be implemented in the Guest class, thus the need to separate the two groups of methods.

	/*public String getFirstName();
	public String getSurName();
	public String getFullName();
	public void setFirstName();
	public void setSurName();
	public void setFullName();*/
	
	public double calculateCredit();
	public int calculateBonus();
}
