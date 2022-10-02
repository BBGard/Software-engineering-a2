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
public class SplashScreen extends Screen{
	
//	private ControlClass controller; // A reference to the controller class
//	protected Shell shell;
	

//	/**
//	 * Open the window.
//	 * @wbp.parser.entryPoint
//	 */
//	public void open(ControlClass controller) {
//		this.controller = controller;
//
//		Display display = Display.getDefault();
//		createContents();
//		shell.open();
//		shell.layout();
//		while (!shell.isDisposed()) {
//			if (!display.readAndDispatch()) {
//				display.sleep();
//			}
//		}
//	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		shell.setSize(800, 600);
		shell.setText("Tactics & Trouble");
		shell.setLayout(null);
		
		final Label lblSplashTitle = new Label(shell, SWT.NONE);
		lblSplashTitle.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSplashTitle.setFont(SWTResourceManager.getFont("Franklin Gothic Heavy", 38, SWT.BOLD));
		lblSplashTitle.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSplashTitle.setAlignment(SWT.CENTER);
		lblSplashTitle.setBounds(100, 100, 600, 150);
		lblSplashTitle.setText("Tactics and Trouble");
		
		final Button btnSplashStart = new Button(shell, SWT.NONE);
		btnSplashStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Disable title screen
				//lblSplashTitle.setVisible(false);
				//btnSplashStart.setVisible(false);
				shell.close();

				
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
