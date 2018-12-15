package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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
	@FXML GridPane gridpane;
	GameBoard gameboard;

	int select_row;
	int select_col;
	private int[][] player_board;
	private int[][] game_board;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gameboard = new GameBoard();
		select_row = 0;
		select_col = 0;
		game_board = gameboard.getBoard();
		for(int i=0; i<81; i++){
			if(game_board[i/9][i%9]!=0){
				String lis = Integer.toString(game_board[i/9][i%9]);
				Text tex = new Text(lis);
				tex.setFont(Font.font("Arial", FontWeight.BOLD, 20));
				gridpane.add(tex,i/9,i%9);
			}
		}
	}
	@FXML
	public void ongridpane(){
			gridpane.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					int mouse_x = (int) event.getX();
					int mouse_y = (int) event.getY();
					select_row = (int) (mouse_y / 50);
					select_col = (int) (mouse_x / 50);
				}
			});
	}

	public void gridpanewrite(int answer,int x,int y){
		Label lis = new Label();
		if(game_board[x][y]==0){
			game_board[x][y]=answer;
			lis.setText(Integer.toString(game_board[x][y]));
			lis.setStyle("-fx-background-color:white;");
			lis.setTextFill(Color.BLUE);
			gridpane.add(lis, x, y);
		}
//
//		int[][] initial = gameboard.getBoard();
//		for(int i=0; i<81; i++){
//			if(initial[i/9][i%9]!=0){
//				String lis = Integer.toString(initial[i/9][i%9]);
//				Text tex = new Text(lis);
//				tex.setFill(Color.BLACK);
//				tex.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//				gridpane.add(tex,i/9,i%9);
//			}
//		}

//		int[][] played = gameboard.getPlayer();
//		for(int i=0; i<81; i++){
//			if(played[i/9][i%9]!=0){
//				String lis = Integer.toString(played[i/9][i%9]);
//				Text tex = new Text(lis);
//				tex.setFill(Color.GREEN);
//				tex.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//				gridpane.add(tex, i/9, i%9);
//			}
//		}
	}

	public void buttonOnePressed() {
//		gameboard.modifyPlayer(1, select_row, select_col);
//		gridpanewrite();

		gridpanewrite(1, select_row, select_col);
	}
	public void buttonTwoPressed() {
//		gameboard.modifyPlayer(2, select_row, select_col);
//		gridpanewrite();
		gridpanewrite(2, select_row, select_col);
	}

	public void buttonThreePressed() {
//		gameboard.modifyPlayer(3, select_row, select_col);
//		gridpanewrite();
		gridpanewrite(3, select_row, select_col);
	}

	public void buttonFourPressed() {
//		gameboard.modifyPlayer(4, select_row, select_col);
//		gridpanewrite();
		gridpanewrite(4, select_row, select_col);
	}

	public void buttonFivePressed() {
//		gameboard.modifyPlayer(5, select_row, select_col);
//		gridpanewrite();
		gridpanewrite(5, select_row, select_col);
	}

	public void buttonSixPressed() {
//		gameboard.modifyPlayer(6, select_row, select_col);
//		gridpanewrite();
		gridpanewrite(6, select_row, select_col);
	}

	public void buttonSevenPressed() {
//		gameboard.modifyPlayer(7, select_row, select_col);
//		gridpanewrite();
		gridpanewrite(7, select_row, select_col);
	}

	public void buttonEightPressed() {
//		gameboard.modifyPlayer(8, select_row, select_col);
//		gridpanewrite();
		gridpanewrite(8, select_row, select_col);
	}

	public void buttonNinePressed() {
//		gameboard.modifyPlayer(9, select_row, select_col);
//		gridpanewrite();
		gridpanewrite(9, select_row, select_col);
	}

}
