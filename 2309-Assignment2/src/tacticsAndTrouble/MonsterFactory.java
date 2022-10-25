package tacticsAndTrouble;

public class MonsterFactory {

	public Monster createMonster(String type) {
		
		
		switch (type) {
		case Monster.BARON_OF_HELL: 			
			return new Monster(type, 70, 40, 150, 1, new PowerType(PowerType.LIGHTNING));
		case Monster.CYBER_DEMON: 			
			return new Monster(type, 60, 30, 100, 2, new PowerType(PowerType.METAL));
		case Monster.IMP: 			
			return new Monster(type, 50, 20, 75, 3, new PowerType(PowerType.SPIRIT));
		case Monster.MANCU_BEN: 			
			return new Monster(type, 40, 15, 75, 2, new PowerType(PowerType.VOID));
		case Monster.ZOMBIE: 			
			return new Monster(type, 30, 10, 90, 4, new PowerType(PowerType.WOOD));		
		default:
			return new Monster("Gary Demon", 50, 20, 100, 1, new PowerType(PowerType.NORMAL));
		}
		
	}
}
