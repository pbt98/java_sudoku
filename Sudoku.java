package JavaProject_Sudoku;

import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Sudoku {
	public int[][] Board() { // board 기본값 설정+배열 랜덤설정후 board return
		int[][] lis = { { 4, 9, 2, 7, 5, 8, 6, 3, 1 }, 
		  				{ 1, 3, 6, 4, 2, 9, 7, 5, 8 }, 
		  				{ 8, 7, 5, 3, 1, 6, 4, 2, 9 }, 
		  				{ 7, 2, 1, 9, 8, 5, 3, 4, 6 }, 
		  				{ 9, 5, 3, 6, 7, 4, 8, 1, 2 }, 
		  				{ 4, 6, 8, 2, 3, 1, 5, 9, 7 }, 
		  				{ 6, 4, 5, 1, 9, 7, 2, 8, 3 }, 
		  				{ 3, 1, 7, 8, 4, 2, 9, 6, 5 }, 
		  				{ 2, 8, 9, 5, 6, 3, 1, 7, 4 }};
		int[][] board = new int[9][9];
		
		Random random = new Random();
		int inp = random.nextInt(3)+1;
		
		switch(inp) {
			case 1:{
				int[] temp= {2,0,1,5,4,3,8,6,7};
				for(int i=0; i<9; i++) {
					for(int j=0; j<9; j++) {
						board[i][j]=lis[temp[i]][j];//201534867
					}
				}
				break;
			}
			case 2:{
				int[] temp= {2,0,1,5,4,3,8,6,7};
				for(int i=0; i<9; i++) {
					for(int j=0; j<9; j++) {
						board[j][i]=lis[j][temp[i]];//201534867
					}
				}
				break;
			}
			case 3:{
				int[] temp= {2,0,1,5,4,3,8,6,7};
				int tmp=0;
				for(int i=0; i<9; i++) {
					for(int j=0; j<9; j++) {
						board[i][j]=lis[temp[i]][j];//201534867
					}
				}
				for(int k=0; k<9; k++) {
					for(int l=0; l<9; l++) {
						tmp=board[l][k];
						board[l][k]=board[l][temp[k]];
						board[l][temp[k]]=tmp;
					}
				}
				break;
			}
		}
		return board;
	}
	
	public int get_level(int x) { //level set--> easy or hard
		if(x==1) return 45;
		else return 55;
	}
	
	public int[][] make_holes(int[][] board, int level) { //level에 맞춘 구멍뚫기
		int holes=level;
		while(holes>0) {
			Random random = new Random();
			int inp1 = random.nextInt(9);
			int inp2 = random.nextInt(9);
			if(board[inp1][inp2]!=0) {
				board[inp1][inp2]=0;
				holes--;
			}
		}
		return board;
	}
	
	public Boolean check(int[][] board, int[][] answer, int x, int y) {//정답 체크, 정답보드하고 같을경우 false, 다를경우 true 출력
		boolean answer_1 = false;
		if(board[y-1][x-1]!=answer[y-1][x-1]) {
			answer_1 = true;
		}
		return answer_1;
	}
	
	public static int[][] game_play(int[][] board, int x, int y, int answer){ // game play 잘못된 접근일 경우 잘못된 위치라고 말하고 보드 수정안하고 그대로 리턴
		if(board[y-1][x-1]==0) {
			board[y-1][x-1] = answer;
		}
		else {
			System.out.println("잘못된 위치입니다.");
		}
		return board;
	}
	
	public static int[][] game_play_2(int[][] board, int x, int y){ // 틀렸을때 다시 0으로 수정
		board[y-1][x-1] = 0;
		return board;
	}
	
	public static void printing_board(int[][] board) {// 보드 프린트

		int count = 0;
		System.out.println("┏━━━┳━━━┯━━━┯━━━┳━━━┯━━━┯━━━┳━━━┯━━━┯━━━┓");
		System.out.println("┃   ┃ "+1+" │ "+2+" │ "+3+" ┃ "+4+" │ "+5+" │ "+6+" ┃ "+7+" │ "+8+" │ "+9+" ┃");
		for(int i=0; i<19; i++) {
			if(i==0){
				System.out.println("┣━━━╋━━━┿━━━┿━━━╋━━━┿━━━┿━━━╋━━━┿━━━┿━━━┫");
			}
			else if(i%2==1) {
				System.out.println("┃ "+(count+1)+" ┃ "+board[count][0]+" │ "+board[count][1]+" │ "+board[count][2]+" ┃ "+board[count][3]+" │ "+board[count][4]+" │ "+board[count][5]+" ┃ "+board[count][6]+" │ "+board[count][7]+" │ "+board[count][8]+" ┃");//2 4 8 10 14 16 xxx 6 12 xxx 0 18
				count++;
			}
			else if(i%2==0 && i%6!=0 && i!=0) {
				System.out.println("┠───╂───┼───┼───╂───┼───┼───╂───┼───┼───┨");
			}
			else if(i%6==0 && i!=0 && i!=18) {
				System.out.println("┣━━━╋━━━┿━━━┿━━━╋━━━┿━━━┿━━━╋━━━┿━━━┿━━━┫");
			}
			else {
				System.out.println("┗━━━┻━━━┷━━━┷━━━┻━━━┷━━━┷━━━┻━━━┷━━━┷━━━┛");
			}
		}
	}
	
	public int zerosum(int[][] board) {// 빈칸 갯수 세기
		int sum = 0;
		for(int i=0; i<81; i++) {
			int row = i/9;
			int column = i%9;
			if(board[row][column]==0) {
				sum++;
			}
		}
		return sum;
	}
	
	public static void FileWrite(String username, double time) throws IOException {//데이터 입력 아직 미완성
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/gangdongho/eclipse-workspace/java_test/src/JavaProject_Sudoku/data.txt")); 
        writer.write(username +" : "+ time+"\n"); 
        writer.close();

	}
	
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();

		Scanner scan = new Scanner(System.in);
		System.out.print("level input (1==easy, 2==hard) :");//게임 시작시 난이도 묻기
		int level = scan.nextInt();//입력(나중에 예외처리 진행 예정)
		Sudoku makeboard = new Sudoku();//메이크보드로 스도쿠 생성
		int[][] testboard = makeboard.Board();//정답 보드 미리 제작
		int[][] answerboard = new int[9][9];
		for(int i=0; i<81; i++) {
			int row = i/9;
			int column = i%9;
			answerboard[row][column]=testboard[row][column];
		}
		
		int[][] board = makeboard.make_holes(testboard, makeboard.get_level(level));//정답보드와 초기 입력값을 이용한 수치로 구멍뚫린 게임보드 만들기
		printing_board(board);//게임보드 프린트
		printing_board(answerboard);
		int zero_sum = makeboard.zerosum(board);
		int false_check = 3;
		do{
			System.out.println("x,y,answer input:");
			int x = scan.nextInt();
			int y = scan.nextInt();
			int answer = scan.nextInt();
			board = game_play(board,x,y,answer);
			if(makeboard.check(board, answerboard, x, y)==true) {
				board = game_play_2(board,x,y);
				false_check--;
				System.out.println("sorry you have "+false_check+" chance");
			}
			else {
				printing_board(board);
				zero_sum = makeboard.zerosum(board);
			}
		}while(zero_sum != 0 && false_check!=0); //게임 진행, 제로섬이 0이되면 게임 종료
		
		long end = System.currentTimeMillis();
		
		double time = (end-start)/1000.0;
		
		if(zero_sum == 0) {
			System.out.println("your win!your play time is "+time);//game end
//			System.out.print("input your name(ex:KDH) :");
			String name = "KDH";
			
			FileWrite(name,time);
			
			System.out.println("Tanks you");
		}
		if(false_check == 0) {
			System.out.println("your lose");
		}
	}
}


