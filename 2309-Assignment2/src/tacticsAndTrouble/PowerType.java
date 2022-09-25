/**
 * 
 */
package tacticsAndTrouble;

/**
 * @author Benjamin Gardiner
 * This interface provide methods power types in the game Tactics and Trouble
 */
public interface PowerType {
	public static final String NORMAL = "Normal";
	public static final String LIGHTNING = "Lightning";
	public static final String WOOD = "Wood";
	public static final String METAL = "Metal";
	public static final String VOID = "Void";
	public static final String SPIRIT = "Spirit";

	/*
	 * Set the power type
	 */
	public void setType(String type);
	
	/*
	 * Get the power type
	 */
	public String getType();
	
	@Override
	public String toString();
}
