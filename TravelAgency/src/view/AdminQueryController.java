package view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeSet;

import controller.QueriesController;
import controller.Shared;
import controller.Sound;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Accommodation;
import model.Address;
import model.Person;
import model.Destination;
import model.Order;
import model.TravelPackage;

public class AdminQueryController implements Initializable{
	private static final String Input = "JavaTravel.ser";
	private QueriesController control=new QueriesController();

	@FXML
	private TableView<Destination> PopularDestinationsTable;

	@FXML
	private TableColumn<Destination, String> popularDestCountry;

	@FXML
	private TableColumn<Destination, String> popularDestCity;

	@FXML
	private TextField packagesMinPrice;

	@FXML
	private TextField packagesMaxPrice;

	@FXML
	private Button packagesGet;

	@FXML
	private AnchorPane packagesTableWrapper;

	@FXML
	private TableView<Person> wifiTable;

	@FXML
	private TableColumn<Person, Long> wifiId;

	@FXML
	private TableColumn<Person, String> wifiFirst;

	@FXML
	private TableColumn<Person, String> wifiLat;

	@FXML
	private TableColumn<Person, Date> wifiBirth;

	@FXML
	private TableColumn<Person, String> wifiEmail;

	@FXML
	private TableColumn<Person, Address> wifiAddress;

	@FXML
	private AnchorPane accommodationTableWrapper;

	@FXML
	private Button accommodationsAsc;

	@FXML
	private Button accommodationsDsc;

	@FXML
	private TableView<OrdersForTable> ordersTable;

	@FXML
	private TableColumn<OrdersForTable, Double> ordersPrice;

	@FXML
	private TableColumn<OrdersForTable, Integer> ordersID;

	@FXML
	private TableColumn<OrdersForTable, String> ordersOwner;

	@FXML
	private TableColumn<OrdersForTable, Integer> ordersQuantity;

	@FXML
	private ComboBox<String> xorFlightOne;

	@FXML
	private ComboBox<String> xorFlightTwo;

	@FXML
	private Button xorGetPersons;

	@FXML
	private AnchorPane xorTableWrapper;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//populating popular destinations table
		popularDestCountry.setCellValueFactory(new PropertyValueFactory<Destination, String>("Country"));
		popularDestCity.setCellValueFactory(new PropertyValueFactory<Destination, String>("City"));
		PopularDestinationsTable.setItems(getDestItems());
		//populating WIFI table
		wifiId.setCellValueFactory(new PropertyValueFactory<Person, Long>("id"));
		wifiFirst.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		wifiLat.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
		wifiBirth.setCellValueFactory(new PropertyValueFactory<Person, Date>("birthDate"));
		wifiEmail.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		wifiAddress.setCellValueFactory(new PropertyValueFactory<Person, Address>("address"));
		wifiTable.setItems(getWifiItems());
		//populating Orders Table
		ordersID.setCellValueFactory(new PropertyValueFactory<OrdersForTable, Integer>("id"));
		ordersOwner.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("owner"));
		ordersQuantity.setCellValueFactory(new PropertyValueFactory<OrdersForTable, Integer>("quantity"));
		ordersPrice.setCellValueFactory(new PropertyValueFactory<OrdersForTable, Double>("Price"));
		ordersTable.setItems(getOrderItems());
		//populating FlightXOR comboBoxes
		ObservableList<String> flights=FXCollections.observableArrayList();
		ArrayList<String> flightNumber=new ArrayList<String>();
		for(String f:Shared.getInstance().getFlights().keySet())
			flightNumber.add(f);
		flights.addAll(flightNumber);
		xorFlightOne.setItems(flights);
		xorFlightTwo.setItems(flights);


	}
	public void getXorCustomers(ActionEvent e)
	{
		XorTableController.flight1=xorFlightOne.getValue();
		XorTableController.flight2=xorFlightTwo.getValue();
		TableView<TravelPackage> pane;
		try {
			pane = FXMLLoader.load(getClass().getResource("FlightOneXorTwoTable.fxml"));
			pane.setPrefSize(xorTableWrapper.getWidth(), xorTableWrapper.getHeight());
			xorTableWrapper.getChildren().removeAll(xorTableWrapper.getChildren());
			xorTableWrapper.getChildren().add(pane);
		}

		catch (IOException e1) {

			e1.printStackTrace();
		}

	}


	private ObservableList<OrdersForTable> getOrderItems() {
		ObservableList<OrdersForTable> orders=FXCollections.observableArrayList();
		ArrayList<Order> query=new ArrayList<Order>(control.getAllOrdersSortededByTotalCost());
		ArrayList<OrdersForTable> convertedForTable=new ArrayList<OrdersForTable>();
		for(Order o:query)
			convertedForTable.add(new OrdersForTable(o));
		orders.addAll(convertedForTable);
		return orders;
	}




	public void getAccommodationAsc(ActionEvent e)
	{
		goodSound();
		AccommodationTableController.ascending=true;
		TableView<TravelPackage> pane;
		try {
			pane = FXMLLoader.load(getClass().getResource("AccommodationTable.fxml"));
			pane.setPrefSize(accommodationTableWrapper.getWidth(), accommodationTableWrapper.getHeight());
			accommodationTableWrapper.getChildren().removeAll(accommodationTableWrapper.getChildren());
			accommodationTableWrapper.getChildren().add(pane);
		}

		catch (IOException e1) {

			e1.printStackTrace();
		}


	}
	public void getAccommodationDsc(ActionEvent e)
	{
		goodSound();
		AccommodationTableController.ascending=false;
		TableView<TravelPackage> pane;
		try {
			pane = FXMLLoader.load(getClass().getResource("AccommodationTable.fxml"));
			pane.setPrefSize(accommodationTableWrapper.getWidth(), accommodationTableWrapper.getHeight());
			accommodationTableWrapper.getChildren().removeAll(accommodationTableWrapper.getChildren());
			accommodationTableWrapper.getChildren().add(pane);
		}

		catch (IOException e1) {

			e1.printStackTrace();
		}

	}


	private ObservableList<Person> getWifiItems() {
		ObservableList<Person> wifi=FXCollections.observableArrayList();
		ArrayList<Person> query=new ArrayList<Person>();
		query.addAll(control.getAllCustomersWhoOrdered_A_MotelWithWiFiService());
		wifi.addAll(query);
		return wifi;
	}

	private ObservableList<Destination> getDestItems() {
		ObservableList<Destination> popular=FXCollections.observableArrayList();
		ArrayList<Destination> query=(ArrayList<Destination>) control.getMostPopularDestinations();
		popular.addAll(query);


		return popular;
	}


	public void getPackagesInRange(ActionEvent e)
	{
		try {
			double min=Double.parseDouble(packagesMinPrice.getText());
			double max=Double.parseDouble(packagesMaxPrice.getText());
			ArrayList<TravelPackage> query=new ArrayList<TravelPackage> (control.getAllPackagesInRange(min, max));
			PackageTableController.tableInput=query;
			TableView<TravelPackage> pane;
			pane = FXMLLoader.load(getClass().getResource("PackagesTable.fxml"));
			pane.setPrefSize(packagesTableWrapper.getWidth(), packagesTableWrapper.getHeight());
			packagesTableWrapper.getChildren().removeAll(packagesTableWrapper.getChildren());
			packagesTableWrapper.getChildren().add(pane);
		}

		catch (IOException e1) {

			e1.printStackTrace();
		}
		catch(NumberFormatException e1) {
			badSound();
			Alert al = new Alert(Alert.AlertType.ERROR);
			al.setContentText("Please type numbers");
			al.setHeaderText("Input Error");
			al.setTitle("Database");
			al.setResizable(false);
			al.showAndWait();
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
