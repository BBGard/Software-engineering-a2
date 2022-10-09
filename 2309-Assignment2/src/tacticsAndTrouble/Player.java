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
	 * Revives a player
	 */
	public String revive(Player playerToRevive) {
		if (playerToRevive == null) {
			return "Null playerToRevive";
		}
				
		if (playerToRevive.isAlive()) {
			return "Can't revive a living player. Try heal instead.";
		}
		
		playerToRevive.bringBack();
		
		return getName() + " revives " + playerToRevive.getName() + ". " + playerToRevive.getName() + " now has "
				+ playerToRevive.getHealth() + " health but does not get a turn this round.";
	}
	
	/*
	 * Revives this player
	 */
	private void bringBack() {
		// Sets health to 30% of life
		addHealth(getLife() * 30 / 100);
		
		// Sets this player to alive
		setAlive(true);
	}
	
	/*
	 * Applies power up
	 */
	public String powerUp() {
		if(getSpeed() <= 1 ) {
			return "Speed not greater than 1!";
		}
		
		// Double power, halve speed
		setPower((int)Math.round(getPower() * 2.0));
		setSpeed((int)Math.round(getSpeed() / 2.0));
		increasePowerUpsUsed();
		
		return getName() + " uses Power Up" + (getPowerUpsUsed() > 1 ? " again. ":". ") + "It's successful, and " + getName() + " now has " 
				+getSpeed() + " speed and " + getPower() + " power.";
	}
	
	/*
	 * Resets power, speed, and powerUpsUsed to original values
	 */
	public void resetAttributes() {
		if (getPowerUpsUsed() > 0) {
//			setPower(getPower() / (2*getPowerUpsUsed()));
//			setSpeed(getSpeed() * (2*getPowerUpsUsed()));
			setPower(getBasePower());
			setSpeed(getBaseSpeed());
			resetPowerUpsUsed();
		}
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
