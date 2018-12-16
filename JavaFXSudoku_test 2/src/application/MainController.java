package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static com.sun.javafx.application.PlatformImpl.exit;

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
	long start = System.currentTimeMillis();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gameboard = new GameBoard();
		select_row = 0;
		select_col = 0;//(x,y) reset
		GraphicsContext picture = canvas.getGraphicsContext2D();
		drawCanvas(picture);
	}

	public void Data_Save(double time, String name) {
		try {
			File file = new File("datae.txt");
			boolean isExists = file.exists();

			if (isExists) {
				PrintWriter writer = new PrintWriter(new FileWriter("datae.txt", true));
				writer.println(time + ":" + name);
				writer.close();
			} else {
				PrintWriter writer = new PrintWriter(new FileWriter("datae.txt"));
				writer.println(time + ":" + name);
				writer.close();
			}
		} catch(IOException e) {
			exit();
		}
	}

	public void drawCanvas(GraphicsContext picture) {//game start to drawing
		picture.clearRect(0, 0, 450, 450);//drawing panel reset
		int width = 46;
		for(int i=0; i<81; i++) {//white text area 9*9 reset
			int y = (i/9)*50+2;
			int x = (i%9)*50+2;
			picture.setFill(Color.WHITE);//white
			picture.fillRoundRect(x, y, width, width, 10, 10);
		}
		picture.setStroke(Color.BLUE);
		picture.setLineWidth(3);
		picture.strokeRoundRect(select_col*50+2, select_row*50+2, width, width, 10, 10);

		int[][] initial = gameboard.getBoard();//board call
		for(int j=0; j<81; j++) {//board apply
			int y = (j/9)*50+30;
			int x = (j%9)*50+20;
			picture.setFill(Color.BLACK);
			picture.setFont(new Font(20));
			if(initial[j/9][j%9]!=0) {//if initial[j/9][j%9]==0 --> blank
				picture.fillText(initial[j/9][j%9] + "", x, y);
			}
		}

		int[][] player = gameboard.getPlayer();//player board call --> work during game
		for(int k=0; k<81; k++) {
			int y = (k/9)*50+30;
			int x = (k%9)*50+20;
			if(gameboard.checksum(k/9,k%9)){//gameboard.checksum true --> BLUE letter input
				picture.setFill(Color.BLUE);
			}
			else{//false --> RED letter input
				picture.setFill(Color.RED);
			}
			picture.setFont(new Font(20));//font 20
			if(player[k/9][k%9]!=0) {//if player[k/9][k%9]==0 --> blank
				picture.fillText(player[k/9][k%9] + "", x, y);
			}
		}
		if(gameboard.checkALL() == true) {//sudoku all clear, true --> game clear
			picture.clearRect(0, 0, 450, 450);//re drawing
			picture.setFill(Color.GREEN);
			picture.setFont(new Font(36));
			picture.fillText("EASY CLEAR!", 150, 250);
			select_col = 0;
			select_row = 0;
			long end = System.currentTimeMillis();
			double time = (end - start) / 1000.0;
			TextInputDialog dialog = new TextInputDialog("");
			dialog.setTitle("JavaFX Sudoku");
			dialog.setHeaderText("You Won! Your running time is: "+ time);
			dialog.setContentText("Please enter your name");
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(name-> Data_Save(time, name));
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
