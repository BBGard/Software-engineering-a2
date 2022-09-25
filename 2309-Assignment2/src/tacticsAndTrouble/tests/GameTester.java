package tacticsAndTrouble.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tacticsAndTrouble.Game;
import tacticsAndTrouble.GameCharacter;
import tacticsAndTrouble.Player;
import tacticsAndTrouble.PowerType;
import tacticsAndTrouble.Weapon;

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
		assertEquals("Normal", player.getWeaponType());	
	}
	
	@Test
	public void testCreatePlayerWithWeapon() {
		GameCharacter player = new Player("Ben", 35, 44, 12, 2, new Weapon(PowerType.METAL));
		assertEquals("Ben", player.getName());	
		assertEquals(35, player.getPower());	
		assertEquals(44, player.getDefense());	
		assertEquals(12, player.getLife());	
		assertEquals(2, player.getSpeed());	
		assertEquals(12, player.getHealth());	
		assertEquals("Metal", player.getWeaponType());	
	}
	
	@Test
	public void testCreatePlayerWithMadeUpWeapon() {
		GameCharacter player = new Player("Ben", 35, 44, 12, 2, new Weapon("Doom"));
		assertEquals("Ben", player.getName());	
		assertEquals(35, player.getPower());	
		assertEquals(44, player.getDefense());	
		assertEquals(12, player.getLife());	
		assertEquals(2, player.getSpeed());	
		assertEquals(12, player.getHealth());	
		assertEquals("Doom", player.getWeaponType());	
	}
	
	@Test
	public void testAddPlayer() {
		assertTrue(game.addPlayer(player1));
	}
	
	@Test
	public void testAddMultiplePlayers() {
		GameCharacter player2 = new Player("Bill", 22, 12, 35, 2);
		GameCharacter player3 = new Player("Bob", 33, 10, 23, 1);
		GameCharacter player4 = new Player("Bree", 44, 50, 12, 5);
		
		assertTrue(game.addPlayer(player2));
		assertTrue(game.addPlayer(player3));
		assertTrue(game.addPlayer(player4));
	}
	
	@Test
	public void addPlayerWithWeapon() {
		GameCharacter player = new Player("Ben", 35, 44, 12, 2, new Weapon(PowerType.LIGHTNING));
		assertTrue(game.addPlayer(player));
	}
	
	
}
