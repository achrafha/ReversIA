package model;

import java.awt.Color;
import java.util.ArrayList;

public interface Game {

	Board getBoard();
	
	void playTurn();
	void initGame();
	void endGame();
	
	boolean isFinished();
	boolean isValidMove();
	int getScore(Player p);
	
	ArrayList<Player> getPlayers();
	Player getNextPlayer();
	Player getCurrentPlayer();
	Player getWinner();
	
}
