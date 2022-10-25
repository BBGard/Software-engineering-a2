package tacticsAndTrouble.UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import tacticsAndTrouble.ControlClass;
import tacticsAndTrouble.Monster;
import tacticsAndTrouble.MonsterFactory;

import java.io.IOException;
import java.util.regex.Pattern;

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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;

public class SetupScreen extends Screen{

	public SetupScreen(View view) {
		super(view);
	}

	// UI elements
	private Label lblSetupTitle;
	private Combo comboChooser;
	private Label lblCharacterList;
	private List listCharacters;
	private Label lblName;
	private Button btnAddCharacter;
	private Button btnNext;
	private Label lblErrorMessage;
	
	private Text textName;
	private Text textPower;
	private Text textDefence;
	private Text textLife;
	private Text textSpeed;
	
	private String setupState = "PLAYER"; 	// Tracks which setup screen is being displayed - player or monster
	private boolean validName = false;		// Used to check if a valid name has been input

//	protected Shell shell;	// TODO REMOVE ME
//	/**
//	 * Open the window.
//	 * @wbp.parser.entryPoint
//	 * TODO REMOVE THIS
//	 */
//	public void open(ControlClass controller) {
//		this.controller = controller;
//
//		Display display = Display.getDefault();
//		createContents();
//		shell.open();
//		shell.layout();
//		
//		//controller.setScreen(this);
//		
//		while (!shell.isDisposed()) {
//			if (!display.readAndDispatch()) {
//				display.sleep();
//			}
//		}
//	}

	/**
	 * Create contents of the window.
	 */
	@Override
	public void createContents() {
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
		textPower.setText("40");
		textPower.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		textPower.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDefence = new Label(groupInput, SWT.NONE);
		lblDefence.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblDefence.setAlignment(SWT.RIGHT);
		lblDefence.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDefence.setText("Defence");
		lblDefence.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		
		textDefence = new Text(groupInput, SWT.BORDER);
		textDefence.setText("20");
		textDefence.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		textDefence.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblLife = new Label(groupInput, SWT.NONE);
		lblLife.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblLife.setAlignment(SWT.RIGHT);
		lblLife.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLife.setText("Life");
		lblLife.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		
		textLife = new Text(groupInput, SWT.BORDER);
		textLife.setText("80");
		textLife.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		textLife.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSpeed = new Label(groupInput, SWT.NONE);
		lblSpeed.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSpeed.setAlignment(SWT.RIGHT);
		lblSpeed.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpeed.setText("Speed");
		lblSpeed.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		
		textSpeed = new Text(groupInput, SWT.BORDER);
		textSpeed.setText("2");
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
		
		comboChooser = new Combo(groupInput, SWT.READ_ONLY);
		comboChooser.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		comboChooser.setItems(new String[] {"Normal", "Lightning", "Wood", "Metal", "Void", "Spirit"});
		comboChooser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboChooser.setText("Normal");
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
		
		// Disable button until at least 1 player has been added
		btnNext.setEnabled(false);
		
		lblErrorMessage = new Label(shell, SWT.NONE);
		FormData fd_lblErrorMessage = new FormData();
		fd_lblErrorMessage.right = new FormAttachment(groupInput, 0, SWT.RIGHT);
		fd_lblErrorMessage.bottom = new FormAttachment(groupInput, 37, SWT.BOTTOM);
		fd_lblErrorMessage.top = new FormAttachment(groupInput, 6);
		fd_lblErrorMessage.left = new FormAttachment(groupInput, 10, SWT.LEFT);
		lblErrorMessage.setLayoutData(fd_lblErrorMessage);
		lblErrorMessage.setText("");
		lblErrorMessage.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblErrorMessage.setFont(SWTResourceManager.getFont("Segoe UI Black", 10, SWT.NORMAL));
		


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
	
		// Listen for changes to the name text field
		textName.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent arg0) {	
				validName = false;
				
				// check name has characters
				if (textName.getText().trim().length() > 0) {
					
					// Check if there is already names in the list
					if(listCharacters.getItems().length > 0) {
						validName = true;
						
						// Go through names, if a matching name is found, don't allow adding name
						for (String name : listCharacters.getItems()) {							
							if(name.trim().equalsIgnoreCase(textName.getText().trim()) && textName.getText().trim().length() > 0) {
								validName = false;	
								lblErrorMessage.setText("Name already used, please enter a new name.");
							}
						}
					}
					else {
						validName = true;
					}
				}
				else {
					lblErrorMessage.setText("Please enter a name.");
					validName = false;
				}
			}
		});
		
	}
	
	// Attempts to add a character to the game
	private void addCharacter() {		
		// For players
		if (setupState.equalsIgnoreCase("PLAYER") && verifyInputs()) {			
			
			
			
			// Try to add player to game
			boolean playerAdded = controller.addPlayer(textName.getText(), textPower.getText(), textDefence.getText(), textLife.getText(),
					textSpeed.getText(), comboChooser.getText());
			
			if (playerAdded) {

				// Add player name to character list
				listCharacters.add(textName.getText() + "\n");

				// Reset textFields
				textName.setText("");
				textPower.setText("40");
				textDefence.setText("20");
				textLife.setText("80");
				textSpeed.setText("2");

				lblErrorMessage.setText("");
				btnNext.setEnabled(true);
			}
			else {
				 lblErrorMessage.setText("Maximum players reached.");
			}
		}
		// for monsters
		else if (setupState.equalsIgnoreCase("MONSTER")) {
			// Try to add monster to game	
			boolean monsterAdded =	controller.addMonster(comboChooser.getText());		
						
			if (monsterAdded) {
				// Add monster name to character list
				listCharacters.add(comboChooser.getText() + "\n");
			}
			else {
				 lblErrorMessage.setText("Maximum monsters reached.");
			}
		}
		
	}
	
	// Verifies all of the input text fields before allowing a character to be added
	private boolean verifyInputs() {
		String illegalChars = "[a-zA-Z]+";
		
		// Build an array of text fields to test
		String[] textFields = new String[4];
		textFields[0] = textPower.getText();
		textFields[1] = textDefence.getText();
		textFields[2] = textLife.getText();
		textFields[3] = textSpeed.getText();
		
		// iterate through the list and check for valid characters
		for (int i = 0; i < 4;) {
			if(Pattern.matches(illegalChars, textFields[i]) == false && textFields[i].length() > 0) {
				if(Integer.parseInt(textFields[i]) > 0) {
					i++;
				}
				else {
					lblErrorMessage.setText("Invalid input. Stats must be greater than zero.");
					return false;
				}
			}
			else {
				lblErrorMessage.setText("Invalid input. Stats must be numbers.");
				
				return false;
			}
		}
		// only reaches this if all checks were valid
		if(validName) {
			return true;
		} else {
			//lblErrorMessage.setText("Please enter a valid name.");
		}
		
		return false;
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
			nextScreen(new CombatScreen(view));
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
		comboChooser.setText("Mancu-Ben");					
		
		btnAddCharacter.setText("Add Monster");	
		btnNext.setText("Begin Game");
		lblCharacterList.setText("Monsters");
			
		
		// Refresh layout
		shell.layout(true, true);
	}

	
	
}
