/**
 * 
 */
package tacticsAndTrouble;

/**
 * @author Benjamin Gardiner
 * This class represents all characters for the game tactics and trouble
 * Both Player characters and Monsters
 */
public abstract class GameCharacter {
	protected String name;	// The name of the monster/player
	protected int power;	// The power of the monster/player
	protected int defense;	// The defense of the monster/player
	protected int life;		// The life of the monster/player
	protected int speed;	// The speed of the monster/player
	protected int health;	// The health of the monster/player
	protected int turns;	// The number of turns of the monster/player 
//	protected PowerType weapon;	// The weapon type/monster type of the monster/player
	
	protected boolean isAlive;	// Wether the monster/player is alive

	public GameCharacter(String name, int power, int defense, int life, int speed) {
		this.name = name;
		this.power = power;
		this.defense = defense;
		this.life = life;
		this.speed = speed;
		this.health = life;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public abstract String getWeaponType();
	
	
}