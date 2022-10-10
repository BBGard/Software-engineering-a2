package tacticsAndTrouble.UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import tacticsAndTrouble.ControlClass;
import org.eclipse.swt.widgets.Group;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PlayerTurnScreen extends Screen{

	protected Shell shell; // TODO REMOVE THIS

	

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 * TODO REMOVE THIS
	 */
	//@Override
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
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setLayout(new FormLayout());
		
		Group playerStatsGroup = new Group(shell, SWT.NONE);
		FormData fd_playerStatsGroup = new FormData();
		fd_playerStatsGroup.bottom = new FormAttachment(0, 555);
		fd_playerStatsGroup.right = new FormAttachment(0, 262);
		fd_playerStatsGroup.top = new FormAttachment(0, 79);
		fd_playerStatsGroup.left = new FormAttachment(0, 10);
		playerStatsGroup.setLayoutData(fd_playerStatsGroup);
		GridLayout gl_playerStatsGroup = new GridLayout(2, false);
		gl_playerStatsGroup.verticalSpacing = 30;
		gl_playerStatsGroup.horizontalSpacing = 15;
		playerStatsGroup.setLayout(gl_playerStatsGroup);
		
		Label lblCurentTurn = new Label(playerStatsGroup, SWT.NONE);
		lblCurentTurn.setAlignment(SWT.RIGHT);
		GridData gd_lblCurentTurn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblCurentTurn.heightHint = 29;
		gd_lblCurentTurn.widthHint = 98;
		lblCurentTurn.setLayoutData(gd_lblCurentTurn);
		lblCurentTurn.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblCurentTurn.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		lblCurentTurn.setText("Curent Turn:");
		
		Label lblCurrentplayer = new Label(playerStatsGroup, SWT.NONE);
		GridData gd_lblCurrentplayer = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblCurrentplayer.heightHint = 35;
		gd_lblCurrentplayer.widthHint = 116;
		lblCurrentplayer.setLayoutData(gd_lblCurrentplayer);
		lblCurrentplayer.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));
		lblCurrentplayer.setText("currentPlayer");
		new Label(playerStatsGroup, SWT.NONE);
		new Label(playerStatsGroup, SWT.NONE);
		
		Label lblPower = new Label(playerStatsGroup, SWT.NONE);
		GridData gd_lblPower = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPower.widthHint = 99;
		lblPower.setLayoutData(gd_lblPower);
		lblPower.setAlignment(SWT.RIGHT);
		lblPower.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		lblPower.setText("Power");
		
		Label lblPlayerPower = new Label(playerStatsGroup, SWT.NONE);
		lblPlayerPower.setText("power");
		lblPlayerPower.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));
		
		Label lblDefence = new Label(playerStatsGroup, SWT.NONE);
		GridData gd_lblDefence = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblDefence.widthHint = 99;
		lblDefence.setLayoutData(gd_lblDefence);
		lblDefence.setText("Defence");
		lblDefence.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		lblDefence.setAlignment(SWT.RIGHT);
		
		Label lblPlayerDefence = new Label(playerStatsGroup, SWT.NONE);
		lblPlayerDefence.setText("defence");
		lblPlayerDefence.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));
		
		Label lblPLife = new Label(playerStatsGroup, SWT.NONE);
		GridData gd_lblPLife = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPLife.widthHint = 98;
		lblPLife.setLayoutData(gd_lblPLife);
		lblPLife.setText("Life");
		lblPLife.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		lblPLife.setAlignment(SWT.RIGHT);
		
		Label lblPlayerLife = new Label(playerStatsGroup, SWT.NONE);
		lblPlayerLife.setText("life");
		lblPlayerLife.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));
		
		Label lblSpeed = new Label(playerStatsGroup, SWT.NONE);
		GridData gd_lblSpeed = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblSpeed.widthHint = 99;
		lblSpeed.setLayoutData(gd_lblSpeed);
		lblSpeed.setText("Speed");
		lblSpeed.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		lblSpeed.setAlignment(SWT.RIGHT);
		
		Label lblPlayerSpeed = new Label(playerStatsGroup, SWT.NONE);
		lblPlayerSpeed.setText("speed");
		lblPlayerSpeed.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));
		
		Label lblWeapon = new Label(playerStatsGroup, SWT.NONE);
		GridData gd_lblWeapon = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblWeapon.widthHint = 99;
		lblWeapon.setLayoutData(gd_lblWeapon);
		lblWeapon.setText("Weapon");
		lblWeapon.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		lblWeapon.setAlignment(SWT.RIGHT);
		
		Label lblPlayerWeapon = new Label(playerStatsGroup, SWT.NONE);
		lblPlayerWeapon.setText("weapon");
		lblPlayerWeapon.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));
		
		Label lblHealth = new Label(playerStatsGroup, SWT.NONE);
		GridData gd_lblHealth = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblHealth.widthHint = 100;
		lblHealth.setLayoutData(gd_lblHealth);
		lblHealth.setText("Health");
		lblHealth.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		lblHealth.setAlignment(SWT.RIGHT);
		
		Label lblPlayerHealth = new Label(playerStatsGroup, SWT.NONE);
		lblPlayerHealth.setText("health");
		lblPlayerHealth.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.BOLD));
		shell.setSize(800, 600);
		shell.setText("Tactics & Trouble");
		
		Group playerMovesGroup = new Group(shell, SWT.NONE);
		FormData fd_playerMovesGroup = new FormData();
		fd_playerMovesGroup.bottom = new FormAttachment(0, 555);
		fd_playerMovesGroup.right = new FormAttachment(0, 777);
		fd_playerMovesGroup.top = new FormAttachment(0, 10);
		fd_playerMovesGroup.left = new FormAttachment(0, 276);
		playerMovesGroup.setLayoutData(fd_playerMovesGroup);
		playerMovesGroup.setText("");
		
		TabFolder movesFolder = new TabFolder(playerMovesGroup, SWT.NONE);
		movesFolder.setBounds(10, 123, 481, 412);
		
		TabItem tbtmAttack = new TabItem(movesFolder, SWT.NONE);
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
		
		List listMonstersToAttack = new List(groupPlayerListAttack, SWT.BORDER);
		listMonstersToAttack.setFont(SWTResourceManager.getFont("Segoe UI Light", 16, SWT.NORMAL));
		listMonstersToAttack.setBounds(10, 79, 453, 224);
		
		Button btnAttack = new Button(groupPlayerListAttack, SWT.NONE);
		btnAttack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAttack.setText("Attack");
		btnAttack.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnAttack.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		btnAttack.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnAttack.setBounds(245, 307, 218, 67);
		
		TabItem tbtmHeal = new TabItem(movesFolder, 0);
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
		
		List listPlayersToHeal = new List(groupPlayerList, SWT.BORDER);
		listPlayersToHeal.setFont(SWTResourceManager.getFont("Segoe UI Light", 16, SWT.NORMAL));
		listPlayersToHeal.setBounds(10, 79, 453, 224);
		
		Button btnHeal = new Button(groupPlayerList, SWT.NONE);
		btnHeal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnHeal.setText("Heal");
		btnHeal.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnHeal.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		btnHeal.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnHeal.setBounds(245, 307, 218, 67);
		
		TabItem tbtmRevive = new TabItem(movesFolder, 0);
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
		
		List listPlayersToRevive = new List(groupPlayerList_1, SWT.BORDER);
		listPlayersToRevive.setFont(SWTResourceManager.getFont("Segoe UI Light", 16, SWT.NORMAL));
		listPlayersToRevive.setBounds(10, 79, 453, 224);
		
		Button btnRevive = new Button(groupPlayerList_1, SWT.NONE);
		btnRevive.setText("Revive");
		btnRevive.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRevive.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		btnRevive.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnRevive.setBounds(245, 307, 218, 67);
		
		TabItem tbtmPowerUp = new TabItem(movesFolder, 0);
		tbtmPowerUp.setText("Power Up");
		
		Group groupPlayerList_1_1 = new Group(movesFolder, SWT.NONE);
		tbtmPowerUp.setControl(groupPlayerList_1_1);
		
		Button btnAttemptPowerUp = new Button(groupPlayerList_1_1, SWT.NONE);
		btnAttemptPowerUp.setText("Attempt Power Up");
		btnAttemptPowerUp.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnAttemptPowerUp.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		btnAttemptPowerUp.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		btnAttemptPowerUp.setBounds(129, 148, 218, 67);

	}
}
