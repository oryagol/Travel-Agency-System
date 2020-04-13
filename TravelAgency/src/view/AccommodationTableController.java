package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeSet;

import controller.QueriesController;
import controller.Shared;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Accommodation;
import model.Destination;

public class AccommodationTableController implements Initializable {
	private QueriesController control=new QueriesController();
    static boolean ascending;
	@FXML
	private TableView<AccommodationForTable> accommodationTable;

	@FXML
	private TableColumn<AccommodationForTable, Destination> accommodationLocation;

	@FXML
	private TableColumn<AccommodationForTable, Long> accommodationId;

	@FXML
	private TableColumn<AccommodationForTable, Integer> accommodationRooms;

	@FXML
	private TableColumn<AccommodationForTable, Integer> accommodationPPR;

	@FXML
	private TableColumn<AccommodationForTable, Double> accommodationPrice;

	@FXML
	private TableColumn<AccommodationForTable, String> accommodationType;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//populating Accommodation table
		accommodationLocation.setCellValueFactory(new PropertyValueFactory<AccommodationForTable, Destination>("location"));
		accommodationId.setCellValueFactory(new PropertyValueFactory<AccommodationForTable, Long>("businessId"));
		accommodationRooms.setCellValueFactory(new PropertyValueFactory<AccommodationForTable, Integer>("numberOfRooms"));
		accommodationPPR.setCellValueFactory(new PropertyValueFactory<AccommodationForTable, Integer>("numberOfPeoplePerRoom"));
		accommodationPrice.setCellValueFactory(new PropertyValueFactory<AccommodationForTable, Double>("pricePerPerson"));
		accommodationType.setCellValueFactory(new PropertyValueFactory<AccommodationForTable, String>("type"));
		accommodationTable.setItems(getAccommodationItems());

	}
	private ObservableList<AccommodationForTable> getAccommodationItems() {
		Map<Destination, TreeSet<Accommodation>> data=control.getAllAccommodationSortedByDestination( Shared.getInstance().getAccommodations().values(), ascending);
		ObservableList<AccommodationForTable> accommodation=FXCollections.observableArrayList();
		ArrayList<Accommodation> query=new ArrayList<Accommodation>();
		for(Destination d:data.keySet())
		{
			query.addAll(data.get(d));
		}
		ArrayList<AccommodationForTable> convertForDisplay=new ArrayList<AccommodationForTable>();
		for(Accommodation a:query)
			convertForDisplay.add(new AccommodationForTable(a));
		accommodation.addAll(convertForDisplay);
		return accommodation;
	}
}
