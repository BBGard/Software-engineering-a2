
import javax.swing.SwingUtilities;

import tacticsAndTrouble.ControlClass;
import tacticsAndTrouble.Game;
import tacticsAndTrouble.UI.Screen;
import tacticsAndTrouble.UI.SplashScreen;

/**
 * @author Benjamin Gardiner This is the main class for ITECH 2309 Assignment 2
 *         - Tactics & Trouble
 */
public class Main {
//	private static Game theGame;

	public static void main(String[] args) {
//		startGame();
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {                                           
//                Game game = new Game();
//                GUI gui = new GUI("Tactics & Trouble"); 
//                ControlClass controller = new ControlClass(game,gui);
//                gui.begin(controller);
            	
            	try {
            		Game game = new Game(); // The model
        			Screen screen = new SplashScreen(); // The view
        			ControlClass controller = new ControlClass(game,screen); // The controller
        			controller.open();
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
            }
        });
		
		

	}


}
