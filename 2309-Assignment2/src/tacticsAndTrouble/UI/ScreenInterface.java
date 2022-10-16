package tacticsAndTrouble.UI;

import java.util.ArrayList;

import tacticsAndTrouble.GameCharacter;

/**
 * An interface for combat screen specific methods
 * @author Benjamin Gardiner
 *
 */
public interface ScreenInterface {

	//public void showStats(GameCharacter character);	
	public void setupTurn(GameCharacter character, ArrayList<GameCharacter> playerList, ArrayList<GameCharacter> monsterList);	
	
	public void setWindowTitle(String windowTitle); 

	public void setTurnText(String turnText);
}
