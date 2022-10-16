package tacticsAndTrouble;

/**
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tacticsAndTrouble.UI.CombatScreen;
import tacticsAndTrouble.UI.Screen;
import tacticsAndTrouble.UI.PopupScreen;

/**
 * @author Benjamin Gardiner This is the controller class for the Tactics and
 *         Trouble game This class handles player input/output This is the
 *         middle class between Game and GUI in the MVC design pattern.
 */
public class ControlClass {
	private Game game;
	private Screen currentScreen;

	private MonsterFactory monsterMaker; // For creating monsters

	private boolean running = true; // Controls if the game loop is running or not

	public ControlClass(Game game, Screen screen) {
		this.game = game;
		setScreen(screen);

		monsterMaker = new MonsterFactory();

		// FOR TESTING ONLY
		// DELETE ME
		setupFakeGame();
	}

	/*
	 * TESTING PURPOSES ONLY - DELETE
	 */
	private void setupFakeGame() {
		addPlayer("Antoxx", "40", "20", "80", "2", "Spirit");
		addPlayer("Breta", "20", "15", "53", "3", "Normal");
		addPlayer("Crum", "70", "30", "35", "1", "Spirit");
		addMonster("Zombie");
		addMonster("Baron of Hell");

	}

	/*
	 * Opens the splash screen to begin the program
	 */
	public void open() {
		currentScreen.open(this);
	}

	/*
	 * Converts input to appropiate types, creates a new GameCharacter and adds it
	 * to the Game
	 */
	public void addPlayer(String name, String power, String defense, String life, String speed, String weapon) {

		if (game.canAddPlayers()) {
			GameCharacter player = new Player(name, Integer.parseInt(power), Integer.parseInt(defense),
					Integer.parseInt(life), Integer.parseInt(speed), new PowerType(weapon));
			game.addPlayer(player);
		}

	}

	/*
	 * Adds a monster to the game Uses the MonsterFactory class to create the
	 * monster
	 */
	public void addMonster(String type) {
		Monster monster = monsterMaker.createMonster(type);
		game.addMonster(monster);
	}

	/*
	 * Begins the game loop
	 */
	public void beginCombat() {
		game.setupTurns();
		displayTurn();
	}
	
	/**
	 * Calls setup the next turn
	 */
	public void nextTurn() {
		game.nextTurn();
		// If the game is running AND enough players remain alive/revived
		if (game.isRunning() && game.playersRemain()) {			
			displayTurn();
		}
		else if (!game.isRunning() && game.playersRemain()){ // If the end of round is reached, but players remain alive/revived
			// TODO display round over dialog, remaining players
			// start next round by calling game.setupTurns()
		}
		else {
			System.out.println("End game here and return to setup.");
			//TODO display end of game stats?  track these maybe
			// restart the program to player setup screen
		}
	}
	
	/*
	 * calls on the current screen to display the next turns data
	 */
	public void displayTurn() {
		((CombatScreen) currentScreen).setupTurn(game.getCurrentPlayer(), game.getPlayersList(),
				game.getMonstersList());
	}

	/**
	 * Calls the attack function in game
	 * 
	 * @param characterName - the name of the character to attack
	 */
	public void attack(String characterName) {
		System.out.println("Attack " + characterName);
		String result = game.attack(game.getCurrentPlayer(), game.getCharacterByName(characterName));

		((CombatScreen) currentScreen).displayResult(PopupScreen.POPUP_TYPE_ATTACK, result);
	}


	/*
	 * Sets the current screen being shown (tracks state of the game)
	 */
	public void setScreen(Screen currentScreen) {
		this.currentScreen = currentScreen;
	}
}
