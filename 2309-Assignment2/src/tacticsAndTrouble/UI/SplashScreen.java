/**
 * 
 */
package tacticsAndTrouble.UI;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;


/**
 * @author Benjamin Gardiner
 * This is the SplashScreen / Title Screen for the game Tactics & Trouble
 * Contains a button which when pressed transitions to the SetupScreen
 */
public class SplashScreen extends Screen {

	public SplashScreen(View view) {
		super(view);
	}

	/**
	 * Create contents of the window.
	 * Display Splash Screen
	 */
	@Override
	public void createContents() {
		// Setup window
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		shell.setSize(800, 600);
		shell.setText("Tactics & Trouble");
		shell.setLayout(null);
				
		// Setup elements 
		final Label lblSplashTitle = new Label(shell, SWT.NONE);
		lblSplashTitle.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSplashTitle.setFont(SWTResourceManager.getFont("Franklin Gothic Heavy", 48, SWT.BOLD));
		lblSplashTitle.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSplashTitle.setAlignment(SWT.CENTER);
		lblSplashTitle.setBounds(50, 150, 700, 200);
		lblSplashTitle.setText("Tactics && Trouble");
		
		
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
				nextScreen(new SetupScreen(view));
			}
		});
	}

	
}
