import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class DoctorPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton loginButton = new JButton("Login");
	private JLabel space1 = new JLabel("                            ");
	private JLabel space2 = new JLabel("                            ");
	private JLabel space3 = new JLabel("                            ");	
	private JLabel doctorUsernameLabel = new JLabel("Doctor Username: Case Sensitive",SwingConstants.LEFT);
	private JLabel passwordLabel = new JLabel("Password: Case Sensitive",SwingConstants.LEFT);
	private JLabel loginConfirmationLabel1 = new JLabel("Please enter your Username and password if you are a doctor, if you");
	private JLabel loginConfirmationLabel2 = new JLabel("are a Patient Please press the BACK button to go back to the Main Menu");
	private JLabel successfulLoginLabel = new JLabel("Login Successful Please press NEXT to continue to Patient Transfer");				//used for when the user logs in correctly
	private JLabel failedLoginLabel = new JLabel("Login Failed Please Try Again");   //used for when the user logs in unSuccessfuly
	private JTextField doctorUsernameTextField = new JTextField(10);
	private JTextField passwordField = new JTextField(10);
	private Font bigFont = new Font("Serif",Font.BOLD,15);
	private Vector<String> doctorUsernameArray = new Vector<String>();
	private Vector<String> doctorPasswordArray = new Vector<String>();
	private Boolean loginConfirmationBoolean = false;
	private String currentDoctor;
	
	public DoctorPanel(Vector<String> doctorUsernameArray, Vector<String> doctorPasswordArray) {
		//import the vectors and the doctor user names and passwords
		this.doctorUsernameArray = doctorUsernameArray;
		this.doctorPasswordArray = doctorPasswordArray;
				
		//this sets the fonts for the labels and buttons as well as alignments for the labels
		loginButton.setFont(bigFont);
		doctorUsernameLabel.setFont(bigFont);
		passwordLabel.setFont(bigFont);
		loginConfirmationLabel1.setFont(bigFont);
		loginConfirmationLabel2.setFont(bigFont);
		successfulLoginLabel.setFont(bigFont);
		failedLoginLabel.setFont(bigFont);
		loginConfirmationLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		loginConfirmationLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		successfulLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		failedLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginButton.setHorizontalAlignment(SwingConstants.CENTER);
		successfulLoginLabel.setForeground(Color.BLUE);
		failedLoginLabel.setForeground(Color.RED);
		
		//this makes the login Successful and login failed labels not visible until needed
		successfulLoginLabel.setVisible(false);
		failedLoginLabel.setVisible(false);
		doctorUsernameTextField.setEnabled(true);
		passwordField.setEnabled(true);
		
		//holds doctor login and password
		JPanel doctorLogin = new JPanel();
		doctorLogin.setLayout(new GridLayout(7, 0));		
		doctorLogin.add(space1);
		doctorLogin.add(space2);
		doctorLogin.add(space3);
		doctorLogin.add(doctorUsernameLabel);
		doctorLogin.add(doctorUsernameTextField);
		doctorLogin.add(passwordLabel);
		doctorLogin.add(passwordField);
		
		//this contains information on how to login and information if your on the wrong page
		JPanel doctorLoginLabels = new JPanel();
		doctorLoginLabels.setLayout(new GridLayout(4, 0));		
		doctorLoginLabels.add(loginConfirmationLabel1);
		doctorLoginLabels.add(loginConfirmationLabel2);
		doctorLoginLabels.add(successfulLoginLabel);
		doctorLoginLabels.add(failedLoginLabel);
		
		//contains the button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 0));	
		
		//Contains them all
		JPanel allPanel = new JPanel();
		allPanel.setLayout(new BorderLayout());		
		allPanel.add(doctorLogin,BorderLayout.PAGE_START);
		allPanel.add(doctorLoginLabels,BorderLayout.CENTER);
		allPanel.add(buttonPanel,BorderLayout.PAGE_END);
				
		this.add(allPanel);
	}//end DoctorPanel
	
	public String getCurrentDoctor() {
		return this.currentDoctor;
	}
				
	public void setPanelToDefault(){
		successfulLoginLabel.setVisible(false);
		failedLoginLabel.setVisible(false);
		loginConfirmationBoolean = false;
		doctorUsernameTextField.setEnabled(true);
		passwordField.setEnabled(true);
		doctorUsernameTextField.setText("");
		passwordField.setText("");		
	}//end setDefault	
	
	public Boolean getLoginConfirmation(){
		//loops through all the user names until it finds the one its looking for 	
		for(int i = 0; i < doctorUsernameArray.size(); i++){
			//if it matches the the user typed in with the current list 
			if(doctorUsernameArray.get(i).equals(doctorUsernameTextField.getText())){
				//this will check the pass word with the associated user log them in if it matches
				if(doctorPasswordArray.get(i).equals(passwordField.getText())){
					this.currentDoctor = doctorUsernameArray.get(i);
					loginConfirmationBoolean = true;
					doctorUsernameTextField.setEnabled(false);
					passwordField.setEnabled(false);
					successfulLoginLabel.setVisible(true);
					failedLoginLabel.setVisible(false);
				}//end if
				else{
					failedLoginLabel.setVisible(true);
				}//end else
				//ends loop because it found that specific doctor user
				i = doctorPasswordArray.size();				
			}//end if
			//if the user does not match and password does not match it will give an error message
			else{
					failedLoginLabel.setVisible(true);
				}//end else			
		}//end for	
		
		return loginConfirmationBoolean;
	}
}//end class
