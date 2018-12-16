package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller implements Initializable {
	private Stage primaryStage;
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
    @FXML private Button easymode;
    @FXML private Button hardmode;
    @FXML private Button userrank;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        System.out.println("game loading");
    }

    public void nextPage() throws IOException{
    	Stage stage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("gameboard.fxml"));
    	Scene sc = new Scene(root);
    	stage.setScene(sc);
    	stage.show();
    	Stage title = (Stage) easymode.getScene().getWindow();
    	title.close();
    }

    public void easymodePressed() throws IOException{
    	System.out.println("easymode?");
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("easymode");

		Parent parent = FXMLLoader.load(getClass().getResource("gameboard.fxml"));
		Scene scene = new Scene(parent);

		dialog.setScene(scene);
		dialog.show();
    }

    public void hardmodePressed() throws IOException{
    	System.out.println("hardmode?");
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("hardmode");

		Parent parent = FXMLLoader.load(getClass().getResource("gameboardhard.fxml"));
		Scene scene = new Scene(parent);

		dialog.setScene(scene);
		dialog.show();
    }

    public void userrankPressed() throws IOException{
    	System.out.println("rank?");
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("Rank");

		Parent parent = FXMLLoader.load(getClass().getResource("rank.fxml"));
		Scene scene = new Scene(parent);

		dialog.setScene(scene);
		dialog.show();
    }
}
