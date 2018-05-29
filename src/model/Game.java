package model;

import java.util.ArrayList;

public interface Game {

	Board getBoard();
	
	void playTurn();
	void initGame();
	void endGame();
	
	boolean isFinished();
	boolean isValidMove();
	
	ArrayList<Player> getPlayer();
	Player getNextPlayer();
	Player getCurrentPlayer();
	Player getWinner();
	
}
