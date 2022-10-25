/**
 * 
 */
package tacticsAndTrouble.UI;

import java.util.ArrayList;

import tacticsAndTrouble.ControlClass;
import tacticsAndTrouble.GameCharacter;

/**
 * @author Benjamin Gardiner
 * The view class uses the state pattern to control the UI components
 * of Tactics & Trouble
 */
public class View {
	private Screen state;
	
	public View() {
		// Set the initial state
		state = new SplashScreen(this);
	}
	
	/*
	 * Sets the state to the current Screen state
	 */
	public void setScreen(Screen state) {
		this.state = state;
	}
	
	/*
	 * Opens the current screen
	 */
	public void openScreen(ControlClass controller) {
		state.open(controller);
	}
	
	public void setupTurn(GameCharacter character, ArrayList<GameCharacter> playerList, ArrayList<GameCharacter> monsterList) {
		if(state instanceof CombatScreen) {
			((CombatScreen) state).setupTurn(character, playerList, monsterList);
		}
		else {
			System.out.println("You should not be here.\nThe current state is: "+state);
		}
	}
	
	/*
	 * Displays result text
	 */
	public void displayResult(String moveType, String resultText) {
		if(state instanceof CombatScreen) {
			((CombatScreen) state).displayResult(moveType, resultText);	
		}
		else {
			System.out.println("You should not be here.\nThe current state is: "+state);
		}
	}
	
	public void quit() {
		state.quit();
	}
}
