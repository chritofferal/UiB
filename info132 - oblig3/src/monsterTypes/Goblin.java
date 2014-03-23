package monsterTypes;

import models.Monster;

public class Goblin extends Monster {

	public Goblin(int health, int level) {
		super(health, level);
		setDmgMultiplyer(1.2);
	}

}
