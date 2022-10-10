package tacticsAndTrouble.UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import tacticsAndTrouble.ControlClass;

public class MainGameScreen extends Screen{

//	protected Shell shell;
//	private ControlClass controller;


	
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void open(ControlClass controller) {
	//public void open() {	
		this.controller = controller;
		
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		
		controller.startGame();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("Tactics & Trouble");
	}
}
