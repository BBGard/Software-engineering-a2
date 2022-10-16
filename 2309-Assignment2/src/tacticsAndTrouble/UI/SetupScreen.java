package tacticsAndTrouble.UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import tacticsAndTrouble.ControlClass;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SetupScreen extends Screen{

	// UI elements
	private Label lblSetupTitle;
	private Combo comboChooser;
	private Label lblCharacterList;
	private List listCharacters;
	private Label lblName;
	private Button btnAddCharacter;
	private Button btnNext;
	
	private Text textName;
	private Text textPower;
	private Text textDefence;
	private Text textLife;
	private Text textSpeed;
	
	private String setupState = "PLAYER"; 	// Tracks which setup screen is being displayed - player or monster

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
		
		controller.setScreen(this);
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	@Override
	protected void createContents() {
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("Player Setup");
		shell.setLayout(new FormLayout());
		
		// Create Player Setup
		lblSetupTitle = new Label(shell, SWT.NONE);
		FormData fd_lblSetupTitle = new FormData();
		fd_lblSetupTitle.right = new FormAttachment(0, 775);
		fd_lblSetupTitle.top = new FormAttachment(0, 53);
		fd_lblSetupTitle.left = new FormAttachment(0, 10);
		lblSetupTitle.setLayoutData(fd_lblSetupTitle);
		lblSetupTitle.setAlignment(SWT.CENTER);
		lblSetupTitle.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		lblSetupTitle.setText("Player Setup");
		
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
		
		lblName = new Label(groupInput, SWT.NONE);
		lblName.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblName.setAlignment(SWT.RIGHT);
		lblName.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblName.widthHint = 119;
		lblName.setLayoutData(gd_lblName);
		lblName.setText("Name");
		
		textName = new Text(groupInput, SWT.BORDER);
		textName.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		textName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPower = new Label(groupInput, SWT.NONE);
		lblPower.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblPower.setAlignment(SWT.RIGHT);
		lblPower.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		GridData gd_lblPower = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblPower.widthHint = 119;
		lblPower.setLayoutData(gd_lblPower);
		lblPower.setText("Power");
		
		textPower = new Text(groupInput, SWT.BORDER);
		textPower.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		textPower.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDefence = new Label(groupInput, SWT.NONE);
		lblDefence.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblDefence.setAlignment(SWT.RIGHT);
		lblDefence.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDefence.setText("Defence");
		lblDefence.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		
		textDefence = new Text(groupInput, SWT.BORDER);
		textDefence.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		textDefence.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblLife = new Label(groupInput, SWT.NONE);
		lblLife.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblLife.setAlignment(SWT.RIGHT);
		lblLife.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLife.setText("Life");
		lblLife.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		
		textLife = new Text(groupInput, SWT.BORDER);
		textLife.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		textLife.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSpeed = new Label(groupInput, SWT.NONE);
		lblSpeed.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSpeed.setAlignment(SWT.RIGHT);
		lblSpeed.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpeed.setText("Speed");
		lblSpeed.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		
		textSpeed = new Text(groupInput, SWT.BORDER);
		textSpeed.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		textSpeed.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblWeapon = new Label(groupInput, SWT.NONE);
		lblWeapon.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		GridData gd_lblWeapon = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblWeapon.widthHint = 118;
		lblWeapon.setLayoutData(gd_lblWeapon);
		lblWeapon.setAlignment(SWT.RIGHT);
		lblWeapon.setText("Weapon");
		lblWeapon.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		
		comboChooser = new Combo(groupInput, SWT.NONE);
		comboChooser.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		comboChooser.setItems(new String[] {"Normal", "Lightning", "Wood", "Metal", "Void", "Spirit"});
		comboChooser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(groupInput, SWT.NONE);
		
		btnAddCharacter = new Button(groupInput, SWT.CENTER);		
		btnAddCharacter.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnAddCharacter.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		GridData gd_btnAddCharacter = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnAddCharacter.widthHint = 202;
		btnAddCharacter.setLayoutData(gd_btnAddCharacter);
		btnAddCharacter.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		btnAddCharacter.setText("Add Player");
		
		Group groupCharacterList = new Group(shell, SWT.NONE);
		FormData fd_groupCharacterList = new FormData();
		fd_groupCharacterList.bottom = new FormAttachment(groupInput, 0, SWT.BOTTOM);
		fd_groupCharacterList.top = new FormAttachment(lblSetupTitle, 6);
		fd_groupCharacterList.left = new FormAttachment(groupInput, 65);
		fd_groupCharacterList.right = new FormAttachment(100, -99);
		groupCharacterList.setLayoutData(fd_groupCharacterList);
		
		lblCharacterList = new Label(groupCharacterList, SWT.NONE);
		lblCharacterList.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblCharacterList.setAlignment(SWT.CENTER);
		lblCharacterList.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblCharacterList.setBounds(10, 16, 218, 30);
		lblCharacterList.setText("Players");
		
		Label seperator = new Label(groupCharacterList, SWT.SEPARATOR | SWT.HORIZONTAL);
		seperator.setBounds(10, 57, 218, 16);
		
		listCharacters = new List(groupCharacterList, SWT.BORDER);
		listCharacters.setFont(SWTResourceManager.getFont("Segoe UI Light", 16, SWT.NORMAL));
		listCharacters.setBounds(10, 79, 218, 224);
		
		btnNext = new Button(groupCharacterList, SWT.NONE);		
		btnNext.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		btnNext.setBackground(SWTResourceManager.getColor(255, 102, 102));
		btnNext.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNext.setBounds(10, 324, 218, 67);
		btnNext.setText("Setup Monsters");
		


		/*
		 * Button handlers here	
		 */
		
		// Add player button
		btnAddCharacter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addCharacter();
			}			
		});
		
		// Setup Monsters button
		btnNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Dispose children
				textName.dispose();
				textDefence.dispose();
				textLife.dispose();
				textPower.dispose();
				textSpeed.dispose();
				lblDefence.dispose();
				lblLife.dispose();
				lblPower.dispose();
				lblWeapon.dispose();
				lblSpeed.dispose();
				
				listCharacters.removeAll();
				
				// Refresh layout
				shell.layout(true, true);
				
				
				// Handle the button click
				nextButtonClicked();					
			}
		});
	
	}
	
	private void addCharacter() {		
		// For players
		if (setupState.equalsIgnoreCase("PLAYER")) {
			// Add player name to character list
			listCharacters.add(textName.getText() + "\n");
			
			// Add player to game
			controller.addPlayer(textName.getText(), textPower.getText(), textDefence.getText(), textLife.getText(),
					textSpeed.getText(), comboChooser.getText());

			// Reset textFields
			textName.setText("");
			textPower.setText("");
			textDefence.setText("");
			textLife.setText("");
			textSpeed.setText("");
		}
		// for monsters
		else if (setupState.equalsIgnoreCase("MONSTER")) {
			// Add monster name to character list
			listCharacters.add(comboChooser.getText() + "\n");
			
			// Add monster to game				
			controller.addMonster(comboChooser.getText());
		}
		
	}
	
	/**
	 * Handles the btnNext selected events
	 */
	private void nextButtonClicked() {
		// Either show monster setup screen
		if(setupState.equalsIgnoreCase("PLAYER")) {
			monsterSetup();
		}
		// Or start the game
		else {
			shell.close();
			nextScreen(new CombatScreen());
		}
		
	}
	
	/*
	 * Setup and display monster setup screen elements
	 */
	private void monsterSetup() {
		setupState = "MONSTER";
		
		shell.setText("Monster Setup");
		lblSetupTitle.setText("Monster Setup");			
		lblName.setText("Monster");		
		comboChooser.setItems(new String[] {"Baron of Hell", "Imp", "Zombie", "Mancu-Ben", "Gary Demon"});
		btnAddCharacter.setText("Add Monster");	
		btnNext.setText("Begin Game");
		lblCharacterList.setText("Monsters");
		
		
		// Refresh layout
		shell.layout(true, true);
	}
	
	// TODO DELETE ME
	@Override
	public void debugScreen() {
		System.out.println("I am a SETUP screen");
	}
	
}