package tacticsAndTrouble;

/**
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tacticsAndTrouble.UI.CombatScreen;
import tacticsAndTrouble.UI.Screen;
import tacticsAndTrouble.UI.ICombatInterface;
import tacticsAndTrouble.UI.View;
import tacticsAndTrouble.UI.PopupScreen;

/**
 * @author Benjamin Gardiner This is the controller class for the Tactics and
 *         Trouble game.
 *         This class handles communication between the game and the GUI 
 *         This is the middle class between Game and View in the MVC design pattern.
 */
public class ControlClass {
	private Game game;	// Reference to the Game
	private View view;	// Reference to the View

	private MonsterFactory monsterMaker; // For creating monsters

	
	public ControlClass(Game game, View view) {
		this.game = game;
		this.view = view;

		monsterMaker = new MonsterFactory();
	}

	/*
	 * Opens the splash screen to begin the program
	 */
	public void open() {
		view.openScreen(this);
	}

	/*
	 * Creates a new Player GameCharacter and tries to add it to the game
	 * returning the result
	 */
	public boolean addPlayer(String name, String power, String defense, String life, String speed, String weapon) {

		GameCharacter player = new Player(name, Integer.parseInt(power), Integer.parseInt(defense),
				Integer.parseInt(life), Integer.parseInt(speed), new PowerType(weapon));
		
		return game.addGameCharacter(player);
	}

	/*
	 * Check if we can add a monster
	 * If so, uses the monster factory to create a new monster and adds it to the game
	 * returning the result
	 */
	public boolean addMonster(String type) {
		
		Monster monster = monsterMaker.createMonster(type);
			
		return game.addGameCharacter(monster);
	}

	/*
	 * Starts a new round
	 */
	public void nextRound() {
		game.setupRound();
		displayTurn();
	}
	
	/**
	 * Runs the next turn
	 * Then displays results depending on the STATE of the game
	 */
	public void nextTurn() {
		game.nextTurn();
		
		// If the game is running AND enough players remain alive/revived
		if (game.isRunning() && game.canPlay()) {		// STATE 1	- play the turn
			displayTurn();
		}
		else if (!game.isRunning() && game.canPlay()){  // STATE 2 - end of round, show results
			// If the end of round is reached, but players remain alive/revived
			view.displayResult(PopupScreen.POPUP_TYPE_END_OF_ROUND, game.getSummary());
			
		}
		else { // STATE 3 - end of game, show summary
			// restart the program to player setup screen
			view.displayResult(PopupScreen.POPUP_TYPE_END_OF_GAME, game.getSummary());
		}
	}
	
	/*
	 * Calls on the current view to display the next turns data
	 */
	public void displayTurn() {
		view.setupTurn(game.getCurrentPlayer(), game.getPlayersList(), game.getMonstersList());
	}

	/*
	 * Carries out an attack move, tells view to display result
	 */
	public void attack(String characterToAttack) {
		String result = game.attack( game.getCurrentPlayer(), game.getCharacterByName(characterToAttack));

		view.displayResult(PopupScreen.POPUP_TYPE_ATTACK, result);
	}
	
	/*
	 * Carries out a heal move, tells view to display result
	 */
	public void heal(String characterToHeal) {
		String result = game.heal(((Player) game.getCurrentPlayer()), ((Player) getCharacterByName(characterToHeal)));
		view.displayResult(PopupScreen.POPUP_TYPE_HEAL, result);
	}
	
	/*
	 * Carries out a revive move, tells view to display result
	 */
	public void revive(String characterToHeal) {
		String result = game.revive(((Player) game.getCurrentPlayer()), ((Player) getCharacterByName(characterToHeal)));
		view.displayResult(PopupScreen.POPUP_TYPE_REVIVE, result);
	}
	
	/*
	 * Carries out a powerup move, tells view to display result
	 */
	public void powerUp() {
		String result = game.powerUp(((Player) game.getCurrentPlayer()));
		view.displayResult(PopupScreen.POPUP_TYPE_POWERUP, result);
	}
	
	/*
	 * Asks game to retrieve a GameCharacter by their name
	 */
	public GameCharacter getCharacterByName(String name) {
		return game.getCharacterByName(name);
	}

	/*
	 * Tells View to quit the game and return to the player setup menu
	 */
	public void quitGame() {
		view.quit();		
	}

	
}
