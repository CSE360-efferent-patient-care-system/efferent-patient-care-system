import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class PainChart extends JPanel{
	private Vector accountList;
	private JButton back;
	private JButton submit;
	private JLabel painLevel;
	private JLabel painLocation;
	private JLabel additionalSymptoms;
	private JLabel bodyDiagram;
	private String[] painLevelList;
	private String[] painLocationList;
	private JComboBox painLevelComboBox;
	private JCheckBox bodyDiagramCheckBox;
	private JTextArea additionalSymptomsTextArea;



	public PainChart(Vector accountList) {
		// TODO Auto-generated constructor stub.
	}

	public PainChart(Vector accountList, int num) {
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
