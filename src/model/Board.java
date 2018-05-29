package model;

public interface Board {
	
	int getCell(int i, int j);
	void playAndUpdate(int i, int j, Player p);
	int getScore(Player p);
	int getColumnNb();
	int getLineNb();
	
	
}
