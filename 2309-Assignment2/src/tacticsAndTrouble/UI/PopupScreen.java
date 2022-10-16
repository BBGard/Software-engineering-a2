package tacticsAndTrouble.UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import tacticsAndTrouble.ControlClass;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class PopupScreen extends Screen{

	protected Shell shell;
	
	private String windowTitle;
	private String popupText;
	private Label lblPopupText;	// The text displayed by this popup window
	
	// Window titles
	public static final String POPUP_TYPE_WELCOME = "Welcome";
	public static final String POPUP_TYPE_ATTACK = "Attack!";
	public static final String POPUP_TYPE_HEAL = "Heal Player";
	public static final String POPUP_TYPE_POWERUP = "Power Up!";
	public static final String POPUP_WELCOME_MESSAGE = "Welcome to Tactics & Trouble!\n\n"
			+ "Your brave party approaches the fiery gates of hell."
			+ "\nThe battle begins...";
	
	
	// Sets the text elements of the popup
	public PopupScreen(String windowTitle, String popupText) {
		this.popupText = popupText;
		this.windowTitle = windowTitle;
	}	

	/**
	 * Open the window.
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

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(800, 300);
		shell.setText(windowTitle);
		shell.setLayout(new FormLayout());
		
		lblPopupText = new Label(shell, SWT.NONE);
		FormData fd_lblPopupText = new FormData();
		fd_lblPopupText.top = new FormAttachment(0, 10);
		fd_lblPopupText.left = new FormAttachment(0, 34);
		fd_lblPopupText.bottom = new FormAttachment(0, 187);
		fd_lblPopupText.right = new FormAttachment(0, 751);
		lblPopupText.setLayoutData(fd_lblPopupText);
		lblPopupText.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblPopupText.setAlignment(SWT.CENTER);
		lblPopupText.setText(popupText);
		
		Button btnContinue = new Button(shell, SWT.NONE);
		FormData fd_btnContinue = new FormData();
		fd_btnContinue.top = new FormAttachment(lblPopupText, 6);
		fd_btnContinue.right = new FormAttachment(100, -256);
		fd_btnContinue.bottom = new FormAttachment(0, 243);
		fd_btnContinue.left = new FormAttachment(0, 283);
		btnContinue.setLayoutData(fd_btnContinue);
		btnContinue.setFont(SWTResourceManager.getFont("Segoe UI Light", 14, SWT.BOLD));
		btnContinue.setText("Continue");
		
		btnContinue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				continueAction();
			}
		});

	}
	
	/*
	 * Handles the continue button being pressed
	 */
	private void continueAction() {
		
		switch (windowTitle) {
		case POPUP_TYPE_WELCOME:		
			// begin combat
			controller.beginCombat();
			break;
			
		case POPUP_TYPE_ATTACK:
			
			break;
			
		case POPUP_TYPE_HEAL:
			
			break;
			
		case POPUP_TYPE_POWERUP:
			
			break;
		

		default:
			break;
		}
		
		
		// Close this window
		shell.close();
	}
	
	// TODO DELETE ME
	@Override
	public void debugScreen() {
		System.out.println("I am a POPUP screen");
	}

}
