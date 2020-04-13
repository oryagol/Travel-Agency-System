package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import controller.Shared;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Destination;
import model.GroupTrip;
import model.Guide;

public class GuideInformationsPageController implements Initializable {
	@FXML
	private TableView<GroupTrip> trips;

	@FXML
	private TableColumn<GroupTrip, Integer> tripID;

	@FXML
	private TableColumn<GroupTrip, String> tripDescription;

	@FXML
	private TableColumn<GroupTrip, Date> tripDate;

	@FXML
	private TableColumn<GroupTrip, Destination> tripLocation;

	@FXML
	private TableColumn<GroupTrip, Guide> tripGuide;

	@FXML
	private TableColumn<GroupTrip, Double> tripPrice;

	@FXML
	private TableColumn<GroupTrip, Integer> tripCapacity;

	@FXML
	private TableColumn<GroupTrip, Integer> tripOccupied;
	
	@FXML
	private TableView<Destination> destinations;
	@FXML
	private TableColumn<Destination, String> destCountry;

	@FXML
	private TableColumn<Destination, String> destCity;


@Override
public void initialize(URL location, ResourceBundle resources) {
	//Populating Destination Table from DB
			destCountry.setCellValueFactory(new PropertyValueFactory<Destination, String>("country"));
			destCity.setCellValueFactory(new PropertyValueFactory<Destination, String>("city"));
			destinations.setItems(getDests());
			//Populating GroupTrip table from DB
			tripID.setCellValueFactory(new PropertyValueFactory<GroupTrip, Integer>("tripId"));
			tripDescription.setCellValueFactory(new PropertyValueFactory<GroupTrip, String>("description"));
			tripDate.setCellValueFactory(new PropertyValueFactory<GroupTrip, Date>("date"));
			tripLocation.setCellValueFactory(new PropertyValueFactory<GroupTrip, Destination>("location"));
			tripGuide.setCellValueFactory(new PropertyValueFactory<GroupTrip, Guide>("guide"));
			tripPrice.setCellValueFactory(new PropertyValueFactory<GroupTrip, Double>("price"));
			tripCapacity.setCellValueFactory(new PropertyValueFactory<GroupTrip, Integer>("maxCapacity"));
			tripOccupied.setCellValueFactory(new PropertyValueFactory<GroupTrip, Integer>("currentNumberOfTourists"));
			trips.setItems(getTrips());
		}


private ObservableList<Destination> getDests() {
	ObservableList<Destination> dest=FXCollections.observableArrayList();
	ArrayList<String> query=new ArrayList<String>(Shared.getInstance().getDestinations().keySet());
	ArrayList<Destination> tmp=new ArrayList<Destination> ();
	for(String s:query)
		tmp.addAll(Shared.getInstance().getDestinations().get(s));
	dest.addAll(tmp);
	return dest;	
}

private ObservableList<GroupTrip> getTrips() {
	ObservableList<GroupTrip> trips=FXCollections.observableArrayList();
	ArrayList<GroupTrip> query=new ArrayList<GroupTrip>(Shared.getInstance().getTrips().values());

	trips.addAll(query);
	return trips;	
}
	
}

