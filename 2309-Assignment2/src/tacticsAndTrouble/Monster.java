/**
 * 
 */
package tacticsAndTrouble;

/**
 * @author Benjamin Gardiner
 *
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

	@Override
	public String toString() {
		String monsterStats = "";
		
		monsterStats = "Name: " + getName() + "\n" +
				"Power: " + getPower() + "\n" +
				"Defense: " + getDefense() + "\n" +
				"Life: " + getLife() + "\n" +
				"Speed: " + getSpeed() + "\n" +
				"Health: " + getHealth() + "\n" +
				"Type: " + getPowerTypeString() + "\n";
		
		return monsterStats;
	}

}
