package view;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import controller.PrimaryController;
import controller.Shared;
import controller.Sound;
import exception.FailToAddException;
import exception.GuideNotExist;
import exception.IllegelCountryException;
import exception.IllegelInputException;
import exception.LocationNotExistException;
import exception.NegativNumberException;
import exception.NegativeNumberNotPriceException;
import exception.ObjectExistException;
import exception.PasswordMismatchException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Destination;

public class GuideAddPageController  implements Initializable {
	private static final String Input = "JavaTravel.ser";
	PrimaryController control=new PrimaryController();
	@FXML
	private TextField customerFirst;

	@FXML
	private TextField customerLast;

	@FXML
	private TextField customerEmail;

	@FXML
	private TextField customerCountry;

	@FXML
	private TextField customerCity;

	@FXML
	private TextField customerStreet;

	@FXML
	private TextField customerHouse;

	@FXML
	private TextField customerPhone;

	@FXML
	private DatePicker customerBirth;

	@FXML
	private Button addCustomer;

	@FXML
	private TextField customerPass;

	@FXML
	private TextField customerPassVerify;

	@FXML
	private TextField customerQuestion;

	@FXML
	private TextField customerId;

	@FXML
	private TextField tripId;

	@FXML
	private TextField tripPrice;

	@FXML
	private DatePicker tripDate;

	@FXML
	private Button addTrip;

	@FXML
	private TextArea tripDescription;

	@FXML
	private ComboBox<String> tripCountry;

	@FXML
	private ComboBox<String> tripCity;

	@FXML
	private TextField tripPeople;

    @FXML
    private TextField tripGuideId;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ArrayList<String> countyList=new ArrayList(Shared.getInstance().getDestinations().keySet());
		ObservableList<String> comboCountryList=FXCollections.observableArrayList();
		comboCountryList.addAll(countyList);
		tripCountry.setItems(comboCountryList);

	}



	public void addCustomer(ActionEvent e)
	{
		String a = "Customer";
		try {
			long id=Long.parseLong(customerId.getText());
			String password=customerPass.getText();
			String passwordVerify=customerPassVerify.getText();
			String answer=customerQuestion.getText();
			String firstName=customerFirst.getText();
			String LastName=customerLast.getText();
			LocalDate localDate =customerBirth.getValue();
			Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
			Date date = Date.from(instant);
			String email=customerEmail.getText();
			String country=customerCountry.getText();
			String city=customerCity.getText();
			String street=customerStreet.getText();
			int houseNumber=Integer.parseInt(customerHouse.getText());
			String phoneNumber=customerPhone.getText();




			control.addCustomer(id,password,passwordVerify,answer,firstName,LastName,date,email,country,city,street,houseNumber,phoneNumber);
			goodSound();
			success(a, "Success");
			Shared.save(Input);
			//pop up with success
			//exception-Customer adding failed,Customer already exists/illegal input
		}
		catch(IllegelInputException e1) {
			badSound();
			fail(a, e1.toString());
		}
		catch(PasswordMismatchException e1) {
			badSound();
			fail(a, e1.toString());
		}
		catch(NegativNumberException e1) {
			badSound();
			fail(a, e1.toString());
		}
		catch(NegativeNumberNotPriceException e1) {
			badSound();
			fail(a, e1.toString());
		}
		catch(ObjectExistException e1) {
			badSound();
			fail(a, "Person"+e1.toString());
		}
		catch(NumberFormatException e1) {
			badSound();
			fail(a, "Wrong Input!");
		}
		catch (Exception e1) {
			badSound();
			fail(a, e1.toString());
		}
	}

	public void addGroupTrip(ActionEvent e)
	{
		String a = "Group Trip";
		try {
			int idtrip=Integer.parseInt(tripId.getText());
			long guideId=Long.parseLong(tripGuideId.getText());
			String description=tripDescription.getText();
			String country=tripCountry.getValue();
			String city=tripCity.getValue();
			double price=Double.parseDouble(tripPrice.getText());
			int maxPeople=Integer.parseInt(tripPeople.getText());
			LocalDate localDateStart =tripDate.getValue();
			Instant instantStart = Instant.from(localDateStart.atStartOfDay(ZoneId.systemDefault()));
			Date tripDate = Date.from(instantStart);

			control.addGroupTrip(idtrip, guideId, description, tripDate, country, city, price, maxPeople);
			goodSound();
			success(a, "Success");
			Shared.save(Input);
				//pop up with success
				//exception-trip adding failed, already exists/illegal input	
		}
		catch(IllegelInputException e1) {
			badSound();
			fail(a, e1.toString());
		}
		catch(ObjectExistException e1) {
			badSound();
			fail(a, a+e1.toString());
		}
		catch(NegativNumberException e1) {
			badSound();
			fail(a, e1.toString());
		}
		catch(NegativeNumberNotPriceException e1) {
			badSound();
			fail(a, e1.toString());
		}
		catch(GuideNotExist e1) {
			badSound();
			fail(a, e1.toString());
		}
		catch(NumberFormatException e1) {
			badSound();
			fail(a, "Wrong Input!");
		}
		catch(IllegelCountryException e1) {
			badSound();
			fail(a,e1.toString());
		}
		catch(LocationNotExistException e1) {
			badSound();
			fail(a,e1.toString());
		}
		catch (Exception e1) {
			badSound();
			fail(a, e1.toString());
		}
	}

	public void showCitiesTrip(ActionEvent e)
	{
		{
			ObservableList<String> list=FXCollections.observableArrayList();

			String country=tripCountry.getValue();
			ArrayList<Destination>dests =Shared.getInstance().getDestinations().get(country);
			for(Destination d:dests)
			{
				list.add(d.getCity());
			}
			tripCity.setItems(list);
		}
	}


	public void success(String content, String header) {
		Alert al = new Alert(Alert.AlertType.INFORMATION);
		al.setContentText(content+" Added Successfully");
		al.setHeaderText(header);
		al.setTitle("Database");
		al.setResizable(false);
		al.showAndWait();
	}

	public void fail(String content, String header) {
		Alert al = new Alert(Alert.AlertType.ERROR);
		al.setContentText("Faild to add : " + content);
		al.setHeaderText(header);
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



