package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;


import controller.Shared;
import controller.Sound;
import exception.IllegelInputException;
import exception.IllegelPasswordException;
import exception.IllegelUserNameException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Admin;
import model.Customer;
import model.Guide;
import model.Person;

public class LoginController implements Initializable {

	@FXML
	private AnchorPane mainPane;

	@FXML
	private TextField id;

	@FXML
	private Button login;

	@FXML
	private PasswordField password;

	@FXML
	private Button forgot;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub


	}

	public void Login(ActionEvent e) throws IOException
	{
		try {
			Person user;
			if(id.getText().equals("admin") && password.getText().equals("admin"))
			{
				user = Admin.getInstance();
			}
			else
				user=loginSystem(Long.parseLong(id.getText()),password.getText());
			if(user instanceof Customer)
			{
				goodSound();
				CustomerMainPageController.setCustomer(Shared.getInstance().getCustomers().get(Long.parseLong(id.getText())));
				StackPane pane=FXMLLoader.load(getClass().getResource("CustomerMainPage.fxml"));
				pane.setPrefSize(mainPane.getWidth(), mainPane.getHeight());
				mainPane.getChildren().removeAll(mainPane.getChildren());
				mainPane.getChildren().add(pane);
			}
			else if(user instanceof Guide)
			{
				goodSound();
				GuideMainPageController.setGuide(Shared.getInstance().getGuides().get(Long.parseLong(id.getText())));
				StackPane pane=FXMLLoader.load(getClass().getResource("GuideMainPage.fxml"));
				pane.setPrefSize(mainPane.getWidth(), mainPane.getHeight());
				mainPane.getChildren().removeAll(mainPane.getChildren());
				mainPane.getChildren().add(pane);
			}
			else
			{
				goodSound();
				StackPane pane=FXMLLoader.load(getClass().getResource("AdminMainPage.fxml"));
				pane.setPrefSize(mainPane.getWidth(), mainPane.getHeight());
				mainPane.getChildren().removeAll(mainPane.getChildren());
				mainPane.getChildren().add(pane);
			}
		} 
		catch (IllegelPasswordException e1) {
			badSound();
			Alert al = new Alert(Alert.AlertType.ERROR);
			al.setContentText("Please try again");
			al.setHeaderText("Wrong Password");
			al.setTitle("Error");
			al.setResizable(false);
			al.showAndWait();
		}
		catch (NumberFormatException e1) {
			badSound();
			Alert al = new Alert(Alert.AlertType.ERROR);
			al.setContentText("Please try again");
			al.setHeaderText("Wrong User Name");
			al.setTitle("Error");
			al.setResizable(false);
			al.showAndWait();
		}
		catch (IllegelUserNameException e1) {
			badSound();
			Alert al = new Alert(Alert.AlertType.ERROR);
			al.setContentText("Please try again");
			al.setHeaderText("Wrong User Name");
			al.setTitle("Error");
			al.setResizable(false);
			al.showAndWait();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	
		public void ForgotPassword(ActionEvent e)
		{
			goodSound();
			try {
				FXMLLoader loader=new FXMLLoader(getClass().getResource("ForgotPassword.fxml"));
				Parent root1=(Parent)loader.load();
				Stage stage=new Stage();
				stage.setTitle("Forgot Password");
				stage.setScene(new Scene(root1));
				ForgotPasswordController.stage=stage;
				stage.show();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	

	/**
	 * method to login to the system
	 * @param id of person
	 * @param password of person
	 */
	public Person loginSystem(long id, String password) throws Exception{
		Person user = Shared.getInstance().getUserConfirmation().get(id);
		if(user == null)
			throw new IllegelUserNameException();

		if(user.getPassword().equals(password))
		{
			return user;
		}
		else
			throw new IllegelPasswordException();
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


