import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class PatientSymptoms1_5 extends JPanel{
	private Vector accountList;
	private JButton back;
	private JButton next;
	private JLabel howTired;
	private JLabel appetite;
	private JLabel drowsiness;
	private JLabel depression;
	private JLabel anxiety;
	private String[] howTiredList;
	private String[] drowsinessList;
	private String[] anxietyList;
	private String[] appetiteList;
	private JComboBox howTiredComboBox;
	private JComboBox drowsinessComboBox;
	private JComboBox depressionComboBox;
	private JComboBox anxietyComboBox;
	private JComboBox appetiteComboBox;
	
	

	public PatientSymptoms1_5(Vector accountList) {
		// TODO Auto-generated constructor stub
	}

	public PatientSymptoms1_5(Vector accountList, int num) {
		// TODO Auto-generated constructor stub
	}

	
	private class ButtonListener implements ActionListener{
		private int panelLocation;
		private Boolean nextButtonClicked;
		
		public void actionPerformed(ActionEvent action)
		{
			
		
		
	}
	}
}
