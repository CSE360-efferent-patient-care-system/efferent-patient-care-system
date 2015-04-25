import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;


public class PatientSymptoms1_5 extends JPanel{
	private JLabel howTiredLabel;
	private JLabel appetiteLabel;
	private JLabel drowsinessLabel;
	private JLabel depressionLabel;
	private JLabel anxietyLabel;	
	private JLabel spaceLabel1 = new JLabel("                                                              ");
	private JLabel spaceLabel2 = new JLabel("                                                              ");
	private JSlider howTiredJSlider;
	private JSlider drowsinessJSlider;
	private JSlider depressionJSlider;
	private JSlider anxietyJSlider;
	private JSlider appetiteJSlider;
	private int sliderMax=10;
	private int sliderMin=0;
	private int sliderInit=0;
	

	public PatientSymptoms1_5() {
		
		//this creates the labels and gives them names as well as orientation 
		howTiredLabel = new JLabel("Tiredness:",SwingConstants.LEFT);
		appetiteLabel= new JLabel("Appetite:",SwingConstants.LEFT);
		drowsinessLabel= new JLabel("Drowsiness:",SwingConstants.LEFT);
		depressionLabel = new JLabel("Depression",SwingConstants.LEFT);
		anxietyLabel= new JLabel("Anxiety",SwingConstants.LEFT);
		
		//this creates the sliders and gives them orientation
		howTiredJSlider= new JSlider(JSlider.HORIZONTAL,sliderMin,sliderMax,sliderInit);
		drowsinessJSlider= new JSlider(JSlider.HORIZONTAL,sliderMin,sliderMax,sliderInit);
		depressionJSlider= new JSlider(JSlider.HORIZONTAL,sliderMin,sliderMax,sliderInit);
		anxietyJSlider= new JSlider(JSlider.HORIZONTAL,sliderMin,sliderMax,sliderInit);
		appetiteJSlider= new JSlider(JSlider.HORIZONTAL,sliderMin,sliderMax,sliderInit);
		
		//this handles the how tired slider
		howTiredJSlider.setMajorTickSpacing(5);
		howTiredJSlider.setMinorTickSpacing(1);
		howTiredJSlider.setPaintTicks(true);
		howTiredJSlider.setPaintLabels(true);
		
		//this handles the drowsiness slider
		drowsinessJSlider.setMajorTickSpacing(5);
		drowsinessJSlider.setMinorTickSpacing(1);
		drowsinessJSlider.setPaintTicks(true);
		drowsinessJSlider.setPaintLabels(true);
		
		//this handles the depression slider
	    depressionJSlider.setMajorTickSpacing(5);
		depressionJSlider.setMinorTickSpacing(1);
		depressionJSlider.setPaintTicks(true);
		depressionJSlider.setPaintLabels(true);
		
		//this handles the anxiety slider
		anxietyJSlider.setMajorTickSpacing(5);
		anxietyJSlider.setMinorTickSpacing(1);
		anxietyJSlider.setPaintTicks(true);
		anxietyJSlider.setPaintLabels(true);
		
		//this handles the appetite slider
		appetiteJSlider.setMajorTickSpacing(5);
		appetiteJSlider.setMinorTickSpacing(1);
		appetiteJSlider.setPaintTicks(true);
		appetiteJSlider.setPaintLabels(true);
		
		//this is used to give some space between sliders
		JPanel emptyPanel = new JPanel();
		
		//this will group the sliders and labels together
		JPanel patientSympPanel= new JPanel();
		patientSympPanel.setLayout(new GridLayout(8,0));
		
		//used to give an empty space at the top of the panel
		patientSympPanel.add(spaceLabel2);
		patientSympPanel.add(spaceLabel1);
		
		//adds the sliders and labels together to patient panel
		patientSympPanel.add(howTiredLabel);
		patientSympPanel.add(appetiteLabel);
		patientSympPanel.add(howTiredJSlider);		
		patientSympPanel.add(appetiteJSlider);
		patientSympPanel.add(anxietyLabel);
		patientSympPanel.add(depressionLabel);
		patientSympPanel.add(anxietyJSlider);
		patientSympPanel.add(depressionJSlider);
		patientSympPanel.add(drowsinessLabel);
		patientSympPanel.add(emptyPanel);
		patientSympPanel.add(drowsinessJSlider);
		
		//used to gather the panels together into one grid layout
	    JPanel patientSympPanel2= new JPanel();
	    patientSympPanel2.setLayout(new GridLayout(2,0));
	
	    //add them together again
	    patientSympPanel2.add(patientSympPanel);
	    
	    
	    
	    //adds patientSympPanel2 to the panel
	    this.add(patientSympPanel2);		
	}//ends PatientSymptoms1_5 constructor
	
	public int getHowTired(){
		int temp = this.howTiredJSlider.getValue();
		this.howTiredJSlider.setValue(sliderMin);
		return temp;		
	}//end
	
	public int getDrowsiness()
	{	int temp = this.drowsinessJSlider.getValue();
		this.drowsinessJSlider.setValue(sliderMin);
		return temp;
	}//end
	
	public int getDepression()
	{	int temp = this.depressionJSlider.getValue();
		this.depressionJSlider.setValue(sliderMin);
		return temp;
	}//end
	
	public int getAnxiety()
	{	int temp = this.anxietyJSlider.getValue();
		this.anxietyJSlider.setValue(sliderMin);
		return temp;
	}//end
	
	public int getAppetite()
	{	int temp = this.appetiteJSlider.getValue();
		this.appetiteJSlider.setValue(sliderMin);
		return temp;
	}//end
	
}//ends PatientSymptoms1_5 class
