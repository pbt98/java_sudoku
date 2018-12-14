package application;

import java.util.Random;

public class GameBoard {

	private int[][] answer;//answer
	private int[][] board;//game board
	/* Array that will contain player's numbers */
	private int[][] player;

	public GameBoard() {
		answer = new int[][]
		{ 
			{4,9,2,7,5,8,6,3,1}, 
			{1,3,6,4,2,9,7,5,8}, 
			{8,7,5,3,1,6,4,2,9}, 
			{7,2,1,9,8,5,3,4,6}, 
			{9,5,3,6,7,4,8,1,2}, 
			{4,6,8,2,3,1,5,9,7}, 
			{6,4,5,1,9,7,2,8,3}, 
			{3,1,7,8,4,2,9,6,5}, 
			{2,8,9,5,6,3,1,7,4}
		};

		board = new int[][]
		{
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0}
		};

		Random random = new Random();
		int inp = random.nextInt(3)+1;
		
		switch(inp) {
			case 1:{
				int[] temp= {2,0,1,5,4,3,8,6,7};
				for(int i=0; i<9; i++) {
					for(int j=0; j<9; j++) {
						board[i][j]=answer[temp[i]][j];//201534867
					}
				}
				break;
			}
			case 2:{
				int[] temp= {2,0,1,5,4,3,8,6,7};
				for(int i=0; i<9; i++) {
					for(int j=0; j<9; j++) {
						board[j][i]=answer[j][temp[i]];//201534867
					}
				}
				break;
			}
			case 3:{
				int[] temp= {2,0,1,5,4,3,8,6,7};
				int tmp=0;
				for(int i=0; i<9; i++) {
					for(int j=0; j<9; j++) {
						board[i][j]=answer[temp[i]][j];//201534867
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

		// player's array is boardized as a 9x9 full of zeroes
		player = new int[9][9];
	}

	public int[][] getAnswer() {return answer;}
	public int[][] getBoard() {return board;}
	public int[][] getPlayer() {return player;}

	public void modifyPlayer(int val, int row, int col) {//게임 실행
		if (board[row][col] == 0) {
			if(val >= 0 && val <= 9){
				player[row][col] = val;
			}
			else{
				System.out.println("Value passed to player falls out of range");
			}
		}
	}

	public boolean checkForSuccessGeneral() {//참거짓 판별
		int[][] truefalse = new int[9][9];
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col <9; col++) {
				if(board[row][col]!=0) {
					truefalse[row][col] = board[row][col];//0아닌 숫자일때 값 복사
				} else {
					truefalse[row][col] = player[row][col];//0일때 플레이어 값 복사
				}
			}
		}
		for(int row = 0; row<9; row++) {
			int sum = 0;
			for(int col = 0; col<9; col++) {
				sum = sum + truefalse[row][col];//1줄 값 합쳐둠
			}
			if(sum!=45) {return false;}//만약 45가 안나오면 잘못된것이므로 false
		}//전부 통과될경우 리턴없이 다음 확인구문으로 지나감

		for(int col = 0; col<9; col++) { 
			int sum = 0;
			for(int row = 0; row<9; row++) {
				sum = sum + truefalse[row][col];
			}
			if(sum!=45) {return false;}
		}//위와 동일

		for (int row = 0; row < 9; row+=3) {
			for(int col = 0; col <9; col+=3) {
				int sum = 0;
				for (int row1 = 0; row1 < 3; row1++) {
					for (int col1 = 0; col1 < 3; col1++) {
						sum = sum + truefalse[row1 + row][col1 + col]; //3*3 합을 저장
					}
				}
				if(sum!=45) {return false;}//만약 45가 안나오면 잘못된것이므로 false
			}
		}//이 구문을 통과하면 참이므로 마지막에 리턴 true해주고 끝남
		return true;
	}

}
