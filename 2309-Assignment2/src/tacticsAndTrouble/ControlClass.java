package tacticsAndTrouble;
/**
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Benjamin Gardiner
 * This is the controller class for the Tactics and Trouble game
 * This class handles player input/output
 * This is the middle class between Game and GUI in the MVC design pattern.
 */
public class ControlClass {
	private Game game;
	private GUI gui;	

	
	public ControlClass(Game game, GUI gui) {
		this.game = game;
		this.gui = gui;
	}
	
	/*
	 * Converts input to appropiate types, creates a new GameCharacter and adds it to the Game
	 */
	public void addPlayer(String name, String power, String defense, String life, String speed, String weapon) {
		
		// Assuming no limit on number of players
		GameCharacter player = new Player(name, Integer.parseInt(power), Integer.parseInt(defense), Integer.parseInt(life), 
				Integer.parseInt(speed), new Weapon(weapon));
		game.addPlayer(player);
	}	

	
}
