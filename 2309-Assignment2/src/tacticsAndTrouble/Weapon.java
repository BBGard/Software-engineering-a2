/**
 * 
 */
package tacticsAndTrouble;

/**
 * @author Benjamin Gardiner
 * This class represents a weapon for a player character in the game Tactics and Trouble
 */
public class Weapon implements PowerType{
	private String type;

	/*
	 * Creates a normal weapon
	 */
	public Weapon() {
		this.type = NORMAL;
	}
	
	/*
	 * Creates a certain type of weapon
	 */
	public Weapon(String type) {
		setType(type);
	}
	
	
	@Override
	public void setType(String type) {
		this.type = type;
		
	}

	@Override
	public String getType() {
		return this.type;		
	}

	@Override
	public String toString() {
		return this.getType();
	}
}
