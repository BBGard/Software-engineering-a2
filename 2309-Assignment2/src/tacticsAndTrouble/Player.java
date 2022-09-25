/**
 * 
 */
package tacticsAndTrouble;

/**
 * @author Benjamin Gardiner
 * This class represents a player character in the game Tactics andd Trouble
 */
public class Player extends GameCharacter {
	private Weapon weapon;
	
	/*
	 * Creates a player with a normal weapon
	 */
	public Player(String name, int power, int defense, int life, int speed) {
		super(name, power, defense, life, speed);
		this.weapon = new Weapon();
	}
	
	/*
	 * Creates a player with a power weapon
	 */
	public Player(String name, int power, int defense, int life, int speed, Weapon weapon) {
		super(name, power, defense, life, speed);
		this.weapon = weapon;
	}
	
	@Override
	public String getWeaponType() {
		return this.weapon.getType();
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
				"Weapon: " + weapon + "\n";
		
		return playerStats;
	}
}
