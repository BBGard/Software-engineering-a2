package tacticsAndTrouble;
/**
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tacticsAndTrouble.UI.PlayerTurnScreen;
import tacticsAndTrouble.UI.Screen;
import tacticsAndTrouble.UI.TurnResultsScreen;

/**
 * @author Benjamin Gardiner
 * This is the controller class for the Tactics and Trouble game
 * This class handles player input/output
 * This is the middle class between Game and GUI in the MVC design pattern.
 */
public class ControlClass {
	private Game game;
	private Screen screen;	
	
	private MonsterFactory monsterMaker; // For creating monsters
	
	private boolean running = true;	// Controls if the game loop is running or not

	
	public ControlClass(Game game, Screen screen) {
		this.game = game;
		this.screen = screen;
		
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
		screen.open(this);
	}

	/*
	 * Converts input to appropiate types, creates a new GameCharacter and adds it to the Game
	 */
	public void addPlayer(String name, String power, String defense, String life, String speed, String weapon) {
		
		if (game.canAddPlayers()) {
			GameCharacter player = new Player(name, Integer.parseInt(power), Integer.parseInt(defense), Integer.parseInt(life), 
					Integer.parseInt(speed), new PowerType(weapon));
			game.addPlayer(player);			
		}
		
	}	
	
	/*
	 * Adds a monster to the game
	 * Uses the MonsterFactory class to create the monster
	 */
	public void addMonster(String type) {
		Monster monster = monsterMaker.createMonster(type);		
		game.addMonster(monster);		
	}
	
	/*
	 * Begins the game loop
	 */
	public void startGame() {
		//game.startGame();
		// Get the first player ready
		GameCharacter firstPlayer =	game.setupTurns();
		
		System.out.println("First player is: "+ firstPlayer.getName());
		
		// Maybe add a start screen here?
		
//		if (firstPlayer instanceof Player) {
//			//open player turn screen
//			screen = new PlayerTurnScreen();
//		}
//		else if (firstPlayer instanceof Monster) {
//			
//			screen = new TurnResultsScreen("Tactics & Trouble");
//		}
		
		screen = new TurnResultsScreen("Tactics & Trouble");
		screen.open(this);			

		
//		System.out.println("Starting game loop");
//		while (running) {
//			game.playTurn();
//		}
			
		
	}
	
	
	public void takeTurn() {
		String turnResult = game.playTurn();
		
		if(!(turnResult.equalsIgnoreCase("Player turn."))) {
			screen.setTurnText(game.playTurn());
		}
		else {
			screen = new PlayerTurnScreen();
			screen.open(this);
		}
		
		
	}
}
