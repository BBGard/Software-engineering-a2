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
	private Screen state;	// The current state of the UI
	
	public View() {
		// Set the initial state
		state = new SplashScreen(this);
	}
	
	/*
	 * Sets the state to the current Screen state
	 * Each screen calls this when they open/transition states
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
	
	/*
	 * If the current state is CombatScreen, tells the screen to setup a turn
	 * Otherwise, should probably throw an exception....
	 */
	public void setupTurn(GameCharacter character, ArrayList<GameCharacter> playerList, ArrayList<GameCharacter> monsterList) {
		if(state instanceof CombatScreen) {
			((CombatScreen) state).setupTurn(character, playerList, monsterList);
		}
		else {
			System.out.println("You should not be here.\nThe current state is: "+state);
		}
	}
	
	/*
	 * If the current state is CombatScreen, tells the screen to display results of a turn
	 * Otherwise, should probably throw an exception....
	 */
	public void displayResult(String moveType, String resultText) {
		if(state instanceof CombatScreen) {
			((CombatScreen) state).displayResult(moveType, resultText);	
		}
		else {
			System.out.println("You should not be here.\nThe current state is: "+state);
		}
	}
	
	/*
	 * Tells the current screen to close
	 */
	public void quit() {
		state.quit();
	}
}
