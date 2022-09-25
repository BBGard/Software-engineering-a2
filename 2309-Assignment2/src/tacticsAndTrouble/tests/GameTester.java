package tacticsAndTrouble.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tacticsAndTrouble.Game;
import tacticsAndTrouble.GameCharacter;
import tacticsAndTrouble.Monster;
import tacticsAndTrouble.Player;
import tacticsAndTrouble.PowerType;

/**
 * 
 * @author Benjamin Gardiner
 * This is a JUnit test class for Game.java (Tactics and Trouble)
 */
public class GameTester {

	private Game game;
	private GameCharacter player1;
	
	@BeforeEach
	public void setup() {
		game = new Game();
		player1 = new Player("Ben", 36, 24, 44, 3);
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
		assertTrue(game.addPlayer(player1));
		
		assertEquals(1, game.getPlayerCount());
	}
	
	@Test
	public void testAddNullPlayer() {
		assertFalse(game.addPlayer(null));
	}
	
	@Test
	public void testAddMultiplePlayers() {
		GameCharacter player2 = new Player("Bill", 22, 12, 35, 2);
		GameCharacter player3 = new Player("Bob", 33, 10, 23, 1);
		GameCharacter player4 = new Player("Bree", 44, 50, 12, 5);
		
		assertTrue(game.addPlayer(player2));
		assertTrue(game.addPlayer(player3));
		assertTrue(game.addPlayer(player4));
		
		assertEquals(3, game.getPlayerCount());
	}
	
	@Test
	public void addPlayerWithWeapon() {
		GameCharacter player = new Player("Ben", 35, 44, 12, 2, new PowerType(PowerType.LIGHTNING));
		assertTrue(game.addPlayer(player));
		assertEquals(1, game.getPlayerCount());
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
		
		assertTrue(game.addMonster(monster));
		assertEquals(1, game.getMonsterCount());
	}
	
	@Test 
	public void testAddNullMonster() {
		game.addMonster(null);
	}
	
	@Test
	public void testMonsterFactory() {
		MonsterFactory monsterMaker = new MonsterFactory();
		
		Monster monster = monsterMaker.createMonster(Monster.BARON_OF_HELL);
		
		assertEquals("Baron of Hell", monster.getName());
		assertEquals(80, monster.getPower());	
		assertEquals(40, monster.getDefense());	
		assertEquals(150, monster.getLife());	
		assertEquals(1, monster.getSpeed());	
		assertEquals(150, monster.getHealth());	
		assertEquals("Lightning", monster.getPowerTypeString());
	}
	
	
}
