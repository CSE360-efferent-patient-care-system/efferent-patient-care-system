
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MedicalPage extends JApplet{
	private int APPLET_WIDTH = 600, APPLET_HEIGHT = 500;
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
	private MedicalAccount medicalaccount;

			
//The method init initializes the Applet with a Pane with two tabs
   public void init()
    {
	   
     //list of accounts to be used in every panel
     accountList = new Vector();
     int num = 0;

     //register panel uses the list of accounts
     patientInformation = new PatientInformation(accountList,num);
     patientSymptoms1_5 = new PatientSymptoms1_5(accountList,num);
     patientSymptoms6_10 = new PatientSymptoms6_10(accountList,num);
     painChart = new PainChart(accountList,num);
     emergencyPortal = new EmergencyPortal(accountList,num);
     doctorPanel = new DoctorPanel(accountList,num);
     patientRecordPanel = new PatientRecordPanel(accountList,num);

     //create a tabbed pane with two tabs
     tPane = new JTabbedPane();               
     
     patientButton = new JButton("Patient Portal");
     doctorButton = new JButton("Doctor Portal");
     emergencyButton = new JButton("Emergncy Portal");
     
    
     getContentPane().add(tPane);
     setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
    }
   
   //ButtonListener is a listener class that listens to
   //see if the buttons are pushed. when pushed it decide 
   //to show many panels to initiate for the user to enter 
   //their information
   
   private class ButtonListener implements ActionListener
   {    	   
	   public void actionPerformed(ActionEvent event){
         

     } //end of actionPerformed method
  } //end of ButtonListener class
   
   
   //main class will handle what the user gets to see
   protected class Main {
	   public void main (String[] args){
		   
		   
	   }//end main
	   
	   public void logIn(int num){
	   
	   switch (num) {
	   case 0: 
		   
		   break;
	   case 1: 
		   tPane.addTab("Patient Information", patientInformation);
		   break;
	   case 2:
		   tPane.addTab("Patient Symptoms1-5", patientSymptoms1_5);
		   break;
	   case 3:
		   tPane.addTab("Pain Chart", painChart);
		   break;
	   case 4:
		   tPane.addTab("Emergency Portal", emergencyPortal);
		   break;
	   case 5:
		   tPane.addTab("Doctor Panel", doctorPanel);
		   break;
	   case 6:
		   tPane.addTab("Patient Record Panel", patientRecordPanel);
		   break;
	   default:
		   
		   break;
	   
	   }//end switch		   
   }//end logIn
 }//end main class   
}//end medical page class
