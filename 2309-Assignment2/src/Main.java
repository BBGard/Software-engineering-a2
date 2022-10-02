
import javax.swing.SwingUtilities;

import tacticsAndTrouble.ControlClass;
import tacticsAndTrouble.GUI;
import tacticsAndTrouble.Game;
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
            		Game game = new Game();
        			SplashScreen window = new SplashScreen();
        			ControlClass controller = new ControlClass(game,window);
        			window.open(controller);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
            }
        });
		
		

	}


}
