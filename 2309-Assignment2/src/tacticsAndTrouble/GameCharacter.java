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
	private String name;	// The name of the monster/player
	private int power;	// The power of the monster/player
	private int defense;	// The defense of the monster/player
	private int life;		// The life of the monster/player ie the max health
	private int speed;	// The speed of the monster/player
	private int health;	// The health of the monster/player
	private int turns;	// The number of turns of the monster/player 
	
	private int basePower; // The start value of power
	private int baseSpeed; // The start value of speed
	
	private boolean isAlive = true;	// Weather the monster/player is alive
	private int powerUpsUsed = 0; // Tracks the number of power ups used each turn, so they can be reset
	
	private PowerType powerType;
	
	public GameCharacter(String name, int power, int defense, int life, int speed) {
		this.name = name;
		this.power = power;
		this.defense = defense;
		this.life = life;
		this.speed = speed;
		this.health = life;
		this.turns = speed;
		
		this.basePower = power;
		this.baseSpeed = speed;
		
		this.powerType = new PowerType();
	}
	
	/*
	 * Calculates the damage from this character attacking another
	 * Returns a string containing the details of the attack
	 */
	public String attack(GameCharacter defender) {
		String result = "";
		// Calculate the damage

		// For players vs monsters
		if (this instanceof Player) {
			result += getName() + " attacks the " + defender.getName() + ". " + getName() + "'s "
					+getPowerTypeString() + " weapon does " + this.powerType.getDamageString(defender.getPowerType())
					+ " damage to " + defender.getPowerTypeString() + " monsters but is reduced by " + defender.getDefense()
					+ " Defense so deals " + defender.applyDamage(this) + " damage. The " + defender.getName()
					+ defender.getHealthStatus();
		} 
		// For monsters vs players
		else if (this instanceof Monster) {
			result += getName() + " attacks " + defender.getName() + ". It does "
					+ getPower() + "-" + defender.getDefense() + "=" + defender.applyDamage(this)
					+ " damage. " + defender.getName() + defender.getHealthStatus();
		}
		
		return result;
	}

	

	/*
	 * Multiplies the attacking characters power vs this characters damage multiplier
	 * Applies the damage to this character
	 * Returns the damage applied
	 */	
	public abstract int applyDamage(GameCharacter attacker);		


	/*
	 * Reduces the characters health by the set amount
	 * Checks if the character is still alive
	 */
	public void reduceHealth(int damage) {
		this.health -= damage;
		
		if(this.health <= 0) {
			setAlive(false);
			this.setHealth(0);
		}
	}
	
	/*
	 * Adds the specified mount of health to the character
	 */
	public void addHealth(int amount) {
		this.health += amount;
		
		// Prevent going above max health
		if(health > life) {
			health = life;
		}
	}
	
	private String getHealthStatus() {
		String status = " now has " + getHealth() + " health.";
		
		if (!isAlive) {
			status = " is now dead.";
		}
		
		return status;
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
	
	public  String getPowerTypeString() {
		return this.powerType.toString();
	}
	
	public PowerType getPowerType() {
		return powerType;
	}
	
	public void setPowerType(PowerType power) {
		this.powerType = power;
	}
	
	public void resetPowerUpsUsed() {
		this.powerUpsUsed = 0; 
	}
	
	public void increasePowerUpsUsed() {
		this.powerUpsUsed++;
	}
	
	public int getPowerUpsUsed() {
		return this.powerUpsUsed;
	}
	
	public int getBasePower() {
		return this.basePower;
	}
	
	public int getBaseSpeed() {
		return this.baseSpeed;
	}
	
	
}
