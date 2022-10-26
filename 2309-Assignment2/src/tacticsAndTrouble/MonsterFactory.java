package tacticsAndTrouble;

/**
 * The monster maker
 * @author Benjamin Gardiner
 * Creates and returns a new monster based on a given type 
 */
public class MonsterFactory {

	public Monster createMonster(String type) {
		
		
		switch (type) {
		case Monster.BARON_OF_HELL: 			
			return new Monster(type, 70, 40, 100, 1, new PowerType(PowerType.METAL));
		case Monster.CYBER_DEMON: 			
			return new Monster(type, 60, 30, 80, 2, new PowerType(PowerType.LIGHTNING));
		case Monster.IMP: 			
			return new Monster(type, 50, 20, 70, 3, new PowerType(PowerType.SPIRIT));
		case Monster.MANCU_BEN: 			
			return new Monster(type, 40, 10, 60, 2, new PowerType(PowerType.VOID));
		case Monster.ZOMBIE: 			
			return new Monster(type, 30, 20, 90, 4, new PowerType(PowerType.WOOD));		
		default:
			return new Monster("Gary Demon", 50, 20, 100, 1, new PowerType(PowerType.NORMAL));
		}
		
	}
}
