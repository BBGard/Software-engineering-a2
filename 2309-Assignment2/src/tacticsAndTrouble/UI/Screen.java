/**
 * 
 */
package tacticsAndTrouble.UI;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import tacticsAndTrouble.ControlClass;
import tacticsAndTrouble.GameCharacter;

/**
 * @author Benjamin Gardiner
 * This class represents all windows/screens for the game Trouble and Tactics
 */
public abstract class Screen  {
	protected ControlClass controller; // A reference to the controller class
	protected Shell shell;
	protected View view;

	public Screen(View view) {
		this.view = view;
	}
	
	/**
	 * Opens the screen.
	 * @wbp.parser.entryPoint
	 */
	public void open(ControlClass controller) {
		this.controller = controller;	
		
		Display display = Display.getDefault();
		createContents();
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
	
	// Abstract Methods //
	
	// Setup the contents of the screen	 
	public abstract void createContents();
	
	
	
}
