import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PatientRecordPanel extends JPanel{
private Vector accountList;
private JButton back;
private JButton next;
private Boolean emergencyPatient;
private JButton transferPatient;
private JLabel patients;
private JLabel selectedPatient;
private JTextField patientInfoField;
private JTextField patientNameField;

	public PatientRecordPanel(Vector accountList) {
		// TODO Auto-generated constructor stub
	}

	public PatientRecordPanel(Vector accountList, int num) {
		// TODO Auto-generated constructor stub
	}
private class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent action) {
		// TODO Auto-generated method stub
		
	}
	
}
}
