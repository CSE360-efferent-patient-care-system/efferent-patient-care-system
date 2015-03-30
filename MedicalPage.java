
import javax.swing.*;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MedicalPage extends JApplet{
	private int APPLET_WIDTH = 600, APPLET_HEIGHT = 500;
	private int BUTTON_WIDTH = 250, BUTTON_HEIGHT = 125;
	private JTabbedPane tPane;
	private PatientInformation patientInformation;
	private PatientSymptoms1_5 patientSymptoms1_5;
	private PatientSymptoms6_10 patientSymptoms6_10;
	private PainChart painChart;
	private EmergencyPortal emergencyPortal;
	private DoctorPanel doctorPanel;
	private PatientRecordPanel patientRecordPanel;	
	private Vector accountList;
	private JButton emergencyButton;
	private JButton patientButton;
	private JButton doctorButton;
	private JButton backButton;
	private JButton nextButton;
	private JButton submitButton;
	private JLabel welcome;   
    private int num = 0;
			
//The method init initializes the Applet with a Pane with two tabs
   public void init()
    {
     //list of accounts to be used in every panel
     accountList = new Vector<MedicalAccount>();

     //register panel uses the list of accounts
     patientInformation = new PatientInformation(accountList,num);
     patientSymptoms1_5 = new PatientSymptoms1_5(accountList,num);
     patientSymptoms6_10 = new PatientSymptoms6_10(accountList,num);
     painChart = new PainChart(accountList,num);
     emergencyPortal = new EmergencyPortal(accountList,num);
     doctorPanel = new DoctorPanel(accountList,num);
     patientRecordPanel = new PatientRecordPanel(accountList,num);
     welcome = new JLabel("Efferent Patient Care System");
     welcome.setFont(new Font("Serif",Font.BOLD,20));
     //create a tabbed pane with two tabs
     tPane = new JTabbedPane(); 
     
     this.add(welcome).setBounds(175, 0, 400, 100);
     //creates the buttons that will give the user options in
     //the beginning of the program
     patientButton = new JButton("Patient Portal");
     doctorButton = new JButton("Doctor Portal");
     emergencyButton = new JButton("Emergncy Portal");
     
     //these buttons will dictate what the user is allowed to see 
     //and also allow the program to show only what the user needs to see
     backButton = new JButton("Back");
     nextButton = new JButton("Next");
     
     //this button will submit all the data the user has submitted
     submitButton = new JButton("Submit");
     
     //adds the main buttons to the applet
     this.add(patientButton).setBounds(175,75,BUTTON_WIDTH, BUTTON_HEIGHT);
     this.add(doctorButton).setBounds(175,200,BUTTON_WIDTH,BUTTON_HEIGHT);
     this.add(emergencyButton).setBounds(175, 325, BUTTON_WIDTH, BUTTON_HEIGHT); 
     
     //adds the submits, back, and next buttons but makes them non visible
     this.add(backButton).setBounds(0, 450, 175, 50);
     this.add(nextButton).setBounds(425, 450, 175, 50);
     this.add(submitButton).setBounds(425, 450, 175, 50);
     
     //these buttons will not be visible until needed
     backButton.setVisible(false);
     nextButton.setVisible(false);
     submitButton.setVisible(false);
     
     //create the applet and initiates it
     getContentPane().add(tPane);
     setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
     
     //button listener will listen for any button 
     //presses and react accordingly to what the user wants
     ButtonListener listener = new ButtonListener();
     patientButton.addActionListener(listener);
     doctorButton.addActionListener(listener);
     emergencyButton.addActionListener(listener);
     nextButton.addActionListener(listener);
     backButton.addActionListener(listener);
     submitButton.addActionListener(listener);
     
    }
   
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
                  

     } //end of actionPerformed method
    
/////////these buttons control the back button designation for patient portal///////////////        
	private void backButtonControlCenter(ActionEvent event) {
	
	    if(event.getSource() == backButton && num == 1){
	   	 num = 0;
	   	 panelControlCenter(num);
	    }         
	    else if(event.getSource() == backButton && num == 2){
	   	 num = 1;
	   	 //set the current tab code here
	   	 
	    }         
	    else if(event.getSource() == backButton && num == 3){
	   	 num = 2;
	   	//set the current tab code here
	   	 
	    }
	    else if(event.getSource()== backButton && num == 4){
	   	 num = 3;
	   	 nextButton.setVisible(true);
	   	 submitButton.setVisible(true);
	   	//set the current tab code here
	   	 
	    }
	/////////these if statements control the doctor back buttons/////////////
	    else if(event.getSource() == backButton && num == 5){
	   	 num = 0;
	   	 panelControlCenter(num);
	    }
	    else if(event.getSource()== backButton && num == 6){
	   	 num = 5;
	   	nextButton.setVisible(true);
	   	 submitButton.setVisible(true);
	   	//set the current tab code here
	   	 
	    }//end else if		
	}//end back Button Control Center

	//////////////patient Panel Control Center////////////////////////////////////////////////
	public void patientPanelControlCenter(ActionEvent event){
    	if(event.getSource() == patientButton){
       	 num = 1;
       	 panelControlCenter(num);
        }         
        else if(event.getSource() == nextButton && num == 1){
       	 num = 2;
       	 panelControlCenter(num);        	 
        }         
        else if(event.getSource() == nextButton && num == 2){
       	 num = 3;
       	 panelControlCenter(num);
        }         
        else if(event.getSource() == nextButton && num == 3){
       	 num = 4;
       	 panelControlCenter(num);
        }
        else if(event.getSource()== submitButton && num == 4){
       	 /*retrieve patient information and add it to medical account
       	 
       	 */
       	// return to welcome screen        	 
        	 num = 0;
        	 panelControlCenter(num);
        }//end else if
    }//end patient Panel Control Center
	
//////////doctor Panel Control Center/////////////////////////////////////////////
	private void doctorPanelControlCenter(ActionEvent event) {
		
		if(event.getSource() == doctorButton){
       	 num = 5;
       	 panelControlCenter(num);
        }
        else if(event.getSource()== nextButton && num == 5){
       	 num = 6;
       	 panelControlCenter(num);
        }
        else if(event.getSource() == submitButton && num == 6){
       	 /* retrieve doctor transfer request
       	 
        	 */
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
    		/*retrieve emergency request and add it to medical account
   	 
    		 */
    		// return to welcome screen        	 
    		num = 0;
    		panelControlCenter(num);
    	}//end else if		
	}//end emergency Panel Control Center
    
///////panel control system will control what the user will see//////////////////////////////
///////in regards to what they are trying to do and what information we need/////////////////
    public void panelControlCenter(int num){
 	   
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
		   
 		   break;
 	   case 1://adds patient Information panel
 		   tPane.addTab("Patient Information", patientInformation);
 		   patientButton.setVisible(false);
 		   doctorButton.setVisible(false);
 		   emergencyButton.setVisible(false);
 		   backButton.setVisible(true);
 		   nextButton.setVisible(true); 
 		   
 		   break;
 	   case 2://adds patientSymptoms1_5 panel
 		   tPane.addTab("Patient Symptoms1-5", patientSymptoms1_5);
 		   patientSymptoms1_5.setVisible(true);
 		   
 		   break;
 	   case 3://adds patientSymptoms6_10 panel
 		   tPane.addTab("Patient Symptoms 6-10", patientSymptoms6_10);
		   patientSymptoms6_10.setVisible(true);
		   
 		   break;
 	   case 4://adds painChart panel
 		   tPane.addTab("Pain Chart", painChart);
 		   painChart.setVisible(true);
 		   backButton.setVisible(true);
 		   nextButton.setVisible(false);
		   submitButton.setVisible(true);
		   
 		   break;
 	  case 5://adds doctorPanel
		   tPane.addTab("Doctor Panel", doctorPanel);
		   doctorPanel.setVisible(true);
		   patientButton.setVisible(false);
		   doctorButton.setVisible(false);
		   emergencyButton.setVisible(false);
		   backButton.setVisible(true);
 		   nextButton.setVisible(true);
 		   
		   break;
	   case 6://adds patient Record Panel
		   tPane.addTab("Patient Record Panel", patientRecordPanel);
		   patientRecordPanel.setVisible(true);
		   backButton.setVisible(true);
		   nextButton.setVisible(false);
		   submitButton.setVisible(true);
		   
		   break;
 	   case 7://adds emergencyPortal panel
 		   tPane.addTab("Emergency Portal", emergencyPortal);
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
}//end medical page class
