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
 *         Trouble game This class handles player input/output This is the
 *         middle class between Game and GUI in the MVC design pattern.
 */
public class ControlClass {
	private Game game;
	//private Screen currentScreen;
	private View view;

	private MonsterFactory monsterMaker; // For creating monsters

	//private boolean running = true; // Controls if the game loop is running or not

	public ControlClass(Game game, View view) {
		this.game = game;
		this.view = view;
		//setScreen(screen);

		monsterMaker = new MonsterFactory();

		// FOR TESTING ONLY
		// DELETE ME
		//setupFakeGame();
	}

	/*
	 * TESTING PURPOSES ONLY - DELETE
	 */
//	private void setupFakeGame() {
//		addPlayer("Antoxx", "40", "20", "80", "2", "Spirit");
//		addPlayer("Breta", "20", "15", "53", "3", "Normal");
//		addPlayer("Crum", "70", "30", "35", "1", "Spirit");		
//		addMonster("Zombie");
//		addMonster("Baron of Hell");
//
//	}

	/*
	 * Opens the splash screen to begin the program
	 */
	public void open() {
		//currentScreen.open(this);
		view.openScreen(this);
	}

	/*
	 * Check if we can add a player
	 * If so, creates a new Player GameCharacter and adds it to the game
	 * returning the result
	 */
	public boolean addPlayer(String name, String power, String defense, String life, String speed, String weapon) {

		if (game.canAddPlayers()) {
			GameCharacter player = new Player(name, Integer.parseInt(power), Integer.parseInt(defense),
					Integer.parseInt(life), Integer.parseInt(speed), new PowerType(weapon));
			return game.addGameCharacter(player);
		}
		else {
			return false;
		}

	}

	/*
	 * Check if we can add a monster
	 * If so, uses the monster factory to create a new monster and adds it to the game
	 * returning the result
	 */
	public boolean addMonster(String type) {
		
		if (game.canAddMonsters()) {
			Monster monster = monsterMaker.createMonster(type);
			return game.addGameCharacter(monster);
		} else {
			return false;
		}
	}

	/*
	 * Starts a new round
	 */
	public void nextRound() {
		game.setupTurns();
		displayTurn();
	}
	
	/**
	 * Runs the next turn
	 * Then displays results depending on the satte of the game
	 */
	public void nextTurn() {
		System.out.println("Next turn");
		game.nextTurn();
		// If the game is running AND enough players remain alive/revived
		if (game.isRunning() && game.canPlay()) {		// STATE 1	- play the turn
			System.out.println("Regular turn");
			displayTurn();
		}
		else if (!game.isRunning() && game.canPlay()){  // STATE 2 - end of round, show results
			// If the end of round is reached, but players remain alive/revived
//			((CombatScreen) currentScreen).displayResult(PopupScreen.POPUP_TYPE_END_OF_ROUND, game.getSummary());
			System.out.println("End of round.");
			view.displayResult(PopupScreen.POPUP_TYPE_END_OF_ROUND, game.getSummary());
			
		}
		else { // STATE 3 - end of game, show summary
			System.out.println("End game here and return to setup.");
			// restart the program to player setup screen
//			((CombatScreen) currentScreen).displayResult(PopupScreen.POPUP_TYPE_END_OF_GAME, game.getSummary());
			System.out.println("End of game");
			view.displayResult(PopupScreen.POPUP_TYPE_END_OF_GAME, game.getSummary());
		}
	}
	
	/*
	 * Calls on the current screen to display the next turns data
	 */
	public void displayTurn() {
//		((CombatScreen) currentScreen).setupTurn(game.getCurrentPlayer(), game.getPlayersList(),
//				game.getMonstersList());
		view.setupTurn(game.getCurrentPlayer(), game.getPlayersList(), game.getMonstersList());
	}

	/*
	 * Carries out an attack move
	 */
	public void attack(String characterToAttack) {
		//System.out.println("Attack " + characterName);
		String result = game.attack( game.getCurrentPlayer(), game.getCharacterByName(characterToAttack));

//		((CombatScreen) currentScreen).displayResult(PopupScreen.POPUP_TYPE_ATTACK, result);
		view.displayResult(PopupScreen.POPUP_TYPE_ATTACK, result);
	}
	
	/*
	 * Carries out a heal move
	 */
	public void heal(String characterToHeal) {
		String result = game.heal(((Player) game.getCurrentPlayer()), ((Player) getCharacterByName(characterToHeal)));
//		((CombatScreen) currentScreen).displayResult(PopupScreen.POPUP_TYPE_HEAL, result);
		view.displayResult(PopupScreen.POPUP_TYPE_HEAL, result);
	}
	
	/*
	 * Carries out a revive move
	 */
	public void revive(String characterToHeal) {
		String result = game.revive(((Player) game.getCurrentPlayer()), ((Player) getCharacterByName(characterToHeal)));
//		((CombatScreen) currentScreen).displayResult(PopupScreen.POPUP_TYPE_REVIVE, result);
		view.displayResult(PopupScreen.POPUP_TYPE_REVIVE, result);
	}
	
	/*
	 * Carries out a powerup move
	 */
	public void powerUp() {
		String result = game.powerUp(((Player) game.getCurrentPlayer()));
//		((CombatScreen) currentScreen).displayResult(PopupScreen.POPUP_TYPE_POWERUP, result);
		view.displayResult(PopupScreen.POPUP_TYPE_POWERUP, result);
	}
	
	/*
	 * Gets a GameCharacter by their name
	 */
	public GameCharacter getCharacterByName(String name) {
		return game.getCharacterByName(name);
	}


	/*
	 * Sets the current screen being shown - changes according to state of the game
	 */
//	public void setScreen(Screen currentScreen) {
//		this.currentScreen = currentScreen;
//	}

	/*
	 * Quits the game and returns to the player setup menu
	 */
	public void quitGame() {
//		((CombatScreen) currentScreen).quit();		
		view.quit();		
	}

	
}
