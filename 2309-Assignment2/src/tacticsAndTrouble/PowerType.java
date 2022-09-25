/**
 * 
 */
package tacticsAndTrouble;

/**
 * @author Benjamin Gardiner
 * This class represents power types in the game Tactics and Trouble
 * For players this is the weapon power
 * For monsters this is the monster type
 */
public class PowerType {
	public static final String NORMAL = "Normal";
	public static final String LIGHTNING = "Lightning";
	public static final String WOOD = "Wood";
	public static final String METAL = "Metal";
	public static final String VOID = "Void";
	public static final String SPIRIT = "Spirit";
	
	private String type;

	/*
	 * Creates a default NORMAL PowerType
	 */
	public PowerType() {
		this.type = NORMAL;
	}
	
	/*
	 * Creates a custom PowerType
	 */
	public PowerType(String type) {
		this.type = type;
	}
	
	/*
	 * Sets the 
	 */
	public void setType(String type) {
		this.type = type;
		
	}

	public String getType() {
		return this.type;		
	}

	public String toString() {
		return this.getType();
	}
}
