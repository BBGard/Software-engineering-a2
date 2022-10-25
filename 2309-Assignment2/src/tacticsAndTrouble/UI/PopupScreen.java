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

//	protected Shell shell;
	
	private String moveType;
	private String popupText;
	private Label lblPopupText;	// The text displayed by this popup window
	
	// Window titles/states
	public static final String POPUP_TYPE_WELCOME = "Welcome";
	public static final String POPUP_TYPE_ATTACK = "Attack!";
	public static final String POPUP_TYPE_HEAL = "Heal Player";
	public static final String POPUP_TYPE_REVIVE = "Revive Player";
	public static final String POPUP_TYPE_POWERUP = "Power Up!";
	public static final String POPUP_TYPE_END_OF_ROUND = "Round Over!";
	public static final String POPUP_TYPE_END_OF_GAME = "Game Over!";
	public static final String POPUP_WELCOME_MESSAGE = "Welcome to Tactics & Trouble!\n\n"
			+ "After climbing down from the highest peak into the Valley of Despair, "
			+ "your brave party approaches the fiery gates of hell."
			+ "\nThe ferocious screeches of nightmarish creatures echo throughout the valley."
			+ "\n\nThe battle begins...";
	
	
	// Sets the text elements of the popup
	public PopupScreen(String moveType, String popupText, View view) {
		super(view);
		this.popupText = popupText;
		this.moveType = moveType;
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
	public void createContents() {
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText(moveType);
		shell.setLayout(new FormLayout());
		
		lblPopupText = new Label(shell, SWT.WRAP);
		lblPopupText.setAlignment(SWT.CENTER);
		FormData fd_lblPopupText = new FormData();
		fd_lblPopupText.top = new FormAttachment(0, 45);
		fd_lblPopupText.left = new FormAttachment(0, 62);
		fd_lblPopupText.bottom = new FormAttachment(0, 462);
		fd_lblPopupText.right = new FormAttachment(0, 734);
		lblPopupText.setLayoutData(fd_lblPopupText);
		lblPopupText.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblPopupText.setText(popupText);
		
		Button btnContinue = new Button(shell, SWT.NONE);
		FormData fd_btnContinue = new FormData();
		fd_btnContinue.top = new FormAttachment(lblPopupText, 20);
		fd_btnContinue.bottom = new FormAttachment(100, -41);
		fd_btnContinue.right = new FormAttachment(100, -256);
		fd_btnContinue.left = new FormAttachment(0, 284);
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
		
		switch (moveType) {
		case POPUP_TYPE_WELCOME:		
			// begin combat
			System.out.println("Start combat now");
			shell.close();
			controller.nextRound();
			break;
			
		case POPUP_TYPE_END_OF_ROUND:
			// Display end of round summary
			System.out.println("Start next round!");
			shell.close();
			controller.nextRound();
			break;
			
		case POPUP_TYPE_END_OF_GAME:
			// Display end of game summary, quit
			System.out.println("Display end of game summary");
			shell.close();
			controller.quitGame();
			break;	
			
//		case POPUP_TYPE_ATTACK:
//			shell.close();
//			controller.nextTurn();
//			break;
//			
//		case POPUP_TYPE_HEAL:
//			shell.close();
//			controller.nextTurn();
//			break;
//			
//		case POPUP_TYPE_POWERUP:
//			shell.close();
//			controller.nextTurn();
//			break;
		

		default:
			System.out.println("Setup next turn");
			shell.close();
			controller.nextTurn();
			break;
		}		
		
	}

}
