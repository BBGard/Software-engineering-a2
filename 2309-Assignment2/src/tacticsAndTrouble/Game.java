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
	private ArrayList<GameCharacter> turnList; 	// List of all players and monsters added according to speed/turns
	private ArrayList<GameCharacter> sinBin; 	// List of all players who have been revived, waiting for the next round
	
	private ArrayList<GameCharacter> players;	// List of all players
	private ArrayList<GameCharacter> monsters;	// List of all monsters
	
	private boolean running = false;		// Controls the main game loop
	
	private static final int MAX_PLAYERS = 5; // Maximum number of players
	private static final int MAX_MONSTERS = 5; // Maximum number of monsters
	
	private Random randomNumber = new Random();	// Used to generate a random number - dice rolls, choices etc
	private int turnCounter = 0;		// Keeps track of the current turn
	

	public Game() {
		players = new ArrayList<GameCharacter>();
		monsters = new ArrayList<GameCharacter>();		
		turnList = new ArrayList<GameCharacter>();		
		sinBin = new ArrayList<GameCharacter>();		
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
	 * Sets up the turns for each character
	 * Called at the beginning of each game
	 */
	public void setupTurns() {
		System.out.println("Setup turns");
				
		// revive all players in the sinBin if any
		for (GameCharacter revivedCharacter : sinBin) {
			if (revivedCharacter instanceof Player) {
				revivedCharacter.setAlive(true);
				sinBin.remove(revivedCharacter);
			}
		}
		
		// Shuffle turns list
		Collections.shuffle(turnList);		
	}
	
	public GameCharacter getCurrentPlayer() {
		return turnList.get(turnCounter);
	}
	
//	public String playTurn() {
//		String output = "";
//		
//		if (turnCounter < turnList.size()) {
//			GameCharacter currentPlayer = turnList.get(turnCounter);
//			
//			// Check that the character is alive first
//			if (currentPlayer.isAlive()) {
//
//				if (currentPlayer instanceof Monster) {
//					System.out.println("Player is a monster: " + currentPlayer.getName());
//					output = runMonsterTurn(currentPlayer);
//					turnCounter++;
//				} else if (currentPlayer instanceof Player) {
//					System.out.println("Player is a player: " + currentPlayer.getName());
//					output = runPlayerTurn(currentPlayer);
//					turnCounter++;
//				}
//			}
//		}
//		return output;
//	}
	
//	
//	
//	
//	/*
//	 * The logic for a monsters turn
//	 */
//	public String runMonsterTurn(GameCharacter monster) {
//		// Pick random player to attack	from players list	
//		GameCharacter playerToAttack = players.get(randomNumber.nextInt(players.size()));
//		
//		System.out.println("Random player to attack is: " + playerToAttack.getName());
//		
//		// attack that player, print result to console for debugging
//		String result = attack(monster, playerToAttack);
//		System.out.println(result);	
//		
//		return result;
//		
//	}
//	
//	/*
//	 * The logic for a players turn
//	 */
//	public String runPlayerTurn(GameCharacter player) {
//		// Await input
//		String result = "Player turn.";
//		
//		return result;
//	}
	
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
	 * Revives another player
	 * NOTE: revives are unlimited and have 100% chance of success
	 * Probably should limit these in the future
	 */
	public String revive(Player reviver, Player playerToRevive) {
		return reviver.revive(playerToRevive);
	}
	
	/*
	 * Attempts to powerUp the player
	 */
	public String powerUp(Player playerToPowerUp) {
		// Roll for a 75% chance to powerUp
		if (rollForChance(75)) {
			return playerToPowerUp.powerUp();
		} else {
			return playerToPowerUp.getName() + " attempts to power up but fails!";
		}
	}
	
	/*
	 * Picks a random number based on the percentage input
	 * if 75% picks random number between 0 and 4 (3 in 4 chance)
	 * if 50% picks random number between 0 and 2 (1 in 2 chance)
	 * checks the answer based on percentage
	 */
	public boolean rollForChance(int percentage) {		
		int roll = 0;
		
		switch (percentage) {
		case 75:
			roll = randomNumber.nextInt(4);
			return roll == 0 || roll == 1 || roll == 2;
		case 50:
			roll = randomNumber.nextInt(2);
			return roll == 0 ;

		default:
			return false;
		}
	}
	
	public ArrayList<GameCharacter> getPlayersList() {
		return this.players;
	}

	public ArrayList<GameCharacter> getMonstersList() {
		return this.monsters;
	}
}
