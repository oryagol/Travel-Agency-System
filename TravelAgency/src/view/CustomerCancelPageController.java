package view;

import java.net.URL;
import java.util.ResourceBundle;

import controller.PrimaryController;
import controller.Shared;
import controller.Sound;
import exception.RemoveOrderException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import model.Customer;
import model.Order;

public class CustomerCancelPageController  implements Initializable  {
	 static Customer customer;
	 private static final String Input = "JavaTravel.ser";
	   @FXML
	    private AnchorPane CancelOrderCancel;

	    @FXML
	    private ComboBox<Integer> cancelOrderId;

	    @FXML
	    private Button orderFromPackageOrder1;
	    
		PrimaryController control=new PrimaryController();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Integer> oList=FXCollections.observableArrayList();
		for(Order o : customer.getOrders()) {
			
			oList.add(o.getOrderId());
		}
		cancelOrderId.setItems(oList);
		
		
	}
	public static Customer getCustomer() {
		return customer;
	}
	public static void setCustomer(Customer customer) {
		CustomerCancelPageController.customer = customer;
	}
	
	public void cancelOrder(ActionEvent e)
	{
		String a = "Order";
		try {
			boolean isOK = false;
			isOK = control.cancelOrder(cancelOrderId.getValue());
			if(isOK == false)
				throw new RemoveOrderException();
			else
			{
				goodSound();
				Shared.save(Input);
				remove(a);
			}
		}
		catch(RemoveOrderException e1) {
			badSound();
			failRemove(a);
		}
	}

	

	public void remove(String a) {
		Alert al = new Alert(Alert.AlertType.INFORMATION);
		al.setContentText(a+" Removed Successfully");
		al.setHeaderText("Success");
		al.setTitle("Database");
		al.setResizable(false);
		al.showAndWait();
	}

	public void failRemove(String a) {
		Alert al = new Alert(Alert.AlertType.ERROR);
		al.setContentText(a+" Failed To Remove");
		al.setHeaderText("Fail");
		al.setTitle("Database");
		al.setResizable(false);
		al.showAndWait();
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
