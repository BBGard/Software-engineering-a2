/**
 * 
 */
package tacticsAndTrouble.UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import tacticsAndTrouble.ControlClass;

/**
 * @author Benjamin Gardiner
 * This abstract class defines all windows/screens for the game Trouble and Tactics
 */
public abstract class Screen {
	protected ControlClass controller; // A reference to the controller class
	protected Shell shell;

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(ControlClass controller) {
		this.controller = controller;

		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	protected abstract void createContents();

}
