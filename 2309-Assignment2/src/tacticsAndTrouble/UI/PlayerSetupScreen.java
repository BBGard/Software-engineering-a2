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

public class PlayerSetupScreen extends Screen{

	//protected Shell shell;
	private Text textName;
	private Text textPower;
	private Text textDefence;
	private Text textLife;
	private Text textSpeed;


	/**
	 * Launch the application.
	 * @param args
	 */
//	public void newScreen(ControlClass controller) {
//		this.controller = controller;
//		
//
//		try {
//			PlayerSetupScreen window = new PlayerSetupScreen();
//			window.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
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
//		
//	}

	/**
	 * Create contents of the window.
	 */
	@Override
	protected void createContents() {
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("Player Setup");
		shell.setLayout(new FormLayout());
		
		Label lblSetupTitle = new Label(shell, SWT.NONE);
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
		
		Label lblName = new Label(groupInput, SWT.NONE);
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
		
		final Combo comboWeapon = new Combo(groupInput, SWT.NONE);
		comboWeapon.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		comboWeapon.setItems(new String[] {"Normal", "Lightning", "Wood", "Metal", "Void", "Spirit"});
		comboWeapon.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(groupInput, SWT.NONE);
		
		final Button btnAddPlayer = new Button(groupInput, SWT.CENTER);
		
		btnAddPlayer.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnAddPlayer.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		GridData gd_btnAddPlayer = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnAddPlayer.widthHint = 202;
		btnAddPlayer.setLayoutData(gd_btnAddPlayer);
		btnAddPlayer.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		btnAddPlayer.setText("Add Player");
		
		Group groupPlayerList = new Group(shell, SWT.NONE);
		FormData fd_groupPlayerList = new FormData();
		fd_groupPlayerList.bottom = new FormAttachment(groupInput, 0, SWT.BOTTOM);
		fd_groupPlayerList.top = new FormAttachment(lblSetupTitle, 6);
		fd_groupPlayerList.left = new FormAttachment(groupInput, 65);
		fd_groupPlayerList.right = new FormAttachment(100, -99);
		groupPlayerList.setLayoutData(fd_groupPlayerList);
		
		Label lblPlayers = new Label(groupPlayerList, SWT.NONE);
		lblPlayers.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblPlayers.setAlignment(SWT.CENTER);
		lblPlayers.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblPlayers.setBounds(10, 16, 218, 30);
		lblPlayers.setText("Players");
		
		Label seperator = new Label(groupPlayerList, SWT.SEPARATOR | SWT.HORIZONTAL);
		seperator.setBounds(10, 57, 218, 16);
		
		final List listPlayers = new List(groupPlayerList, SWT.BORDER);
		listPlayers.setFont(SWTResourceManager.getFont("Segoe UI Light", 16, SWT.NORMAL));
		listPlayers.setBounds(10, 79, 218, 224);
		
		Button btnSetupMonsters = new Button(groupPlayerList, SWT.NONE);
		
		btnSetupMonsters.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		btnSetupMonsters.setBackground(SWTResourceManager.getColor(255, 102, 102));
		btnSetupMonsters.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnSetupMonsters.setBounds(10, 324, 218, 67);
		btnSetupMonsters.setText("Setup Monsters");
		


		/*
		 * Button handlers here	
		 */
		
		btnAddPlayer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Add player name to player list
				listPlayers.add(textName.getText() + "\n");

				// Add player to game
				
				controller.addPlayer(textName.getText(), textPower.getText(),
				textDefence.getText(), textLife.getText(), textSpeed.getText(),
				comboWeapon.getText());
				
								
				// Reset textFields
				textName.setText("");
				textPower.setText("");
				textDefence.setText("");
				textLife.setText("");
				textSpeed.setText("");
			}

			
		});
		
		btnSetupMonsters.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Show monster setup screen
				shell.close();

				// Create player setup screen
				MonsterSetupScreen monsterSetup = new MonsterSetupScreen();
				monsterSetup.open(controller);
			}
		});
	
	}
	
}
