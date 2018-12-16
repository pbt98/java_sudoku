package application;

import java.util.Random;

public class GameBoardhard {

	private int[][] defalte;//defalte
	private int[][] board;//game board
	private int[][] player;//playing board
	private int[][] answer = new int[9][9];//answer, checksum used
	private int holes;

	public GameBoardhard() {
		defalte = new int[][]//defalte board set
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

		switch(inp) {//random board set
			case 1:{
				int[] temp= {2,0,1,5,4,3,8,6,7};
				for(int i=0; i<9; i++) {
					for(int j=0; j<9; j++) {
						board[i][j]=defalte[temp[i]][j];//201534867
					}
				}
				break;
			}
			case 2:{
				int[] temp= {2,0,1,5,4,3,8,6,7};
				for(int i=0; i<9; i++) {
					for(int j=0; j<9; j++) {
						board[j][i]=defalte[j][temp[i]];//201534867
					}
				}
				break;
			}
			case 3:{
				int[] temp= {2,0,1,5,4,3,8,6,7};
				int tmp=0;
				for(int i=0; i<9; i++) {
					for(int j=0; j<9; j++) {
						board[i][j]=defalte[temp[i]][j];//201534867
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

		for(int i=0; i<81; i++){
			answer[i/9][i%9] = board[i/9][i%9];
		}

		holes = 3;//hard
        while(holes>0) {
            int inp1 = random.nextInt(9);
            int inp2 = random.nextInt(9);
            if(board[inp1][inp2]!=0) {
                board[inp1][inp2]=0;
                holes--;
            }
        }
		player = new int[9][9];
	}

	public int[][] getDefalte() {return defalte;}
	public int[][] getBoard() {return board;}
	public int[][] getPlayer() {return player;}
	public int[][] getAnswer() {return answer;}

	public void Play(int val, int row, int col) {//playing game
		if (board[row][col] == 0) {
			if(val >= 0 && val <= 9){
				player[row][col] = val;
			}
			else{
				System.out.println("Value passed to player falls out of range");
			}
		}
	}

	public boolean checksum(int row, int col){//answer check
		if(player[row][col]==answer[row][col]){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean checkALL() {//sudoku all clear, true --> game clear
		int[][] truefalse = new int[9][9];
		int sum = 0;
		int sum2 = 0;
		for(int i=0; i<81; i++) {
			if(board[i/9][i%9]!=0) {
				truefalse[i/9][i%9] = board[i/9][i%9];
			}
			else {
				truefalse[i/9][i%9] = player[i/9][i%9];
			}
		}

		for(int j=0; j<81; j++) {
			if(j%9 == 0) sum = 0;
			sum += truefalse[j/9][j%9];
			sum2 += 1;
			if(sum!=45 && sum2%9 == 0) {return false;}
		}

		sum2 = 0;

		for(int k=0; k<81; k++) {
			if(k%9 == 0)sum = 0;
			sum += truefalse[k%9][k/9];
			sum2 += 1;
			if(sum!=45 && sum2%9 == 0) {return false;}
		}

		for (int row=0; row<9; row+=3) {
			for(int col=0; col<9; col+=3) {
				sum = 0;
				for (int row1=0; row1<3; row1++) {
					for (int col1=0; col1<3; col1++) {
						sum += truefalse[row1 + row][col1 + col];
					}
				}
				if(sum!=45) {return false;}
			}
		}
		return true;
	}
}
