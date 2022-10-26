/**
 * 
 */
package tacticsAndTrouble;

/**
 * @author Benjamin Gardiner
 * This class represents a Monster character for the game Tactics and Trouble
 */
public class Monster extends GameCharacter {
	// Monsters
	public static final String CYBER_DEMON = "Cyber Demon";
	public static final String BARON_OF_HELL = "Baron of Hell";
	public static final String IMP = "Imp";
	public static final String ZOMBIE = "Zombie";
	public static final String MANCU_BEN = "Mancu-Ben";
	public static final String GARY_DEMON = "Gary Demon";	// Default type, no powers

	/*
	 * Creates a monster with default type
	 */
	public Monster(String name, int power, int defense, int life, int speed) {
		super(name, power, defense, life, speed);		
	}
	
	/*
	 * Creates a monster with a particular type
	 */
	public Monster(String name, int power, int defense, int life, int speed, PowerType type) {
		super(name, power, defense, life, speed);
		setPowerType(type);
	}
	
	/*
	 * Multiplies the attacking characters power vs this characters damage multiplier
	 * Applies the damage to this character
	 * Returns the damage applied
	 */
	@Override
	public int applyDamage(GameCharacter attacker) {	
		int damage = 1;
		
		// If Attacker power < defence, calculate damage
		if (attacker.getPower() > this.getDefense()) {
			damage = (int)(attacker.getPower() * attacker.getPowerType().getDamageMultiplier(this.getPowerType())) - this.getDefense();
		}
		
		// Reduce health
		reduceHealth(damage);		
		
		return damage;
	}

	

}
