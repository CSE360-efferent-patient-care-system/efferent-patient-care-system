import java.util.Vector;


public class MedicalAccount {
	public Vector accountList;
	private String age;
	private String firstName;
	private String lastName;
	private String howTired;
	private String drowsiness;
	private String depression;
	private String anxiety;
	private String appetite;
	private String hoursOfSleep;
	private String active;
	private String shortnessOfBreath;
	private String nausea;
	private String wellbeing;
	private Boolean emergencyPatient;
	
	
	public MedicalAccount(Vector accountList)
	{
		
	}
	
	
	public MedicalAccount(Vector accountList, int num)
	{
		
		
		
		
	}
	public String getAge()
	{
		return this.age;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public String getHowTired()
	{
		return this.howTired;
		
	}
	public String getDrowsiness()
	{
		return this.drowsiness;
	}
	public String getDepression()
	{
		return this.depression;
	}
	public String getAnxiety()
	{
		return this.anxiety;
	}
	public String getAppetite()
	{
		return this.appetite;
	}
	public String getHoursOfSleep()
	{
		return this.hoursOfSleep;
	}
	public String getActive()
	{
		return this.active;
	}
	public String getShortnessofBreath()
	{
		return this.shortnessOfBreath;
	}
	public String getNausea()
	{
		return this.nausea;
	}
	public String getWellBeing()
	{
		return this.wellbeing;
	}
	/*public String toString()
	{
		
	}
*/
}
