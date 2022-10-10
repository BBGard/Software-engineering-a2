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

public class TurnResultsScreen extends Screen{

	protected Shell shell;
	
	private String typeOfTurn; // Used for labeling the window
	Label lblTurnResults;
	
	public TurnResultsScreen(String typeOfTurn) {
		this.typeOfTurn = typeOfTurn;
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
		shell.setSize(800, 600);
		shell.setText(typeOfTurn);
		shell.setLayout(null);
		
		lblTurnResults = new Label(shell, SWT.NONE);
		lblTurnResults.setBounds(237, 189, 300, 222);
		lblTurnResults.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblTurnResults.setAlignment(SWT.CENTER);
		lblTurnResults.setText("And so the battle begins!");
		
		Button btnContinue = new Button(shell, SWT.NONE);
		btnContinue.setBounds(310, 438, 153, 50);
		btnContinue.setFont(SWTResourceManager.getFont("Segoe UI Light", 14, SWT.BOLD));
		btnContinue.setText("Continue");
		
		btnContinue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controller.takeTurn();
			}
		});

	}
	
	/*
	 * Sets the text for the results of the current turn
	 */
	@Override
	public void setTurnText(String turnText) {
		lblTurnResults.setText(turnText);
	}
}
