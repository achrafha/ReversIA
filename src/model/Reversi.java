package model;

import java.awt.Color;
import java.util.ArrayList;

public class Reversi implements Game {

	private Player black;
	private Player white;
	private final static int BLACK_VALUE = -1;
	private final static int WHITE_VALUE = 1;
	private final static int EMPTY = -1;
	private Player whitePlayer;
	private Board board;

	@Override
	public int getScore(Player p) {
		int score = 0;
		if(p == whitePlayer) {
			score = board.occurencesOfValue(WHITE_VALUE);
			return score;
		}
		score = board.occurencesOfValue(BLACK_VALUE);
		return score;
		

	}

	@Override
	public Board getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void playTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void endGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player getNextPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

}
