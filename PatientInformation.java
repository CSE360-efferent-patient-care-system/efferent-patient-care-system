import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PatientInformation extends JPanel{
	
	
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel ageLabel;
	private JLabel genderLabel;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private String[] genderList = {"Male", "Female","Unknown"};
	private String[] monthList = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	private String[] dayList = new String[31];	
	private String[] yearList = new String[101];
			
	private JComboBox genderComboList = new JComboBox(genderList);
	private JComboBox monthComboBox = new JComboBox(monthList);
	private JComboBox dayComboBox;
	private JComboBox yearComboBox;
			


	public PatientInformation() {
		addDays(dayList);
		addYears(yearList);		
		dayComboBox = new JComboBox(dayList);
		yearComboBox = new JComboBox(yearList);
		yearComboBox.setSelectedItem(yearList[100]);
		firstNameLabel = new JLabel("First Name:",SwingConstants.LEFT);    
	    lastNameLabel = new JLabel("Last Name:",SwingConstants.LEFT);
	    ageLabel = new JLabel("Age: MM/DD/YYYY",SwingConstants.LEFT);    
	    genderLabel = new JLabel("Gender:",SwingConstants.LEFT);
	    firstNameField = new JTextField(20);
	    lastNameField = new JTextField(20);
		
	    
	    JPanel testPanel = new JPanel();
	    testPanel.setLayout(new GridLayout(2,2));
	    
	    
	    /***************************************************************************
	     * this starts the name panel information 
	     * *************************************************************************/
	    //panel is a grid layout that handles the name information
	    JPanel namePanel = new JPanel();
	    namePanel.setLayout(new GridLayout(3,0));
		
	    //this will ass the name panel
	    namePanel.add(firstNameLabel);
	    namePanel.add(lastNameLabel);
	    namePanel.add(firstNameField);	    
	    namePanel.add(lastNameField);
	    
	    /***************************************************************************
	     * this starts the gender panel information 
	     * *************************************************************************/
	    //panel is a grid layout that handles the gender information
	    JPanel genderPanel = new JPanel();
	    genderPanel.setLayout(new GridLayout(1,1));
	    genderPanel.add(genderLabel);
	    genderPanel.add(genderComboList);
		
	    /***************************************************************************
	     * this starts the date of age JLabel 
	     * *************************************************************************/
	    //panel is a grid layout that handles the age JLabel 
	    JPanel agePanel = new JPanel();
	    agePanel.setLayout(new GridLayout(1,0)); 
	    agePanel.add(ageLabel);
	    
	    /***************************************************************************
	     * this starts the date of birth panel information 
	     * *************************************************************************/
	    //panel is a grid layout that handles the date of birth information
	    JPanel birthdayPanel = new JPanel();
	    birthdayPanel.setLayout(new GridLayout(0,3));
	    birthdayPanel.add(monthComboBox);
	    birthdayPanel.add(dayComboBox);
	    birthdayPanel.add(yearComboBox);
	    
	    /***************************************************************************
	     * this starts the panel that puts them all together
	     * *************************************************************************/
	    //panel is a grid layout that handles the order of which the panels are put together
	    JPanel togetherPanel = new JPanel();
	    togetherPanel.setLayout(new GridLayout(5,0));
	    togetherPanel.add(testPanel);
	    togetherPanel.add(namePanel);
	    togetherPanel.add(genderPanel);
	    togetherPanel.add(agePanel);
	    togetherPanel.add(birthdayPanel);
	    
	    
	    add(togetherPanel);
	}//end Patient Information Constructor
	
	public String getAge()
	{
		String temp = monthComboBox.getSelectedItem().toString() + 
				      "/" + dayComboBox.getSelectedItem().toString() +
				      "/" + yearComboBox.getSelectedItem().toString();
		
		monthComboBox.setSelectedItem(monthList[0]);
		dayComboBox.setSelectedItem(dayList[0]);
		yearComboBox.setSelectedItem(yearList[100]);
		
		return temp;
	}//end getAge
	
	public String getGender(){
		String temp = genderComboList.getSelectedItem().toString();
		genderComboList.setSelectedItem(genderList[0]);
		return 	temp;
	}//end
	
	public String getFirstName(){
		String temp;
		if (firstNameField.getText().equals(null)){
			return "";
		}
		else {
			temp = firstNameField.getText();
			firstNameField.setText(" ");
			return temp;
		}
		
	}//end
	
	public String getLastName(){
		String temp;
		if (lastNameField.getText().equals(null)){
			return "";
		}
		else {
			temp = lastNameField.getText();
			lastNameField.setText(" ");
			return temp;
		}
	}
	
	private void addDays(String[] dayList){
		for(int i = 0; i < dayList.length;i++){
			dayList[i] = Integer.toString(i+1);			
		}
	}//end addDays list
	
	private void addYears(String[] yearList){
		for(int i = 0;i < yearList.length;i++){
			yearList[i] = Integer.toString(1915+i);
		}
	}//end addYear list
	
}//end patient Information Class
