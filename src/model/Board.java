package model;

public interface Board {

	void playAndUpdate(int i, int j, Player p);
	
	int getCell(int i, int j);
	int occurencesOfValue(int value);
	int getColumnNb();
	int getLineNb();

}
