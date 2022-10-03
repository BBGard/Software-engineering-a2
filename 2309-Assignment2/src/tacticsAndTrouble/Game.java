/**
 * 
 */
package tacticsAndTrouble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Benjamin Gardiner
 * This class represents the game tactics and trouble
 * Within the game, this class is essentially the "Tactician"
 * in charge of all game logic and decisions
 */
public class Game {
	private List<GameCharacter> turnList; 	// List of all players and monsters added according to speed/turns
	private List<GameCharacter> sinBin; 	// List of all players who have been revived, waiting for the next round
	
	private List<GameCharacter> players;	// List of all players
	private List<GameCharacter> monsters;	// List of all monsters
	
	private boolean running = false;		// Controls the main game loop
	
	private static final int MAX_PLAYERS = 5; // Maximum number of players
	private static final int MAX_MONSTERS = 5; // Maximum number of monsters

	public Game() {
		players = new ArrayList<GameCharacter>();
		monsters = new ArrayList<GameCharacter>();		
		turnList = new ArrayList<GameCharacter>();		
	}
	
	/*
	 * Add a player to the game
	 */
	public String addPlayer(GameCharacter player) {
		
		if (players.size() == MAX_PLAYERS) {
			
			return "Reached player limit!";
			//throw new Exception("Reached player limit");
		}
		
		if(player != null) {
			players.add(player);
			
			for (int i=0; i< player.getSpeed(); i++) {
				turnList.add(player);
			}
			return "Player added!";
		}
		
		return "Could not add player!";
		//throw new Exception("Could not add player!");
	}
	
	/*
	 * Add a monster to the game
	 */
	public String addMonster(GameCharacter monster) {
		if(monsters.size() == MAX_MONSTERS) {
			return "Reached monster limit!";
		}
		
		if(monster != null) {
			monsters.add(monster);
			
			for (int i=0; i< monster.getSpeed(); i++) {
				turnList.add(monster);
			}
			return "Monster added!";
		}
		
		return "Could not add monster!"; 
	}
	
	/*
	 * Returns the number of players in the game
	 */
	public int getPlayerCount() {
		return players.size();
	}
	
	/*
	 * Returns the number of monsters in the game
	 */
	public int getMonsterCount() {
		return monsters.size();
	}
	
	/*
	 * Returns true if players.size < MAX_PLAYERS
	 */
	public boolean canAddPlayers() {
		return getPlayerCount() < MAX_PLAYERS;
	}
	
	/*
	 * Returns true if monsters.size < MAX_MONSTERS
	 */
	public boolean canAddMonsters() {
		return getPlayerCount() < MAX_PLAYERS;
	}
	
	/*
	 * Begins the game loop
	 */
	public void startGame() {

		System.out.println("Starting game loop");
		running = true;

		// TODO revive all players in the sinBin
		// set isAlive to true, remove from sin bin
		
		// Game loop
		while (running) {
			// Shuffle turns list
			Collections.shuffle(turnList);

//		System.out.println("turnList after: ");
//		for (GameCharacter gameCharacter : turnList) {
//			System.out.println(gameCharacter.getName());
//		}

			// Iterate through turns
			for (GameCharacter gameCharacter : turnList) {
				// Check that the character is alive first
				if (gameCharacter.isAlive()) {
					// Check if the character is a player or monster
					if (gameCharacter instanceof Monster) {
						// Monster turn
						System.out.println("Character is a monster");
					} else if (gameCharacter instanceof Player) {
						// Player turn
						System.out.println("Character is a player");
					}
				}
			}
			
			running = false;
		}
		System.out.println("Game loop stopped");
		
	}
	
	/*
	 * Calls the attack function on a character
	 */
	public String attack(GameCharacter attacker, GameCharacter defender) {
		return attacker.attack(defender);
	}
	
	/*
	 * Attempts to heal another player
	 */
	public String heal(Player healer, Player playerToHeal) {
		// Roll for a 50% chance to heal
		if(rollForChance(50)) {
			return healer.heal(playerToHeal);
		}
		else {
			return healer.getName() + " attempts to heal " 
					+ playerToHeal.getName() + " but fails!";
		}
	}
	
	/*
	 * Picks a random number based on the percentage input
	 * if 75% picks random number between 0 and 4 (3 in 4 chance)
	 * if 50% picks random number between 0 and 2 (1 in 2 chance)
	 * checks the answer based on percentage
	 */
	public boolean rollForChance(int percentage) {
		Random diceRoll = new Random();
		int roll = 0;
		
		switch (percentage) {
		case 75:
			roll = diceRoll.nextInt(4);
			return roll == 0 || roll == 1 || roll == 2;
		case 50:
			roll = diceRoll.nextInt(2);
			return roll == 0 ;

		default:
			return false;
		}
	}
	
}
