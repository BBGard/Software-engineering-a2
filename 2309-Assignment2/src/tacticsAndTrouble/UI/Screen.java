/**
 * 
 */
package tacticsAndTrouble.UI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import tacticsAndTrouble.ControlClass;

/**
 * @author Benjamin Gardiner
 * This class represents all windows/screens for the game Trouble and Tactics
 */
public class Screen {
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
		
		controller.setScreen(this);
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	/**
	 * Create contents of the window.
	 * Display Splash Screen
	 */
	protected void createContents() {
		// Setup window
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		shell.setSize(800, 600);
		shell.setText("Tactics & Trouble");
		shell.setLayout(null);
				
		// Setup elements 
		final Label lblSplashTitle = new Label(shell, SWT.NONE);
		lblSplashTitle.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSplashTitle.setFont(SWTResourceManager.getFont("Franklin Gothic Heavy", 38, SWT.BOLD));
		lblSplashTitle.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSplashTitle.setAlignment(SWT.CENTER);
		lblSplashTitle.setBounds(100, 100, 600, 150);
		lblSplashTitle.setText("Tactics and Trouble");
		
		final Button btnSplashStart = new Button(shell, SWT.NONE);		
		btnSplashStart.setFont(SWTResourceManager.getFont("Segoe UI", 25, SWT.NORMAL));
		btnSplashStart.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnSplashStart.setBounds(300, 400, 200, 100);
		btnSplashStart.setText("START");
		
		// Button listener
		btnSplashStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				// Open a new player setup screen
				nextScreen(new SetupScreen());
			}
		});
	}
	
	/**
	 * Closes this screen and opens the next
	 * @param screen - the screen to open
	 */
	protected void nextScreen(Screen screen) {
		// Close splash screen, open new screen
		screen.open(controller);			
	}
	
	
	
	// TODO DELETE ME

	public void debugScreen() {
		System.out.println("I am a PARENT screen");
	}

}
