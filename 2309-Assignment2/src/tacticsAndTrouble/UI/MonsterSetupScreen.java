package tacticsAndTrouble.UI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import tacticsAndTrouble.ControlClass;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MonsterSetupScreen extends Screen{

	protected Shell shell;	// TODO REMOVE ME
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 * TODO REMOVE THIS
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
	 * 
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("Monster Setup");

		shell.setLayout(new FormLayout());
		
		Label lblSetupTitle = new Label(shell, SWT.NONE);
		FormData fd_lblSetupTitle = new FormData();
		fd_lblSetupTitle.right = new FormAttachment(0, 775);
		fd_lblSetupTitle.top = new FormAttachment(0, 53);
		fd_lblSetupTitle.left = new FormAttachment(0, 10);
		lblSetupTitle.setLayoutData(fd_lblSetupTitle);
		lblSetupTitle.setAlignment(SWT.CENTER);
		lblSetupTitle.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		lblSetupTitle.setText("Monster Setup");
		
		Group groupInput = new Group(shell, SWT.NONE);
		fd_lblSetupTitle.bottom = new FormAttachment(groupInput, -6);
		FormData fd_groupInput = new FormData();
		fd_groupInput.bottom = new FormAttachment(100, -43);
		fd_groupInput.left = new FormAttachment(0, 21);
		fd_groupInput.right = new FormAttachment(0, 382);
		fd_groupInput.top = new FormAttachment(0, 105);
		groupInput.setLayoutData(fd_groupInput);
		GridLayout gl_groupInput = new GridLayout(2, false);
		gl_groupInput.horizontalSpacing = 15;
		gl_groupInput.verticalSpacing = 15;
		groupInput.setLayout(gl_groupInput);
		
		Label lblMonster = new Label(groupInput, SWT.NONE);
		lblMonster.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblMonster.setAlignment(SWT.RIGHT);
		lblMonster.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		GridData gd_lblMonster = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblMonster.widthHint = 119;
		lblMonster.setLayoutData(gd_lblMonster);
		lblMonster.setText("Monster");
		
		
		final Combo comboMonster = new Combo(groupInput, SWT.NONE);
		comboMonster.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		comboMonster.setItems(new String[] {"Baron of Hell", "Imp", "Zombie", "Mancu-Ben", "Gary Demon"});
		comboMonster.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		new Label(groupInput, SWT.NONE);
		
		final Button btnAddMonster = new Button(groupInput, SWT.CENTER);
		
		
		btnAddMonster.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnAddMonster.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		GridData gd_btnAddMonster = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnAddMonster.widthHint = 202;
		btnAddMonster.setLayoutData(gd_btnAddMonster);
		btnAddMonster.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		btnAddMonster.setText("Add Monster");
		
		Group groupPlayerList = new Group(shell, SWT.NONE);
		FormData fd_groupPlayerList = new FormData();
		fd_groupPlayerList.bottom = new FormAttachment(groupInput, 0, SWT.BOTTOM);
		fd_groupPlayerList.top = new FormAttachment(lblSetupTitle, 6);
		fd_groupPlayerList.left = new FormAttachment(groupInput, 65);
		fd_groupPlayerList.right = new FormAttachment(100, -99);
		groupPlayerList.setLayoutData(fd_groupPlayerList);
		
		Label lblMonsters = new Label(groupPlayerList, SWT.NONE);
		lblMonsters.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblMonsters.setAlignment(SWT.CENTER);
		lblMonsters.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblMonsters.setBounds(10, 16, 218, 30);
		lblMonsters.setText("Players");
		
		Label seperator = new Label(groupPlayerList, SWT.SEPARATOR | SWT.HORIZONTAL);
		seperator.setBounds(10, 57, 218, 16);
		
		final List listMonsters = new List(groupPlayerList, SWT.BORDER);
		listMonsters.setFont(SWTResourceManager.getFont("Segoe UI Light", 16, SWT.NORMAL));
		listMonsters.setBounds(10, 79, 218, 224);
		
		Button btnStartCombat = new Button(groupPlayerList, SWT.NONE);
		
		
		btnStartCombat.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		btnStartCombat.setBackground(SWTResourceManager.getColor(255, 102, 102));
		btnStartCombat.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnStartCombat.setBounds(10, 324, 218, 67);
		btnStartCombat.setText("Start Combat");
		
		
		
		/*
		 * Button handlers
		 */
		
		// Add Monster
		btnAddMonster.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Add monster name to monster list
				listMonsters.add(comboMonster.getText() + "\n");

				// Add monster to game				
				controller.addMonster(comboMonster.getText());
			}
		});
		
		// Start the game
		btnStartCombat.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Close this screen
				shell.close();
				
				// Start the main game screen
				//MainGameScreen mainGame = new MainGameScreen();
				//mainGame.open(controller);
				controller.startGame();
			}
		});
	}

}
