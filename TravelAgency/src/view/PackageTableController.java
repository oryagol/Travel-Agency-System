package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Sound;
import exception.QueryNotFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Destination;
import model.TravelPackage;

public class PackageTableController implements Initializable  {
	static ArrayList<TravelPackage> tableInput;

	@FXML
	private TableView<TravelPackageForTable> packagesInRangeTable;

	@FXML
	private TableColumn<TravelPackageForTable, String> packagesName;

	@FXML
	private TableColumn<TravelPackageForTable, Integer> packagesId;

	@FXML
	private TableColumn<TravelPackageForTable, Integer> packagesQunatity;

	@FXML
	private TableColumn<TravelPackageForTable, Double> packagesPrice;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		packagesName.setCellValueFactory(new PropertyValueFactory<TravelPackageForTable, String>("Name"));
		packagesId.setCellValueFactory(new PropertyValueFactory<TravelPackageForTable, Integer>("id"));
		packagesQunatity.setCellValueFactory(new PropertyValueFactory<TravelPackageForTable, Integer>("quantity"));
		packagesPrice.setCellValueFactory(new PropertyValueFactory<TravelPackageForTable, Double>("Price"));

		packagesInRangeTable.setItems(getItems());
	}

	private ObservableList<TravelPackageForTable> getItems() {
		try {
			ObservableList<TravelPackageForTable> popular=FXCollections.observableArrayList();
			ArrayList<TravelPackageForTable> convertToDisplay=new ArrayList<TravelPackageForTable>();
			for(TravelPackage tp:tableInput)
				convertToDisplay.add(new TravelPackageForTable(tp));
			popular.addAll(convertToDisplay);
			if(popular.isEmpty())
				throw new QueryNotFoundException();
			goodSound();
			return popular;
		}
		catch(QueryNotFoundException e1) {
			badSound();
			Alert al = new Alert(Alert.AlertType.ERROR);
			al.setContentText("Faild to find packages");
			al.setHeaderText(e1.toString());
			al.setTitle("Database");
			al.setResizable(false);
			al.showAndWait();
			return null;
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

	public void badSound() {
		Sound s = new Sound();
		try {
			s.errorSound();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
