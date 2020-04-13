	
import controller.PrimaryController;
import controller.Shared;
import view.AdminMainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Admin;
import model.Motel;



public class MainClass extends Application{
	private static final String Input = "JavaTravel.ser";
	
	public static void main(String[] args) {
		// loading the database
		Shared.load(Input);
		
		// saving the information in the database
		Shared.save(Input);
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/MiniTours.fxml"));
		Scene scene = new Scene(root,1050,700);
		stage.setTitle("World Tours & Travels");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}

}
