package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Shared;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.Order;

public class customerOrdersPageController  implements Initializable {
	
	private static Customer customer;
	
	@FXML
	private TableView<OrdersForTable> orders;

	@FXML
	private TableColumn<OrdersForTable, Integer> ordersID;

	

	@FXML
	private TableColumn<OrdersForTable, Integer> ordersQuantity;

	@FXML
	private TableColumn<OrdersForTable,Double> ordersPrice;

	@FXML
	private TableColumn<OrdersForTable, String> OrdersFlights;

	@FXML
	private TableColumn<OrdersForTable, String> OrderAccom;

	@FXML
	private TableColumn<OrdersForTable, String> ordersTrips;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//populate Orders Table from DB
				ordersID.setCellValueFactory(new PropertyValueFactory<OrdersForTable, Integer>("id"));
				ordersQuantity.setCellValueFactory(new PropertyValueFactory<OrdersForTable, Integer>("quantity"));
				ordersPrice.setCellValueFactory(new PropertyValueFactory<OrdersForTable, Double>("Price"));
				OrdersFlights.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("flights"));
				OrderAccom.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("accommodations"));
				ordersTrips.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("groupTrips"));
				orders.setItems(getItems());
		
	}

	private ObservableList<OrdersForTable> getItems() {
		
		ObservableList<OrdersForTable> orders=FXCollections.observableArrayList();
		ArrayList<Order> query=new ArrayList<Order>(customer.getOrders());
		ArrayList<OrdersForTable> convertedForTable=new ArrayList<OrdersForTable>();
		for(Order o:query)
			convertedForTable.add(new OrdersForTable(o));
		orders.addAll(convertedForTable);
		return orders;

	}
	
	public static Customer getCustomer() {
		return customer;
	}

	public static void setCustomer(Customer customer) {
		customerOrdersPageController.customer = customer;
	}

	
}
