package game;

import factory.Factory;

public class Demo {

	public static void main(String[] args) {
		
		Factory.chooseParser("txt");
	
		GameSities game = new GameSities();
		game.startGame();
	}
}
