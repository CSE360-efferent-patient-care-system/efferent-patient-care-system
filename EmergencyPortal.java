import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EmergencyPortal extends JPanel{
	private Vector accountList;
	private JButton back;
	private JButton submit;
	private JLabel painLevel;
	private JLabel painlocation;
	private String[] painLeveList;
	private String[] painLocationList;
	private JComboBox painLevelComboBox;
	private JCheckBox bodyDiagramCheckBox;
	
	
	
	public EmergencyPortal(Vector accountList) {
		// TODO Auto-generated constructor stub
	}

	public EmergencyPortal(Vector accountList, int num) {
		// TODO Auto-generated constructor stub
	}

	
	
	
	private class ButtonListener implements ActionListener
	{
		private int panelLocation;
		private Boolean submitButtonClicked;
		
		public void actionPerformed(ActionEvent event)
		{
		
		
		
		
		
	}
	}
}
