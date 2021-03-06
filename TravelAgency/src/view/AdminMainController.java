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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class AdminMainController implements Initializable {
	@FXML
	private AnchorPane rootPane;
	@FXML
	private ToggleButton add;
	@FXML
	private ToggleButton manage;

	@FXML
	private ToggleButton queries;

	@FXML
	private ToggleButton exit;
	@FXML
	private ToggleButton log;
	@FXML
	private ToggleButton db;
	@FXML
	private StackPane mainPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		manage.setSelected(false);
		queries.setSelected(false);
		db.setSelected(false);
		add.setSelected(false);
		exit.setSelected(false);
		log.setSelected(false);

	}


	public void loadAdd(ActionEvent e)
	{
		try {
			if(add.isSelected())
			{
				manage.setSelected(false);
				queries.setSelected(false);
				db.setSelected(false);
				TabPane pane=FXMLLoader.load(getClass().getResource("AdminaddPage.fxml"));
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
				manage.setSelected(false);
				queries.setSelected(false);
				add.setSelected(false);
				TabPane pane=FXMLLoader.load(getClass().getResource("AdminDataBasePage.fxml"));
				pane.setPrefSize(rootPane.getWidth(), rootPane.getHeight());
				rootPane.getChildren().removeAll(rootPane.getChildren());
				rootPane.getChildren().add(pane);
			}

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	public void loadManage(ActionEvent e)
	{
		try {
			if(manage.isSelected())
			{
				add.setSelected(false);
				queries.setSelected(false);
				db.setSelected(false);
				TabPane pane=FXMLLoader.load(getClass().getResource("AdminManageOrders.fxml"));
				pane.setPrefSize(rootPane.getWidth(), rootPane.getHeight());
				rootPane.getChildren().removeAll(rootPane.getChildren());
				rootPane.getChildren().add(pane);
			}

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}


	public void loadQueries(ActionEvent e)
	{
		try {
			if(queries.isSelected())
			{
				add.setSelected(false);
				manage.setSelected(false);
				db.setSelected(false);
				TabPane pane=FXMLLoader.load(getClass().getResource("AdminQueryPage.fxml"));
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