




package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainController implements Initializable {

	@FXML Button button_one;
	@FXML Button button_two;
	@FXML Button button_three;
	@FXML Button button_four;
	@FXML Button button_five;
	@FXML Button button_six;
	@FXML Button button_seven;
	@FXML Button button_eight;
	@FXML Button button_nine;
	@FXML Canvas canvas;

	GameBoard gameboard;

	int select_row;
	int select_col;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gameboard = new GameBoard();
		select_row = 0;
		select_col = 0;
		GraphicsContext context = canvas.getGraphicsContext2D();
		drawOnCanvas(context);
	}

	public void drawOnCanvas(GraphicsContext context) {
		long start = System.currentTimeMillis();
		context.clearRect(0, 0, 450, 450);
		for(int row = 0; row<9; row++) {
			for(int col = 0; col<9; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.WHITE);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
		context.setStroke(Color.BLUE);
		context.setLineWidth(3);
		context.strokeRoundRect(select_col * 50 + 2, select_row * 50 + 2, 46, 46, 10, 10);
		int[][] initial = gameboard.getBoard();

		for(int row = 0; row<9; row++) {
			for(int col = 0; col<9; col++) {
				int position_y = row * 50 + 30;
				int position_x = col * 50 + 20;
				context.setFill(Color.BLACK);
				context.setFont(new Font(20));
				if(initial[row][col]!=0) {
					context.fillText(initial[row][col] + "", position_x, position_y);
				}
			}
		}
		int[][] player = gameboard.getPlayer();
		for(int row = 0; row<9; row++) {
			for(int col = 0; col<9; col++) {
				int position_y = row * 50 + 30;
				int position_x = col * 50 + 20;
				context.setFill(Color.PURPLE);
				context.setFont(new Font(20));
				if(player[row][col]!=0) {
					context.fillText(player[row][col] + "", position_x, position_y);
				}
			}
		}
		if(gameboard.checkForSuccessGeneral() == true) {
			long end = System.currentTimeMillis();
			double time = (end - start) / 1000;

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
	}

}
