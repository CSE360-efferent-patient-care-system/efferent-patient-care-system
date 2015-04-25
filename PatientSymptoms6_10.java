import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PatientSymptoms6_10 extends JPanel{
	private Vector accountList;
	private JButton back;
	private JButton next;
	private JLabel hoursOfSleep;
	private JLabel active;
	private JLabel shortnessOfBreath;
	private JLabel nausea;
	private JLabel wellbeing;
	private String[] hoursOfSleepList;
	private String[] activeList;
	private String[] shortnessOfBreathList;
	private String[] nauseaList;
	private String[] wellbeingList;
	private JComboBox hoursofSleepComboBox;
	private JComboBox activeComboBox;
	private JComboBox shortnessOfBreathComboBox;
	private JComboBox nauseaComboBox;
	private JComboBox wellbeingcComboBox;
	

	public PatientSymptoms6_10(Vector accountList) {
		// TODO Auto-generated constructor stub
	}

	public PatientSymptoms6_10(Vector accountList, int num) {
		// TODO Auto-generated constructor stub
	}

	
	
	private class ButtonListner implements ActionListener
	{
		private int panelLocation;
		private Boolean nextButtonClicked;
		
		public void actionPerformed(ActionEvent event)
		{
			
			
		}
		
		
		
	}
		
	
}
