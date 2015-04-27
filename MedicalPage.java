
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JLabel;


public class MedicalPage extends JApplet{	
	
	private int APPLET_WIDTH = 600, APPLET_HEIGHT = 500;
	private int BUTTON_WIDTH = 250, BUTTON_HEIGHT = 125;
	private JTabbedPane tPane = new JTabbedPane();
	private PatientInformation patientInformation;
	private PatientSymptoms1_5 patientSymptoms1_5;
	private PatientSymptoms6_10 patientSymptoms6_10;
	private PainChart painChart;
	private EmergencyPortal emergencyPortal;
	private DoctorPanel doctorPanel;
	private PatientRecordPanel patientRecordPanel;
	private MedicalAccount medicalAccount;
	private Vector<MedicalAccount> accountList;
	private Vector<String> doctorUsernameArray = new Vector<String>();
	private Vector<String> doctorPasswordArray = new Vector<String>();
	private String currentDoctor;
	private JButton emergencyButton;
	private JButton patientButton;
	private JButton doctorButton;
	private JButton backButton;
	private JButton nextButton;
	private JButton submitButton;
	private JButton doctorLoginButton;
	private JLabel welcomeLabel;
	private JLabel emergencyLabel;
    private int num = 0;
	private Dimension maximumSize = new Dimension(APPLET_WIDTH, APPLET_HEIGHT);	
	private String fileName;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
    //The method init initializes the Applet with a Pane with two tabs
    public void init()
    {
     //list of accounts to be used in every panel
     accountList = new Vector<MedicalAccount>();
     importDoctorCredentials();
     
     //register panel uses the list of accounts
     patientInformation = new PatientInformation();
     patientSymptoms1_5 = new PatientSymptoms1_5();
     patientSymptoms6_10 = new PatientSymptoms6_10();
     doctorPanel = new DoctorPanel(doctorUsernameArray, doctorPasswordArray);
     patientRecordPanel = new PatientRecordPanel();
     painChart = new PainChart(); 
     emergencyPortal = new EmergencyPortal(); 
     
     welcomeLabel = new JLabel("Efferent Patient Care System");
     emergencyLabel = new JLabel("Emergency Portal");
     Font bigFont = new Font("Serif",Font.BOLD,20);
     welcomeLabel.setFont(bigFont);     
     emergencyLabel.setFont(bigFont);
     
     this.add(welcomeLabel).setBounds(175, 0, 400, 100);
     this.add(emergencyLabel).setBounds(225, 0, 400, 100);
     emergencyLabel.setVisible(false);
     //creates the buttons that will give the user options in
     //the beginning of the program
     patientButton = new JButton("Patient Portal");
     doctorButton = new JButton("Doctor Portal");
     emergencyButton = new JButton("Emergncy Portal");
     
     patientButton.setFont(bigFont);
     doctorButton.setFont(bigFont);
     emergencyButton.setFont(bigFont);
     
     //these buttons will dictate what the user is allowed to see 
     //and also allow the program to show only what the user needs to see
     backButton = new JButton("Back");
     nextButton = new JButton("Next");
     
     //this button will submit all the data the user has submitted
     submitButton = new JButton("Submit");
     
     // this button logs in the doctor
     doctorLoginButton = new JButton("Doctor Login ");
     this.add(doctorLoginButton).setBounds(225, 325, 175, 50);
     
     //adds the main buttons to the applet
     this.add(patientButton).setBounds(175,75,BUTTON_WIDTH, BUTTON_HEIGHT);
     this.add(doctorButton).setBounds(175,200,BUTTON_WIDTH,BUTTON_HEIGHT);
     this.add(emergencyButton).setBounds(175, 325, BUTTON_WIDTH, BUTTON_HEIGHT); 
     
     //adds the submits, back, and next buttons but makes them non visible
     this.add(backButton).setBounds(0, 450, 175, 50);
     this.add(nextButton).setBounds(225, 450, 175, 50);
     this.add(submitButton).setBounds(425, 450, 175, 50);
     
     //these buttons will not be visible until needed
     backButton.setVisible(false);
     nextButton.setVisible(false);
     submitButton.setVisible(false);
     doctorLoginButton.setVisible(false);
     
     //create the applet and initiates it
     getContentPane().add(tPane);
     //set Applet size
     setSize(APPLET_WIDTH, APPLET_HEIGHT); 
     this.setMaximumSize(maximumSize );
     
     //button listener will listen for any button 
     //presses and react accordingly to what the user wants
     ButtonListener listener = new ButtonListener();
     patientButton.addActionListener(listener);
     doctorButton.addActionListener(listener);
     emergencyButton.addActionListener(listener);
     nextButton.addActionListener(listener);
     backButton.addActionListener(listener);
     submitButton.addActionListener(listener); 
     doctorLoginButton.addActionListener(listener);
     
    }//end Init
   
   //ButtonListener is a listener class that listens to
   //see if the buttons are pushed. when pushed it decide 
   //to show many panels to initiate for the user to enter 
   //their information
   
   private class ButtonListener implements ActionListener
   {
    
	public void actionPerformed(ActionEvent event)
     {
//////////these if statements control the button configuration and acquisition of information
        //this controls the patient panel directions
    	patientPanelControlCenter(event);
    	
    	//this controls the doctor panel directions
    	doctorPanelControlCenter(event);
    	
    	//this controls the emergency panel directions
    	emergencyPanelControlCenter(event);
    	
    	//this controls the back button directions
    	backButtonControlCenter(event); 
    	
    	if(event.getSource()== doctorLoginButton && doctorPanel.getLoginConfirmation().equals(true)){ 
    		currentDoctor = doctorPanel.getCurrentDoctor();
    		nextButton.setEnabled(true);
    	}    	
    	    	
     } //end of actionPerformed method    
           
	private void backButtonControlCenter(ActionEvent event) {
/////////these buttons control the back button designation for patient portal/////////////// 	
	    if(event.getSource() == backButton && num == 1){
	   	 num = 0;
	   	 panelControlCenter(num);//this will reset all parameters of the program
	    }         
	    else if(event.getSource() == backButton && num == 2){
	   	 num = 1;
	   	 tPane.setSelectedIndex(0);//this selects the previous tab
	   	 
	    }         
	    else if(event.getSource() == backButton && num == 3){
	   	 num = 2;
	   	 tPane.setSelectedIndex(1);//this selects the previous tab
	   	 
	    }
	    else if(event.getSource()== backButton && num == 4){
	   	 num = 3;
	   	 nextButton.setVisible(true);
	   	 submitButton.setVisible(false);
	   	 tPane.setSelectedIndex(2);//this selects the previous tab	   	 
	    }
	/////////these if statements control the doctor back buttons/////////////
	    else if(event.getSource() == backButton && num == 5){
	   	 num = 0;
	   	 panelControlCenter(num);
	    }
	    else if(event.getSource()== backButton && num == 6){
	   	 num = 5;
	   	 nextButton.setVisible(true);
	   	 submitButton.setVisible(false);
	   	 nextButton.setEnabled(false);
	   	 doctorLoginButton.setVisible(true);
	   	 doctorPanel.setPanelToDefault();
	   	 tPane.setSelectedIndex(0);//this selects the previous tab
	   	 
	    }//end else if
   //////////if they are in emergency but want to go back
	    else if(event.getSource() == backButton && num == 7){
	    	num = 0;
	    	panelControlCenter(num);
	    }
	}//end back Button Control Center

	//////////////patient Panel Control Center////////////////////////////////////////////////
	private void patientPanelControlCenter(ActionEvent event){
    	if(event.getSource() == patientButton){
       	 num = 1;
       	 panelControlCenter(num);
        }//end if         
        else if(event.getSource() == nextButton && num == 1){
       	 num = 2;
       	 try{
       		tPane.setSelectedIndex(1); 
       	 }//end try
       	 catch(Exception e){
       		panelControlCenter(num); 
       	 }//end catch       	         	 
        }//end else if         
        else if(event.getSource() == nextButton && num == 2){
       	 num = 3;
       	try{
       		tPane.setSelectedIndex(2); 
       	 }//end try
       	 catch(Exception e){
       		panelControlCenter(num); 
       	 }//end catch
        }//end try         
        else if(event.getSource() == nextButton && num == 3){
       	 num = 4;
       	try{
       		tPane.setSelectedIndex(3);
  		   nextButton.setVisible(false);
 		   submitButton.setVisible(true); 
       	 }//end try
       	 catch(Exception e){
       		panelControlCenter(num);
       	 }//end catch
        }//end try
        else if(event.getSource()== submitButton && num == 4){
 ///////////////////*retrieve patient information and add it to medical account//////////////////////
       	 	
        	accountList.add(new MedicalAccount(patientInformation.getAge(), patientInformation.getGender(),
        			                           patientInformation.getFirstName(), patientInformation.getLastName(), 
        			                           patientSymptoms1_5.getHowTired(), patientSymptoms1_5.getDrowsiness(),
        			                           patientSymptoms1_5.getDepression(), patientSymptoms1_5.getAnxiety(),
        			                           patientSymptoms1_5.getAppetite(), patientSymptoms6_10.getHoursOfSleep(),
        			                           patientSymptoms6_10.getActive(), patientSymptoms6_10.getShortnessofBreath(),
        			                           patientSymptoms6_10.getNausea(), patientSymptoms6_10.getWellBeing(),false,
        			                           painChart.getPainLevel(), painChart.getAdditionalSymptoms(),
        			                           painChart.getPainLocation()));
//        	for(int i = 0;i < accountList.size();i++){
//        		accountList.get(i).printMedicalAccount();
//        		System.out.println("");
//        	}
        	
 ////////////////////////////////////////////////////////////////////////////////////////////////////
       	// return to welcome screen        	 
        	 num = 0;
        	 panelControlCenter(num);
        }//end else if
    }//end patient Panel Control Center
	
//////////doctor Panel Control Center/////////////////////////////////////////////
	private void doctorPanelControlCenter(ActionEvent event) {
		
		if(event.getSource() == doctorButton){
			 nextButton.setEnabled(false);	
	       	 num = 5;
	       	 panelControlCenter(num);
	       	 doctorPanel.setPanelToDefault();
        }//end if
		else if(event.getSource()== nextButton && num == 5){        	
       	 num = 6;
       	 panelControlCenter(num);
       	//sets the vector        	   	 
       	 patientRecordPanel.setVectorList(accountList,currentDoctor);
        }
        else if(event.getSource() == submitButton && num == 6){
///////////////////*retrieve patient information and add it to medical account//////////////////////
        		//TODO get medical info and print it out for doctor
        	
//////////////////////////////////////////////////////////////////////////////////////////////////// 
        	 // return to welcome screen        	 
        	 num = 0;
        	 panelControlCenter(num);
        }//end else if		
	}//end doctor Panel Control Center
	
////////emergency Panel Control Center//////////////////////////////////////////////////////	
	private void emergencyPanelControlCenter(ActionEvent event) {
    	if(event.getSource()== emergencyButton){
    		num = 7;
    		panelControlCenter(num);        	         	 
    	}
    	else if(event.getSource() == submitButton && num == 7){
///////////////////*retrieve patient information and add it to medical account//////////////////////
    		accountList.add(new MedicalAccount(true, emergencyPortal.getPainLevel(), emergencyPortal.getAdditionalSymptoms(),
    										   emergencyPortal.getPainLocation())); 
    		
//    		for(int i = 0;i < accountList.size();i++){
//        		accountList.get(i).printMedicalAccount();
//        		System.out.println("");
//        	}
////////////////////////////////////////////////////////////////////////////////////////////////////
 // return to welcome screen        	 
    		num = 0;
    		panelControlCenter(num);
    	}//end else if		
	}//end emergency Panel Control Center
		    
///////panel control system will control what the user will see//////////////////////////////
///////in regards to what they are trying to do and what information we need/////////////////
    private void panelControlCenter(int num){
 	   
 	   switch (num) {
 	   case 0://resets the welcome screen
 		   patientButton.setVisible(true);
		   doctorButton.setVisible(true);
		   emergencyButton.setVisible(true);
		   tPane.remove(patientInformation);
		   tPane.remove(patientSymptoms1_5);
		   tPane.remove(patientSymptoms6_10);
		   tPane.remove(painChart);
		   tPane.remove(doctorPanel);
		   tPane.remove(patientRecordPanel);
		   tPane.remove(emergencyPortal);
		   backButton.setVisible(false);
		   nextButton.setVisible(false);
		   submitButton.setVisible(false);
		   emergencyLabel.setVisible(false);
		   doctorLoginButton.setVisible(false);
 		   welcomeLabel.setVisible(true);
 		   nextButton.setEnabled(true);
		   
 		   break;
 	   case 1://adds patient Information panel
 		   tPane.addTab("Patient Information", patientInformation);
 		   tPane.setSelectedIndex(0);
 		   patientButton.setVisible(false);
 		   doctorButton.setVisible(false);
 		   emergencyButton.setVisible(false);
 		   backButton.setVisible(true);
 		   nextButton.setVisible(true); 
 		   
 		   break;
 	   case 2://adds patientSymptoms1_5 panel
 		   tPane.addTab("Patient Symptoms1-5", patientSymptoms1_5);
 		   tPane.setSelectedIndex(1);
 		   
 		   break;
 	   case 3://adds patientSymptoms6_10 panel
 		   tPane.addTab("Patient Symptoms 6-10", patientSymptoms6_10);
 		   tPane.setSelectedIndex(2);
		   
 		   break;
 	   case 4://adds painChart panel
 		   tPane.addTab("Pain Chart", painChart);
 		   tPane.setSelectedIndex(3);
 		   painChart.setVisible(true);
 		   backButton.setVisible(true);
 		   nextButton.setVisible(false);
		   submitButton.setVisible(true);
		   
 		   break;
 	  case 5://adds doctorPanel
		   tPane.addTab("Doctor Panel", doctorPanel);
		   tPane.setSelectedIndex(0);
		   patientButton.setVisible(false);
		   doctorButton.setVisible(false);
		   emergencyButton.setVisible(false);
		   doctorLoginButton.setVisible(true);
		   backButton.setVisible(true);
 		   nextButton.setVisible(true);
 		   
		   break;
	   case 6://adds patient Record Panel
		   tPane.addTab("Patient Record Panel", patientRecordPanel);
		   tPane.setSelectedIndex(1);
		   backButton.setVisible(true);
		   nextButton.setVisible(false);
		   doctorLoginButton.setVisible(false);		   
		   submitButton.setVisible(true);
		   
		   break;
 	   case 7://adds emergencyPortal panel
 		   tPane.addTab("Emergency Portal", emergencyPortal);
 		   tPane.setSelectedIndex(0);
 		   emergencyLabel.setVisible(true);
 		   welcomeLabel.setVisible(false);
 		   patientButton.setVisible(false);
		   doctorButton.setVisible(false);
		   emergencyButton.setVisible(false);
		   backButton.setVisible(true);
		   submitButton.setVisible(true);
		   
 		   break; 	   
 	   default:
 		   // N/A to be revised
 		   break;
 	   
 	   }//end switch		   
    }//end panelControlCenter
  } //end of ButtonListener class
   
   //his method imports the doctor credentials such as user names and passwords 
   private void importDoctorCredentials() {
		// The name of the file to open.
	       fileName = "C:/Users/Isaac orellana/Documents/JAVA2/CSE360PhaseIIIProjectDelta/doctorLogin.txt";
	       // This will reference one line at a time
	       String line = null;	       
	       try {	    	   
	           // FileReader reads text files in the default encoding.
	           fileReader = new FileReader(fileName);

	           // Always wrap FileReader in BufferedReader.
	           bufferedReader = new BufferedReader(fileReader);
	           
	           //will go line by line to read the user names and passwords 	
	           while((line = bufferedReader.readLine()) != null) {
       		   String[] separate  = line.split(",");//used to split the user name and password
       		   doctorUsernameArray.addElement(separate[0]);//adds them to the lists
       		   doctorPasswordArray.addElement(separate[1]);        		   
	           }//end while	
       	  // Always close files.
	          bufferedReader.close();            
	       }//end try
	       catch(FileNotFoundException ex) {
	           System.out.println("Unable to open file '" + fileName + "'");                
	       }//end catch
	       catch(IOException ex) {
	           System.out.println("Error reading file '"+ fileName + "'");    
	       }//end catch
	}//end importDoctorCredentials
}//end medical page class
