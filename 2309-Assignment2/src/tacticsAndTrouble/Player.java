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
	
	/*
	 * This player heals the playerToHeal
	 */
	public String heal(Player playerToHeal) {
		if (playerToHeal == null) {
			return "Null playerToHeal";
		}
				
		if (!playerToHeal.isAlive()) {
			return "Can't heal a dead player. Try revive instead.";
		}
		
		playerToHeal.addHealth(this.getPower());
		
		return this.getName() + " heals " + playerToHeal.getName()
		+ ". It's successful, healing up to " + this.getPower() + " health."
		+" Crum now has " + playerToHeal.getHealth() + " health.";
	}
	
	/*
	 * Revives the player
	 */
	public String revive(Player playerToRevive) {
		return "";
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
