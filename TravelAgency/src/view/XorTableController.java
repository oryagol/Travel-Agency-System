package view;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import controller.QueriesController;
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
import model.Address;
import model.Customer;


public class XorTableController implements Initializable {

	static String flight1;
	static String flight2;

	@FXML
	private TableView<Customer> xorTable;

	@FXML
	private TableColumn<Customer, Long> xorID;

	@FXML
	private TableColumn<Customer, String> xorFirst;

	@FXML
	private TableColumn<Customer, String> xorLast;

	@FXML
	private TableColumn<Customer, Date> xorBirth;

	@FXML
	private TableColumn<Customer, String> xorEmail;

	@FXML
	private TableColumn<Customer, Address> xorAddress;

	private QueriesController control=new QueriesController();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		xorID.setCellValueFactory(new PropertyValueFactory<Customer, Long>("id"));
		xorFirst.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
		xorLast.setCellValueFactory(new PropertyValueFactory<Customer, String>("surname"));
		xorBirth.setCellValueFactory(new PropertyValueFactory<Customer, Date>("birthDate"));
		xorEmail.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
		xorAddress.setCellValueFactory(new PropertyValueFactory<Customer, Address>("address"));
		xorTable.setItems(getItems());



	}


	private ObservableList<Customer> getItems() {
		try {
			ObservableList<Customer> Customers=FXCollections.observableArrayList();
			Customers.addAll(control.getCustomersFlight1XORFlight2(flight1, flight2));
			if(Customers.isEmpty())
				throw new QueryNotFoundException();
			goodSound();
			return Customers;
		}
		catch(QueryNotFoundException e1) {
			badSound();
			Alert al = new Alert(Alert.AlertType.ERROR);
			al.setContentText("Faild to find customers");
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
