/**
 * 
 */
package tacticsAndTrouble.UI;


import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import tacticsAndTrouble.ControlClass;

/**
 * @author Benjamin Gardiner
 * This abstract class represents all windows/screens for the game Trouble and Tactics
 */
public abstract class Screen  {
	protected ControlClass controller; // A reference to the controller class
	protected Shell shell;			   // The shell is the Window
	protected View view;				// Reference to the view, for changing states

	public Screen(View view) {
		this.view = view;
	}
	
	/**
	 * Opens the screen.
	 * @wbp.parser.entryPoint
	 */
	public void open(ControlClass controller) {
		this.controller = controller;	
		
		// Setup screen
		Display display = Display.getDefault();
		createContents();
		
		centreShell(display);
		
		shell.open();
		shell.layout();
		
		// Tells the view that the state has changed
		view.setScreen(this);
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/*
	 * Centres the shell in the middle of the primary display
	 * Code from: https://www.admfactory.com/swt-centre-a-shell-in-the-middle-of-the-screen/
	 */
	protected void centreShell(Display display) {	
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		shell.setLocation(x, y);
	}
	
	/**
	 * Opens the next screen
	 * @param screen - the screen to open
	 */
	protected void nextScreen(Screen screen) {
		screen.open(controller);			
	}
	
	// Closes the screen
	protected void quit() {
		shell.close();
	}
	
	
	// Setup the contents of the screen	 - each screen does this differently
	public abstract void createContents();
	
	
	
}
