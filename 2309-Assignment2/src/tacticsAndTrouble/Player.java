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
		setPowerType(weapon);
	}
	
	/*
	 * Multiplies the attacking characters power vs this characters damage multiplier
	 * Applies the damage to this character
	 * Ignores powerTypes for player characters
	 * Returns the damage applied
	 */
	@Override
	public int applyDamage(GameCharacter attacker) {
		int damage = 1;
		
		// If Attacker power < defence, calculate damage
		if (attacker.getPower() > this.getDefense()) {
			damage = attacker.getPower() - this.getDefense();
		}		
		
		// Reduce health
		reduceHealth(damage);		
		
		return damage;
	}
	
	@Override
	public String toString() {
		String playerStats = "";
		
		playerStats = "Name: " + getName() + "\n" +
				"Power: " + getPower() + "\n" +
				"Defense: " + getDefense() + "\n" +
				"Life: " + getLife() + "\n" +
				"Speed: " + getSpeed() + "\n" +
				"Health: " + getHealth() + "\n" +
				"Weapon: " + getPowerTypeString() + "\n";
		
		return playerStats;
	}

	
}
