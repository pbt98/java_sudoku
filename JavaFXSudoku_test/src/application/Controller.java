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
<<<<<<< Updated upstream
	private Stage primaryStage;
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
=======

	@FXML Button button_one; //버튼 생성 1~9
	@FXML Button button_two;
	@FXML Button button_three;
	@FXML Button button_four;
	@FXML Button button_five;
	@FXML Button button_six;
	@FXML Button button_seven;
	@FXML Button button_eight;
	@FXML Button button_nine;
	@FXML Canvas canvas; // 캔버스 생성, 여기에 판 만들고 게임할거임
	GameBoard gameboard;
	int select_row;
	int select_col;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {//이거슨 초기화임
		gameboard = new GameBoard();
		select_row = 0;
		select_col = 0;
		GraphicsContext context = canvas.getGraphicsContext2D();
		drawOnCanvas(context);
	}

	public void drawOnCanvas(GraphicsContext context) {
		context.clearRect(0, 0, 450, 450);
		for(int row = 0; row<9; row++) {
			for(int col = 0; col<9; col++) {
				int y = row * 50 + 2;
				int x = col * 50 + 2;
				int width = 46;

				context.setFill(Color.WHITE);

				context.fillRoundRect(x, y, width, width, 10, 10);
			}
		}
		context.setStroke(Color.BLUE);
		context.setLineWidth(3);
		context.strokeRoundRect(select_col * 50 + 2, select_row * 50 + 2, 46, 46, 10, 10);
		int[][] initial = gameboard.getBoard();

		for(int row = 0; row<9; row++) {
			for(int col = 0; col<9; col++) {
				int y = row * 50 + 30;
				int x = col * 50 + 20;
				context.setFill(Color.BLACK);
				context.setFont(new Font(20));
				if(initial[row][col]!=0) {
					context.fillText(initial[row][col] + "", x, y);
				}
			}
		}
		int[][] player = gameboard.getPlayer();
		for(int row = 0; row<9; row++) {
			for(int col = 0; col<9; col++) {
				int y = row * 50 + 30;
				int x = col * 50 + 20;
				context.setFill(Color.PURPLE);
				context.setFont(new Font(20));
				if(player[row][col]!=0) {
					context.fillText(player[row][col] + "", x, y);
				}
			}
		}
		if(gameboard.checkForSuccessGeneral() == true) {
			context.clearRect(0, 0, 450, 450);
			context.setFill(Color.GREEN);
			context.setFont(new Font(36));
			context.fillText("SUCCESS!", 150, 250);
		}
	}
	public void canvasMouseClicked() {
		canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				int mouse_x = (int) event.getX();
				int mouse_y = (int) event.getY();
				select_row = (int) (mouse_y / 50);
				select_col = (int) (mouse_x / 50);
				drawOnCanvas(canvas.getGraphicsContext2D());
			}
		});
	}

	public void buttonOnePressed() {
		gameboard.modifyPlayer(1, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
	public void buttonTwoPressed() {
		gameboard.modifyPlayer(2, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
	public void buttonThreePressed() {
		gameboard.modifyPlayer(3, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
	public void buttonFourPressed() {
		gameboard.modifyPlayer(4, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
	public void buttonFivePressed() {
		gameboard.modifyPlayer(5, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
	public void buttonSixPressed() {
		gameboard.modifyPlayer(6, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
	public void buttonSevenPressed() {
		gameboard.modifyPlayer(7, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
	public void buttonEightPressed() {
		gameboard.modifyPlayer(8, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
	public void buttonNinePressed() {
		gameboard.modifyPlayer(9, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
>>>>>>> Stashed changes
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
