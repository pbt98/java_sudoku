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
	@FXML Button button_nine;//play button for 1~9
	@FXML Canvas canvas;//draw canvas, easy make sudoku

	GameBoard gameboard;//application.Gameboard

	int select_row;
	int select_col;//player select (x,y)

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gameboard = new GameBoard();
		select_row = 0;
		select_col = 0;//(x,y) reset
		GraphicsContext picture = canvas.getGraphicsContext2D();
		drawCanvas(picture);
	}

	public void drawCanvas(GraphicsContext picture) {//game start to drawing
		picture.clearRect(0, 0, 450, 450);//drawing panel reset
		for(int i=0; i<81; i++) {//white text area 9*9 reset
			int y = (i/9)*50+2;
			int x = (i%9)*50+2;
			int width = 46;
			picture.setFill(Color.WHITE);//white
			picture.fillRoundRect(x, y, width, width, 10, 10);
		}
		picture.setStroke(Color.BLUE);
		picture.setLineWidth(3);
		picture.strokeRoundRect(select_col*50+2, select_row*50+2, 46, 46, 10, 10);

		int[][] initial = gameboard.getBoard();//board call
		for(int i=0; i<81; i++) {//board apply
			int y = (i/9)*50+30;
			int x = (i%9)*50+20;
			picture.setFill(Color.BLACK);
			picture.setFont(new Font(20));
			if(initial[i/9][i%9]!=0) {//if initial[i/9][i%9]==0 --> blank
				picture.fillText(initial[i/9][i%9] + "", x, y);
			}
		}

		int[][] player = gameboard.getPlayer();//player board call --> work during game
		for(int i=0; i<81; i++) {
			int y = (i/9)*50+30;
			int x = (i%9)*50+20;
			if(gameboard.checksum(i/9,i%9)){//gameboard.checksum true --> BLUE letter input
				picture.setFill(Color.BLUE);
			}
			else{//false --> RED letter input
				picture.setFill(Color.RED);
			}
			picture.setFont(new Font(20));//font 20
			if(player[i/9][i%9]!=0) {//if player[i/9][i%9]==0 --> blank
				picture.fillText(player[i/9][i%9] + "", x, y);
			}
		}
		if(gameboard.checkALL()) {//sudoku all clear, true --> game clear
			picture.clearRect(0, 0, 450, 450);//re drawing
			picture.setFill(Color.GREEN);
			picture.setFont(new Font(36));

			select_row = 0;
			select_col = 0;

			picture.fillText("EASY CLEAR!", 150, 250);
		}
	}


	public void MouseClicked() {//click
		canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				int mouse_x = (int)event.getX();
				int mouse_y = (int)event.getY();
				select_row = (int)(mouse_y/50);
				select_col = (int)(mouse_x/50);
				drawCanvas(canvas.getGraphicsContext2D());
			}
		});
	}

	public void OnePress() {//1 pressed
		gameboard.Play(1, select_row, select_col);//game
		drawCanvas(canvas.getGraphicsContext2D());//re draw
	}
	public void TwoPress() {
		gameboard.Play(2, select_row, select_col);
		drawCanvas(canvas.getGraphicsContext2D());
	}

	public void ThreePress() {
		gameboard.Play(3, select_row, select_col);
		drawCanvas(canvas.getGraphicsContext2D());
	}

	public void FourPress() {
		gameboard.Play(4, select_row, select_col);
		drawCanvas(canvas.getGraphicsContext2D());
	}

	public void FivePress() {
		gameboard.Play(5, select_row, select_col);
		drawCanvas(canvas.getGraphicsContext2D());
	}

	public void SixPress() {
		gameboard.Play(6, select_row, select_col);
		drawCanvas(canvas.getGraphicsContext2D());
	}

	public void SevenPress() {
		gameboard.Play(7, select_row, select_col);
		drawCanvas(canvas.getGraphicsContext2D());
	}

	public void EightPress() {
		gameboard.Play(8, select_row, select_col);
		drawCanvas(canvas.getGraphicsContext2D());
	}

	public void NinePress() {
		gameboard.Play(9, select_row, select_col);
		drawCanvas(canvas.getGraphicsContext2D());
	}

}
