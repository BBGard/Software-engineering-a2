package tacticsAndTrouble.UI;

import tacticsAndTrouble.GameCharacter;

/**
 * An interface for combat screen specific methods
 * @author Benjamin Gardiner
 *
 */
public interface ScreenInterface {

	public void showStats(GameCharacter character);	
	
	public void setWindowTitle(String windowTitle); 

	public void setTurnText(String turnText);
}
