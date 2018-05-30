package model;

public class BoardStd implements Board {

	private int[][] board;
	private int size;
	
	@Override
	public int getCell(int i, int j) {
		if(i >= size || j >= size) {
			throw new AssertionError("illegal argument");
		}
		return board[i][j];
	}

	@Override
	public void playAndUpdate(int i, int j, Player p) {
		// TODO Auto-generated method stub
	}
	
	public int occurencesOfValue(int value) {
		int occurences = 0;
		for(int i = 0; i < board.length; ++i) {
			for(int j = 0; j < board[i].length; ++j) {
				if(board[i][j] == value) {
					++occurences;
				}
			}
		}
		return occurences;
	}

	@Override
	public int getColumnNb() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLineNb() {
		// TODO Auto-generated method stub
		return 0;
	}

}
