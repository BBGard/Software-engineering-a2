/**
 * 
 */
package tacticsAndTrouble;

/**
 * @author Benjamin Gardiner
 * This class represents a player character in the game Tactics andd Trouble
 */
public class Player extends GameCharacter {
	
	/*
	 * Creates a player with a normal weapon
	 */
	public Player(String name, int power, int defense, int life, int speed) {
		super(name, power, defense, life, speed);
	}
	
	/*
	 * Creates a player with a power weapon
	 */
	public Player(String name, int power, int defense, int life, int speed, PowerType weapon) {
		super(name, power, defense, life, speed);
		this.powerType = weapon;
	}
	
	
	
	
	@Override
	public String toString() {
		String playerStats = "";
		
		playerStats = "Name: " + name + "\n" +
				"Power: " + power + "\n" +
				"Defense: " + defense + "\n" +
				"Life: " + life + "\n" +
				"Speed: " + speed + "\n" +
				"Health: " + health + "\n" +
				"Weapon: " + powerType + "\n";
		
		return playerStats;
	}
}
