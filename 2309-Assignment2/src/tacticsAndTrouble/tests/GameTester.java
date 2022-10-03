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
 * @author Benjamin Gardiner
 * This is a JUnit test class for Game.java (Tactics and Trouble)
 */
public class GameTester {

	private Game game;
	private GameCharacter player1;
	private MonsterFactory monsterMaker;
	
	@BeforeEach
	public void setup() {
		game = new Game();
		player1 = new Player("Ben", 36, 24, 44, 3);
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
		assertEquals("Player added!", game.addPlayer(player1));
		
		assertEquals(1, game.getPlayerCount());
	}
	
	@Test
	public void testAddNullPlayer() {
		assertEquals("Could not add player!", game.addPlayer(null));
	}
	
	@Test
	public void testAddMultiplePlayers() {
		GameCharacter player2 = new Player("Bill", 22, 12, 35, 2);
		GameCharacter player3 = new Player("Bob", 33, 10, 23, 1);
		GameCharacter player4 = new Player("Bree", 44, 50, 12, 5);
		
		assertEquals("Player added!", game.addPlayer(player2));
		assertEquals("Player added!", game.addPlayer(player3));
		assertEquals("Player added!", game.addPlayer(player4));
		
		assertEquals(3, game.getPlayerCount());
	}
	
	@Test
	public void addPlayerWithWeapon() {
		GameCharacter player = new Player("Ben", 35, 44, 12, 2, new PowerType(PowerType.LIGHTNING));
		assertEquals("Player added!", game.addPlayer(player));
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
		
		assertEquals("Monster added!", game.addMonster(monster));
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
		assertEquals(70, monster.getPower());	
		assertEquals(40, monster.getDefense());	
		assertEquals(150, monster.getLife());	
		assertEquals(1, monster.getSpeed());	
		assertEquals(150, monster.getHealth());	
		assertEquals("Lightning", monster.getPowerTypeString());
	}
	
	@Test
	public void testGameAttack() {			
		Monster monster = monsterMaker.createMonster(Monster.BARON_OF_HELL);
		GameCharacter player = new Player("Ben", 35, 44, 12, 2, new PowerType(PowerType.LIGHTNING));
		GameCharacter player2 = new Player("Bill", 50, 50, 50, 1, new PowerType(PowerType.WOOD));
		
		assertEquals("Ben attacks the Baron of Hell. "
				+ "Ben's Lightning weapon does normal damage to "
				+ "Lightning monsters but is reduced by 40 Defense "
				+ "so deals 0 damage. The Baron of Hell now has 150 health.", game.attack(player, monster));
		
		assertEquals("Baron of Hell attacks Bill. "
				+ "It does 70-50=20 damage."
				+ " Bill now has 30 health.", game.attack(monster, player2));
	}
	@Test
	public void testPlayerAttackMonster() {
		Monster monster = monsterMaker.createMonster(Monster.CYBER_DEMON);
		GameCharacter player = new Player("Ben", 35, 44, 12, 2, new PowerType(PowerType.LIGHTNING));
		
		assertEquals(
				"Ben attacks the Cyber Demon. "
				+ "Ben's Lightning weapon does double damage to Metal monsters "
				+ "but is reduced by 30 Defense so deals 40 damage. "
				+ "The Cyber Demon now has 60 health.", player.attack(monster));
	}
	
	@Test 
	public void testPlayerKillsMonster() {
		Monster monster = monsterMaker.createMonster(Monster.GARY_DEMON);
		GameCharacter player = new Player("Ben", 150, 44, 12, 2, new PowerType(PowerType.LIGHTNING));
		
		assertEquals(
				"Ben attacks the Gary Demon. "
				+ "Ben's Lightning weapon does normal damage to Normal monsters "
				+ "but is reduced by 20 Defense so deals 130 damage. "
				+ "The Gary Demon is now dead.", player.attack(monster));
	}
	
	@Test
	public void testMonsterAttacksPlayer() {
		Monster monster = monsterMaker.createMonster(Monster.IMP);
		GameCharacter player = new Player("Alex", 40, 20, 80, 2, new PowerType(PowerType.SPIRIT));
		
		assertEquals("Imp attacks Alex. "
				+ "It does 50-20=30 damage."
				+ " Alex now has 50 health.", game.attack(monster, player));

	}
	
	@Test
	public void testMonsterKillsPlayer() {
		Monster monster = monsterMaker.createMonster(Monster.MANCU_BEN);
		GameCharacter player = new Player("Alex", 40, 20, 20, 2, new PowerType(PowerType.VOID));
		
		assertEquals("Mancu-Ben attacks Alex. "
				+ "It does 40-20=20 damage."
				+ " Alex is now dead.", game.attack(monster, player));
	}
}
