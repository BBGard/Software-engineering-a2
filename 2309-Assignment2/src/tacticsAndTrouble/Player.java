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
		int damage = 0;
		
		// if no damage can be done, return 0
		if (attacker.getPower() < this.getDefense()) {
			return damage;
		}
		else {
			damage = attacker.getPower() - this.getDefense();
		}
		
		if(damage > 0) {
			reduceHealth(damage);
		}
		else {
			damage = 0;
		}
		
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
