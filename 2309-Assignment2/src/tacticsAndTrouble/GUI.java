/**
 * 
 */
package tacticsAndTrouble;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 * @author Benjamin Gardiner This is the main window shown on the launch of
 *         Trouble & Tactics
 */
public class GUI extends JFrame {

	private ControlClass controller; // A reference to the controller class

	// UI elements
	private Container container;
	private JPanel mainTitlePanel, mainStartButtonPanel, setupTitlePanel, setupLeftPanel, setupRightPanel, setupMonstersButtonPanel;
	private JLabel mainTitleLabel, setupTitleLabel, setupPlayersLabel, setupMonstersLabel;
	private JButton mainStartButton, setupAddPlayerButton, setupAddMonsterButton, setupStartButton, setupMonstersButton;
	private JTextField setupNameTextField, setupPowerTextField, setupDefenceTextField, setupLifeTextField,
			setupSpeedTextField;
	private JLabel setupNameLabel, setupPowerLabel, setupDefenceLabel, setupLifeLabel, setupSpeedLabel,
			setupWeaponLabel, setupMonsterLabel, emptyLabel;
	private JComboBox<String> setupWeaponCombo, setupMonsterCombo;
	private JTextArea setupPlayerList, setupMonsterList;
	
	// Fonts
	private Font mainTitleFont = new Font("Serif", Font.BOLD, 60);
	private Font buttonFont = new Font("Sans-Serif", Font.PLAIN, 25);
	private Font setupTitleFont = new Font("Sans-Serif", Font.PLAIN, 30);
	private Font normalFont = new Font("Sans-Serif", Font.PLAIN, 24);

	// Button Handlers
	private MainStartButtonHandler mainStartHandler = new MainStartButtonHandler();
	private AddPlayerButtonHandler addPlayerButtonHandler = new AddPlayerButtonHandler();
	private SetupCombatButtonHandler setupCombatButtonHandler = new SetupCombatButtonHandler();

	private List<JTextField> playerSetupTextFields = new ArrayList<JTextField>();
	private List<JLabel> playerSetupLabels = new ArrayList<JLabel>();

	public GUI(String title) {
		super(title);

	}

	/*
	 * Shows the title screen
	 */
	public void begin(ControlClass controller) {
		this.controller = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 800, 600);
		setLayout(null);
		container = getContentPane();

		// Show the title screen
		showTitleScreen();
	}

	/*
	 * Sets up and shows the title screen
	 */
	private void showTitleScreen() {
		container.setBackground(Color.black);

		// Setup panels
		mainTitlePanel = new JPanel();
		mainTitlePanel.setBounds(100, 100, 600, 150);
		mainTitlePanel.setBackground(Color.black);

		mainStartButtonPanel = new JPanel();
		mainStartButtonPanel.setBounds(300, 400, 200, 100);
		mainStartButtonPanel.setBackground(Color.black);

		// Start Button
		mainStartButton = new JButton("BEGIN");
		mainStartButton.setBackground(Color.blue);
		mainStartButton.setForeground(Color.white);
		mainStartButton.setFont(buttonFont);
		mainStartButtonPanel.add(mainStartButton);
		

		// Action listener for start button
		mainStartButton.addActionListener(mainStartHandler);

		// Title text
		mainTitleLabel = new JLabel("Tactics & Trouble", SwingConstants.CENTER);
		mainTitleLabel.setFont(mainTitleFont);
		mainTitleLabel.setForeground(Color.white);
		mainTitlePanel.add(mainTitleLabel);

		// Add to container
		container.add(mainTitlePanel);
		container.add(mainStartButtonPanel);

		this.setVisible(true);
	}

	/*
	 * Creates and shows the player creation screen
	 */
	public void createPlayerSetupScreen() {
		// Title Panel
		setupTitlePanel = new JPanel();
		setupTitlePanel.setBounds(0, 12, 800, 48);
		setupTitlePanel.setBackground(Color.black);
		container.add(setupTitlePanel);

		// Title
		setupTitleLabel = new JLabel("Player Setup");
		setupTitleLabel.setFont(setupTitleFont);
		setupTitleLabel.setForeground(Color.white);
		setupTitlePanel.add(setupTitleLabel, SwingConstants.CENTER);

		// Left panel
		setupLeftPanel = new JPanel();
		setupLeftPanel.setBounds(50, 125, 350, 300);
		setupLeftPanel.setBackground(Color.black);
		setupLeftPanel.setLayout(new GridLayout(7, 2, 5, 5));
		container.add(setupLeftPanel);
		
		// Right panel
		setupRightPanel = new JPanel();
		setupRightPanel.setBounds(450, 125, 200, 300);
		setupRightPanel.setBackground(Color.white);
		setupRightPanel.setLayout(new BorderLayout());
		container.add(setupRightPanel);
		
		// Setup combat button
		setupMonstersButtonPanel = new JPanel();
		setupMonstersButtonPanel.setBounds(450, 450, 200, 180);
		setupMonstersButtonPanel.setBackground(Color.red);
		container.add(setupMonstersButtonPanel);
		
		setupMonstersButton = new JButton("Setup Monsters");
		setupMonstersButton.setBackground(Color.red);
		setupMonstersButton.setForeground(Color.white);
		setupMonstersButton.setFont(normalFont);
		
		setupMonstersButton.addActionListener(setupCombatButtonHandler);

		setupMonstersButtonPanel.add(setupMonstersButton);

		
		/*------------------------------------------------------*/
		// Left panel components
		setupNameTextField = new JTextField(10);
		setupPowerTextField = new JTextField(10);
		setupDefenceTextField = new JTextField(10);
		setupLifeTextField = new JTextField(10);
		setupSpeedTextField = new JTextField(10);

		// Add TextFields to arrays for easier setup
		playerSetupTextFields.add(setupNameTextField);
		playerSetupTextFields.add(setupPowerTextField);
		playerSetupTextFields.add(setupDefenceTextField);
		playerSetupTextFields.add(setupLifeTextField);
		playerSetupTextFields.add(setupSpeedTextField);

		// Style
		for (JTextField textField : playerSetupTextFields) {
			textField.setFont(normalFont);
			textField.setForeground(Color.black);
			textField.setBackground(Color.white);
		}

		// Setup labels
		setupNameLabel = new JLabel("Name", SwingConstants.RIGHT);
		setupPowerLabel = new JLabel("Power", SwingConstants.RIGHT);
		setupDefenceLabel = new JLabel("Defence", SwingConstants.RIGHT);
		setupLifeLabel = new JLabel("Life", SwingConstants.RIGHT);
		setupSpeedLabel = new JLabel("Speed", SwingConstants.RIGHT);
		setupWeaponLabel = new JLabel("Weapon", SwingConstants.RIGHT);
		emptyLabel = new JLabel();

		playerSetupLabels.add(setupNameLabel);
		playerSetupLabels.add(setupPowerLabel);
		playerSetupLabels.add(setupDefenceLabel);
		playerSetupLabels.add(setupLifeLabel);
		playerSetupLabels.add(setupSpeedLabel);
		playerSetupLabels.add(setupWeaponLabel);

		// Style
		for (JLabel jLabel : playerSetupLabels) {
			jLabel.setFont(normalFont);
			jLabel.setForeground(Color.white);
		}

		setupWeaponCombo = new JComboBox<String>();
		setupWeaponCombo.addItem(new String("Normal"));
		setupWeaponCombo.addItem(new String("Lightning"));
		setupWeaponCombo.addItem(new String("Wood"));
		setupWeaponCombo.addItem(new String("Metal"));
		setupWeaponCombo.addItem(new String("Void"));
		setupWeaponCombo.addItem(new String("Spirit"));

		// Add player button
		setupAddPlayerButton = new JButton("Add Player");
		setupAddPlayerButton.setBackground(Color.blue);
		setupAddPlayerButton.setForeground(Color.white);
		setupAddPlayerButton.setFont(normalFont);

		// Add components to left panel
		setupLeftPanel.add(setupNameLabel);
		setupLeftPanel.add(setupNameTextField);
		setupLeftPanel.add(setupPowerLabel);
		setupLeftPanel.add(setupPowerTextField);
		setupLeftPanel.add(setupDefenceLabel);
		setupLeftPanel.add(setupDefenceTextField);
		setupLeftPanel.add(setupLifeLabel);
		setupLeftPanel.add(setupLifeTextField);
		setupLeftPanel.add(setupSpeedLabel);
		setupLeftPanel.add(setupSpeedTextField);
		setupLeftPanel.add(setupWeaponLabel);
		setupLeftPanel.add(setupWeaponCombo);
		setupLeftPanel.add(emptyLabel);
		setupLeftPanel.add(setupAddPlayerButton);

		/*------------------------------------------------------*/
		
		// Right Panel components		
		setupPlayersLabel = new JLabel("Players", SwingConstants.CENTER);
		setupPlayersLabel.setFont(normalFont);
		setupPlayersLabel.setForeground(Color.blue);
		setupPlayersLabel.setBackground(Color.white);
		setupPlayersLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		setupPlayerList = new JTextArea(10, 1);
		setupPlayerList.setFont(normalFont);
		
			
		// Add components to right panel
		setupRightPanel.add(setupPlayersLabel, BorderLayout.NORTH);
		setupRightPanel.add(setupPlayerList);
		

		// Add action listener for addPlayerButton
		setupAddPlayerButton.addActionListener(addPlayerButtonHandler);
	}

	/*
	 * Creates the monster selection screen components
	 */
	public void createMonsterSetupScreen() {

	}

	/*
	 * Creates the gameplay screen components
	 */
	public void createGameplayScreen() {

	}

	/*
	 * Main Start button handler inner class
	 */
	public class MainStartButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// Disable title screen
			mainStartButtonPanel.setVisible(false);
			mainTitlePanel.setVisible(false);

			// Create player setup screen
			createPlayerSetupScreen();

		}
	}

	/*
	 * Add Player button handler inner class
	 */
	public class AddPlayerButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Add player name to player list
			setupPlayerList.append(setupNameTextField.getText() + "\n");
			System.out.println(setupNameTextField.getText());
			
			// Add player to game
			controller.addPlayer(setupNameTextField.getText(), setupPowerTextField.getText(), setupDefenceTextField.getText(), setupLifeTextField.getText(),
					setupSpeedTextField.getText(), setupWeaponCombo.getSelectedItem().toString());
			
			// Reset textFields
			setupNameTextField.setText("");
			setupPowerTextField.setText("");
			setupDefenceTextField.setText("");
			setupLifeTextField.setText("");
			setupSpeedTextField.setText("");
			setupWeaponCombo.setSelectedIndex(0);
		}

	}
	
	/*
	 * Setup combat button handler inner class
	 */
	public class SetupCombatButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// Disable player setup screen
			setupTitlePanel.setVisible(false);
			setupLeftPanel.setVisible(false);
			setupRightPanel.setVisible(false);
			setupMonstersButtonPanel.setVisible(false);
			
			// Create monster setup screen
			createMonsterSetupScreen();

		}
	}
}
