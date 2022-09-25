package tacticsAndTrouble;
/**
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tacticsAndTrouble.tests.MonsterFactory;

/**
 * @author Benjamin Gardiner
 * This is the controller class for the Tactics and Trouble game
 * This class handles player input/output
 * This is the middle class between Game and GUI in the MVC design pattern.
 */
public class ControlClass {
	private Game game;
	private GUI gui;	
	
	private MonsterFactory monsterMaker; // For creating monsters

	
	public ControlClass(Game game, GUI gui) {
		this.game = game;
		this.gui = gui;
		
		monsterMaker = new MonsterFactory();
	}
	
	/*
	 * Converts input to appropiate types, creates a new GameCharacter and adds it to the Game
	 */
	public void addPlayer(String name, String power, String defense, String life, String speed, String weapon) {
		
		// Assuming no limit on number of players
		GameCharacter player = new Player(name, Integer.parseInt(power), Integer.parseInt(defense), Integer.parseInt(life), 
				Integer.parseInt(speed), new PowerType(weapon));
		game.addPlayer(player);
	}	
	
	/*
	 * Adds a monster to the game
	 * Uses the MonsterFactory class to create the monster
	 */
	public void addMonster(String type) {
		Monster monster = monsterMaker.createMonster(type);		
		game.addMonster(monster);		
	}
	
}
