package tacticsAndTrouble.UI;

import java.util.ArrayList;

import tacticsAndTrouble.GameCharacter;

/**
 * An interface for CombatScreen specific methods
 * @author Benjamin Gardiner
 *
 */
public interface ICombatInterface {

	// Setup the user interface to display the current characters turn
	public void setupTurn(GameCharacter character, ArrayList<GameCharacter> playerList, ArrayList<GameCharacter> monsterList);	

	// Display the results of a turn
	public void displayResult(String moveType, String resultText);
	
}
