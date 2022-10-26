package tacticsAndTrouble.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tacticsAndTrouble.Game;
import tacticsAndTrouble.GameCharacter;
import tacticsAndTrouble.Monster;
import tacticsAndTrouble.MonsterFactory;
import tacticsAndTrouble.Player;
import tacticsAndTrouble.PowerType;

/**
 * 
 * @author Benjamin Gardiner This is a JUnit test class for Game.java (Tactics
 *         and Trouble)
 */
public class GameTester {

	private Game game;
	private GameCharacter player;
	private MonsterFactory monsterMaker;

	@BeforeEach
	public void setup() {
		game = new Game();
		player = new Player("Ben", 36, 24, 44, 3);
		monsterMaker = new MonsterFactory();
	}

	@Test
	public void testCreatePlayer() {
		GameCharacter player = new Player("Ben", 35, 44, 12, 2);
		assertEquals("Ben", player.getName());
		assertEquals(35, player.getPower());
		assertEquals(44, player.getDefense());
		assertEquals(12, player.getLife());
		assertEquals(2, player.getSpeed());
		assertEquals(12, player.getHealth());
		assertEquals("Normal", player.getPowerTypeString());
	}

	@Test
	public void testCreatePlayerWithWeapon() {
		GameCharacter player = new Player("Ben", 35, 44, 12, 2, new PowerType(PowerType.METAL));
		assertEquals("Ben", player.getName());
		assertEquals(35, player.getPower());
		assertEquals(44, player.getDefense());
		assertEquals(12, player.getLife());
		assertEquals(2, player.getSpeed());
		assertEquals(12, player.getHealth());
		assertEquals("Metal", player.getPowerTypeString());
	}

	@Test
	public void testCreatePlayerWithMadeUpWeapon() {
		GameCharacter player = new Player("Ben", 35, 44, 12, 2, new PowerType("Doom"));
		assertEquals("Ben", player.getName());
		assertEquals(35, player.getPower());
		assertEquals(44, player.getDefense());
		assertEquals(12, player.getLife());
		assertEquals(2, player.getSpeed());
		assertEquals(12, player.getHealth());
		assertEquals("Doom", player.getPowerTypeString());
	}

	@Test
	public void testAddPlayer() {
		assertTrue(game.addGameCharacter(player));

		assertEquals(1, game.getPlayersList().size());
	}

	@Test
	public void testAddNullPlayer() {
		assertFalse(game.addGameCharacter(null));
	}

	@Test
	public void testAddMultiplePlayers() {
		GameCharacter player1 = new Player("Bill", 22, 12, 35, 2);
		GameCharacter player2 = new Player("Bob", 33, 10, 23, 1);
		GameCharacter player3 = new Player("Bree", 44, 50, 12, 5);
		GameCharacter player4 = new Player("Bro", 44, 50, 12, 5);
		GameCharacter player5 = new Player("Bra", 44, 50, 12, 5);

		assertTrue(game.addGameCharacter(player1));
		assertTrue(game.addGameCharacter(player2));
		assertTrue(game.addGameCharacter(player3));
		assertTrue(game.addGameCharacter(player4));
		assertTrue(game.addGameCharacter(player5));

		assertEquals(5, game.getPlayersList().size());
	}
	
	@Test
	public void testAddTooManyPlayers() {
		GameCharacter player1 = new Player("Bill", 22, 12, 35, 2);
		GameCharacter player2 = new Player("Bob", 33, 10, 23, 1);
		GameCharacter player3 = new Player("Bree", 44, 50, 12, 5);
		GameCharacter player4 = new Player("Bro", 44, 50, 12, 5);
		GameCharacter player5 = new Player("Bra", 44, 50, 12, 5);
		GameCharacter player6 = new Player("Broo", 44, 50, 12, 5);
		
		assertTrue(game.addGameCharacter(player1));
		assertTrue(game.addGameCharacter(player2));
		assertTrue(game.addGameCharacter(player3));
		assertTrue(game.addGameCharacter(player4));
		assertTrue(game.addGameCharacter(player5));
		
		assertFalse(game.addGameCharacter(player6));
	}

	@Test
	public void addPlayerWithWeapon() {
		GameCharacter player = new Player("Ben", 35, 44, 12, 2, new PowerType(PowerType.LIGHTNING));
		assertTrue(game.addGameCharacter(player));
		assertEquals(1, game.getPlayersList().size());
	}

	@Test
	public void testCreateMonster() {
		GameCharacter monster = new Monster(Monster.BARON_OF_HELL, 23, 44, 55, 12);
		assertEquals("Baron of Hell", monster.getName());
		assertEquals(23, monster.getPower());
		assertEquals(44, monster.getDefense());
		assertEquals(55, monster.getLife());
		assertEquals(12, monster.getSpeed());
		assertEquals(55, monster.getHealth());
		assertEquals("Normal", monster.getPowerTypeString());
	}

	@Test
	public void testCreateMonsterWithType() {
		GameCharacter monster = new Monster(Monster.BARON_OF_HELL, 23, 44, 55, 12, new PowerType(PowerType.SPIRIT));
		assertEquals("Baron of Hell", monster.getName());
		assertEquals(23, monster.getPower());
		assertEquals(44, monster.getDefense());
		assertEquals(55, monster.getLife());
		assertEquals(12, monster.getSpeed());
		assertEquals(55, monster.getHealth());
		assertEquals("Spirit", monster.getPowerTypeString());
	}

	@Test
	public void testAddMonster() {
		GameCharacter monster = new Monster(Monster.BARON_OF_HELL, 23, 44, 55, 12, new PowerType(PowerType.SPIRIT));

		assertTrue(game.addGameCharacter(monster));
		assertEquals(1, game.getMonstersList().size());
	}

	@Test
	public void testAddNullMonster() {
		game.addGameCharacter(null);
	}

	@Test
	public void testMonsterFactory() {
		MonsterFactory monsterMaker = new MonsterFactory();
		Monster monster = monsterMaker.createMonster(Monster.BARON_OF_HELL);

		assertEquals("Baron of Hell", monster.getName());
		assertEquals(70, monster.getPower());
		assertEquals(40, monster.getDefense());
		assertEquals(100, monster.getLife());
		assertEquals(1, monster.getSpeed());
		assertEquals(100, monster.getHealth());
		assertEquals("Metal", monster.getPowerTypeString());
	}
	
	@Test
	public void testAddTooManyMonsters() {
		MonsterFactory monsterMaker = new MonsterFactory();
		Monster monster1 = monsterMaker.createMonster(Monster.BARON_OF_HELL);
		Monster monster2 = monsterMaker.createMonster(Monster.BARON_OF_HELL);
		Monster monster3 = monsterMaker.createMonster(Monster.BARON_OF_HELL);
		Monster monster4 = monsterMaker.createMonster(Monster.BARON_OF_HELL);
		Monster monster5 = monsterMaker.createMonster(Monster.BARON_OF_HELL);
		Monster monster6 = monsterMaker.createMonster(Monster.BARON_OF_HELL);
		
		assertTrue(game.addGameCharacter(monster1));
		assertTrue(game.addGameCharacter(monster2));
		assertTrue(game.addGameCharacter(monster3));
		assertTrue(game.addGameCharacter(monster4));
		assertTrue(game.addGameCharacter(monster5));
		
		assertFalse(game.addGameCharacter(monster6));
	}

	@Test
	public void testGameAttack() {
		Monster monster = monsterMaker.createMonster(Monster.BARON_OF_HELL);
		GameCharacter player = new Player("Ben", 35, 44, 12, 2, new PowerType(PowerType.LIGHTNING));
		GameCharacter player2 = new Player("Bill", 50, 50, 50, 1, new PowerType(PowerType.WOOD));

		assertEquals("Ben attacks the Baron of Hell.\n\n" + "Ben's Lightning weapon does double damage to "
				+ "Metal monsters but is reduced by 40 Defense "
				+ "so deals 1 damage.\n\nThe Baron of Hell now has 99 health.", game.attack(player, monster));

		assertEquals("Baron of Hell attacks Bill.\n\n" + "It does 20 damage." + "\n\nBill now has 30 health.",
				game.attack(monster, player2));
	}

	@Test
	public void testPlayerAttackMonster() {
		Monster monster = monsterMaker.createMonster(Monster.CYBER_DEMON);
		GameCharacter player = new Player("Ben", 35, 44, 12, 2, new PowerType(PowerType.LIGHTNING));

		assertEquals(
				"Ben attacks the Cyber Demon.\n\n" + "Ben's Lightning weapon does normal damage to Lightning monsters "
						+ "but is reduced by 30 Defense so deals 5 damage.\n\n" + "The Cyber Demon now has 75 health.",
				player.attack(monster));
	}

	@Test
	public void testPlayerKillsMonster() {
		Monster monster = monsterMaker.createMonster(Monster.GARY_DEMON);
		GameCharacter player = new Player("Ben", 150, 44, 12, 2, new PowerType(PowerType.LIGHTNING));

		assertEquals(
				"Ben attacks the Gary Demon.\n\n" + "Ben's Lightning weapon does normal damage to Normal monsters "
						+ "but is reduced by 20 Defense so deals 130 damage.\n\n" + "The Gary Demon is now dead.",
				player.attack(monster));
	}

	@Test
	public void testMonsterAttacksPlayer() {
		Monster monster = monsterMaker.createMonster(Monster.IMP);
		GameCharacter player = new Player("Alex", 40, 20, 80, 2, new PowerType(PowerType.SPIRIT));

		assertEquals("Imp attacks Alex.\n\n" + "It does 30 damage." + "\n\nAlex now has 50 health.",
				game.attack(monster, player));

	}

	@Test
	public void testMonsterKillsPlayer() {
		Monster monster = monsterMaker.createMonster(Monster.MANCU_BEN);
		GameCharacter player = new Player("Alex", 40, 20, 20, 2, new PowerType(PowerType.VOID));

		assertEquals("Mancu-Ben attacks Alex.\n\n" + "It does 20 damage." + "\n\nAlex is now dead.",
				game.attack(monster, player));
	}

	@Test
	public void testMonsterDoesAtLeast1Damage() {
		Monster monster = monsterMaker.createMonster(Monster.BARON_OF_HELL); // 70 power
		GameCharacter player = new Player("Old Greg", 40, 80, 20, 2, new PowerType(PowerType.VOID)); // vs 80 defence

		assertEquals("Baron of Hell attacks Old Greg.\n\n" + "It does 1 damage." + "\n\nOld Greg now has 19 health.",
				game.attack(monster, player));
	}

	@Test
	public void testRandomChanceRoll() {
		boolean roll1 = game.rollForChance(75);
		boolean roll2 = game.rollForChance(50);

		// Make sure its a bool returned - actual value will be random each time
		assertTrue(roll1 == true || roll1 == false);
		assertTrue(roll2 == true || roll2 == false);

		// Test for chances not allowed - should always be false
		assertEquals(false, game.rollForChance(20));
		assertEquals(false, game.rollForChance(-1));
		assertEquals(false, game.rollForChance(51));
	}

	@Test
	public void testHealPlayer() {
		// Setup characters
		Player player1 = new Player("Antoxx", 40, 20, 80, 2, new PowerType(PowerType.SPIRIT));
		Player player2 = new Player("Crum", 70, 30, 35, 1, new PowerType(PowerType.LIGHTNING));

		// Damage player
		player2.setHealth(10);
		assertEquals(10, player2.getHealth());

		// Heal a player
		assertEquals("Antoxx heals Crum.\n" + "It's successful, healing up to 40 health.\n" + "Crum now has 35 health.",
				player1.heal(player2));
		

		// Try to heal a dead player - need to use revive() instead
		player2.setAlive(false);
		assertEquals("Can't heal a dead player. Try revive instead.", player1.heal(player2));

		// Try to heal a null character
		player2 = null;
		assertEquals("Null playerToHeal", player1.heal(player2));		
		
	}

	@Test
	public void testRevivePlayer() {
		// Setup characters
		Player player1 = new Player("Antoxx", 40, 20, 80, 2, new PowerType(PowerType.SPIRIT));
		Player player2 = new Player("Crum", 70, 30, 35, 1, new PowerType(PowerType.LIGHTNING));

		// Kill player
		player2.setHealth(0);
		player2.setAlive(false);
		
		// Revive a player
		assertEquals("Antoxx revives Crum.\n\n" + "Crum now has 10 health but does not get a turn this round.",
				player1.revive(player2));
		
		// Kill player
		player2.setHealth(0);
		player2.setAlive(false);
		
		// Revive a player using Game class
		assertEquals("Antoxx revives Crum.\n\n" + "Crum now has 10 health but does not get a turn this round.",
				game.revive(player1, player2));
		
		// Try to revive a living player - need to use heal() instead
		player2.setHealth(35);
		player2.setAlive(true);
		assertEquals("Can't revive a living player. Try heal instead.", player1.revive(player2));

		// Try to heal a null character
		player2 = null;
		assertEquals("Null playerToRevive", player1.revive(player2));
	}
	
	@Test
	public void tetsPowerUp() {
		// Setup characters
		Player player1 = new Player("Breta", 20, 15, 53, 3, new PowerType(PowerType.SPIRIT));
		Player player2 = new Player("Crum", 70, 30, 35, 4, new PowerType(PowerType.LIGHTNING));
		Player player3 = new Player("Bilbo", 40, 20, 25, 1, new PowerType(PowerType.LIGHTNING));
		
		// Test powerUp on player 1
		assertEquals("Breta uses Power Up.\n\nIt's successful, and Breta now has 2 speed and 40 power.", player1.powerUp());
		assertEquals(40, player1.getPower());
		assertEquals(2, player1.getSpeed());
		
		// Test powerUp on player 2
		assertEquals("Crum uses Power Up.\n\nIt's successful, and Crum now has 2 speed and 140 power.",
				player2.powerUp());
		assertEquals(140, player2.getPower());
		assertEquals(2, player2.getSpeed());
		
		// Test powerUp on player 3
		assertEquals("Speed not greater than 1!", player3.powerUp());
		assertEquals(40, player3.getPower());
		assertEquals(1, player3.getSpeed());
		
		// Test another (stacked) power up on each player
		assertEquals("Breta uses Power Up again.\n\nIt's successful, and Breta now has 1 speed and 80 power.", player1.powerUp());
		assertEquals(80, player1.getPower());
		assertEquals(1, player1.getSpeed());
		
		assertEquals("Crum uses Power Up again.\n\nIt's successful, and Crum now has 1 speed and 280 power.",
				player2.powerUp());
		assertEquals(280, player2.getPower());
		assertEquals(1, player2.getSpeed());
		
		// Final tests - cannot power up again
		assertEquals("Speed not greater than 1!", player1.powerUp());
		assertEquals(80, player1.getPower());
		assertEquals(1, player1.getSpeed());
		
		assertEquals("Speed not greater than 1!", player2.powerUp());
		assertEquals(280, player2.getPower());
		assertEquals(1, player2.getSpeed());
	}
	
	@Test
	public void tetsResetPowerUp() {
		// Setup characters
		Player player1 = new Player("Breta", 20, 15, 53, 3, new PowerType(PowerType.SPIRIT));
		Player player2 = new Player("Crum", 70, 30, 35, 4, new PowerType(PowerType.LIGHTNING));
		Player player3 = new Player("Bilbo", 40, 20, 25, 1, new PowerType(PowerType.LIGHTNING));
		
		// Test powerUp on player 1
		assertEquals("Breta uses Power Up.\n\nIt's successful, and Breta now has 2 speed and 40 power.", player1.powerUp());
		assertEquals(40, player1.getPower());
		assertEquals(2, player1.getSpeed());
		
		// Test powerUp on player 2
		assertEquals("Crum uses Power Up.\n\nIt's successful, and Crum now has 2 speed and 140 power.",
				player2.powerUp());
		assertEquals(140, player2.getPower());
		assertEquals(2, player2.getSpeed());
		
		// Run resets
		player1.resetAttributes();
		player2.resetAttributes();
		player3.resetAttributes();
		
		// Check everything reset
		assertEquals(20, player1.getPower());
		assertEquals(70, player2.getPower());
		assertEquals(40, player3.getPower());
		
		assertEquals(3, player1.getSpeed());
		assertEquals(4, player2.getSpeed());
		assertEquals(1, player3.getSpeed());
	}
}
