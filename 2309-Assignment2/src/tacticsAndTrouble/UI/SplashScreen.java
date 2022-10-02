package tacticsAndTrouble.UI;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import swing2swt.layout.BoxLayout;
import tacticsAndTrouble.ControlClass;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * @author Benjamin Gardiner This is the main window (splash screen) shown on the launch of
 *         Trouble & Tactics
 *         Created using WindowBuilder
 */
public class SplashScreen {
	
	private ControlClass controller; // A reference to the controller class
	protected Shell shlTacticsTrouble;
	

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(ControlClass controller) {
		this.controller = controller;

		Display display = Display.getDefault();
		createContents();
		shlTacticsTrouble.open();
		shlTacticsTrouble.layout();
		while (!shlTacticsTrouble.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTacticsTrouble = new Shell();
		shlTacticsTrouble.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		shlTacticsTrouble.setSize(800, 600);
		shlTacticsTrouble.setText("Tactics & Trouble");
		shlTacticsTrouble.setLayout(null);
		
		final Label lblSplashTitle = new Label(shlTacticsTrouble, SWT.NONE);
		lblSplashTitle.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSplashTitle.setFont(SWTResourceManager.getFont("Franklin Gothic Heavy", 38, SWT.BOLD));
		lblSplashTitle.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSplashTitle.setAlignment(SWT.CENTER);
		lblSplashTitle.setBounds(100, 100, 600, 150);
		lblSplashTitle.setText("Tactics and Trouble");
		
		final Button btnSplashStart = new Button(shlTacticsTrouble, SWT.NONE);
		btnSplashStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Disable title screen
				//lblSplashTitle.setVisible(false);
				//btnSplashStart.setVisible(false);
				shlTacticsTrouble.close();

				
				// Create player setup screen
				PlayerSetupScreen playerSetup = new PlayerSetupScreen();
				playerSetup.open(controller);
			}
		});
		btnSplashStart.setFont(SWTResourceManager.getFont("Segoe UI", 25, SWT.NORMAL));
		btnSplashStart.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnSplashStart.setBounds(300, 400, 200, 100);
		btnSplashStart.setText("START");

	}
}
