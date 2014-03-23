package monsterTypes;

import models.Monster;

public class Wraith extends Monster{

	public Wraith(int health, int level) {
		super(health, level);
		setDmgMultiplyer(1.3);
	}

}
