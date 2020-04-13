package view;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.Sound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import model.Guide;

public class GuideMainPageController implements Initializable {
	
	private static Guide guide;
	@FXML
    private StackPane mainPane;

    @FXML
    private ToggleButton add;

    @FXML
    private ToggleButton db;

    @FXML
    private ToggleButton exit;

    @FXML
    private AnchorPane rootPane;
    
    @FXML
	private ToggleButton log;

   
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		db.setSelected(false);
		add.setSelected(false);
		
	}

	
	public void loadAdd(ActionEvent e)
	{
		try {
			if(add.isSelected())
			{
				
				db.setSelected(false);
				TabPane pane=FXMLLoader.load(getClass().getResource("GuideaddPage.fxml"));
				pane.setPrefSize(rootPane.getWidth(), rootPane.getHeight());
				rootPane.getChildren().removeAll(rootPane.getChildren());
				rootPane.getChildren().add(pane);
			}

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	public void loadDB(ActionEvent e)
	{
		try {
			if(db.isSelected())
			{
				
				add.setSelected(false);
				TabPane pane=FXMLLoader.load(getClass().getResource("GuideInformationPage.fxml"));
				pane.setPrefSize(rootPane.getWidth(), rootPane.getHeight());
				rootPane.getChildren().removeAll(rootPane.getChildren());
				rootPane.getChildren().add(pane);
			}

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	


	

	public void exitProgrem(ActionEvent e) {
		Alert al = new Alert(Alert.AlertType.CONFIRMATION);
		al.setHeaderText("Are you sure you want to exit the program?");
		al.setTitle("Exit Progrem");
		al.setResizable(false);
		Optional<ButtonType> result = al.showAndWait();
		if(result.get() == ButtonType.OK)
		{
			goodSound();
			System.exit(0);
		}
	}

	public static Guide getGuide() {
		return guide;
	}

	public static void setGuide(Guide guide) {
		GuideMainPageController.guide = guide;
	}

	public void logOutSys(ActionEvent e) {
		Alert al = new Alert(Alert.AlertType.CONFIRMATION);
		al.setHeaderText("Are you sure you want to log out of the system?");
		al.setTitle("Log out");
		al.setResizable(false);
		Optional<ButtonType> result = al.showAndWait();
		if(result.get() == ButtonType.OK)
		{
			goodSound();
			try {
				AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/MiniTours.fxml"));
				pane.setPrefSize(mainPane.getWidth(), mainPane.getHeight());
				mainPane.getChildren().removeAll(mainPane.getChildren());
				mainPane.getChildren().add(pane);
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
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
