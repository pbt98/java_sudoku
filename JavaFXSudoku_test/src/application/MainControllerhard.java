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

public class MainControllerhard implements Initializable {

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

	GameBoardhard gameboard;

	int select_row;
	int select_col;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gameboard = new GameBoardhard();
		select_row = 0;
		select_col = 0;
		GraphicsContext context = canvas.getGraphicsContext2D();
		drawOnCanvas(context);
	}

	public void drawOnCanvas(GraphicsContext context) {
//		int[][] answer = gameboard.getAnswer();
		context.clearRect(0, 0, 450, 450);
		for(int i=0; i<81; i++) {
			int y = (i/9) * 50 + 2;
			int x = (i%9) * 50 + 2;
			int width = 46;
			context.setFill(Color.WHITE);
			context.fillRoundRect(x, y, width, width, 10, 10);
		}
		context.setStroke(Color.BLUE);
		context.setLineWidth(3);
		context.strokeRoundRect(select_col * 50 + 2, select_row * 50 + 2, 46, 46, 10, 10);
		int[][] initial = gameboard.getBoard();

		for(int i=0; i<81; i++) {
			int y = (i/9) * 50 + 30;
			int x = (i%9) * 50 + 20;
			context.setFill(Color.BLACK);
			context.setFont(new Font(20));
			if(initial[i/9][i%9]!=0) {
				context.fillText(initial[i/9][i%9] + "", x, y);
			}
		}
		int[][] player = gameboard.getPlayer();
		for(int i=0; i<81; i++) {
			int y = (i/9) * 50 + 30;
			int x = (i%9) * 50 + 20;
			if(gameboard.checksum(i/9,i%9)){
				context.setFill(Color.BLUE);
			}
			else{
				context.setFill(Color.RED);
			}
			context.setFont(new Font(20));
			if(player[i/9][i%9]!=0) {
				context.fillText(player[i/9][i%9] + "", x, y);
			}
		}
		if(gameboard.checkALL() == true) {
			context.clearRect(0, 0, 450, 450);
			context.setFill(Color.GREEN);
			context.setFont(new Font(36));
			context.fillText("HARD CLEAR!", 150, 250);
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
		gameboard.Play(1, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
	public void buttonTwoPressed() {
		gameboard.Play(2, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonThreePressed() {
		gameboard.Play(3, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonFourPressed() {
		gameboard.Play(4, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonFivePressed() {
		gameboard.Play(5, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonSixPressed() {
		gameboard.Play(6, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonSevenPressed() {
		gameboard.Play(7, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonEightPressed() {
		gameboard.Play(8, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonNinePressed() {
		gameboard.Play(9, select_row, select_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

}
