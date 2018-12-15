package application;

import java.util.Random;

public class GameBoard {

	private int[][] answer;//answer
	private int[][] board;//game board
	/* Array that will contain player's numbers */
//	private int[][] player;
	private int holes;

	public GameBoard() {
		answer = new int[][]
		{
			{5,4,3,9,2,1,8,7,6},
			{2,1,9,6,8,7,5,4,3},
			{8,7,6,3,5,4,2,1,9},
			{9,8,7,4,6,5,3,2,1},
			{3,2,1,7,9,8,6,5,4},
			{6,5,4,1,3,2,9,8,7},
			{7,6,5,2,4,3,1,9,8},
			{4,3,2,8,1,9,7,6,5},
			{1,9,8,5,7,6,4,3,2}
		};

		board = new int[9][9];

		Random random = new Random();
		int inp = random.nextInt(3)+1;

		switch(inp) {//스까두기
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
		holes = 1;
        while(holes>0) {
            int inp1 = random.nextInt(9);
            int inp2 = random.nextInt(9);
            if(board[inp1][inp2]!=0) {
                board[inp1][inp2]=0;
                holes--;
            }
        }

		// player's array is boardized as a 9x9 full of zeroes
//		player = new int[9][9];
	}

	public int[][] getAnswer() {return answer;}
	public int[][] getBoard() {return board;}
//	public int[][] getPlayer() {return player;}
//
//	public void modifyPlayer(int val, int row, int col) {//게임 플레이시키는 함수
//		if (board[row][col] == 0) {
//			if(val >= 0 && val <= 9){
//				player[row][col] = val;
//			}
//			else{
//				System.out.println("Value passed to player falls out of range");
//			}
//		}
//	}
//
//	public boolean checkForSuccessGeneral() {//게임성공 실패 판별기
//		int[][] truefalse = new int[9][9];
//		for(int row = 0; row < 9; row++) {
//			for(int col = 0; col <9; col++) {
//				if(board[row][col]!=0) {
//					truefalse[row][col] = board[row][col];
//				} else {
//					truefalse[row][col] = player[row][col];
//				}
//			}
//		}
//		for(int row = 0; row<9; row++) {
//			int sum = 0;
//			for(int col = 0; col<9; col++) {
//				sum = sum + truefalse[row][col];
//			}
//			if(sum!=45) {return false;}
//		}
//
//		for(int col = 0; col<9; col++) {
//			int sum = 0;
//			for(int row = 0; row<9; row++) {
//				sum = sum + truefalse[row][col];
//			}
//			if(sum!=45) {return false;}
//		}
//
//		for (int row = 0; row < 9; row+=3) {
//			for(int col = 0; col <9; col+=3) {
//				int sum = 0;
//				for (int row1 = 0; row1 < 3; row1++) {
//					for (int col1 = 0; col1 < 3; col1++) {
//						sum = sum + truefalse[row1 + row][col1 + col];
//					}
//				}
//				if(sum!=45) {return false;}
//			}
//		}
//		return true;
//	}

}
