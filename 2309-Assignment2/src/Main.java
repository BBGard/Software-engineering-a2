
import javax.swing.SwingUtilities;

import tacticsAndTrouble.ControlClass;
import tacticsAndTrouble.Game;
import tacticsAndTrouble.UI.Screen;
import tacticsAndTrouble.UI.View;

/**
 * @author Benjamin Gardiner This is the main class for ITECH 2309 Assignment 2
 *         - Tactics & Trouble
 */
public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {       
            	
            	try {
            		// Setup th MVC components and start the program
            		Game game = new Game(); // The model
        			//Screen screen = new Screen(); // The view
            		View theView = new View();	// The view
        			ControlClass controller = new ControlClass(game,theView); // The controller
        			controller.open();
        			
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
            }
        });
		
		

	}


}
