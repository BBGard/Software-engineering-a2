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
		return players.add(player);
	}
}
