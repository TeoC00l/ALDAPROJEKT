//Author: Teodor Tysklind tety9897

public class EightQueenProblem {
	
	private final int BOARD_WIDTH_HEIGHT = 8;
	private int[][] board = new int[BOARD_WIDTH_HEIGHT][BOARD_WIDTH_HEIGHT];
	
	private void printBoard() {
		for(int row = 0; row < BOARD_WIDTH_HEIGHT ; row ++) {
			
			for(int column = 0; column < BOARD_WIDTH_HEIGHT; column++) {
				System.out.print("[" + board[row][column] + "]");					
				}
			System.out.println();
			}
		}
	
	private boolean attackCheck(int row, int column) {
		
		//Check for vertical hit
		for (int r = 0 ; r < BOARD_WIDTH_HEIGHT ; r++) {
			if (board[r][column] != 0) {
				return false;
			}
		}
		
		//Check for horizontal hit
		for (int c = 0 ; c < BOARD_WIDTH_HEIGHT ; c++) {
			if (board[row][c] != 0) {
				return false;
			}
		}
		
		
		//Check for hit diagonally, upper left corner and down
		for (int r = 0, c = column-row; r < BOARD_WIDTH_HEIGHT ; r++, c++) {
			
			if(c >= 0 && c< BOARD_WIDTH_HEIGHT) {
				if(board[r][c] != 0) {
					return false;
				}
			}			
		}
		
		//Check for hit diagonally, upper right corner and down
		for (int r = 0, c = column + row ; r < BOARD_WIDTH_HEIGHT ; r++, c--) {
			
			if(c >= 0 && c< BOARD_WIDTH_HEIGHT) {
				if(board[r][c] != 0) {
					return false;
				}		
			}	
		}
		
		return true;
	}
	
	//Using backtracking algorithm to recursively find placements for queens
	private boolean placeQueens(int queensPlaced) {
		
		for(int row = 0; row < BOARD_WIDTH_HEIGHT ; row++) {			
			
			if(queensPlaced == BOARD_WIDTH_HEIGHT) {
				return true;
			}

			for(int column = 0 ; column < BOARD_WIDTH_HEIGHT ; column++) {				
				
				if (attackCheck(row, column)) {					
					board[row][column] = 1;
					
					if(placeQueens(queensPlaced +1)) {
						return true;
					}
					board[row][column] = 0;
				}
			}
		}
		return false;
	}
	
	public void run(){
		if (placeQueens(0)) {
			printBoard();
		}else {
			System.out.println("Placements failed");
		}
	}
	
	public static void main (String[] args) {
		EightQueenProblem eqp = new EightQueenProblem();
		eqp.run();
	}
}