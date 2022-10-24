/**
 * 
 */
package tacticsAndTrouble;

/**
 * @author Benjamin Gardiner
 * This class represents power types in the game Tactics and Trouble
 * For players this is the weapon power
 * For monsters this is the monster type
 * Methods are available for interactions between power types (multipliers)
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
	
	
	public void setType(String type) {
		this.type = type;
		
	}

	public String getType() {
		return this.type;		
	}
	
	/*
	 * Returns a string specifying the damage amount of one powerType vs another
	 * Needs some tender loving refactoring!
	 */
	public String getDamageString(PowerType defenderPowerType) {
		String result = "normal";
		
		switch (type) {
		case PowerType.LIGHTNING:
			if (defenderPowerType.getType() == PowerType.METAL) {
				result = "double";
			}
			if (defenderPowerType.getType() == PowerType.WOOD) {
				result = "half";
			}
			break;
		case PowerType.WOOD:
			if (defenderPowerType.getType() == PowerType.LIGHTNING) {
				result = "double";
			}
			if (defenderPowerType.getType() == PowerType.METAL) {
				result = "half";
			}
			break;
		case PowerType.METAL:
			if (defenderPowerType.getType() == PowerType.WOOD) {
				result = "double";
			}
			if (defenderPowerType.getType() == PowerType.LIGHTNING) {
				result = "half";
			}
			break;
		case PowerType.VOID:
			if (defenderPowerType.getType() == PowerType.SPIRIT) {
				result = "double";
			}
			break;
		case PowerType.SPIRIT:
			if (defenderPowerType.getType() == PowerType.VOID) {
				result = "double";
			}
			break;
	
		default:
			result = "normal";
			break;
		}
		
		return result;
	}
	
	/*
	 * Returns an double specifying the damage multiplier of one powerType vs another
	 * Needs refactoring, code duplication
	 */
	public double getDamageMultiplier(PowerType defenderPowerType) {
		double result = 1.0;
		
		switch (type) {
		case PowerType.LIGHTNING:
			if (defenderPowerType.getType() == PowerType.METAL) {
				result = 2.0;
			}
			if (defenderPowerType.getType() == PowerType.WOOD) {
				result = 0.5;
			}
			break;
		case PowerType.WOOD:
			if (defenderPowerType.getType() == PowerType.LIGHTNING) {
				result = 2.0;
			}
			if (defenderPowerType.getType() == PowerType.METAL) {
				result = 0.5;
			}
			break;
		case PowerType.METAL:
			if (defenderPowerType.getType() == PowerType.WOOD) {
				result = 2.0;
			}
			if (defenderPowerType.getType() == PowerType.LIGHTNING) {
				result = 0.5;
			}
			break;
		case PowerType.VOID:
			if (defenderPowerType.getType() == PowerType.SPIRIT) {
				result = 2.0;
			}
			break;
		case PowerType.SPIRIT:
			if (defenderPowerType.getType() == PowerType.VOID) {
				result = 2.0;
			}
			break;
	
		default:
			result = 1.0;
			break;
		}
		
		return result;
	}
	

	@Override
	public String toString() {
		return this.getType();
	}
}
