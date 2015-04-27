import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;


public class PatientSymptoms6_10 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel hoursOfSleepLabel;
	private JLabel activeLabel;
	private JLabel shortnessOfBreathLabel;
	private JLabel nauseaLabel;
	private JLabel wellbeingLabel;	
	private JLabel spaceLabel1 = new JLabel("                                                              ");
	private JLabel spaceLabel2 = new JLabel("                                                              ");
	private JSlider hoursOfSleepJSlider;
	private JSlider activeJSlider;
	private JSlider shortnessOfBreathJSlider;
	private JSlider nauseaJSlider;
	private JSlider wellbeingJSlider;
	private int sliderMax=10;
	private int sliderMin=0;
	private int sliderInit=0;
	
	

	public PatientSymptoms6_10() {
		//this creates the labels and gives them names as well as orientation 
				hoursOfSleepLabel = new JLabel("Hours of Sleep:",SwingConstants.LEFT);
				activeLabel= new JLabel("Active:",SwingConstants.LEFT);
				shortnessOfBreathLabel= new JLabel("Shortness of Breath:",SwingConstants.LEFT);
				nauseaLabel = new JLabel("Nausea",SwingConstants.LEFT);
				wellbeingLabel= new JLabel("Well Being",SwingConstants.LEFT);
				
				//this creates the sliders and gives them orientation
				hoursOfSleepJSlider= new JSlider(JSlider.HORIZONTAL,sliderMin,sliderMax,sliderInit);
				activeJSlider= new JSlider(JSlider.HORIZONTAL,sliderMin,sliderMax,sliderInit);
				shortnessOfBreathJSlider= new JSlider(JSlider.HORIZONTAL,sliderMin,sliderMax,sliderInit);
				nauseaJSlider= new JSlider(JSlider.HORIZONTAL,sliderMin,sliderMax,sliderInit);
				wellbeingJSlider= new JSlider(JSlider.HORIZONTAL,sliderMin,sliderMax,sliderInit);
				
				//this handles the how tired slider
				hoursOfSleepJSlider.setMajorTickSpacing(5);
				hoursOfSleepJSlider.setMinorTickSpacing(1);
				hoursOfSleepJSlider.setPaintTicks(true);
				hoursOfSleepJSlider.setPaintLabels(true);
				
				//this handles the drowsiness slider
				activeJSlider.setMajorTickSpacing(5);
				activeJSlider.setMinorTickSpacing(1);
				activeJSlider.setPaintTicks(true);
				activeJSlider.setPaintLabels(true);
				
				//this handles the depression slider
			    shortnessOfBreathJSlider.setMajorTickSpacing(5);
				shortnessOfBreathJSlider.setMinorTickSpacing(1);
				shortnessOfBreathJSlider.setPaintTicks(true);
				shortnessOfBreathJSlider.setPaintLabels(true);
				
				//this handles the anxiety slider
				nauseaJSlider.setMajorTickSpacing(5);
				nauseaJSlider.setMinorTickSpacing(1);
				nauseaJSlider.setPaintTicks(true);
				nauseaJSlider.setPaintLabels(true);
				
				//this handles the appetite slider
				wellbeingJSlider.setMajorTickSpacing(5);
				wellbeingJSlider.setMinorTickSpacing(1);
				wellbeingJSlider.setPaintTicks(true);
				wellbeingJSlider.setPaintLabels(true);
				
				//this is used to give some space between sliders
				JPanel emptyPanel = new JPanel();
				
				//this will group the sliders and labels together
				JPanel patientSympPanel= new JPanel();
				patientSympPanel.setLayout(new GridLayout(8,0));
				
				//used to give an empty space at the top of the panel
				patientSympPanel.add(spaceLabel2);
				patientSympPanel.add(spaceLabel1);
				
				//adds the sliders and labels together to patient panel
				patientSympPanel.add(hoursOfSleepLabel);
				patientSympPanel.add(activeLabel);
				patientSympPanel.add(hoursOfSleepJSlider);		
				patientSympPanel.add(wellbeingJSlider);
				patientSympPanel.add(wellbeingLabel);
				patientSympPanel.add(nauseaLabel);
				patientSympPanel.add(nauseaJSlider);
				patientSympPanel.add(shortnessOfBreathJSlider);
				patientSympPanel.add(shortnessOfBreathLabel);
				patientSympPanel.add(emptyPanel);
				patientSympPanel.add(activeJSlider);
				
				//used to gather the panels together into one grid layout
			    JPanel patientSympPanel2= new JPanel();
			    patientSympPanel2.setLayout(new GridLayout(2,0));
			
			    //add them together again
			    patientSympPanel2.add(patientSympPanel);
			    
			    
			    
			    //adds patientSympPanel2 to the panel
			    this.add(patientSympPanel2);	
	}//end patient Symptoms6-10
		
		
	public int getHoursOfSleep(){
		int temp = this.hoursOfSleepJSlider.getValue();
		this.hoursOfSleepJSlider.setValue(sliderMin);
		return temp;		
	}//end
	
	public int getActive()
	{	int temp = this.activeJSlider.getValue();
		this.activeJSlider.setValue(sliderMin);
		return temp;
	}//end
	
	public int getShortnessofBreath()
	{	int temp = this.shortnessOfBreathJSlider.getValue();
		this.shortnessOfBreathJSlider.setValue(sliderMin);
		return temp;
	}//end
	
	public int getNausea()
	{	int temp = this.nauseaJSlider.getValue();
		this.nauseaJSlider.setValue(sliderMin);
		return temp;
	}//end
	
	public int getWellBeing()
	{	int temp = this.wellbeingJSlider.getValue();
		this.wellbeingJSlider.setValue(sliderMin);
		return temp;
	}//end
	
	public void setReset(){
		this.wellbeingJSlider.setValue(sliderMin);
		this.nauseaJSlider.setValue(sliderMin);
		this.shortnessOfBreathJSlider.setValue(sliderMin);
		this.activeJSlider.setValue(sliderMin);
		this.hoursOfSleepJSlider.setValue(sliderMin);
	}
}//end class
