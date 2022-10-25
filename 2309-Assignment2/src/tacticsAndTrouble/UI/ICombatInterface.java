package tacticsAndTrouble.UI;

import java.util.ArrayList;

import tacticsAndTrouble.GameCharacter;

/**
 * An interface for CombatScreen specific methods
 * @author Benjamin Gardiner
 *
 */
public interface ICombatInterface {

	public void setupTurn(GameCharacter character, ArrayList<GameCharacter> playerList, ArrayList<GameCharacter> monsterList);	
	
//	public void setWindowTitle(String windowTitle); 

	public void displayResult(String moveType, String resultText);
	
	public void quit();
}
