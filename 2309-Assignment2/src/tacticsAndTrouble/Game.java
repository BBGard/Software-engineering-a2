/**
 * 
 */
package tacticsAndTrouble;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Benjamin Gardiner
 * This class represents the game tactics and trouble
 * Within the game, this class is essentially the "Tactician"
 * in charge of all game logic and decisions
 */
public class Game {
	private List<GameCharacter> players;
	private List<GameCharacter> monsters;

	public Game() {
		players = new ArrayList<GameCharacter>();
		monsters = new ArrayList<GameCharacter>();
	}
	
	/*
	 * Add a player to the game
	 */
	public boolean addPlayer(GameCharacter player) {
		if(player != null) {
			players.add(player);
			return true;
		}
		
		return false;
	}
	
	/*
	 * Add a monster to the game
	 */
	public boolean addMonster(GameCharacter monster) {
		if(monster != null) {
			monsters.add(monster);
			return true;
		}
		
		return false; 
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
}
