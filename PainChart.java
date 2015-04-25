import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultStyledDocument;


public class PainChart extends JPanel{
	static final int MIN = 0;
	static final int MAX = 10;
	static final int INIT = 0;    //initial indicator
	private JLabel spaceLabel = new JLabel("                                                                             ");
	private JLabel painLevelLabel = new JLabel("Pain Lable:");
	private JLabel painLocationLabel = new JLabel("Pain Location Indicator:");	
	private JLabel additionalSymptomsLabel = new JLabel("Pain Location:");
	private JSlider painLevelSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
	private JLabel picLabel;
	private int maxArrayLenght = 56;
	private ImageIcon[] imageArray = new ImageIcon[maxArrayLenght];
	private String[] pictureNameArray = new String[maxArrayLenght]; 
	private BufferedImage currentPicture;
	private JCheckBox headCheckBox;
	private JCheckBox bodyCheckBox;
	private JCheckBox leftArmCheckBox;
	private JCheckBox rightArmCheckBox;
	private JCheckBox leftLegCheckBox;
	private JCheckBox rightLegCheckBox;
	private JTextArea additionalSymptomsTextArea = new JTextArea(10,20);
	private JScrollPane scrollArea = new JScrollPane(additionalSymptomsTextArea);
	private TitledBorder additionalSymptomsBorder =  BorderFactory.createTitledBorder("Aditional information Here");
	private Font bigFont = new Font("Serif",Font.BOLD,15);
	private String fileName;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	public PainChart() {
		
//////////this imports the names of the images to get		
		importImageNames();
		
//////////this imports the images of the patients body diagram into the program		
		importImages();
		
////////////this creates the check boxes and gives them their names/////////////////////////
		checkBoxesInit();
		
		//adds a text area for additional comments regarding their ailment
		additionalSymptomsTextArea.setText("    ");
		additionalSymptomsTextArea.setEditable(true);
		additionalSymptomsTextArea.setLineWrap(true);
		additionalSymptomsTextArea.setWrapStyleWord(true);
		scrollArea.setEnabled(true);
		scrollArea.setBorder(additionalSymptomsBorder);
		picLabel.setIcon(imageArray[0]);
		
		//Turn on labels at major tick marks.
		painLevelSlider.setMajorTickSpacing(1);
		painLevelSlider.setPaintTicks(true);
		painLevelSlider.setPaintLabels(true);
        painLevelSlider.setFont(bigFont);
        painLevelLabel.setFont(bigFont);
        painLevelLabel.setFont(bigFont);
        additionalSymptomsLabel.setFont(bigFont);
	        
	    			 			
		/***************************************************************************
	     * this starts the pain panel information assembly
	     * *************************************************************************/
	    //panel is a grid layout that handles the pain information
	    JPanel painSliderPanel = new JPanel();
	    painSliderPanel.setLayout(new GridLayout(2,0));	    
	    painSliderPanel.add(painLevelLabel);
	    painSliderPanel.add(painLevelSlider);
	    
	    //panel is a grid layout that handles the additional information
	    //additionalnfoPanel adds a scroll area for the text the user writes
	    JPanel additionalnfoPanel = new JPanel();
	    additionalnfoPanel.setLayout(new BorderLayout());	   
	    additionalnfoPanel.add(scrollArea);
	    
	    //this layout puts the right side of the screen together
	    JPanel rightSidePanel = new JPanel();
	    rightSidePanel.setLayout(new BoxLayout(rightSidePanel, BoxLayout.Y_AXIS));	    
	    rightSidePanel.add(painSliderPanel);
	    rightSidePanel.add(additionalnfoPanel);
	    
	  //this layout puts the left side of the screen together
	    JPanel leftSidePanel = new JPanel();
	    leftSidePanel.setLayout(new BoxLayout(leftSidePanel, BoxLayout.Y_AXIS));	    
	    leftSidePanel.add(painLocationLabel);
	    leftSidePanel.add(picLabel);
	    
	  //this layout puts the check boxes together
	    JPanel centerPanel = new JPanel();
	    centerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));	    
	    centerPanel.add(additionalSymptomsLabel);
	    centerPanel.add(headCheckBox);
	    centerPanel.add(bodyCheckBox);
	    centerPanel.add(leftArmCheckBox);
	    centerPanel.add(rightArmCheckBox);
	    centerPanel.add(leftLegCheckBox);
	    centerPanel.add(rightLegCheckBox);
	    		    
	    //final panel holds the left and right together all together
	    JPanel finalPanel = new JPanel();
	    finalPanel.setLayout(new GridLayout(1,1));	    
	    finalPanel.add(leftSidePanel);
	    finalPanel.add(rightSidePanel);
	    
	    //this panel is to give some extra space to the pictures
	    JPanel spacePanel = new JPanel();
	    spacePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	    spacePanel.add(spaceLabel);
	    
	    //final grouping of the panels		    
	    JPanel finalGroupingPanel = new JPanel();
	    finalGroupingPanel.setLayout(new BoxLayout(finalGroupingPanel, BoxLayout.Y_AXIS));
	    finalGroupingPanel.add(spacePanel);
	    finalGroupingPanel.add(centerPanel);
	    finalGroupingPanel.add(finalPanel);
	    
	    //adds everything to the PainChart panel and begins to check if the 
	    //check marks have been checked
	    this.add(finalGroupingPanel); 
/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////this action listener will check what parts of the body have been checked and apply the correct image 
/////////////////////////////////////////////////////////////////////////////////////////////////////
	    ActionListener listener = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Determines what body parts were selected 
				String[] check = {"","","","","","",""};
/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////Selected if statements
/////////////////////////////////////////////////////////////////////////////////////////////////////				
				//sets the check where in the body patient hurts
				if (e.equals(headCheckBox) != headCheckBox.isSelected()){
					//System.out.println("checked");
					//picLabel.setIcon(imageArray[1]);
					check[1] = "head";
					//System.out.println(check[1]);
		    	}//end if
				
				if (e.equals(bodyCheckBox) != bodyCheckBox.isSelected()){
					//System.out.println("un-checked");
					//picLabel.setIcon(imageArray[0]);
					check[2] = "body";
		    	}//end if
				
				if (e.equals(rightArmCheckBox) != rightArmCheckBox.isSelected()){
					//System.out.println("un-checked");
					//picLabel.setIcon(imageArray[0]);
					check[3] = "rightarm";
		    	}//end if

				if (e.equals(leftArmCheckBox) != leftArmCheckBox.isSelected()){
					//System.out.println("un-checked");
					//picLabel.setIcon(imageArray[0]);
					check[4] = "leftarm";
		    	}//end if

				if (e.equals(rightLegCheckBox) != rightLegCheckBox.isSelected()){
					//System.out.println("un-checked");
					//picLabel.setIcon(imageArray[0]);
					check[5] = "rightleg";
		    	}//end if

				if (e.equals(leftLegCheckBox) != leftLegCheckBox.isSelected()){
					//System.out.println("un-checked");
					//picLabel.setIcon(imageArray[0]);
					check[6] = "leftleg";
		    	}//end if
/////////////////////////////////////////////////////////////////////////////////////////////////////
				//Unselected if statements
/////////////////////////////////////////////////////////////////////////////////////////////////////
				if (e.equals(headCheckBox) == headCheckBox.isSelected()){
					//System.out.println("un-checked");
					//picLabel.setIcon(imageArray[0]);
					check[1] = "";
		    	}//end if

				if (e.equals(bodyCheckBox) == bodyCheckBox.isSelected()){
					//System.out.println("un-checked");
					//picLabel.setIcon(imageArray[0]);
					check[2] = "";
		    	}//end if

				if (e.equals(rightArmCheckBox) == rightArmCheckBox.isSelected()){
					//System.out.println("un-checked");
					//picLabel.setIcon(imageArray[0]);
					check[3] = "";
		    	}//end if

				if (e.equals(leftArmCheckBox) == leftArmCheckBox.isSelected()){
					//System.out.println("un-checked");
					//picLabel.setIcon(imageArray[0]);
					check[4] = "";
		    	}//end if

				if (e.equals(rightLegCheckBox) == rightLegCheckBox.isSelected()){
					//System.out.println("un-checked");
					//picLabel.setIcon(imageArray[0]);
					check[5] = "";
		    	}//end if

				if (e.equals(leftLegCheckBox) == leftLegCheckBox.isSelected()){
					//System.out.println("un-checked");
					//picLabel.setIcon(imageArray[0]);
					check[6] = "";
		    	}//end if
				
				//System.out.println(new String(check[1]+check[2]+check[3]+check[4]+check[5]+check[6]));
				//searching algorithm that searches for the correct image
				for(int i = 0; i < pictureNameArray.length; i++){					
					//System.out.println(i+"."+pictureNameArray[i]);
					if(pictureNameArray[i].toLowerCase().equals(check[1]+check[2]+check[3]+check[4]+check[5]+check[6])){
						//System.out.println("image has changed");
						picLabel.setIcon(imageArray[i]);
						i = pictureNameArray.length;
					}//end if
					else if(new String(check[1]+check[2]+check[3]+check[4]+check[5]+check[6]).equals("")){
						picLabel.setIcon(imageArray[0]);
					}//end else if
				}//end for look
				
			}//end actionPerformed
		};//end ActionListener
		
		//adds the action listeners to all the check boxes
		headCheckBox.addActionListener(listener);
		bodyCheckBox.addActionListener(listener);
		leftArmCheckBox.addActionListener(listener);
		rightArmCheckBox.addActionListener(listener);
		leftLegCheckBox.addActionListener(listener);
		rightLegCheckBox.addActionListener(listener);
		//adds everything to the PainChart panel and begins to check if the 
	    //check marks have been checked
	    this.add(finalGroupingPanel);
	}//end pain chart constructor

	private void importImageNames() {
		// The name of the file to open.
	       fileName = "/Desktop/pictureNameArray.txt";

	       // This will reference one line at a time
	       String line = null;
	       
	       try {
	           // FileReader reads text files in the default encoding.
	           fileReader = new FileReader(System.getProperty("user.home") + fileName);

	           // Always wrap FileReader in BufferedReader.
	           bufferedReader = new BufferedReader(fileReader);
	           
	           //will go line by line to read the names of the pictures
	           for(int i = 0; i < pictureNameArray.length; i++){
	        	   //System.out.println(pictureNameArray[i]);
	        	   if((line = bufferedReader.readLine()) != null) {
	        		   pictureNameArray[i] = line;// adds the name of the picture
	        		   //System.out.println(pictureNameArray[i]+" Success");   
		           }
	           }//end for
	           // Always close files.
	           bufferedReader.close();            
	       }//end try
	       catch(FileNotFoundException ex) {
	           System.out.println("Unable to open file '" + fileName + "'");                
	       }//end catch
	       catch(IOException ex) {
	           System.out.println("Error reading file '"+ fileName + "'");    
	       }//end catch
	}

///////////this method initializes the check boxes////////////////////
	private void checkBoxesInit() {
		///initializes the head
		headCheckBox = new JCheckBox("Head");
		headCheckBox.setSelected(false);
		headCheckBox.setVisible(true);
		
		///initializes the body
		bodyCheckBox = new JCheckBox("Body");
		bodyCheckBox.setSelected(false);
		bodyCheckBox.setVisible(true);
		
		///initializes the leftArmCheckBox
		leftArmCheckBox = new JCheckBox("Left Arm");
		leftArmCheckBox.setSelected(false);
		leftArmCheckBox.setVisible(true);
		
		///initializes the rightArmCheckBox
		rightArmCheckBox = new JCheckBox("Right Arm");
		rightArmCheckBox.setSelected(false);
		rightArmCheckBox.setVisible(true);
		
		///initializes the leftLegCheckBox
		leftLegCheckBox = new JCheckBox("Left Leg");
		leftLegCheckBox.setSelected(false);
		leftLegCheckBox.setVisible(true);
		
		///initializes the rightLegCheckBox
		rightLegCheckBox = new JCheckBox("Right Leg");
		rightLegCheckBox.setSelected(false);
		rightLegCheckBox.setVisible(true);
	}//end checkBoxesInit

/////////////adds the image to the program if image is not found the panel will be blank
	private void importImages() {
		try{
			for(int i = 0; i < imageArray.length; i++){
				//System.out.print(pictureNameArray[i]);
				currentPicture = ImageIO.read(new File(System.getProperty("user.home") +"/Desktop/Body images/" + pictureNameArray[i] +".jpg"));
				//System.out.println(i + "." +pictureNameArray[i] + " Success");
				imageArray[i] = new ImageIcon(currentPicture);
			}//end for
			
			//sets the default picture to a clear body
			picLabel = new JLabel(imageArray[0]);
		}catch(Exception e){
			System.out.print(": Image could not be loaded");
		}//end catch		
	}

	////////these are to transmit the the location of the pain locations//////////////// 	
	public String getAdditionalSymptoms(){
		String temp = additionalSymptomsTextArea.getText();
		additionalSymptomsTextArea.setText(" ");
		return temp;
	}//end getAdditionalSymptoms 
	
	public String getPainLocation() {
		String temp = "";
		if(headCheckBox.isSelected()){			
			temp = temp + "Head, ";
		}//end if
		
		if(bodyCheckBox.isSelected()){
			temp = temp+ "Body, ";
		}//end if
		
		if(leftArmCheckBox.isSelected()){
			temp = temp + "Left Arm, ";
		}//end if
		
		if(rightArmCheckBox.isSelected()){
			temp = temp + "Right Arm, ";
		}//end if
		
		if(leftLegCheckBox.isSelected()){
			temp = temp + "Left Leg, ";
		}//end if
		
		if(rightLegCheckBox.isSelected()){
			temp = temp + "Right Leg";
		}//end if
		
		picLabel.setIcon(imageArray[0]);
		headCheckBox.setSelected(false);		
		bodyCheckBox.setSelected(false);
		leftArmCheckBox.setSelected(false);
		rightArmCheckBox.setSelected(false);
		leftLegCheckBox.setSelected(false);
		rightLegCheckBox.setSelected(false);
		
		return temp;
		
	}//end head location pain indicator
			
	public int getPainLevel(){
		int temp = painLevelSlider.getValue();
		painLevelSlider.setValue(MIN);
		return temp;
	}//end get pain level
	
//////////////end of get methods/////////////////////////////////////////
	
}//end pain chart class
