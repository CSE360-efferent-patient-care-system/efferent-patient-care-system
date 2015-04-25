import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyledEditorKit.BoldAction;

public class PatientRecordPanel extends JPanel{
	private Vector<MedicalAccount> accountList = new Vector<MedicalAccount>();
	private JLabel spaceLabel = new JLabel("                                 ",SwingConstants.RIGHT);
	private String currentDoctor;
	private JButton viewpatientButton = new JButton("View Patient details");
	private JButton transferButton = new JButton("Transfer Patient");
	private JButton removeButton = new JButton("Retract Patient");
	private JLabel patients = new JLabel("Current Patients:");	
	private JTextArea patientInfoArea = new JTextArea(15,35);
	private Font font = new Font("Serif",Font.BOLD,20);
	private int MAX = 0;
	private String[] patientPriority;
	private JComboBox<String> patientsComboList;
	private JScrollPane scrollArea = new JScrollPane(patientInfoArea);
	private TitledBorder additionalSymptomsBorder =  BorderFactory.createTitledBorder("Currently Selected Patient Information:");

	public PatientRecordPanel() {		
		
		//button listener will listen for any button 
	    //presses and react accordingly to what the user wants
	    ButtonListener listener = new ButtonListener();
		transferButton.addActionListener(listener);
		removeButton.addActionListener(listener);
		viewpatientButton.addActionListener(listener);
		
	}//end PatientRecordPanel constructor

	private void setPanel() {
		//makes the panel to add to the Applet		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(viewpatientButton);
		buttonPanel.add(transferButton);
		buttonPanel.add(removeButton);
		
		JPanel spacePanel = new JPanel();
		spacePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		spacePanel.add(spaceLabel);
		
		JPanel patientsPanel = new JPanel();
		patientsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		patientsPanel.add(patients);
		
		
		JPanel patientsAvailable = new JPanel();
		patientsAvailable.setLayout(new BoxLayout(patientsAvailable,BoxLayout.PAGE_AXIS));
		patientsAvailable.add(spacePanel);
		patientsAvailable.add(patientsPanel);
		patientsAvailable.add(patientsComboList);
		patientsAvailable.add(buttonPanel);

		
		JPanel additionalnfoPanel = new JPanel();
	    additionalnfoPanel.setLayout(new BoxLayout(additionalnfoPanel,BoxLayout.PAGE_AXIS));
	    additionalnfoPanel.add(patientsAvailable);
	    additionalnfoPanel.add(scrollArea);		
		
		
		//this.add(patientsAvailable);
		this.add(additionalnfoPanel);
	}
	
	//checks to see how many elements in the account array
	private void howMany(){
		//checks to see how many patients
		for(int i = 0; i < accountList.size(); i++){			
			MAX++;
		}//end for  
		//makes the max for the priority array
		patientPriority = new String[MAX];			
	}
	
	//checks how many patients in the list	and adds them to combo box
	public void setVectorList(Vector<MedicalAccount> accountList,String currentDoctor){
		//instantiates objects
		this.currentDoctor = currentDoctor;
		this.accountList = accountList;
		howMany();//calls this to set max array
		
		//adds all patients to array
		for(int i = 0; i < accountList.size(); i++){
			int temp = i+1;
			patientPriority[i] = "Patient "+ temp + " Emergency Patient: "+accountList.get(i).getEmergency();
		}//end for	
						
		//adds the list to the combo box
		patientsComboList = new JComboBox<String>(patientPriority);
		//changes the font type		
		patientsComboList.setFont(new Font("Serif",Font.BOLD,15));
		patientsComboList.setSize(10, 25);
		
		//prints out the first patient
		if(!accountList.isEmpty()){
			patientInfoArea.setText(accountList.get(patientsComboList.getSelectedIndex()).printMedicalAccount());
		}//end if
		
		//sets the fonts of the labels
		spaceLabel.setFont(font);
		patients.setFont(font);
		
		//sets the way the patientInfoArea is printed
		patientInfoArea.setText(" ");
		patientInfoArea.setEditable(false);
		patientInfoArea.setLineWrap(true);
		patientInfoArea.setWrapStyleWord(true);
		additionalSymptomsBorder.setTitleColor(Color.BLUE);
		scrollArea.setEnabled(true);
		scrollArea.setBorder(additionalSymptomsBorder);
		
		//sets the size of the buttons
		transferButton.setSize(10, 15);
		removeButton.setSize(10, 15);
		viewpatientButton.setSize(10, 15);
		setPanel();
	}//end setVectorList
			
	//this will transfer the patient to the doctor
	private class ButtonListener implements ActionListener{	
		@Override
		public void actionPerformed(ActionEvent action) {
			// TODO Auto-generated method stub
			if(!accountList.isEmpty()){
				if(action.getSource().equals(viewpatientButton)){
				patientInfoArea.setText(accountList.get(patientsComboList.getSelectedIndex()).printMedicalAccount());
				}//end if
				
				if(action.getSource().equals(transferButton)){
					accountList.get(patientsComboList.getSelectedIndex()).setDoctor(currentDoctor);
				}//end if
				
				if(action.getSource().equals(removeButton)){
					accountList.get(patientsComboList.getSelectedIndex()).setDoctor("");
				}//end if
			}//end if			
		}//end action performed	
	  }//end button listener class
}//end class PatientRecordPanel 
