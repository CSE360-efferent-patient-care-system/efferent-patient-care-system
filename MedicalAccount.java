import javax.swing.JTextArea;



public class MedicalAccount {
	private String age;
	private String gender;
	private String firstName;
	private String lastName;
	private int howTired;
	private int drowsiness;
	private int depression;
	private int anxiety;
	private int appetite;
	private int hoursOfSleep;
	private int active;
	private int shortnessOfBreath;
	private int nausea;
	private int wellbeing;
	private Boolean emergencyPatient;
	private int painLevel;
	private String additionalSymptoms;
	private String painLocation;
	private int priorityLevel;
	private String currentDoctor = "none";
	
	
	public MedicalAccount(String age, String gender, String firstName, String lastName, int howTired,
						  int drowsiness, int depression,	int anxiety, int appetite,
						  int hoursOfSleep, int active, int shortnessOfBreath,	int nausea,
						  int wellbeing,Boolean emergencyPatient,int painLevel, String additionalSymptoms,
						  String painLocation)
	{
		this.age = age;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.howTired = howTired;
		this.drowsiness = drowsiness;
		this.depression = depression;
		this.anxiety = anxiety;
		this.appetite = appetite;
		this.hoursOfSleep = hoursOfSleep;
		this.active = active;
		this.shortnessOfBreath = shortnessOfBreath;
		this.nausea = nausea;
		this.wellbeing = wellbeing;
		this.emergencyPatient = emergencyPatient;
		this.painLevel = painLevel;
		this.additionalSymptoms = additionalSymptoms;
		this.painLocation = painLocation;
		this.priorityLevel = (howTired +drowsiness +depression + anxiety +appetite
							 + hoursOfSleep + active + shortnessOfBreath +
							 nausea + wellbeing + painLevel)/2;
		
	}//end MedicalAccount constructor for regular patients
	
	public MedicalAccount(Boolean emergencyPatient,int painLevel, String additionalSymptoms,
			              String painLocation){		
		this.emergencyPatient = emergencyPatient;
		this.painLevel = painLevel;
		this.additionalSymptoms = additionalSymptoms;
		this.painLocation = painLocation;
		this.priorityLevel = 60;
	}//end MedicalAccount Constructor for emergencies
		
	public String getDoctor(){
		return this.currentDoctor;
	}//end get doctor
		
	public void setDoctor(String doctor) {
		this.currentDoctor = doctor; 
	}//end set doctor	
	
	public Boolean getEmergency(){
		
		return this.emergencyPatient;
	}//end
	
	public int getPriority(){
		return this.priorityLevel;
	}//end
	
	public String printMedicalAccount()
	{
		if(emergencyPatient.equals(false)){
			return "Current doctor assignened: " + this.currentDoctor + "\n"+
				   "Priority of Patient: " + this.priorityLevel + " out of 60"+"\n"+
				   "Name: " + this.lastName + ", " + this.firstName+ "\n"+
				   "Gender: " + this.gender+ "\nDate Of Birth: "+ this.age+"\n"+
				   "How Tired: " + this.howTired +"\n"+
				   "Drowsiness: " + this.drowsiness +"\n"+
				   "Depression: " + this.depression  +"\n"+
				   "Anxiety: " + this.anxiety +"\n"+
				   "Appetite: " + this.appetite +"\n"+
				   "Hours Of Sleep: " + this.hoursOfSleep +"\n"+
				   "Active: " + this.active + "\n"+
				   "Shortness Of Breath: " + this.shortnessOfBreath +"\n"+
				   "Nausea: " + nausea +"\n"+
				   "Wellbeing: " + this.wellbeing +"\n"+
				   "PainLevel: " + this.painLevel +"\n"+
				   "PainLocation: " + this.painLocation +"\n"+
				   "AdditionalSymptoms: " + additionalSymptoms +"\n";
		}//end if
		else{
			return  "Current doctor assignened: " + this.currentDoctor + "\n"+
					"EMERGENCY PATIENT: THIS PATIENT TAKES PRIORITY"+"\n"+
					"Pain Level: " + this.painLevel + "\n"+
					"Pain Location: " + this.painLocation + "\n"+
					"Additional Symptoms: " + additionalSymptoms +"\n";
		}//end else
	}//end printMedicalAccount
}//end MedicalAccount class
