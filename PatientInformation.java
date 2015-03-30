import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PatientInformation extends JPanel{
	
	private Vector accountList;
	private JButton back;
	private JButton next;
	private JLabel firstNameLabel;
	private JLabel lastNAmeLabel;
	private JLabel optional1;
	private JLabel optional2;
	private JLabel age;
	private JLabel gender;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private String[] ageList;
	private String[] genderList;
	private String[] monthList;
	private String[] dayList;
	private String[] yearList;
	private JComboBox ageComboBox;
	private JComboBox genderComboBox;
	private JComboBox monthComboBox;
	private JComboBox dayComboBox;
	private JComboBox yearComboBox;
			
	
	


	public PatientInformation(Vector accountList) {
		// TODO Auto-generated constructor stub
	}

	public PatientInformation(Vector accountList, int num) {
		// TODO Auto-generated constructor stub
	}

	private class ButtonListener implements ActionListener
	{
		private int panelLocation;
		private Boolean nextButtonClicked;
	
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		
	}
	
	
	
	
}
