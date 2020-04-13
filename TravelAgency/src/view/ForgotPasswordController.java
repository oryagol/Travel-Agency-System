package view;

import java.net.URL;
import java.util.ResourceBundle;


import controller.Shared;
import controller.Sound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ForgotPasswordController  implements Initializable {
	static Stage stage;
	@FXML
	private TextField answer;

	@FXML
	private Label showPass;



	@FXML
	private TextField id;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}


	public void showPassword(ActionEvent e)
	{
		try {
			if(Shared.getInstance().getUserConfirmation().containsKey(Long.parseLong(id.getText())))
			{
				String pass=Shared.getInstance().getUserConfirmation().get(Long.parseLong(id.getText())).getAnswer();
				if(answer.getText().equals(pass))
				{
					goodSound();
					showPass.setText("Your Password is: "+Shared.getInstance().getUserConfirmation().get(Long.parseLong(id.getText())).getPassword());
				}
				else
				{
					badSound();
					showPass.setText("Incorrect Answer!");
				}
			}
			else
			{
				badSound();
				showPass.setText("User Does Not Exist!");
			}
		}
		catch(NumberFormatException e1) {
			badSound();
			showPass.setText("Please enter numbers only at the ID field");
		}
	}

	public void close(ActionEvent e)
	{
		goodSound();
		stage.close();
	}
	
	public void badSound() {
		Sound s = new Sound();
		try {
			s.errorSound();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public void goodSound() {
		Sound s = new Sound();
		try {
			s.successSound();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
