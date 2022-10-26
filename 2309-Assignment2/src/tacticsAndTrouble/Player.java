/**
 * 
 */
package tacticsAndTrouble;

/**
 * @author Benjamin Gardiner
 * This class represents a player character in the game Tactics and Trouble
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
		+ ".\nIt's successful, healing up to " + this.getPower() + " health.\n"
		+playerToHeal.getName() + " now has " + playerToHeal.getHealth() + " health.";
	}
	
	/*
	 * This player revives another player
	 */
	public String revive(Player playerToRevive) {
		if (playerToRevive == null) {
			return "Null playerToRevive";
		}
				
		if (playerToRevive.isAlive()) {
			return "Can't revive a living player. Try heal instead.";
		}
		
		// Set revived players health to 30% of their life
		playerToRevive.setHealth(playerToRevive.getLife() * 30 / 100);
		
		return getName() + " revives " + playerToRevive.getName() + ".\n" + playerToRevive.getName() + " now has "
				+ playerToRevive.getHealth() + " health but does not get a turn this round.";
	}
	
	
	
	/*
	 * Applies power up to this player
	 */
	public String powerUp() {
		if(getSpeed() <= 1 ) {
			return "Speed not greater than 1!";
		}
		
		// Double power, halve speed
		setPower((int)Math.round(getPower() * 2.0));
		setSpeed((int)Math.round(getSpeed() / 2.0));
		increasePowerUpsUsed();
		
		return getName() + " uses Power Up" + (getPowerUpsUsed() > 1 ? " again.\n":".\n") + "It's successful, and " + getName() + " now has " 
				+getSpeed() + " speed and " + getPower() + " power.";
	}
	
	
	
}
