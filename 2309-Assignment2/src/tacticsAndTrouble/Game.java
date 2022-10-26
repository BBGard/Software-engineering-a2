/**
 * 
 */
package tacticsAndTrouble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Benjamin Gardiner
 * This is the main game class for the game tactics and trouble
 * This class holds all gameplay related data and methods
 * This is the "model" in the model-view-controller design pattern
 */
public class Game {
	private ArrayList<GameCharacter> turnList; 	// List of all players and monsters in order of their turns
	private ArrayList<GameCharacter> sinBin; 	// List of all players who have been revived, waiting for the next round, not currently in play	
	private ArrayList<GameCharacter> players;	// List of all players in the game
	private ArrayList<GameCharacter> monsters;	// List of all monsters in the game
	
	private boolean turnsRemaining = false;		// Controls the turns in each round - true if turns remain
	private boolean gameOver = false;			// Controls the game - false if players and monsters remain alive
	
	private static final int MAX_PLAYERS = 5; // Maximum number of players
	private static final int MAX_MONSTERS = 5; // Maximum number of monsters
	
	private Random randomNumber = new Random();	// Used to generate a random number - dice rolls, choices etc
	
	private int turnCounter = 0;		// Keeps track of the current turn
	private int roundCounter = 0;		// Tracks the number of rounds
	

	public Game() {
		players = new ArrayList<GameCharacter>();
		monsters = new ArrayList<GameCharacter>();		
		turnList = new ArrayList<GameCharacter>();		
		sinBin = new ArrayList<GameCharacter>();		
	}
	
	/*
	 * Attempts to add a GameCharacter to the game
	 * Determines if the character is a player or monster 
	 * and adds to the appropriate list
	 */
	public boolean addGameCharacter(GameCharacter character) {
		
		if(character != null) {
			if(character instanceof Player) {
				if(!canAddPlayers()) { return false; }				
				players.add(character); // Add player to the player list				
			}
			else if (character instanceof Monster) {
				if(!canAddMonsters()) { return false; }	
				monsters.add(character); // add monster to the monster list
			}
			
			// Add character to the turns list according to their speed/number of turns
			for (int i = 0; i < character.getSpeed(); i++) {
				turnList.add(character);
			}
			return true;
		}
		
		return false;
	}
	
	/*
	 * Sets up a new round for the game
	 * Called at the beginning of each game/each new round
	 * Revives players, removes powerups, shuffles turns
	 */
	public void setupRound() {
		gameOver = false;
		turnCounter = 0;
		roundCounter++;
						
		ArrayList<GameCharacter> charactersToRevive = new ArrayList<GameCharacter>();
		
		// Revive all players in the sinBin if any
		for (GameCharacter revivedCharacter : sinBin) {
			if (revivedCharacter instanceof Player) {
				revivedCharacter.setAlive(true);
				charactersToRevive.add(revivedCharacter);
				
				for (int i=0; i< revivedCharacter.getSpeed(); i++) {
					turnList.add(revivedCharacter);
				}				
			}
		}
		
		// Clear the sinBin
		sinBin.removeAll(charactersToRevive);
		
		// Remove any powerups
		for (GameCharacter gameCharacter : players) {
			gameCharacter.resetAttributes();
		}
		
		// Shuffle turns list and begin the game
		Collections.shuffle(turnList);	
		turnsRemaining = true;		
		
		/*
		 * DEBUG
		 */
//		System.out.println("Turns");
//		for (GameCharacter gameCharacter : turnList) {
//			System.out.println(gameCharacter.getName() + " alive? " + gameCharacter.isAlive());
//		}
	}
	
	/*
	 * Sets up the next turn by incrementing the turn counter 
	 * and making sure characters are alive
	 */
	public void nextTurn() {
		// increase turn counter
		turnCounter++;
		
		// Check for turns remaining
		if(turnCounter >= turnList.size()) {
			turnsRemaining = false;
		}		
		else {
			// If the next character in the turn list is dead, move on
			while(!turnList.get(turnCounter).isAlive() && (turnCounter < turnList.size()-2)) {
				turnCounter++;				
			}
		}		
	}
	
	/*
	 * Who's turn is it currently?
	 * Returns the current character at the turnCounter position of the turn list
	 */
	public GameCharacter getCurrentPlayer() {
		if (turnsRemaining) {
			return turnList.get(turnCounter);	
		}
		else {
			System.out.println("Cant return player, game is not running");
			return null;
		}		
	}
	
	/*
	 * Calls the attack function on a character
	 * Attacker attacks the defender
	 */
	public String attack(GameCharacter attacker, GameCharacter defender) {
		// Make the attack
		String result = attacker.attack(defender);
		
		// Check if defender is now dead, if so, remove from turn list
		if(!defender.isAlive()) {
			removeDeadCharacter(defender);
		}
		
		return result;
	}

	
	
	/*
	 * Attempts to heal another player
	 * healer heals playerToHeal
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
	 * Maybe limit these in the future?
	 * reviver revives the playerToRevive
	 */
	public String revive(Player reviver, Player playerToRevive) {
		sinBin.add(playerToRevive);
		
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
	
	/*
	 * Removes all instances of a dead character from the turnList
	 */
	private void removeDeadCharacter(GameCharacter character) {
		ArrayList<GameCharacter> instancesToRemove = new ArrayList<GameCharacter>();
		
		for (GameCharacter gameCharacter : turnList) {
			if(gameCharacter.equals(character)) {
				instancesToRemove.add(gameCharacter);
			}
		}
		
		turnList.removeAll(instancesToRemove);		
		
	}
	
	/*
	 * Returns a list of all Players in the game
	 */
	public ArrayList<GameCharacter> getPlayersList() {
		return this.players;
	}

	/*
	 * Returns a list of all Monsters in the game
	 */
	public ArrayList<GameCharacter> getMonstersList() {
		return this.monsters;
	}
	
	/**
	 * Looks for a particular character based on the provided name
	 * Returns the GameCharacter if found
	 */
	public GameCharacter getCharacterByName(String characterName) {
		// go through lists and look for character with matching name
		for (GameCharacter gameCharacter : monsters) {
			if(gameCharacter.getName().equalsIgnoreCase(characterName)) {
				return gameCharacter;
			}
		}
		for (GameCharacter gameCharacter : players) {
			if(gameCharacter.getName().equalsIgnoreCase(characterName)) {
				return gameCharacter;
			}
		}
		
		return null;
	}

	
	/*
	 * Returns the state of the game - turns remaining
	 */
	public boolean isRunning() {
		return this.turnsRemaining;
	}

	/*
	 * Checks whether we can keep playing
	 * Need at least 1 monster and 1 player to continue playing
	 */
	public boolean canPlay() {	
		
		if(playersRemain() && monstersRemain()) {
			return true;
		}
		else {
			gameOver = true;
			return false;
		}
	}
	
	/*
	 * Checks if at least one monster remains in the game
	 */
	private boolean monstersRemain() {
		// Looks for at least 1 monster
		for (GameCharacter gameCharacter : monsters) {
			if (gameCharacter.isAlive()) {
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * Determines if there is at least one player left in the game -alive or revived
	 */
	private boolean playersRemain() {
		// Looks for at least 1 player
		if(sinBin.size() > 0) {
			return true;
		}
		
		for (GameCharacter gameCharacter : players) {
			if (gameCharacter.isAlive()) {
				return true;
			}
		}
		
		return false;
	}

	/*
	 * Generates a String summary of the current state of the game
	 * remaining players, stats, etc
	 */
	public String getSummary() {
		String summary = "The battle is over!";
		
		
		// End of round
		if(!gameOver ) {

			summary = "The beasts retreat temporarily, allowing our players a brief moment to regroup."
					+ "\n\nRemaining players: ";
			
			for (GameCharacter gameCharacter : players) {
				if(gameCharacter.isAlive()) {
					summary += ("\n" + gameCharacter.getName());
				}
			}
			for (GameCharacter gameCharacter : sinBin) {
				summary += ("\n" + gameCharacter.getName());				
			}
			
			summary += "\n\nRemaining Monsters:  ";
			
			for (GameCharacter gameCharacter : monsters) {
				if(gameCharacter.isAlive()) {
					summary += ("\n" + gameCharacter.getName());
				}
			}
		}
		else {
			// Players won!!
			if(playersRemain()) {
				summary += "\nThe brave party is victorious!!"
						+ "\n\nIt took the warriors " + roundCounter + " round(s) to win."
						+ "\n\nReminaing players: ";
				for (GameCharacter gameCharacter : players) {
					if(gameCharacter.isAlive()) {
						summary += ("\n" + gameCharacter.getName());
					}
				}
			}
			// Monsters won!!
			else if (monstersRemain()) {
				summary += "The brave party has been defeated!!"
						+ "\n\nIt took the monsters " + roundCounter + " round(s) to win."
						+ "\n\nThe following beasts still roam: ";
				for (GameCharacter gameCharacter : monsters) {
					if(gameCharacter.isAlive()) {
						summary += ("\n" + gameCharacter.getName());
					}
				}
			}
			// reset everything here
			endGame();	
		}
		
			
		return summary;
	}
	
	/*
	 * Checks if player limit has been reached
	 */
	public boolean canAddPlayers() {
		return players.size() < MAX_PLAYERS;
	}
	
	/*
	 * Check is monster limit has been reached
	 */
	public boolean canAddMonsters() {
		return monsters.size() < MAX_MONSTERS;
	}
	
	/*
	 * Game Over
	 * Reset anything that needs to be reset here 
	 */
	private void endGame() {
		System.out.println("\nEnd of game. Resetting");
		roundCounter = 0;
		turnCounter = 0;
		turnList.clear();
		sinBin.clear(); 	
		players.clear();
		monsters.clear();		
		turnsRemaining = false;
	}
	
	
}
