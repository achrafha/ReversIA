package model;

import java.awt.Color;

public class Human implements Player {
	
	private Color color;
	private String name;

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public String getMove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
