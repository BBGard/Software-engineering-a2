package tacticsAndTrouble.UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

import tacticsAndTrouble.ControlClass;
import tacticsAndTrouble.GameCharacter;
import tacticsAndTrouble.Monster;
import tacticsAndTrouble.Player;

import org.eclipse.swt.widgets.Group;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


/**
 * @author Benjamin Gardiner
  * This is the gameplay screen for the game Tactics and Trouble
  * Needs some refactoring love...
 */
public class CombatScreen extends Screen implements ICombatInterface{

	
	// Interface components	
	private Label lblCurrentCharacter;
	private Label lblCharacterPower;
	private Label lblCharacterDefence;
	private Label lblCharacterLife;
	private Label lblCharacterSpeed;
	private Label lblPowerType;
	private Label lblCharacterPowerType;
	private Label lblCharacterHealth;
	
	private TabFolder movesFolder;
	
	private TabItem tbtmAttack;
	private TabItem tbtmHeal;
	private TabItem tbtmRevive;
	private TabItem tbtmPowerUp;
	
	private List listCharactersToAttack;
	private List listPlayersToHeal;
	private List listPlayersToRevive;
	
	Group characterMovesGroup;
	FormData fd_characterMovesGroup;	
	/////////////////////////////////////////////////
	//protected Shell shell;			   //REMOVE

	// Constructor
	public CombatScreen(View view) {
		super(view);
	}

	/**
	 * Open the window and display a popup message.
	 * @wbp.parser.entryPoint
	 */
	// @Override
	public void open(ControlClass controller) {
		this.controller = controller;

		Display display = Display.getDefault();
		createContents();
		
		centreShell(display);
		
		shell.open();
		shell.layout();
		
		// Tells the view that the state has changed
		view.setScreen(this);
		
		// Displays the game start text
		displayResult(PopupScreen.POPUP_TYPE_WELCOME, PopupScreen.POPUP_WELCOME_MESSAGE);		
		
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
	public void createContents() {
		
		// Setup all the interface components
		shell = new Shell();
		shell.setLayout(new FormLayout());

		Group characterStatsGroup = new Group(shell, SWT.NONE);
		FormData fd_characterStatsGroup = new FormData();
		fd_characterStatsGroup.bottom = new FormAttachment(0, 555);
		fd_characterStatsGroup.right = new FormAttachment(0, 262);
		fd_characterStatsGroup.top = new FormAttachment(0, 79);
		fd_characterStatsGroup.left = new FormAttachment(0, 10);
		characterStatsGroup.setLayoutData(fd_characterStatsGroup);
		GridLayout gl_characterStatsGroup = new GridLayout(2, false);
		gl_characterStatsGroup.verticalSpacing = 30;
		gl_characterStatsGroup.horizontalSpacing = 15;
		characterStatsGroup.setLayout(gl_characterStatsGroup);

		Label lblCurentTurn = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblCurentTurn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		//gd_lblCurentTurn.heightHint = 0;
		gd_lblCurentTurn.widthHint = 55;
		lblCurentTurn.setLayoutData(gd_lblCurentTurn);
		lblCurentTurn.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblCurentTurn.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 12, SWT.NORMAL));
		lblCurentTurn.setText("Turn:");

		lblCurrentCharacter = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblCurrentcharacter = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblCurrentcharacter.widthHint = 116;
		lblCurrentCharacter.setLayoutData(gd_lblCurrentcharacter);
		lblCurrentCharacter.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 12, SWT.BOLD));
		lblCurrentCharacter.setText("name");

		Label lblPower = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblPower = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPower.widthHint = 63;
		lblPower.setLayoutData(gd_lblPower);
		lblPower.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 12, SWT.NORMAL));
		lblPower.setText("Power:");

		lblCharacterPower = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblCharacterPower = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblCharacterPower.widthHint = 115;
		lblCharacterPower.setLayoutData(gd_lblCharacterPower);
		lblCharacterPower.setText("power");
		lblCharacterPower.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));

		Label lblDefence = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblDefence = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblDefence.widthHint = 71;
		lblDefence.setLayoutData(gd_lblDefence);
		lblDefence.setText("Defence:");
		lblDefence.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 12, SWT.NORMAL));

		lblCharacterDefence = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblCharacterDefence = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblCharacterDefence.widthHint = 113;
		lblCharacterDefence.setLayoutData(gd_lblCharacterDefence);
		lblCharacterDefence.setText("defence");
		lblCharacterDefence.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));

		Label lblPLife = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblPLife = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPLife.widthHint = 41;
		lblPLife.setLayoutData(gd_lblPLife);
		lblPLife.setText("Life:");
		lblPLife.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 12, SWT.NORMAL));

		lblCharacterLife = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblCharacterLife = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblCharacterLife.widthHint = 112;
		lblCharacterLife.setLayoutData(gd_lblCharacterLife);
		lblCharacterLife.setText("life");
		lblCharacterLife.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));

		Label lblSpeed = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblSpeed = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblSpeed.widthHint = 58;
		lblSpeed.setLayoutData(gd_lblSpeed);
		lblSpeed.setText("Speed:");
		lblSpeed.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 12, SWT.NORMAL));

		lblCharacterSpeed = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblCharacterSpeed = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblCharacterSpeed.widthHint = 111;
		lblCharacterSpeed.setLayoutData(gd_lblCharacterSpeed);
		lblCharacterSpeed.setText("speed");
		lblCharacterSpeed.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));

		lblPowerType = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblWeapon = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblWeapon.widthHint = 73;
		lblPowerType.setLayoutData(gd_lblWeapon);
		lblPowerType.setText("Weapon:");
		lblPowerType.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 12, SWT.NORMAL));

		lblCharacterPowerType = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblCharacterPowerType = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblCharacterPowerType.widthHint = 112;
		lblCharacterPowerType.setLayoutData(gd_lblCharacterPowerType);
		lblCharacterPowerType.setText("weapon");
		lblCharacterPowerType.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));

		Label lblHealth = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblHealth = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblHealth.widthHint = 63;
		lblHealth.setLayoutData(gd_lblHealth);
		lblHealth.setText("Health:");
		lblHealth.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 12, SWT.NORMAL));

		lblCharacterHealth = new Label(characterStatsGroup, SWT.NONE);
		GridData gd_lblCharacterHealth = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblCharacterHealth.widthHint = 113;
		lblCharacterHealth.setLayoutData(gd_lblCharacterHealth);
		lblCharacterHealth.setText("health");
		lblCharacterHealth.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));
		shell.setSize(800, 600);
		shell.setText("Tactics & Trouble");

		characterMovesGroup = new Group(shell, SWT.NONE);
		fd_characterMovesGroup = new FormData();
		fd_characterMovesGroup.bottom = new FormAttachment(0, 555);
		fd_characterMovesGroup.right = new FormAttachment(0, 777);
		fd_characterMovesGroup.top = new FormAttachment(0, 10);
		fd_characterMovesGroup.left = new FormAttachment(0, 276);
		characterMovesGroup.setLayoutData(fd_characterMovesGroup);
		characterMovesGroup.setText("");

		movesFolder = new TabFolder(characterMovesGroup, SWT.NONE);
		movesFolder.setBounds(10, 123, 481, 412);
	}
	
	
	
	/*
	 * Loads the current characters attributes into the view
	 * Should probably move this to the control class....if I can be bothered
	 * Refactor-Refactor-Refactor-Refactor-Refactor-Refactor-RefactorRefactor
	 */
	@Override
	public void setupTurn(GameCharacter currentCharacter, ArrayList<GameCharacter> playerList, ArrayList<GameCharacter> monsterList ) {
		
		//currentCharacter = character;
		
		destroyTabs();	// Remove tabs so they can be setup again
		setupTabs(currentCharacter);	// Setup the tabs
		
		// For Players
		if(currentCharacter instanceof Player) {
			lblPowerType.setText("Weapon:");			
			
			// Populate the character lists for characters to attack/heal/revive
			for (GameCharacter gameCharacter : monsterList) {
				if(gameCharacter.isAlive()) {					
					listCharactersToAttack.add(gameCharacter.getName());
				}
			}
			
			for (GameCharacter gameCharacter : playerList) {
				if(gameCharacter.isAlive() && gameCharacter.getHealth() < gameCharacter.getLife()) {
					listPlayersToHeal.add(gameCharacter.getName());
				}
				// Make sure they are dead AND have no health (in SinBin)
				else if(!gameCharacter.isAlive() && !(gameCharacter.getHealth() > 0)) {
					listPlayersToRevive.add(gameCharacter.getName());
				}
			}
			
		}
		// For monsters
		else if (currentCharacter instanceof Monster) {
			lblPowerType.setText("Type:");

			for (GameCharacter gameCharacter : playerList) {
				if (gameCharacter.isAlive()) {
					listCharactersToAttack.add(gameCharacter.getName());
				}
			}
		}

		// Setup labels
		lblCurrentCharacter.setText(currentCharacter.getName());
		lblCharacterPower.setText(Integer.toString(currentCharacter.getPower()));
		lblCharacterDefence.setText(Integer.toString(currentCharacter.getDefense()));
		lblCharacterLife.setText(Integer.toString(currentCharacter.getLife()));
		lblCharacterSpeed.setText(Integer.toString(currentCharacter.getSpeed()));
		lblCharacterPowerType.setText(currentCharacter.getPowerTypeString());
		lblCharacterHealth.setText(Integer.toString(currentCharacter.getHealth()));
		
	}
	
	/*
	 * Removes all move tabs so they can be setup fresh
	 */
	private void destroyTabs() {
		if (tbtmAttack != null) {
			tbtmAttack.dispose();
		}
		if (tbtmHeal != null) {
			tbtmHeal.dispose();
		}
		if (tbtmPowerUp != null) {
			tbtmPowerUp.dispose();
		}
		if (tbtmRevive != null) {
			tbtmRevive.dispose();
		}
	}
		
	
	/*
	 * Creates extra move tabs for player characters (heal, revive, powerup)
	 */
	private void setupTabs(GameCharacter currentCharacter) {
		/***********************************************************************
		 * Attack Tab for Players and Monsters
		 */
		tbtmAttack = new TabItem(movesFolder, SWT.NONE);
		tbtmAttack.setText("Attack");

		Group groupPlayerListAttack = new Group(movesFolder, SWT.NONE);
		tbtmAttack.setControl(groupPlayerListAttack);

		Label lblTarget = new Label(groupPlayerListAttack, SWT.NONE);
		lblTarget.setText("Target");
		lblTarget.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblTarget.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblTarget.setAlignment(SWT.CENTER);
		lblTarget.setBounds(10, 16, 453, 33);

		Label seperator = new Label(groupPlayerListAttack, SWT.SEPARATOR | SWT.HORIZONTAL);
		seperator.setBounds(10, 57, 453, 16);

		listCharactersToAttack = new List(groupPlayerListAttack, SWT.BORDER);
		listCharactersToAttack.setFont(SWTResourceManager.getFont("Segoe UI Light", 16, SWT.NORMAL));
		listCharactersToAttack.setBounds(10, 79, 453, 224);

		Button btnAttack = new Button(groupPlayerListAttack, SWT.NONE);		
		btnAttack.setText("Attack");
		btnAttack.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnAttack.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		btnAttack.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnAttack.setBounds(245, 307, 218, 67);
		
		// Disable button until a character has been selected to attack
		btnAttack.setEnabled(false);
		
		// Attack button listener
		btnAttack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controller.attack(listCharactersToAttack.getSelection()[0]);
			}
		});
		
		// Character to attack selection listener		
		listCharactersToAttack.addListener(SWT.Selection, new Listener() {			
			@Override
			public void handleEvent(Event arg0) {
				// Only enable attack button if a selection has been made
				if(listCharactersToAttack.getSelectionIndex() != -1) {
					btnAttack.setEnabled(true);							
				}
			}
		});
		
		

		/**************************************************************************************************
		 * Tabs for Player only
		 */
		if (currentCharacter instanceof Player) {
			tbtmHeal = new TabItem(movesFolder, 0);
			tbtmHeal.setText("Heal");

			Group groupPlayerList = new Group(movesFolder, SWT.NONE);
			tbtmHeal.setControl(groupPlayerList);

			Label lblTarget_1 = new Label(groupPlayerList, SWT.NONE);
			lblTarget_1.setText("Target");
			lblTarget_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
			lblTarget_1.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
			lblTarget_1.setAlignment(SWT.CENTER);
			lblTarget_1.setBounds(10, 16, 453, 33);

			Label seperator_1 = new Label(groupPlayerList, SWT.SEPARATOR | SWT.HORIZONTAL);
			seperator_1.setBounds(10, 57, 453, 16);

			listPlayersToHeal = new List(groupPlayerList, SWT.BORDER);
			listPlayersToHeal.setFont(SWTResourceManager.getFont("Segoe UI Light", 16, SWT.NORMAL));
			listPlayersToHeal.setBounds(10, 79, 453, 224);

			Button btnHeal = new Button(groupPlayerList, SWT.NONE);
			btnHeal.setEnabled(false);

			btnHeal.setText("Heal");
			btnHeal.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			btnHeal.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
			btnHeal.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
			btnHeal.setBounds(245, 307, 218, 67);

			tbtmRevive = new TabItem(movesFolder, 0);
			tbtmRevive.setText("Revive");

			Group groupPlayerList_1 = new Group(movesFolder, SWT.NONE);
			tbtmRevive.setControl(groupPlayerList_1);

			Label lblTarget_1_1 = new Label(groupPlayerList_1, SWT.NONE);
			lblTarget_1_1.setText("Target");
			lblTarget_1_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
			lblTarget_1_1.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
			lblTarget_1_1.setAlignment(SWT.CENTER);
			lblTarget_1_1.setBounds(10, 16, 453, 33);

			Label seperator_1_1 = new Label(groupPlayerList_1, SWT.SEPARATOR | SWT.HORIZONTAL);
			seperator_1_1.setBounds(10, 57, 453, 16);

			listPlayersToRevive = new List(groupPlayerList_1, SWT.BORDER);
			listPlayersToRevive.setFont(SWTResourceManager.getFont("Segoe UI Light", 16, SWT.NORMAL));
			listPlayersToRevive.setBounds(10, 79, 453, 224);

			Button btnRevive = new Button(groupPlayerList_1, SWT.NONE);
			btnRevive.setText("Revive");
			btnRevive.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			btnRevive.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
			btnRevive.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
			btnRevive.setBounds(245, 307, 218, 67);
			btnRevive.setEnabled(false);
	

			// Button listeners
			btnHeal.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					controller.heal(listPlayersToHeal.getSelection()[0]);
				}
			});

			btnRevive.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					controller.revive(listPlayersToRevive.getSelection()[0]);
				}
			});

			// Only show power up tab if character can powerup
			if(currentCharacter.getSpeed() > 1) {
				tbtmPowerUp = new TabItem(movesFolder, 0);
				tbtmPowerUp.setText("Power Up");

				Group groupPlayerList_1_1 = new Group(movesFolder, SWT.NONE);
				tbtmPowerUp.setControl(groupPlayerList_1_1);

				Button btnAttemptPowerUp = new Button(groupPlayerList_1_1, SWT.NONE);
				btnAttemptPowerUp.setText("Attempt Power Up");
				btnAttemptPowerUp.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				btnAttemptPowerUp.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
				btnAttemptPowerUp.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
				btnAttemptPowerUp.setBounds(129, 148, 218, 67);
				
				btnAttemptPowerUp.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						controller.powerUp();
					}
				});
			}
			
			// Selection listeners		
			listPlayersToHeal.addListener(SWT.Selection, new Listener() {			
				@Override
				public void handleEvent(Event arg0) {
					// Only enable attack button if a selection has been made
					if(listPlayersToHeal.getSelectionIndex() != -1) {
						btnHeal.setEnabled(true);							
					}
				}
			});
			
			listPlayersToRevive.addListener(SWT.Selection, new Listener() {			
				@Override
				public void handleEvent(Event arg0) {
					// Only enable attack button if a selection has been made
					if(listPlayersToRevive.getSelectionIndex() != -1) {
						btnRevive.setEnabled(true);							
					}
				}
			});
			
		}

		// Refresh layout
		shell.layout(true, true);

	}

	/**
	 * Displays the result of an action in a PopupScreen
	 */
	@Override
	public void displayResult(String moveType, String resultText) {
		PopupScreen popup = new PopupScreen(moveType, resultText, view);
		popup.open(controller);		
	}
	
	/*
	 * Disposes this screen and all contents
	 * Creates new Setup screen
	 * Called at the end of the game, win/lose, returns game to setup screen
	 */
	@Override
	public void quit() {
		shell.close();
		nextScreen(new SetupScreen(view));
	}
	
}
